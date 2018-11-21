package org.hedbor.evan.dndgen.ui

import tornadofx.App
import tornadofx.launch


fun main(args: Array<String>) = launch<DndGenApp>(args)

class DndGenApp : App(DndGenView::class)