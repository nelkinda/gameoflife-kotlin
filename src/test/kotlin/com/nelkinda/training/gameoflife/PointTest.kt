package com.nelkinda.training.gameoflife

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class PointTest {
    @Test
    fun testToString() = assertEquals("P(0, 1)", P(0, 1).toString())

    @Test
    fun plus() = assertEquals(P(3, 30), P(2, 20) + P(1, 10))

    @Test
    fun neighbors() = assertEquals(
            setOf(P(4, 4), P(4, 5), P(4, 6), P(5, 4), P(5, 6), P(6, 4), P(6, 5), P(6, 6)),
            P(5, 5).neighbors().toSet()
    )
}
