package org.hedbor.evan.dndgen


/**
 *  Represents an attempt to resist a threat. Correlates 1:1 with abilities.
 *
 *  @see AbilityType
 */
class SavingThrow(val characterSheet: CharacterSheet, val type: AbilityType, var proficient: Boolean = false) {
    val modifier: Int
        get() {
            val abilityMod = characterSheet.abilities.withType(type).modifier
            val profMod = if (proficient) characterSheet.proficiencyBonus else 0
            return abilityMod + profMod
        }

    override fun equals(other: Any?) = (other as? SavingThrow)?.type == this.type
    override fun hashCode() = type.hashCode()

    override fun toString(): String {
        val mod = if (modifier >= 0) "$modifier" else "$modifier"
        return "$type: $mod"
    }

    companion object {
        fun defaults(sheet: CharacterSheet): Set<SavingThrow> {
            val set = mutableSetOf<SavingThrow>()
            for (a in AbilityType.values()) {
                set.add(SavingThrow(sheet, a))
            }
            return set
        }
    }
}