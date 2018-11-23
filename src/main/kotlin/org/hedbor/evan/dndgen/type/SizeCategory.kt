package org.hedbor.evan.dndgen.type

import org.hedbor.evan.dndgen.type.SizeCategory.MEDIUM
import org.hedbor.evan.dndgen.util.readableEnumToString


/**
 * Represents the size of a creature. Most playable races are [MEDIUM].
 */
enum class SizeCategory {
    TINY,
    SMALL,
    MEDIUM,
    LARGE,
    HUGE,
    GARGANTUAN;

    override fun toString() = readableEnumToString(this.name)
}