package org.hedbor.evan.dndgen


/**
 *  Represents a character's ability and its associated value.
 *
 *  @see AbilityType
 */
class AbilityScore(val type: AbilityType, var value: Int) {
    val modifier get() = value / 2 - 5

    override fun equals(other: Any?) = (other as? AbilityScore)?.type == this.type
    override fun hashCode() = type.hashCode()

    override fun toString(): String {
        val mod = if (modifier >= 0) "+$modifier" else "$modifier"
        return "$type: $value ($mod)"
    }

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


/**
 *  Provides a quick description of every creature's physical and mental characteristics.
 *
 *  @see AbilityScore
 */
enum class AbilityType {
    /** Measures natural athleticism and bodily power. */
    STRENGTH,
    /** Measures physical agility, reflexes, balance, and poise. */
    DEXTERITY,
    /** Measures endurance, health, stamina, and vital force. */
    CONSTITUTION,
    /** Measures mental acuity, information recall, and analytical skill. */
    INTELLIGENCE,
    /** Measures awareness, intuition, and insight. */
    WISDOM,
    /** Measures confidence, eloquence, leadership, and force of personality. */
    CHARISMA;

    override fun toString() = name[0].toUpperCase() + name.substring(1).toLowerCase()
}