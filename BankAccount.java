import java.util.*;

/**
 * The BankAccount class represents an account in a bank.
 * 
 * @author  Carley Dziewicki
 */
public abstract class BankAccount {

	private String number;
	private double balance;
	private Customer owner;
	private ArrayList<Transaction> transactions;
	
	private static int nextActNumber = 111111;
	
	/**
	 * Initializes a newly constructed Account object with account number, balance, and owner. Account number
	 * is internally generated starting from the value of nextActNumber static variable.
	 * 
	 * @param balance account balance
	 * @param owner account owner as an instance of Customer class
	 */
	public BankAccount(double balance, Customer owner) {
		
		this.number = Integer.toString(nextActNumber);
		nextActNumber++;
		
		this.owner = owner;
		this.transactions = new ArrayList<Transaction>();
		
		if (balance > 0) {	// initial deposit transaction
			this.deposit(balance);
		}
	}
	
	/**
	 * Returns the account number of this BankAccount object.
	 * 
	 * @return account number
	 */
	public String getNumber() {
		return number;
	}
	
	/**
	 * Returns the current balance of this BankAccount object.
	 * 
	 * @return the current balance
	 */
	public double getBalance() {
		return balance;
	}
	
	/**
	 * Returns the owner of this BankAccount object.
	 * 
	 * @return the owner
	 */
	public Customer getOwner() {
		return owner;
	}
	
	/**
	 * Returns the list of Transaction objects for this BankAccount object.
	 * 
	 * @return list of Transaction objects
	 */
	public ArrayList<Transaction> getTransactions() {
		return transactions;
	}
	
	/**
	 * Returns the number of Transaction objects for this BankAccount object.
	 * 
	 * @return the number of Transaction objects
	 */
	public int getNbrTransactions() {
		return transactions.size();
	}
	
	/**
	 * Increments the balance of this BankAccount object by the specified amount.
	 * 
	 * @param amt amount to increase the balance by
	 * 
	 * @return true if deposit operation is successful, false otherwise
	 */
	public boolean deposit(double amt) {
		
		// COMPLETE 
		if(amt > 0) {
			this.balance += amt;
			transactions.add(new Transaction(TransactionType.DEPOSIT, amt));
			return true;
		}
		else {
			return false;
		}
	}
	
	
	/**
	 * Decrements the balance of this BankAccount object by the specified amount.
	 * 
	 * @param amt amount to decrease the balance by
	 * 
	 * @return true if withdrawal operation is successful, false otherwise
	 */
	public boolean withdraw(double amt) {

		// COMPLETE
		if (amt <= this.balance && amt > 0) {

			this.balance -= amt;
			transactions.add(new Transaction(TransactionType.WITHDRAWAL, amt));
			return true;

		} else {
			return false;
		}
	}

	/**
	 * Returns a String object representing this BankAccount object.
	 * 
	 * @return string representing this BankAccount object
	 */
	public String toString() {
		String result = String.format("Account #: %s  Balance: $%.2f", number, balance);
		return result;
	}
}
