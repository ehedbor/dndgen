package org.hedbor.evan.dndgen.util


interface Parser<T> {
    fun fromString(value: String): T?
}