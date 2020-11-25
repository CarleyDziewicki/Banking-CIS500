import java.util.*;

/**
 * Bank class represents a bank that contains zero or more customers and accounts and
 * contains methods for managing customers, accounts, and operations (deposit, withdraw,
 * and transfer) on accounts.
 * 
 * @author Carley Dziewicki
 */
public class Bank {

	private ArrayList<BankAccount> accounts;
	private ArrayList<Customer> customers;
	
	/**
	 * Initializes a newly constructed Bank object.
	 */
	public Bank() {
		accounts = new ArrayList<BankAccount>();
		customers = new ArrayList<Customer>();
	}
	
	/**
	 * Returns the list of BankAccount objects of this bank.
	 * 
	 * @return list of accounts
	 */
	public ArrayList<BankAccount> getAccounts() {
		return accounts;
	}
	
	/**
	 * Returns the number of accounts in this Bank.
	 * 
	 * @return number of accounts
	 */
	public int getNbrAccounts() {
		return accounts.size();
	}
	
	/**
	 * Returns the BankAccount object with the specified account number.
	 * 
	 * @param actNumber account number of the desired Account object
	 * 
	 * @return BankAccount object if found, else null
	 */
	public BankAccount getAccount(String actNumber) {
		
		// COMPLETE THIS METHOD 
		for(BankAccount account : accounts) {
	       
			if (account.getNumber().equals(actNumber)) {
	            return account; // return member when name found
	        }
	    }
	    return null;
		
	}
	
	/**
	 * Returns the list of Customer objects of this bank.
	 * 
	 * @return list of Customers
	 */
	public ArrayList<Customer> getCustomers() {
		return customers;
	}
	
	/**
	 * Returns the number of Customers in this bank.
	 * 
	 * @return number of Customers
	 */
	public int getNbrCustomers() {
		return customers.size();
	}
	
	
	/**
	 * Returns the Customer object with the specified SSN.
	 * 
	 * @param ssn SSN of customer
	 * 
	 * @return Customer object if found, else null
	 */
	public Customer getCustomer(String ssn) {
		
		// COMPLETE 
		for(Customer customer : customers) {
	        if (customer.getSSN().equals(ssn)) {
	            return customer; // return member when name found
	        }
	    }
	    return null;
	}
	
	/**
	 * Creates a new Customer object with the specified values and adds it to the
	 * list of Customer objects managed by this bank, if the customer does not already
	 * exists in the bank.
	 * 
	 * @param ssn SSN of customer
	 * @param custName Name of customer
	 * @param phone Phone number of customer
	 * 
	 * @return true if Customer is added successfully, false otherwise
	 */
	public boolean addCustomer(String ssn, String custName, String phone) {
		
		// COMPLETE
		if (getCustomer(ssn) == null && ssn.replace("-", "").trim().length() == 9) {
			customers.add(new Customer(ssn, custName, phone));
			return true;
		} else {
			return false;
		}
	}

	/**
	 * If the customer with specified SSN exists, it creates a new CheckingAccount
	 * object with the specified balance and adds it to the list of BankAccount
	 * objects managed by this bank and to the list of BankAccount objects owned by
	 * the specified customer.
	 * 
	 * @param ssn     SSN of the customer
	 * @param balance initial balance of CheckingAccount to be created
	 * 
	 * @return true if CheckingAccount is created and added successfully, false
	 *         otherwise
	 */
	public boolean addCheckingAccount(String ssn, double balance) {

		// COMPLETE
		if (getCustomer(ssn) != null) {
			accounts.add(new CheckingAccount(balance, getCustomer(ssn)));
			return true;
		}

		return false;
	}
	
	/**
	 * If the customer with specified SSN exists, it creates a new SavingsAccount object with
	 * the specified balance and adds it to the list of BankAccount objects managed by this bank
	 * and to the list of BankAccount objects owned by the specified customer.
	 * 
	 * @param ssn SSN of the customer
	 * @param balance initial balance of SavingsAccount to be created
	 * @param interestRate interest rate to be paid
	 * 
	 * @return true if SavingsAccount is created and added successfully, false otherwise
	 */
	public boolean addSavingsAccount(String ssn, double balance, double interestRate) {
		
		// COMPLETE 
		if(getCustomer(ssn) != null) {
			
			accounts.add(new SavingsAccount(balance, interestRate, getCustomer(ssn)));
			return true;
		}
		return false;
	}
	
	/**
	 * Deposits amount specified to the BankAccount with the given account number.
	 * 
	 * @param actNumber account number
	 * @param amt       amount to deposit
	 * 
	 * @return true if deposit is successful, false otherwise
	 */
	public boolean deposit(String actNumber, double amt) {

		// COMPLETE
		if (amt > 0) {
			getAccount(actNumber).deposit(amt);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Withdraws amount specified from the BankAccount with the given account number.
	 * 
	 * @param actNumber account number
	 * @param amt amount to withdraw
	 * 
	 * @return true if withdraw is successful, false otherwise
	 */
	public boolean withdraw(String actNumber, double amt) {
		
		// COMPLETE THIS METHOD - REPLACE NEXT STATEMENT WITH YOUR IMPLEMENTATION
		if(amt > 0) {
			getAccount(actNumber).withdraw(amt);
			return true;
		} else {
		return false;
		}
	}	
	
	/**
	 * Transfers amount specified from one account to another.
	 * 
	 * @param from BankAccount to withdraw funds from
	 * @param to BankAccount to deposit funds to
	 * @param amt amount to transfer
	 * 
	 * @return true if transfer is successful, false otherwise
	 */
	public boolean transferFunds(BankAccount from, BankAccount to, double amt) {

		// COMPLETE THIS METHOD
		if (from.getBalance() >= amt && amt > 0) {
			from.withdraw(amt);
			to.deposit(amt);
			return true;
		}
		return false;
	}

}
