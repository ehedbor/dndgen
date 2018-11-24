package org.hedbor.evan.dndgen.ui

import org.hedbor.evan.dndgen.ui.builder.CharacterBuilderWizard
import tornadofx.App
import tornadofx.launch


fun main(args: Array<String>) = launch<DndGenApp>(args)

class DndGenApp : App(CharacterBuilderWizard::class)