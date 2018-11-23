package org.hedbor.evan.dndgen.score

import org.hedbor.evan.dndgen.CharacterSheet
import org.hedbor.evan.dndgen.type.ScoreType

abstract class Score {
    abstract val characterSheet: CharacterSheet
    abstract val type: ScoreType
    abstract val modifier: Int
}