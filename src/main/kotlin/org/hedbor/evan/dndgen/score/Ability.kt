package org.hedbor.evan.dndgen.score

import org.hedbor.evan.dndgen.CharacterSheet
import org.hedbor.evan.dndgen.type.AbilityType
import tornadofx.*

/**
 *  Represents a character's ability and its associated value.
 *
 *  @see AbilityType
 */
class Ability(
    override val characterSheet: CharacterSheet,
    override val type: AbilityType,
    private val baseValue: Int
) : Score() {
    val valueProperty = integerBinding(characterSheet, characterSheet.raceProperty) {
        val racialMod = this.race?.abilityScores?.get(type) ?: 0
        baseValue + racialMod
    }
    val value by valueProperty

    val modifierProperty = valueProperty.integerBinding { it as Int / 2 - 5 }
    override val modifier by modifierProperty
}