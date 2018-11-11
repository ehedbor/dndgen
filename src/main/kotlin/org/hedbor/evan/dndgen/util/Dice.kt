package org.hedbor.evan.dndgen.util

import java.util.concurrent.ThreadLocalRandom


fun Int.d(dice: Int): Int {
    require(this >= 1) { "Dice count must be greater than 0" }
    require(dice >= 1) { "Dice must have at least 1 side" }

    var total = 0
    repeat(this) {
        total += ThreadLocalRandom.current().nextInt(1, dice + 1)
    }
    return total
}

fun d(dice: Int): Int {
    return 1.d(dice)
}