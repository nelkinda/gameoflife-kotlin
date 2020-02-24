package com.nelkinda.training.gameoflife

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertEquals

internal class ParserTest {
    @Test
    fun test() = assertAll(
            { parses("") },
            { parses("x", P(0, 0)) },
            { parses("xx", P(0, 0), P(1, 0)) },
            { parses("x\nx", P(0, 0), P(0, 1)) },
            { parses("x.x", P(0, 0), P(2, 0)) },
            { assertThrows<IllegalArgumentException> { parses("o") } }
    )

    private fun parses(spec: String, vararg cells: Cell) = assertEquals(Universe(life = setOf(*cells)), `parse simplified Life 1_05 format`(spec))
}