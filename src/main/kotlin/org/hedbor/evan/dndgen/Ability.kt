package org.hedbor.evan.dndgen

enum class AbilityType {
    STRENGTH,
    DEXTERITY,
    CONSTITUTION,
    INTELLIGENCE,
    WISDOM,
    CHARISMA;

    override fun toString() = name[0].toUpperCase() + name.substring(1).toLowerCase()
}

class AbilityScore(val value: Int) {
    val modifier get() = value / 2 - 5
}