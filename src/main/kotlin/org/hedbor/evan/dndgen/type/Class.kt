package org.hedbor.evan.dndgen.type

import org.hedbor.evan.dndgen.type.AbilityType.*
import org.hedbor.evan.dndgen.type.SkillType.*


/**
 * Models a playable class in D&D.
 */
sealed class Class(
    val name: String,
    val description: String?,
    val hitDie: Int,
    val primaryAbilities: Set<AbilityType>,
    val savingThrowProficiencies: Set<AbilityType>,
    val skillProficiencies: Set<SkillType>,
    // TODO: Make separate classes for armor and weapons
    val armorProficiencies: String,
    val weaponProficiencies: String,
    val entry: String?
) {
    object Fighter : Class(
        name = "Fighter",
        description = "A master of martial combat, skilled with a variety of weapons and armor",
        hitDie = 10,
        primaryAbilities = setOf(STRENGTH, DEXTERITY),
        savingThrowProficiencies = setOf(STRENGTH, CONSTITUTION),
        skillProficiencies = setOf(
            ACROBATICS,
            ANIMAL_HANDLING,
            ATHLETICS,
            HISTORY,
            INSIGHT,
            INTIMIDATION,
            PERCEPTION,
            SURVIVAL
        ),
        armorProficiencies = "All armor and shields",
        weaponProficiencies = "Simple and martial weapons",
        entry = """
            CLASS FEATURES
            As a fighter, you gain the following class features.
            HIT POINTS
            Hit Dice: 1dlO per fighter level
            Hit Points at 1st Level: 10 + your Constitution modifier
            Hit Points at Higher Levels: 1dlO (or 6) + your
              Constitution modifier per fighter level after 1st

            PROFICIENCIES
            Armor: All armor, shields
            Weapons: Simple weapons, martial weapons
            Tools: None
            Saving Throws: Strength, Constitution
            Skills: Choose two skills from Acrobatics, Animal
              Handling, Athletics, History, Insight, Intimidation,
              Perception, and Survival

            EQUIPMENT
            You start with the following equipment, in addition to
            the equipment granted by your background:
              * (a) chain mail or (b) leather, longbow, and 20 arrows
              * (a) a martial weapon and a shield or (b) two martial weapons
              * (a) a light crossbow and 20 bolts or (b) two handaxes
              * (a) a dungeoneer's pack or (b) an explorer's pack
        """.trimIndent()
    )
}