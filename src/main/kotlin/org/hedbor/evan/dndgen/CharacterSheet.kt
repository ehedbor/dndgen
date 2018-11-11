package org.hedbor.evan.dndgen

import org.hedbor.evan.dndgen.score.AbilityScore
import org.hedbor.evan.dndgen.score.SavingThrow
import org.hedbor.evan.dndgen.score.Skill
import org.hedbor.evan.dndgen.type.AbilityType
import org.hedbor.evan.dndgen.type.AbilityType.*
import org.hedbor.evan.dndgen.type.Alignment
import org.hedbor.evan.dndgen.type.SkillType.*
import org.hedbor.evan.dndgen.util.modifierToString
import org.hedbor.evan.dndgen.util.withType
import org.hedbor.evan.dndgen.util.xpToLevel


/**
 * Models a D&D 5e character sheet. Holds all information relevant to a character.
 */
class CharacterSheet {
    var characterName: String = ""
        internal set
    //val class: Class
    val level get() = xpToLevel(xp)
    //val race: Race
    //val background: Background
    val alignment: Alignment = Alignment.TRUE_NEUTRAL
    var playerName: String = ""
        internal set
    var xp = 0
        internal set

    val abilities: Set<AbilityScore> = AbilityScore.defaults()
    val savingThrows: Set<SavingThrow> = SavingThrow.defaults(this)
    val skills: Set<Skill> = Skill.defaults(this)

    val proficiencyBonus get() = 2 + (level - 1) / 4
    val passivePerception get() = 10 + skills.withType(PERCEPTION).modifier

    val armorClass get() = 10 + abilities.withType(DEXTERITY).modifier
    val initiative get() = abilities.withType(AbilityType.DEXTERITY).modifier
    val speed get() = 30

    //val maxHp: Int
    //val currentHp: Int
    //val tempHp: Int
    //val hitDice: ???
    //val deathSaves: DeathSaves

    // TODO: more stuff eventually...

    override fun toString(): String {
        val characterInfo = listOf(
            "Character Sheet:",
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