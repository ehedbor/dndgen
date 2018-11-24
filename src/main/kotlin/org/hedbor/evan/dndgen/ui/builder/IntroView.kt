package org.hedbor.evan.dndgen.ui.builder

import org.hedbor.evan.dndgen.ui.CharacterSheetModel
import tornadofx.View
import tornadofx.fieldset
import tornadofx.form
import tornadofx.label


/**
 * Provides a brief introduction to the application.
 */
class IntroView : View("Introduction") {
    val model: CharacterSheetModel by inject()

    override val root = form {
        fieldset(title) {
            label("Placeholder text describing character generation.")
        }
    }
}