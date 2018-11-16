package org.hedbor.evan.dndgen.score

import org.hedbor.evan.dndgen.type.ScoreType
import org.hedbor.evan.dndgen.util.modifierToString

abstract class Score {
    abstract val type: ScoreType
    abstract val modifier: Int

    override fun toString() = "$type: (${modifierToString(modifier)})"
}