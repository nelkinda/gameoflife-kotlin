package com.nelkinda.training.gameoflife.life2d

import com.nelkinda.training.gameoflife.Point

private typealias P = Point2D

private val neighbors = (P(-1, -1)..P(1, 1)).filter { it != P(0, 0) }

data class Point2D(private val x: Int, private val y: Int) : Point<P> {
    override operator fun plus(p: P) = P(x + p.x, y + p.y)
    override operator fun rangeTo(p: P) =
            (x..p.x).map { x -> (y..p.y).map { y -> P(x, y) } }.flatten()
    override fun neighbors() = neighbors.map { this + it }
    override fun toString() = "P($x, $y)"
}
