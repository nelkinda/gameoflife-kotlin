package com.nelkinda.training.gameoflife

private val neighbors = (P(-1, -1)..P(1, 1)).filter { it != P(0, 0) }

typealias P = Point

data class Point constructor(private val x: Int, private val y: Int) {
    operator fun plus(p: Point) = P(x + p.x, y + p.y)
    operator fun rangeTo(p: Point) = (x..p.x).map { x -> (y..p.y).map { y -> P(x, y) } }.flatten()
    fun neighbors() = neighbors.map { this + it }
    fun neighbors(predicate: (Point) -> Boolean) = neighbors().filter(predicate)
    override fun toString() = "P($x, $y)"
}
