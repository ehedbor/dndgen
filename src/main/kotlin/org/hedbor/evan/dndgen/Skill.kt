package org.hedbor.evan.dndgen

import org.hedbor.evan.dndgen.AbilityType.*

enum class SkillType(val baseAbility: AbilityType) {
    ACROBATICS(DEXTERITY),
    ANIMAL_HANDLING(WISDOM),
    ARCANA(INTELLIGENCE),
    ATHLETICS(STRENGTH),
    DECEPTION(CHARISMA),
    HISTORY(INTELLIGENCE),
    INSIGHT(WISDOM),
    INTIMIDATION(CHARISMA),
    INVESTIGATION(INTELLIGENCE),
    MEDICINE(WISDOM),
    NATURE(INTELLIGENCE),
    PERCEPTION(WISDOM),
    PERFORMANCE(CHARISMA),
    PERSUASION(CHARISMA),
    RELIGION(INTELLIGENCE),
    SLEIGHT_OF_HAND(DEXTERITY),
    STEALTH(DEXTERITY),
    SURVIVAL(WISDOM);

    override fun toString(): String {
        return when (this) {
            // exceptions to the rule
            ANIMAL_HANDLING -> "Animal Handling"
            SLEIGHT_OF_HAND -> "Sleight of Hand"
            else -> name[0].toUpperCase() + name.substring(1).toLowerCase()
        }
    }
}

class Skill(val proficient: Boolean = false)