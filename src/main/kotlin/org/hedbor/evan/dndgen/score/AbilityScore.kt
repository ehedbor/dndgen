package org.hedbor.evan.dndgen.score

import org.hedbor.evan.dndgen.util.modifierToString
import org.hedbor.evan.dndgen.type.AbilityType

/**
 *  Represents a character's ability and its associated value.
 *
 *  @see AbilityType
 */
class AbilityScore(val type: AbilityType, var value: Int) {
    val modifier get() = value / 2 - 5

    override fun equals(other: Any?) = (other as? AbilityScore)?.type == this.type
    override fun hashCode() = type.hashCode()
    override fun toString()=  "$type: $value (${modifierToString(modifier)}"

    companion object {
        fun defaults(): Set<AbilityScore> {
            val set = mutableSetOf<AbilityScore>()
            for (a in AbilityType.values()) {
                set.add(AbilityScore(a, 10))
            }
            return set
        }
    }
}