package com.nelkinda.training.gameoflife

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertEquals

internal class ParserTest {
    @Test
    fun test() = assertAll(
            { parses("") },
            { parses("*", P(0, 0)) },
            { parses("**", P(0, 0), P(1, 0)) },
            { parses("*\n*", P(0, 0), P(0, 1)) },
            { parses("*.*", P(0, 0), P(2, 0)) },
            { assertThrows<IllegalArgumentException> { parses("o") } }
    )

    private fun parses(spec: String, vararg cells: Cell) =
            assertEquals(Universe(life = setOf(*cells)), `parse simplified Life 1_05`(spec))
}
