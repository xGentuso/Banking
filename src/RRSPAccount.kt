class RRSPAccount(
    accountNumber: String,
    balance: Double,
    private val contributionLimit: Double,
    private var contributionRoom: Double,
    private val interestRate: Double
) : Account(accountNumber, balance) {

    private var yearlyContributions: Double = 0.0
    private var isWithdrawnForHomeOrEducation: Boolean = false

    // Override deposit to track contributions against limits
    override fun deposit(amount: Double) {
        if (amount > 0) {
            if (yearlyContributions + amount <= contributionRoom) {
                balance += amount
                yearlyContributions += amount
                contributionRoom -= amount
                println("Deposited $$amount to RRSP. New balance: $$balance")
                println("Remaining contribution room: $$contributionRoom")
                println("This contribution may be tax-deductible on your next tax return.")
            } else {
                println("Deposit exceeds your RRSP contribution room of $$contributionRoom")
            }
        } else {
            println("Invalid deposit amount.")
        }
    }

    // Apply interest (similar to savings account)
    fun applyInterest() {
        val interest = balance * (interestRate / 100)
        balance += interest
        println("Interest of $$interest applied to RRSP. New balance: $$balance")
    }

    // Update yearly contribution limit
    fun updateContributionRoom(newRoom: Double) {
        contributionRoom += newRoom
        yearlyContributions = 0.0
        println("Updated RRSP contribution room: $$contributionRoom")
    }

    // RRSP withdrawals are taxable unless for first-time home buyers or education
    override fun withdraw(amount: Double) {
        if (amount > 0 && amount <= balance) {
            balance -= amount
            println("Withdrew $$amount. New balance: $$balance")
            if (!isWithdrawnForHomeOrEducation) {
                println("Warning: This withdrawal is taxable and contribution room is permanently lost.")
            } else {
                println("Withdrawal under Home Buyers' Plan or Lifelong Learning Plan. Repayment required.")
            }
        } else {
            println("Invalid withdrawal amount or insufficient funds.")
        }
    }

    // Special withdrawal for home buyers or education purposes
    fun withdrawForHomeOrEducation(amount: Double, purpose: String) {
        if (amount > 0 && amount <= balance) {
            balance -= amount
            isWithdrawnForHomeOrEducation = true
            println("Withdrew $$amount under $purpose program. New balance: $$balance")
            println("Note: This amount must be repaid to your RRSP according to program rules.")
        } else {
            println("Invalid withdrawal amount or insufficient funds.")
        }
    }

    override fun info() {
        super.info()
        println("Account type: RRSP (Registered Retirement Savings Plan)")
        println("Annual contribution limit: $$contributionLimit (or 18% of previous year's income)")
        println("Available contribution room: $$contributionRoom")
        println("Year-to-date contributions: $$yearlyContributions")
        println("Interest Rate: $interestRate%")
    }
}