import org.junit.Test

import org.junit.Assert.*

class MainKtTest {

    @Test
    fun commissionTestMasterCard() {
        val card = "MasterCard"
        val transfer = 10_000
        val previous = 0

        val result = commission(typeCard = card, transfer = transfer, previous = previous)

        assertEquals(-1, result)
    }

    @Test
    fun testWrongCard() {
        val card = "MasterCard123"
        val transfer = 10_000
        val previous = 0

        val result = commission(typeCard = card, transfer = transfer, previous = previous)

        assertEquals(ERROR_CARD, result)
    }

    @Test
    fun testLimitDayMasterCard() {
        val card = "MasterCard"
        val transfer = 300_000
        val previous = 0

        val result = commission(typeCard = card, transfer = transfer, previous = previous)

        assertEquals(ERROR_LIMIT, result)
    }

    @Test
    fun testLimitMonthMasterCard() {
        val card = "MasterCard"
        val transfer = 100_000
        val previous = 550_000

        val result = commission(typeCard = card, transfer = transfer, previous = previous)

        assertEquals(ERROR_LIMIT, result)
    }

    @Test
    fun commissionTestMasterCardElse() {
        val card = "MasterCard"
        val transfer = 80_000
        val previous = 0

        val result = commission(typeCard = card, transfer = transfer, previous = previous)

        assertEquals(500, result)
    }

    @Test
    fun vkPayLimitDay() {
        val card = "VK Pay"
        val transfer = 16_000
        val previous = 0

        val result = commission(typeCard = card, transfer = transfer, previous = previous)

        assertEquals(ERROR_LIMIT, result)
    }

    @Test
    fun vkPayLimitMonth() {
        val card = "VK Pay"
        val transfer = 10_000
        val previous = 45_000

        val result = commission(typeCard = card, transfer = transfer, previous = previous)

        assertEquals(ERROR_LIMIT, result)
    }

    @Test
    fun vkPayElse() {
        val card = "VK Pay"
        val transfer = 10_000
        val previous = 0

        val result = commission(typeCard = card, transfer = transfer, previous = previous)

        assertEquals(0, result)
    }

    @Test
    fun testLimitMonthVisa() {
        val card = "Visa"
        val transfer = 100_000
        val previous = 550_000

        val result = commission(typeCard = card, transfer = transfer, previous = previous)

        assertEquals(ERROR_LIMIT, result)
    }

    @Test
    fun testLimitDayVisa() {
        val card = "Visa"
        val transfer = 300_000
        val previous = 0

        val result = commission(typeCard = card, transfer = transfer, previous = previous)

        assertEquals(ERROR_LIMIT, result)
    }

    @Test
    fun minCommissionTestVisa() {
        val card = "Visa"
        val transfer = 500
        val previous = 0

        val result = commission(typeCard = card, transfer = transfer, previous = previous)

        assertEquals(35, result)
    }

    @Test
    fun commissionTestVisa() {
        val card = "Visa"
        val transfer = 5_000
        val previous = 0

        val result = commission(typeCard = card, transfer = transfer, previous = previous)

        assertEquals(37, result)
    }
}