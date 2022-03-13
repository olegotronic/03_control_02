const val FREE_LIMIT_MASTERCARD_MAESTRO = 75_000_00
const val PERCENT_MASTERCARD_MAESTRO = .6
const val FIX_PAY_MASTERCARD_MAESTRO = 20_00
const val PERCENT_VISA_MIR = .75
const val MINIMAL_PAY_VISA_MIR = 35_00

enum class TypesOfPayments {
    MASTERCARD, MAESTRO, VISA, MIR, VK_PAY
}

fun main() {

    println("Sum: ${2000_00}, commission: ${calculateCommission(TypesOfPayments.MASTERCARD, 2000_00, 74_000_00)}")
    println("Sum: ${100_00}, commission: ${calculateCommission(TypesOfPayments.MIR, 100_00)}")
    println("Sum: ${1_000_00}, commission: ${calculateCommission(TypesOfPayments.MIR, 1_000_00)}")
    println("Sum: ${1_000_00}, commission: ${calculateCommission(TypesOfPayments.VK_PAY, 1_000_00)}")

}

fun calculateCommission(typeOfPayments: TypesOfPayments, sumOfTransfer: Int, sumOfPrevious: Int = 0): Int {

    return when (typeOfPayments) {
        TypesOfPayments.MASTERCARD, TypesOfPayments.MAESTRO -> {
            val sumOfBase = sumOfPrevious + sumOfTransfer - FREE_LIMIT_MASTERCARD_MAESTRO
            if (sumOfBase > 0) (sumOfBase * PERCENT_MASTERCARD_MAESTRO / 100).toInt() + FIX_PAY_MASTERCARD_MAESTRO else 0
        }
        TypesOfPayments.VISA, TypesOfPayments.MIR -> {
            val sumOfCommission = (sumOfTransfer * PERCENT_VISA_MIR / 100).toInt()
            if (sumOfCommission > MINIMAL_PAY_VISA_MIR) sumOfCommission else MINIMAL_PAY_VISA_MIR
        }
        TypesOfPayments.VK_PAY -> {
            0
        }
    }

}