package org.hedbor.evan.dndgen.type

import org.hedbor.evan.dndgen.util.readableEnumToString


enum class SizeCategory {
    TINY,
    SMALL,
    MEDIUM,
    LARGE,
    HUGE,
    GARGANTUAN;

    override fun toString() = readableEnumToString(this.name)
}