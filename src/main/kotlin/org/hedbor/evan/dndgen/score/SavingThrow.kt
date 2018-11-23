package org.hedbor.evan.dndgen.score

import org.hedbor.evan.dndgen.CharacterSheet
import org.hedbor.evan.dndgen.type.AbilityType
import org.hedbor.evan.dndgen.type.ProficiencyLevel
import tornadofx.*

/**
 *  Represents an attempt to resist a threat. Correlates 1:1 with abilities.
 *
 *  @see AbilityType
 */
class SavingThrow(
    override val characterSheet: CharacterSheet,
    override val type: AbilityType,
    val proficiency: ProficiencyLevel = ProficiencyLevel.NOT_PROFICIENT
) : Score() {
    val modifierProperty = integerBinding(characterSheet, characterSheet.abilitiesProperty, characterSheet.proficiencyBonusProperty) {
        val abilityMod = this.abilities?.get(type)?.modifier ?: 0
        val profMod = this.proficiencyBonus * proficiency.multiplier
        abilityMod + profMod
    }
    override val modifier: Int by modifierProperty
}