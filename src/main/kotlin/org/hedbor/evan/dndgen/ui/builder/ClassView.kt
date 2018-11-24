package org.hedbor.evan.dndgen.ui.builder

import org.hedbor.evan.dndgen.ui.CharacterSheetModel
import tornadofx.*


/**
 * Inputs the character's class.
 */
class ClassView : View("Choose a Class") {
    val model: CharacterSheetModel by inject()

    override val root = form {
        fieldset(title) {
            label("Placeholder text. Describe classes and the available selections.")
            field("Class") {
                // TODO: Implement class combobox
                combobox<Nothing>()
            }
        }
    }
}