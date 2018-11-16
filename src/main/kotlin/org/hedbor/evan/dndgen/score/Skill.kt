package org.hedbor.evan.dndgen.score

import org.hedbor.evan.dndgen.CharacterSheet
import org.hedbor.evan.dndgen.util.modifierToString
import org.hedbor.evan.dndgen.type.SkillType
import org.hedbor.evan.dndgen.util.withType


/**
 *  Represents a character's skill and its associated value.
 *
 *  @see SkillType
 */
class Skill(val characterSheet: CharacterSheet, override val type: SkillType, var proficient: Boolean = false) : Score() {
    override val modifier: Int
        get() {
            val abilityModifier = characterSheet.abilities.withType(type.baseAbility).modifier
            val proficiencyModifier = if (proficient) characterSheet.proficiencyBonus else 0
            return abilityModifier + proficiencyModifier
        }

    override fun equals(other: Any?) = (other as? Skill)?.type == this.type
    override fun hashCode() = type.hashCode()

    companion object {
        fun defaults(sheet: CharacterSheet): Set<Skill> {
            val set = mutableSetOf<Skill>()
            for (s in SkillType.values()) {
                set.add(Skill(sheet, s))
            }
            return set
        }
    }
}