class SavingsAccount(accountNumber: String, balance: Double, private val interestRate: Double) :
    Account(accountNumber, balance) {

    fun applyInterest() {
        val interest = balance * (interestRate / 100)
        balance += interest
        println("Interest of $$interest applied. New balance: $$balance")
    }

    override fun info() {
        super.info()
        println("Interest Rate: $interestRate%")
    }
}