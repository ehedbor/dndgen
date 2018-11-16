package org.hedbor.evan.dndgen.score

import org.hedbor.evan.dndgen.util.modifierToString
import org.hedbor.evan.dndgen.type.AbilityType
import org.hedbor.evan.dndgen.type.ScoreType

/**
 *  Represents a character's ability and its associated value.
 *
 *  @see AbilityType
 */
class Ability(override val type: AbilityType, var value: Int) : Score() {
    override val modifier get() = value / 2 - 5

    override fun equals(other: Any?) = other is Ability && super.equals(other)
    override fun hashCode() = type.hashCode()
    override fun toString()=  "$type: $value (${modifierToString(modifier)})"

    companion object {
        fun defaults(): Set<Ability> {
            val set = mutableSetOf<Ability>()
            for (a in AbilityType.values()) {
                set.add(Ability(a, 10))
            }
            return set
        }
    }
}