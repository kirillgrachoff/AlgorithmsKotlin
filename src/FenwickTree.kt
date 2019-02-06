import kotlin.collections.*

open class FenwickTree(val a: Array<Int>) {
    val tree = Array<Int>(a.size + 1, {x -> 0})
    init {
        for (i in 1 .. a.size) {
            tree[i] = tree[i - 1] + a[i - 1]
        }
        for (i in a.size downTo 1) {
            tree[i] -= tree[i - (i and -i)]
        }
    }

    fun sum(pos: Int): Int {
        assert(pos < tree.size)
        var k = pos
        var s = 0
        while (k > 0) {
            s += tree[k]
            k -= k and -k
        }
        return s
    }

    fun sum(l: Int, r: Int): Int {
        assert((l > 0) and (l <= r))
        return sum(r) - sum(l - 1)
    }

    fun add(pos: Int, value: Int) {
        var k = pos
        while (k < tree.size) {
            tree[k] += value
            k += k and -k
        }
    }
}