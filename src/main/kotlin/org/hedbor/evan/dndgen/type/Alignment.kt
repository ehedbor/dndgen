package org.hedbor.evan.dndgen.type

import org.hedbor.evan.dndgen.util.readableEnumToString

/**
 * Represents a character's ethical and moral alignment.
 * Consists of two axis: law vs. chaos ([lawfulness]) and good vs. evil ([morality]).
 *
 * @param lawfulness The [Lawfulness] of the character
 * @param morality The [Morality] of the character
 */
enum class Alignment(val lawfulness: Lawfulness, val morality: Morality) {
    LAWFUL_GOOD    (Lawfulness.LAWFUL,    Morality.GOOD),
    NEUTRAL_GOOD   (Lawfulness.NEUTRAL,   Morality.GOOD),
    CHAOTIC_GOOD   (Lawfulness.CHAOTIC,   Morality.GOOD),
    LAWFUL_NEUTRAL (Lawfulness.LAWFUL,    Morality.NEUTRAL),
    TRUE_NEUTRAL   (Lawfulness.NEUTRAL,   Morality.NEUTRAL),
    CHAOTIC_NEUTRAL(Lawfulness.CHAOTIC,   Morality.NEUTRAL),
    LAWFUL_EVIL    (Lawfulness.LAWFUL,    Morality.EVIL),
    NEUTRAL_EVIL   (Lawfulness.NEUTRAL,   Morality.EVIL),
    CHAOTIC_EVIL   (Lawfulness.CHAOTIC,   Morality.EVIL),
    /** A special alignment reserved for creatures that have no concept of law or morals. */
    UNALIGNED      (Lawfulness.UNALIGNED, Morality.UNALIGNED);

    override fun toString() = when (this) {
        TRUE_NEUTRAL -> "True Neutral"
        UNALIGNED -> "Unaligned"
        else -> "$lawfulness $morality"
    }

    /**
     * Represents a character's respect for authority. Law vs. chaos.
     *
     * @see Alignment
     * @see Morality
     */
    enum class Lawfulness {
        LAWFUL,
        NEUTRAL,
        CHAOTIC,
        UNALIGNED;

        override fun toString() = readableEnumToString(name)
    }

    /**
     * Represents a character's . Good vs. evil
     *
     * @see Alignment
     * @see Lawfulness
     */
    enum class Morality {
        GOOD,
        NEUTRAL,
        EVIL,
        UNALIGNED;

        override fun toString() = readableEnumToString(name)
    }
}