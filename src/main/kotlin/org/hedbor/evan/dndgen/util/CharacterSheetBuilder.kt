package org.hedbor.evan.dndgen.util

import org.hedbor.evan.dndgen.CharacterSheet
import org.hedbor.evan.dndgen.score.Ability
import org.hedbor.evan.dndgen.score.SavingThrow
import org.hedbor.evan.dndgen.score.Skill
import org.hedbor.evan.dndgen.type.AbilityType
import org.hedbor.evan.dndgen.type.Alignment
import org.hedbor.evan.dndgen.type.Race
import org.hedbor.evan.dndgen.type.SkillType
import java.lang.IllegalArgumentException
import java.lang.IllegalStateException
import java.util.*


class CharacterSheetBuilder {
    var race: Race? = null
    var abilities: MutableMap<AbilityType, Int> = emptyEnumMap()
    var savingThrows: MutableMap<AbilityType, Boolean> = emptyEnumMap()
    var skills: MutableMap<SkillType, Boolean> = emptyEnumMap()
    var alignment: Alignment? = null
    var characterName: String? = null
    var playerName: String? = null

    fun build(): CharacterSheet {
        return CharacterSheet(
            race ?: throw IllegalStateException("Must provide race."),
            abilities,
            savingThrows,
            skills,
            alignment ?: throw IllegalStateException("Must provide alignment."),
            characterName ?: throw IllegalStateException("Must provide character name."),
            playerName ?: throw IllegalStateException("Must provide player name.")
        )
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