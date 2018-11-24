package org.hedbor.evan.dndgen.ui.builder

import org.hedbor.evan.dndgen.type.Alignment
import org.hedbor.evan.dndgen.ui.CharacterSheetModel
import tornadofx.*


/**
 * Inputs various information about the character.
 */
class DescriptionView : View("Describe Your Character") {
    companion object {
        private const val ROW_COUNT = 3
        private const val COLUMN_COUNT = 15
        private const val IS_WRAP_TEXT = true
    }

    val model: CharacterSheetModel by inject()

    override val root = form {
        fieldset(title) {
            label("Placeholder text. Briefly describe what this view asks for.")
            field("Alignment") {
                combobox(model.alignment, values = Alignment.values().toList())
            }
            field("Background") {
                // TODO: implement background combobox
                combobox<Nothing>()
            }
            field("Personality Traits") {
                textarea(model.personalityTraits) {
                    prefRowCount = ROW_COUNT
                    prefColumnCount = COLUMN_COUNT
                    isWrapText = IS_WRAP_TEXT
                }
            }
            field("Ideals") {
                textarea(model.ideals) {
                    prefRowCount = ROW_COUNT
                    prefColumnCount = COLUMN_COUNT
                    isWrapText = IS_WRAP_TEXT
                }
            }
            field("Bonds") {
                textarea(model.bonds) {
                    prefRowCount = ROW_COUNT
                    prefColumnCount = COLUMN_COUNT
                    isWrapText = IS_WRAP_TEXT
                }
            }
            field("Flaws") {
                textarea(model.flaws) {
                    prefRowCount = ROW_COUNT
                    prefColumnCount = COLUMN_COUNT
                    isWrapText = IS_WRAP_TEXT
                }
            }
        }
    }
}