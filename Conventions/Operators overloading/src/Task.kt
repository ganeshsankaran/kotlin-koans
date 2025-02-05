import TimeInterval.*

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int)

data class RepeatedTimeInterval(val timeInterval: TimeInterval, val amount: Int = 1)

// Supported intervals that might be added to dates:
enum class TimeInterval { DAY, WEEK, YEAR;
    operator fun times(amount: Int): RepeatedTimeInterval = RepeatedTimeInterval(this, amount)
}

operator fun MyDate.plus(timeInterval: TimeInterval) =
    this.addTimeIntervals(timeInterval, 1)

operator fun MyDate.plus(repeatedTimeInterval: RepeatedTimeInterval)
    = this.addTimeIntervals(repeatedTimeInterval.timeInterval, repeatedTimeInterval.amount)

fun task1(today: MyDate): MyDate {
    return today + YEAR + WEEK
}

fun task2(today: MyDate): MyDate {
    return today + YEAR * 2 + WEEK * 3 + DAY * 5
}
