package org.hedbor.evan.dndgen.util

import org.hedbor.evan.dndgen.score.Ability
import org.hedbor.evan.dndgen.score.SavingThrow
import org.hedbor.evan.dndgen.score.Skill
import org.hedbor.evan.dndgen.type.AbilityType
import org.hedbor.evan.dndgen.type.SkillType


fun Set<Ability>.withType(abilityType: AbilityType) = first { it.type == abilityType }
fun Set<SavingThrow>.withType(savingThrowType: AbilityType) = first { it.type == savingThrowType }
fun Set<Skill>.withType(abilityType: SkillType) = first { it.type == abilityType }

/**
 * Returns the correct level given an amount of [xp].
 */
fun xpToLevel(xp: Int): Int {
    return when {
        xp > 355_000 -> 20
        xp > 305_000 -> 19
        xp > 265_000 -> 18
        xp > 225_000 -> 17
        xp > 195_000 -> 16
        xp > 165_000 -> 15
        xp > 140_000 -> 14
        xp > 120_000 -> 13
        xp > 100_000 -> 12
        xp > 85_000 -> 11
        xp > 64_000 -> 10
        xp > 48_000 -> 9
        xp > 34_000 -> 8
        xp > 23_000 -> 7
        xp > 14_000 -> 6
        xp > 6_500 -> 5
        xp > 2_700 -> 4
        xp > 900 -> 3
        xp > 300 -> 2
        else -> 1
    }
}

/**
 * Converts a modifier to a [String] (adds a plus sign if not negative).
 */
fun modifierToString(modifier: Int) = if (modifier >= 0) "+$modifier" else "$modifier"

/**
 * Converts an enum's name to a readable format. Does not handle spaces.
 */
fun readableEnumToString(name: String) = when (name.length) {
    in 0..1 -> name
    else -> name[0].toUpperCase() + name.substring(1).toLowerCase()
}
