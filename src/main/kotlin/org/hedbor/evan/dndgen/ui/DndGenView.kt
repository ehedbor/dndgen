package org.hedbor.evan.dndgen.ui

import javafx.collections.FXCollections
import javafx.util.StringConverter
import org.hedbor.evan.dndgen.type.AbilityType
import org.hedbor.evan.dndgen.type.Alignment
import org.hedbor.evan.dndgen.type.Alignment.*
import org.hedbor.evan.dndgen.type.Race
import tornadofx.*


class DndGenView : View() {
    private val characterSheet = CharacterSheetModel()

    override val root = vbox {
        // TODO: implement the unused properties.
        label("D&D Character Generator")
        form {
            fieldset("1. Choose a Race") {
                field("Race") {
                    combobox(characterSheet.raceProperty) {
                        items = FXCollections.observableArrayList(
                            null,
                            Race.Human
                        )
                    }
                }
            }
            fieldset("2. Choose a Class") {
                field("Class") {
                    combobox<Nothing?>()
                }
            }
            fieldset("3. Determine Ability Scores") {
                for (abilityType in AbilityType.values()) {
                    field(abilityType.toString()) { textfield() }
                }
            }
            fieldset("4. Describe Your Character") {
                field("Alignment") {
                    combobox(characterSheet.alignmentProperty) {
                        items = FXCollections.observableArrayList(
                            null,
                            LAWFUL_GOOD,
                            NEUTRAL_GOOD,
                            CHAOTIC_GOOD,
                            LAWFUL_NEUTRAL,
                            TRUE_NEUTRAL,
                            CHAOTIC_NEUTRAL,
                            LAWFUL_EVIL,
                            NEUTRAL_EVIL,
                            CHAOTIC_EVIL
                        )
                    }
                }
                field("Background") {
                    combobox<Nothing?>()
                }
                field("Personality Traits") { textfield() }
                field("Ideals") { textfield() }
                field("Bonds") { textfield() }
                field("Flaws") { textfield() }
            }
            fieldset("5. Finishing Touches") {
                field("Character Name") {
                    textfield(characterSheet.characterNameProperty)
                }
                field("Player Name") {
                    textfield(characterSheet.playerNameProperty)
                }
            }
        }
        button("Generate")
    }
}