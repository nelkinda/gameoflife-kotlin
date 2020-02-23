package com.nelkinda.training.gameoflife

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals

internal class PointTest {
    @Test
    fun testToString() = assertEquals("P(0, 1)", P(0, 1).toString())

    @Test
    fun equalPoints() {
        val p1 = P(0, 0)
        val p2 = P(0, 0)
        assertEquals(p1, p2)
        assertEquals(p1.hashCode(), p2.hashCode())
    }

    @Test
    fun notEqualPoints() {
        val p1 = P(0, 0)
        val p2 = P(0, 1)
        assertNotEquals(p1, p2)
        assertNotEquals(p1.hashCode().toLong(), p2.hashCode().toLong())
    }

    @Test
    fun neighbors() = assertEquals(
            setOf(P(4, 4), P(4, 5), P(4, 6), P(5, 4), P(5, 6), P(6, 4), P(6, 5), P(6, 6)),
            P(5, 5).neighbors().toSet()
    )
}