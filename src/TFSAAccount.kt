class TFSAAccount(
    accountNumber: String,
    balance: Double,
    private val annualContributionLimit: Double,
    private var contributionRoom: Double
) : Account(accountNumber, balance) {

    private var yearlyContributions: Double = 0.0

    // Override deposit to track contributions against limits
    override fun deposit(amount: Double) {
        if (amount > 0) {
            if (yearlyContributions + amount <= contributionRoom) {
                balance += amount
                yearlyContributions += amount
                contributionRoom -= amount
                println("Deposited $$amount to TFSA. New balance: $$balance")
                println("Remaining contribution room: $$contributionRoom")
            } else {
                println("Deposit exceeds your TFSA contribution room of $$contributionRoom")
            }
        } else {
            println("Invalid deposit amount.")
        }
    }

    // Add method to reset yearly contribution tracking (typically done annually)
    fun addNewYearContributionRoom(additionalRoom: Double) {
        yearlyContributions = 0.0
        contributionRoom += additionalRoom
        println("Added $$additionalRoom in new contribution room. Total available: $$contributionRoom")
    }

    // Tax-free withdrawals
    override fun withdraw(amount: Double) {
        if (amount > 0 && amount <= balance) {
            balance -= amount
            // Withdrawals create new contribution room for the following year
            println("Withdrew $$amount tax-free. New balance: $$balance")
            println("Note: This withdrawal will create $$amount in additional contribution room next year.")
        } else {
            println("Invalid withdrawal amount or insufficient funds.")
        }
    }

    override fun info() {
        super.info()
        println("Account type: TFSA (Tax-Free Savings Account)")
        println("Annual contribution limit: $$annualContributionLimit")
        println("Available contribution room: $$contributionRoom")
        println("Year-to-date contributions: $$yearlyContributions")
    }
}