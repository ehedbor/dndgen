package org.hedbor.evan.dndgen.type

import org.hedbor.evan.dndgen.util.Parser
import org.hedbor.evan.dndgen.util.readableEnumToString

/**
 *  Provides a quick description of every creature's physical and mental characteristics.
 *
 *  @see AbilityScore
 */
enum class AbilityType : ScoreType {
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

    override fun toString() = readableEnumToString(name)

    companion object : Parser<AbilityType> {
        override fun fromString(value: String): AbilityType? {
            return when (value.toLowerCase()) {
                "str" -> STRENGTH
                "dex" -> DEXTERITY
                "con" -> CONSTITUTION
                "int" -> INTELLIGENCE
                "wis" -> WISDOM
                "cha" -> CHARISMA
                else -> null
            }
        }
    }
}