import kotlin.collections.*

class PartitionTree(val values: List<Int>, val f: (Int, Int) -> Int, val neitralEl: Int = 0) {
    var n = 1
    init {
        while (n < values.size) n *= 2
    }
    val tree = Array<Int>(n * 2, {x -> neitralEl})
    init {
        for (i in values.indices) {
            tree[i + n] = values[i]
        }
        for (i in n - 1 downTo 1) {
            tree[i] = f(tree[2 * i], tree[2 * i + 1])
        }
    }

    fun get(a: Int, b: Int): Int {
        assert((a > 0) and (b < values.size))
        var a = a + n
        var b = b + n
        var res = neitralEl
        while (a <= b) {
            if (a % 2 == 1) {
                res = f(res, tree[a])
                a += 1
            }
            if (b % 2 == 0) {
                res = f(res, tree[b])
                b -= 1
            }
            a /= 2
            b /= 2
        }
        return res
    }

    fun modifyWith(idx: Int, value: Int) {
        var idx = idx + n
        while (idx > 0) {
            tree[idx] = f(tree[idx], value)
            idx /= 2
        }
    }
}