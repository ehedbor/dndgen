package org.hedbor.evan.dndgen.type

import org.hedbor.evan.dndgen.util.readableEnumToString
import org.hedbor.evan.dndgen.type.AbilityType.*

/**
 * A capability a character may have.
 *
 * @see Skill
 */
enum class SkillType(val baseAbility: AbilityType) {
    /** Used when trying to maintain balance or general nimbleness. */
    ACROBATICS(DEXTERITY),
    /** Used to determine how well one deals with animals. */
    ANIMAL_HANDLING(WISDOM),
    /** Used for recalling magical lore. */
    ARCANA(INTELLIGENCE),
    /** Used when determining feats of endurance. */
    ATHLETICS(STRENGTH),
    /** Used when lying. */
    DECEPTION(CHARISMA),
    /** Used when recalling lore of the past. */
    HISTORY(INTELLIGENCE),
    /** Used to determine if some is lying or being suspicious. */
    INSIGHT(WISDOM),
    /** Used to scare someone through threats. */
    INTIMIDATION(CHARISMA),
    /** Used to determine what one is able to deduce about one's surroundings. */
    INVESTIGATION(INTELLIGENCE),
    /** Used to stabilize a dying creature, diagnose illnesses, and occasionally to determine cause of death. */
    MEDICINE(WISDOM),
    /** Used when remembering lore about nature. */
    NATURE(INTELLIGENCE),
    /** Used to determine how much a character notices of their surroundings. */
    PERCEPTION(WISDOM),
    /** Used when entertaining audiences. */
    PERFORMANCE(CHARISMA),
    /** Used to convince others without the use of threats or lies. */
    PERSUASION(CHARISMA),
    /** Used when remembering religious lore. */
    RELIGION(INTELLIGENCE),
    /** Used in situations that require careful hand work, such as pickpocketing or cheating. */
    SLEIGHT_OF_HAND(DEXTERITY),
    /** Used to determine how sneaky a character is being. */
    STEALTH(DEXTERITY),
    /** Used for dealing with the wilds. */
    SURVIVAL(WISDOM);

    override fun toString(): String {
        return when (this) {
            // exceptions to the rule
            ANIMAL_HANDLING -> "Animal Handling"
            SLEIGHT_OF_HAND -> "Sleight of Hand"
            else -> readableEnumToString(name)
        }
    }
}