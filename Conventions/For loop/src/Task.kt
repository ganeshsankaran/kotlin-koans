class DateRange(val start: MyDate, val end: MyDate): Iterable<MyDate> {
    override fun iterator(): Iterator<MyDate> {
        return object: Iterator<MyDate> {
            var it = start

            override fun hasNext() = it <= end

            override fun next(): MyDate {
                if (!hasNext()) throw NoSuchElementException()
                val next = it
                it = it.followingDate()
                return next
            }
        }
    }
}

fun iterateOverDateRange(firstDate: MyDate, secondDate: MyDate, handler: (MyDate) -> Unit) {
    for (date in firstDate..secondDate) {
        handler(date)
    }
}