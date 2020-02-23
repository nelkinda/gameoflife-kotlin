package com.nelkinda.training.gameoflife

val ConwayRules: Rules = StandardRules(setOf(2, 3), setOf(3))

interface Rules {
    fun survives(liveNeighbors: Int): Boolean
    fun born(liveNeighbors: Int): Boolean
}

private fun toString(set: Set<Int>) = set
        .sorted()
        .joinToString("") { obj: Int -> obj.toString() }

internal data class StandardRules(
        private val liveNeighborsForSurvival: Set<Int>,
        private val liveNeighborsForBirth: Set<Int>
) : Rules {
    override fun survives(liveNeighbors: Int) = liveNeighborsForSurvival.contains(liveNeighbors)
    override fun born(liveNeighbors: Int) = liveNeighborsForBirth.contains(liveNeighbors)
    override fun toString() = "R " + toString(liveNeighborsForSurvival) + "/" + toString(liveNeighborsForBirth)
}