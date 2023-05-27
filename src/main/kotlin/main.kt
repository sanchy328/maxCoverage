
const val ERROR_CARD = -1
const val ERROR_LIMIT = -2

fun main() {
    println(commission("VK Pay", 0, 500))
}

fun commission(typeCard: String, previous: Int, transfer: Int): Int = when(typeCard) {
    "MasterCard", "Maestro" -> when {
        transfer > 150_000 || transfer + previous > 600_000 -> ERROR_LIMIT
        transfer in 300..75_000 -> 0
        else -> 20 + (transfer * 0.006).toInt()
    }
    "VK Pay" -> when {
        transfer > 15_000 || transfer + previous > 40_000 -> ERROR_LIMIT
        else -> 0
    }
    "Visa", "Мир" -> when {
        transfer > 150_000 || transfer + previous > 600_000 -> ERROR_LIMIT
        transfer * 0.0075 < 35 -> 35
        else -> (transfer * 0.0075).toInt()
    }
    else -> ERROR_CARD
}