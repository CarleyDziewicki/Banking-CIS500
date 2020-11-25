import java.util.*;

/**
 * The Customer class represents a customer in a bank.
 * 
 * @author Nandigam
 */
public class Customer {
	
	private String ssn;
	private String name;
	private String phone;
	
	// list of BankAccounts that belong to this customer
	private ArrayList<BankAccount> acts;
	
	/**
	 * Initializes a newly constructed Customer object with the specified values.
	 * 
	 * @param ssn SSN of customer
	 * @param name customer name
	 * @param phone customer phone number
	 */
	public Customer(String ssn, String name, String phone) {
		this.ssn = ssn;
		this.setName(name);
		this.setPhone(phone);
		acts = new ArrayList<BankAccount>();
	}
	
	/**
	 * Returns the SSN of this Customer object.
	 * 
	 * @return customer SSN
	 */
	public String getSSN() {
		return ssn;
	}
	
	/**
	 * Returns the name of this Customer object.
	 * 
	 * @return customer name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Sets the name of this Customer object to the specified value.
	 * 
	 * @param name customer name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Returns the phone number of this Customer object.
	 * 
	 * @return customer phone number
	 */
	public String getPhone() {
		return phone;
	}
	
	/**
	 * Sets the phone number of this Customer object to the specified value.
	 * 
	 * @param phone customer phone number
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	/**
	 * Adds the specified account to the list of accounts owned by this customer.
	 * 
	 * @param act the BankAccount object to add
	 */
	public void addAccount(BankAccount act) {
		if (act != null && !acts.contains(act)) {
			acts.add(act);
		}
	}
	
	/**
	 * Returns the list of BankAccount objects owned by this customer.
	 * 
	 * @return list of BankAccount objects of this customer
	 */
	public ArrayList<BankAccount> getAccounts() {
		return acts;
	}
	
	/**
	 * Returns a String object representing this Customer object.
	 * 
	 * @return string representing this Customer object
	 */
	public String toString() {
		return name + "; " + ssn + "; " + phone;
	}
}
