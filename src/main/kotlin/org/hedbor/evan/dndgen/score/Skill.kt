package org.hedbor.evan.dndgen.score

import org.hedbor.evan.dndgen.CharacterSheet
import org.hedbor.evan.dndgen.type.ProficiencyLevel
import org.hedbor.evan.dndgen.type.SkillType
import tornadofx.getValue
import tornadofx.integerBinding


/**
 *  Represents a character's skill and its associated value.
 *
 *  @see SkillType
 */
class Skill(
    override val characterSheet: CharacterSheet,
    override val type: SkillType,
    val proficiency: ProficiencyLevel = ProficiencyLevel.NOT_PROFICIENT
) : Score() {
    val modifierProperty = integerBinding(characterSheet, characterSheet.abilitiesProperty, characterSheet.proficiencyBonusProperty) {
        val abilityMod = this.abilities?.get(type.baseAbility)?.modifier ?: 0
        val profMod = this.proficiencyBonus * proficiency.multiplier
        abilityMod + profMod
    }
    override val modifier: Int by modifierProperty
}