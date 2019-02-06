import kotlin.collections.*

open class DisjointSet(val n: Int) {
    val size = Array<Int>(n + 1, {x -> 1})
    val link = Array<Int>(n + 1, {x -> x})

    fun search(k: Int): Int {
        if (link[k] == k) return k;
        link[k] = search(link[k])
        return link[k]
    }

    fun same(a: Int, b: Int) : Boolean {
        return search(a) == search(b)
    }

    fun unite(a: Int, b: Int) {
        var a = search(a)
        var b = search(b)
        if (a == b) return
        if (size[a] < size[b]) { val t = a; a = b; b = t }
        link[b] = a
        size[a] += size[b]
    }

    fun size(k: Int): Int {
        val k = search(k)
        return size[k]
    }
}