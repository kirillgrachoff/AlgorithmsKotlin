import kotlin.collections.*

class FenwickTree(val a: Array<Int>) {
    val tree = Array<Int>(a.size + 1, {x -> 0})
    init {
        for (i in 1 .. a.size) {
            tree[i] = tree[i - 1] + a[i - 1]
        }
        for (i in a.size downTo 1) {
            tree[i] -= tree[i - (i and -i)]
        }
    }

    fun get(pos: Int): Int {
        return sum(pos)
    }

    fun set(pos: Int, value: Int) {
        add(pos, value - tree[pos])
    }

    fun sum(pos: Int): Int {
        var k = pos
        var s = 0
        while (k > 0) {
            s += tree[k]
            k -= k and -k
        }
        return s
    }

    fun add(pos: Int, value: Int) {
        var k = pos
        while (k < tree.size) {
            tree[k] += value
            k += k and -k
        }
    }
}