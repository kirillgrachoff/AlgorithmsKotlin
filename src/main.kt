import DisjointSet
import FenwickTree

fun main() {
    val t = FenwickTree(Array(10, {x -> 1}))
    t.add(1, -1)
    println(t.sum(10))
}