import java.util.*

fun <T, C: MutableCollection<T>> Collection<T>.partitionTo(a: C, b: C, predicate: (T) -> Boolean): Pair<C, C> {
    this.forEach {
        if (predicate(it)) {
            a.add(it)
        }
        else {
            b.add(it)
        }
    }

    return a to b
}

fun partitionWordsAndLines() {
    val (words, lines) = listOf("a", "a b", "c", "d e")
            .partitionTo(ArrayList(), ArrayList()) { s -> !s.contains(" ") }
    check(words == listOf("a", "c"))
    check(lines == listOf("a b", "d e"))
}

fun partitionLettersAndOtherSymbols() {
    val (letters, other) = setOf('a', '%', 'r', '}')
            .partitionTo(HashSet(), HashSet()) { c -> c in 'a'..'z' || c in 'A'..'Z' }
    check(letters == setOf('a', 'r'))
    check(other == setOf('%', '}'))
}
