package org.hedbor.evan.dndgen.ui

import org.hedbor.evan.dndgen.CharacterSheet
import tornadofx.ItemViewModel


/**
 * Models a [CharacterSheet] in the user interface.
 */
class CharacterSheetModel : ItemViewModel<CharacterSheet>() {
    val race = bind(CharacterSheet::raceProperty)
    val abilities = bind(CharacterSheet::abilitiesProperty)
    val savingThrows = bind(CharacterSheet::savingThrowsProperty)
    val skills = bind(CharacterSheet::skillsProperty)
    val alignment = bind(CharacterSheet::alignmentProperty)
    val personalityTraits = bind(CharacterSheet::personalityTraitsProperty)
    val ideals = bind(CharacterSheet::idealsProperty)
    val bonds = bind(CharacterSheet::bondsProperty)
    val flaws = bind(CharacterSheet::flawsProperty)
    val characterName = bind(CharacterSheet::characterNameProperty)
    val playerName = bind(CharacterSheet::playerNameProperty)
    val exp = bind(CharacterSheet::expProperty) 
    val level = bind(CharacterSheet::levelProperty) 
    val proficiencyBonus = bind(CharacterSheet::proficiencyBonusProperty)
}
