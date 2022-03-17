import org.junit.Test

import org.junit.Assert.*

class CommissionKtTest {

    @Test
    fun calculateCommission_TypesOfPaymentsMASTERCARD_200() {
        // arrange
        val typeOfPayments = TypesOfPayments.MASTERCARD
        val sumOfTransfer = 200_00
        val sumOfPrevious = 0

        // act
        val result = calculateCommission(
            typeOfPayments = typeOfPayments,
            sumOfTransfer = sumOfTransfer,
            sumOfPrevious = sumOfPrevious
        )

        // assert
        assertEquals(0, result)
    }

    @Test
    fun calculateCommission_TypesOfPaymentsMASTERCARD_250_000() {
        // arrange
        val typeOfPayments = TypesOfPayments.MASTERCARD
        val sumOfTransfer = 200_000_00
        val sumOfPrevious = 50_000_00

        // act
        val result = calculateCommission(
            typeOfPayments = typeOfPayments,
            sumOfTransfer = sumOfTransfer,
            sumOfPrevious = sumOfPrevious
        )

        // assert
        assertEquals(1_070_00, result)
    }

    @Test
    fun calculateCommission_TypesOfPaymentsMIR_30() {
        // arrange
        val typeOfPayments = TypesOfPayments.MIR
        val sumOfTransfer = 30_00

        // act
        val result = calculateCommission(
            typeOfPayments = typeOfPayments,
            sumOfTransfer = sumOfTransfer
        )

        // assert
        assertEquals(35_00, result)
    }

    @Test
    fun calculateCommission_TypesOfPaymentsMIR_210_000() {
        // arrange
        val typeOfPayments = TypesOfPayments.MIR
        val sumOfTransfer = 200_000_00
        val sumOfPrevious = 10_000_00

        // act
        val result = calculateCommission(
            typeOfPayments = typeOfPayments,
            sumOfTransfer = sumOfTransfer,
            sumOfPrevious = sumOfPrevious
        )

        // assert
        assertEquals(1_500_00, result)
    }

    @Test
    fun calculateCommission_TypesOfPaymentsVK_PAY() {
        // arrange
        val typeOfPayments = TypesOfPayments.VK_PAY
        val sumOfTransfer = 300_000_00

        // act
        val result = calculateCommission(
            typeOfPayments = typeOfPayments,
            sumOfTransfer = sumOfTransfer
        )

        // assert
        assertEquals(0, result)
    }

}
