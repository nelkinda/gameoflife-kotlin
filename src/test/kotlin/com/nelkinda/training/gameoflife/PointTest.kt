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
            setOf(P(4, 49), P(4, 50), P(4, 51), P(5, 49), P(5, 51), P(6, 49), P(6, 50), P(6, 51)),
            P(5, 50).neighbors().toSet()
    )
}
