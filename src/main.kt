import DisjointSet
import FenwickTree
import PartitionTree

fun main() {
    val t = PartitionTree(List<Int>(4, {1}), {a: Int, b: Int -> a + b})
    println(t.tree[0])
    println(t.get(0, 3))
    println("Hello")

}