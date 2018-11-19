package org.hedbor.evan.dndgen.type

import org.hedbor.evan.dndgen.util.Parser
import org.hedbor.evan.dndgen.util.readableEnumToString


enum class SizeCategory {
    TINY,
    SMALL,
    MEDIUM,
    LARGE,
    HUGE,
    GARGANTUAN;

    override fun toString() = readableEnumToString(this.name)

    companion object : Parser<SizeCategory> {
        override fun fromString(value: String): SizeCategory? {
            return when (value.toLowerCase()) {
                "tiny" -> TINY
                "small" -> SMALL
                "medium" -> MEDIUM
                "large" -> LARGE
                "huge" -> HUGE
                "gargantuan" -> GARGANTUAN
                else -> null
            }
        }
    }
}