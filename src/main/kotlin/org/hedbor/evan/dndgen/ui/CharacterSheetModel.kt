package org.hedbor.evan.dndgen.ui

import javafx.beans.property.SimpleMapProperty
import javafx.beans.property.SimpleObjectProperty
import javafx.beans.property.SimpleStringProperty
import javafx.collections.ObservableMap
import org.hedbor.evan.dndgen.type.AbilityType
import org.hedbor.evan.dndgen.type.Alignment
import org.hedbor.evan.dndgen.type.Race
import org.hedbor.evan.dndgen.type.SkillType
import tornadofx.*


@Suppress("MemberVisibilityCanBePrivate")
class CharacterSheetModel(
    race: Race? = null,
    //class: Class,
    abilities: ObservableMap<AbilityType, Int>? = null,
    savingThrows: ObservableMap<AbilityType, Boolean>? = null,
    skills: ObservableMap<SkillType, Boolean>? = null,
    alignment: Alignment? = null,
    //personalityTraits: String,
    //ideals: String,
    //bonds: String,
    //flaws: String,
    //background: Background

    characterName: String? = null,
    playerName: String? = null
) {
    val raceProperty = SimpleObjectProperty(race)
    var race by raceProperty

    val abilitiesProperty = SimpleMapProperty(abilities)
    var abilities by abilitiesProperty

    val savingThrowsProperty = SimpleMapProperty(savingThrows)
    var savingThrows by savingThrowsProperty

    val skillsProperty = SimpleMapProperty(skills)
    var skills by skillsProperty

    val alignmentProperty = SimpleObjectProperty(alignment)
    val alignment by alignmentProperty

    val characterNameProperty = SimpleStringProperty(characterName)
    var characterName by characterNameProperty

    val playerNameProperty = SimpleStringProperty(playerName)
    var playerName by playerNameProperty
}