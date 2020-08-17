package com.nelkinda.training.gameoflife

@Suppress("MagicNumber")
val ConwayRules: Rules = StandardRules(setOf(2, 3), setOf(3))

@Suppress("MagicNumber")
val HighlifeRules: Rules = StandardRules(setOf(2, 3), setOf(3, 6))

interface Rules {
    fun survives(liveNeighbors: Int): Boolean
    fun born(liveNeighbors: Int): Boolean
}

data class StandardRules(
    private val liveNeighborsForSurvival: Set<Int>,
    private val liveNeighborsForBirth: Set<Int>,
) : Rules {
    private fun Set<Int>.toStr() = sorted().joinToString("")
    override fun survives(liveNeighbors: Int) = liveNeighbors in liveNeighborsForSurvival
    override fun born(liveNeighbors: Int) = liveNeighbors in liveNeighborsForBirth
    override fun toString() = "R ${liveNeighborsForSurvival.toStr()}/${liveNeighborsForBirth.toStr()}"
}
