class CheckingAccount(accountNumber: String, balance: Double, private val overdraftLimit: Double) :
    Account(accountNumber, balance) {

    override fun withdraw(amount: Double) {
        if (amount > 0 && (balance + overdraftLimit) >= amount) {
            balance -= amount
            println("Withdrew $$amount (Overdraft Limit: $$overdraftLimit). New balance: $$balance")
        } else {
            println("Withdrawal denied. Exceeds overdraft limit.")
        }
    }

    override fun info() {
        super.info()
        println("Overdraft Limit: $$overdraftLimit")
    }
}
