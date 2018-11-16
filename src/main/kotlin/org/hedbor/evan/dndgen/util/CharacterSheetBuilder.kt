package org.hedbor.evan.dndgen.util

import org.hedbor.evan.dndgen.CharacterSheet
import org.hedbor.evan.dndgen.score.Ability
import org.hedbor.evan.dndgen.score.SavingThrow
import org.hedbor.evan.dndgen.score.Skill
import org.hedbor.evan.dndgen.type.AbilityType
import org.hedbor.evan.dndgen.type.Alignment
import org.hedbor.evan.dndgen.type.SkillType
import java.lang.IllegalStateException


class CharacterSheetBuilder {
    var characterName: String? = null
    var playerName: String? = null
    var alignment: Alignment? = null
    var abilities: MutableMap<AbilityType, Int> = mutableMapOf()
    var savingThrows: MutableMap<AbilityType, Boolean> = mutableMapOf()
    var skills: MutableMap<SkillType, Boolean> = mutableMapOf()

    fun build(): CharacterSheet {
        val c = CharacterSheet()
        c.characterName = characterName ?: throw IllegalStateException("Must provide character name.")
        c.playerName = playerName ?: throw IllegalStateException("Must provide player name.")
        c.alignment = alignment ?: throw IllegalStateException("Must provide alignment.")

        // Complain about missing abilities
        for (a in AbilityType.values()) {
            if (!abilities.containsKey(a)) {
                throw IllegalStateException("Must provide ability score $a.")
            }
        }
        c.abilities = abilities.map { Ability(it.key, it.value) }.toSet()

        // Not proficient in saving throw by default
        for (a in AbilityType.values()) {
            if (!savingThrows.containsKey(a)) {
                savingThrows[a] = false
            }
        }
        c.savingThrows = savingThrows.map { SavingThrow(c, it.key, it.value) }.toSet()

        // Not proficient in skills by default
        for (s in SkillType.values()) {
            if (!skills.containsKey(s)) {
                skills[s] = false
            }
        }
        c.skills = skills.map { Skill(c, it.key, it.value) }.toSet()

        return c
    }
}

/**
 * A convenience builder for constructing character sheets.
 */
fun characterSheet(block: CharacterSheetBuilder.() -> Unit): CharacterSheet {
    val builder = CharacterSheetBuilder()
    builder.apply(block)
    return builder.build()
}