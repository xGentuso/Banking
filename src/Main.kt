fun main() {
    // Original accounts
    val checking = CheckingAccount("CHK123", 1000.0, 500.0)
    val savings = SavingsAccount("SAV456", 2000.0, 3.5)

    // New Canadian registered accounts
    val tfsa = TFSAAccount("TFSA789", 5000.0, 6000.0, 6000.0)
    val rrsp = RRSPAccount("RRSP101", 10000.0, 27830.0, 15000.0, 4.0)

    println("\n--- Checking Account Transactions ---")
    checking.info()
    checking.deposit(200.0)
    checking.withdraw(1500.0)  // Uses overdraft

    println("\n--- Savings Account Transactions ---")
    savings.info()
    savings.deposit(500.0)
    savings.applyInterest()
    savings.withdraw(3000.0)  // Should fail

    println("\n--- TFSA Account Transactions ---")
    tfsa.info()
    tfsa.deposit(3000.0)
    tfsa.withdraw(1000.0)
    tfsa.deposit(5000.0)  // Should exceed contribution room
    tfsa.addNewYearContributionRoom(6000.0)  // Simulate new year
    tfsa.deposit(2000.0)

    println("\n--- RRSP Account Transactions ---")
    rrsp.info()
    rrsp.deposit(5000.0)
    rrsp.applyInterest()
    rrsp.withdraw(1000.0)  // Regular withdrawal (taxable)
    rrsp.withdrawForHomeOrEducation(10000.0, "Home Buyers' Plan")
    rrsp.updateContributionRoom(5000.0)  // Simulate new year
}