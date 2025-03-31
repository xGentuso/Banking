//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val checking = CheckingAccount("CHK123", 1000.0, 500.0)
    val savings = SavingsAccount("SAV456", 2000.0, 3.5)

    println("\n--- Checking Account Transactions ---")
    checking.info()
    checking.deposit(200.0)
    checking.withdraw(1500.0)  // Uses overdraft

    println("\n--- Savings Account Transactions ---")
    savings.info()
    savings.deposit(500.0)
    savings.applyInterest()
    savings.withdraw(3000.0)  // Should fail
}