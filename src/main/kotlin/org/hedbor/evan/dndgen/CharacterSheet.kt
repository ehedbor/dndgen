package org.hedbor.evan.dndgen

import com.sun.org.apache.xpath.internal.operations.Bool
import org.hedbor.evan.dndgen.score.Ability
import org.hedbor.evan.dndgen.score.SavingThrow
import org.hedbor.evan.dndgen.score.Skill
import org.hedbor.evan.dndgen.type.AbilityType
import org.hedbor.evan.dndgen.type.AbilityType.*
import org.hedbor.evan.dndgen.type.Alignment
import org.hedbor.evan.dndgen.type.Race
import org.hedbor.evan.dndgen.type.SkillType
import org.hedbor.evan.dndgen.type.SkillType.*
import org.hedbor.evan.dndgen.util.modifierToString
import org.hedbor.evan.dndgen.util.withType
import org.hedbor.evan.dndgen.util.xpToLevel
import java.lang.IllegalArgumentException
import java.lang.IllegalStateException


/**
 * Models a D&D 5e character sheet. Holds all information relevant to a character.
 */
class CharacterSheet(
    val race: Race,
    //val class: Class,
    abilityMap: MutableMap<AbilityType, Int>,
    savingThrowMap: MutableMap<AbilityType, Boolean>,
    skillMap: MutableMap<SkillType, Boolean>,

    val alignment: Alignment,
    //val personalityTraits: String,
    //val ideals: String,
    //val bonds: String,
    //val flaws: String,
    //val background: Background

    val characterName: String,
    val playerName: String,

    val xp: Int = 0
) {
    val abilities: Set<Ability>
    val savingThrows: Set<SavingThrow>
    val skills: Set<Skill>

    val level get() = xpToLevel(xp)

    val proficiencyBonus get() = 2 + (level - 1) / 4
    val passivePerception get() = 10 + skills.withType(PERCEPTION).modifier

    val armorClass get() = 10 + abilities.withType(DEXTERITY).modifier
    val initiative get() = abilities.withType(AbilityType.DEXTERITY).modifier
    val speed get() = 30

    init {
        //TODO: there's got to be a better way to do this
        // Complain about missing abilities
        for (a in AbilityType.values()) {
            if (!abilityMap.containsKey(a)) {
                throw IllegalArgumentException("Must provide ability score $a.")
            }
        }
        abilities = abilityMap.map { Ability(it.key, it.value) }.toSet()

        // Not proficient in saving throw by default
        for (a in AbilityType.values()) {
            if (!savingThrowMap.containsKey(a)) {
                savingThrowMap[a] = false
            }
        }
        savingThrows = savingThrowMap.map { SavingThrow(this, it.key, it.value) }.toSet()

        // Not proficient in skills by default
        for (s in SkillType.values()) {
            if (!skillMap.containsKey(s)) {
                skillMap[s] = false
            }
        }
        skills = skillMap.map { Skill(this, it.key, it.value) }.toSet()
    }

    override fun toString(): String {
        // TODO: Update info
        val characterInfo = listOf(
            "$characterName:",
            "Player: $playerName",
            "",
            "Alignment: $alignment",
            "Experience Points: $xp",
            "Level: $level",
            "",
            "Armor Class: $armorClass",
            "Initiative: ${modifierToString(initiative)}",
            "Speed: $speed",
            "",
            "Proficiency Bonus: ${modifierToString(proficiencyBonus)}",
            "Passive Perception: $passivePerception") +
            listOf("", "Ability Scores:") + abilities.map { it.toString() } +
            listOf("", "Saving Throws:") + savingThrows.map { it.toString() } +
            listOf("", "Skills:") + skills.map { it.toString() }

        return characterInfo.joinToString(System.lineSeparator())
    }
}