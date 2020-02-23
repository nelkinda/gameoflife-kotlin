package com.nelkinda.training.gameoflife

internal data class Universe constructor(
        private val rules: Rules,
        private val life: Set<Point>
) {
    internal constructor(life: Set<Point>) : this(ConwayRules, life)

    operator fun next() = Universe(rules, survivingCells() + bornCells())

    private fun survivingCells() = life.filter { it.survives() }.toSet()
    private fun bornCells() = life
            .flatMap { it.deadNeighbors() }
            .filter { it.born() }
            .toSet()

    private fun Point.isAlive() = life.contains(this)
    private fun Point.survives() = rules.survives(countLiveNeighbors())
    private fun Point.born() = rules.born(countLiveNeighbors())
    private fun Point.deadNeighbors() = neighbors { !it.isAlive() }
    private fun Point.liveNeighbors() = neighbors { it.isAlive() }
    private fun Point.countLiveNeighbors() = liveNeighbors().count()

    override fun toString() = "Universe{$rules\n$life}"
}