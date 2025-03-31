open class Account(val accountNumber: String, var balance: Double) {

    open fun deposit(amount: Double) {
        if (amount > 0) {
            balance += amount
            println("Deposited $$amount. New balance: $$balance")
        } else {
            println("Invalid deposit amount.")
        }
    }

    open fun withdraw(amount: Double) {
        if (amount > 0 && amount <= balance) {
            balance -= amount
            println("Withdrew $$amount. New balance: $$balance")
        } else {
            println("Invalid withdrawal amount or insufficient funds.")
        }
    }

    open fun info() {
        println("Account: $accountNumber, Balance: $$balance")
    }
}