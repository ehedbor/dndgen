package org.hedbor.evan.dndgen.ui

import org.hedbor.evan.dndgen.type.AbilityType
import org.hedbor.evan.dndgen.type.Alignment.*
import org.hedbor.evan.dndgen.type.Race
import tornadofx.*


class CharacterBuilderView : View() {
    private val model = CharacterSheetModel()

    override val root = vbox {
        // TODO: implement the unused properties.
        label("D&D Character Generator")
        form {
            fieldset("1. Choose a Race") {
                field("Race") {
                    combobox(model.race) {
                        items = listOf<Race?>(
                            null,
                            Race.Human
                        ).observable()
                    }
                }
            }
            fieldset("2. Choose a Class") {
                field("Class") {
                    combobox<Nothing?> {
                        items = listOf(null).observable()
                    }
                }
            }
            fieldset("3. Determine Ability Scores") {
                for (abilityType in AbilityType.values()) {
                    field(abilityType.toString()) { textfield() }
                }
            }
            fieldset("4. Describe Your Character") {
                field("Alignment") {
                    combobox(model.alignment) {
                        items = listOf(
                            null,
                            LAWFUL_GOOD,
                            NEUTRAL_GOOD,
                            CHAOTIC_GOOD,
                            LAWFUL_NEUTRAL,
                            TRUE_NEUTRAL,
                            CHAOTIC_NEUTRAL,
                            LAWFUL_EVIL,
                            NEUTRAL_EVIL,
                            CHAOTIC_EVIL,
                            UNALIGNED
                        ).observable()
                    }
                }
                field("Background") {
                    combobox<Nothing?> {
                        items = listOf(null).observable()
                    }
                }
                field("Personality Traits") {
                    textfield(model.personalityTraits)
                }
                field("Ideals") {
                    textfield(model.ideals)
                }
                field("Bonds") {
                    textfield(model.bonds)
                }
                field("Flaws") {
                    textfield(model.flaws)
                }
            }
            fieldset("5. Finishing Touches") {
                field("Character Name") {
                    textfield(model.characterName)
                }
                field("Player Name") {
                    textfield(model.playerName)
                }
            }
        }
        button("Generate")
    }
}