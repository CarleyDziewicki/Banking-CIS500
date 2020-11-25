/**
 * The Transaction class represents a bank transaction (deposit, withdrawal, and transfer).
 * A transfer transaction is done as a withdrawal from one account followed by a deposit
 * to another account.
 * 
 * @author  Nandigam
 */
public class Transaction {
	
	private TransactionType type;
	private double amount;
	
	/**
	 * Initializes a newly created Transaction object with type and amount.
	 * 
	 * @param type transaction type
	 * @param amount transaction amount
	 */
	public Transaction (TransactionType type, double amount) {
		this.type = type;
		this.amount = amount;
	}
	
	/**
	 * Returns the transaction type.
	 * 
	 * @return the type of this transaction
	 */
	public TransactionType getType() {
		return type;
	}
	
	/**
	 * Returns the amount of this transaction.
	 * 
	 * @return the amount of this transaction
	 */
	public double getAmount() {
		return amount;
	}
	
	/**
	 * Returns a string representing this Transaction object.
	 * 
	 * @return string representation of this Transaction object
	 */
	public String toString() {
		String result = String.format("%s: $%.2f", type, amount);
		return result;
	}
}
