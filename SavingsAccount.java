/**
 * The SavingsAccount class represents a checking account in the bank.
 * 
 * @author Carley Dziewicki
 *
 */
public class SavingsAccount extends BankAccount {

	private double interestRate;
	
	/**
	 * Initializes a newly constructed SavingsAccount object with initial balance, interest rate,
	 * and owner information.
	 * 
	 * @param initialBalance initial balance
	 * @param interestRate interest rate to be paid
	 * @param owner owner of this account
	 */
	public SavingsAccount(double initialBalance, double interestRate, Customer owner) {
		super(initialBalance,owner);
		this.interestRate = interestRate;
	}
	
	/**
	 * Calculate and adds interest (as a deposit) to the current balance.
	 */
	public void addInterest() {
		
		// COMPLETE THIS METHOD
		double interest = (getBalance() * (interestRate /100));
		deposit(interest);
	}
	
	/**
	 * Returns a String object representing this SavingsAccount object.
	 * 
	 * @return string representing this SavingsAccount object
	 */
	public String toString() {
		return "Savings Account: " + super.toString() + " Interest Rate: " + interestRate;
	}
}
