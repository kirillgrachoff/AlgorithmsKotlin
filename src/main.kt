import DisjointSet

fun main() {
    val d = DisjointSet(10)
    for (i in 10 downTo 1) d.unite(i, i - 1)
    println(d.size(0))
}