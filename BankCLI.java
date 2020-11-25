import java.util.*;

/**
 * BankCLI class implements a command-line user interface (CLI) to the banking application.
 * 
 * @author  Carley Dziewicki
 */
public class BankCLI {

	private static Bank bank = new Bank();
	private static Scanner sc = new Scanner(System.in);
	
	/**
	 * Main driver of the bank application.
	 * 
	 * @param args command-line arguments (not used)
	 */
	public static void main(String[] args) {

		while (true) {
			int choice = displayMenuAndGetSelection();
			switch (choice) {
				case 1:
					addCustomer();
					break;
					
				case 2:
					addAccount();
					break;
					
				case 3:
					listCustomers();
					break;
			
				case 4:
					listAccounts();
					break;
					
				case 5:
					listCustomerAccounts();
					break;
					
				case 6:
					listAccountTransactions();
					break;
					
				case 7:
					accountDeposit();
					break;
					
				case 8:
					accountWithdraw();
					break;
					
				case 9:
					accountBalance();
					break;
					
				case 10:
					transferFunds();
					break;
					
				case 11:
					processAccounts();
					break;
					
				case 12:
					System.out.println("Good Bye!!!");
					System.exit(0);
			}
		}
	}
	
	/**
	 * Displays the command menu, prompts and reads the command choice from the user.
	 * 
	 * @return command choice
	 */
	private static int displayMenuAndGetSelection() {
		int choice;
		boolean repeat;
		
		do {
			System.out.println("<<<<<<<<< GVSU Lakers Bank Menu >>>>>>>>>");
			System.out.println("1.  Add Customer");
			System.out.println("2.  Add Account");
			System.out.println("3.  List All Customers");
			System.out.println("4.  List All Accounts");
			System.out.println("5.  List Customer's Accounts");
			System.out.println("6.  List Account's Transactions");
			System.out.println("7.  Account Deposit");
			System.out.println("8.  Account Withdraw");
			System.out.println("9.  Account Balance");
			System.out.println("10. Funds Transfer");
			System.out.println("11. Process Accounts");
			System.out.println("12. Quit");
			System.out.print("Enter your selection: ");
			choice = Integer.parseInt(sc.nextLine());
			repeat = choice < 1 || choice > 12;
			if (repeat) {
				System.out.println("Invalid selection. Try again....");
			}
		} while (repeat);
		
		return choice;
	}
	
	/**
	 * Handles the "Add Customer" menu choice
	 */
	private static void addCustomer() {		
		
		// COMPLETE THIS METHOD
		System.out.print("Please enter your 9 digit SSN: ");
		String ssn = sc.nextLine().trim();
		
		System.out.print("Please enter your full name: ");
		String custName = sc.nextLine();
		
		System.out.print("Please enter you phone number: ");
		String phone = sc.nextLine();
		
		boolean successful = bank.addCustomer(ssn, custName, phone);
		
		if(successful) {
			System.out.println("Add customer operation successful");
		} else {
			System.out.println("Add customer operation failed");
		}
	}
	
	/**
	 * Handles the "Add Account" menu choice
	 */
	private static void addAccount() {

		// COMPLETE THIS METHOD
		boolean success = false;
		System.out.print("Please enter your SSN: ");
		String ssn = sc.nextLine().trim();

		if (ssn.replace("-", "").trim().length() == 9) {

			System.out.print("Please enter the balance: ");
			double balance = Double.parseDouble(sc.nextLine().trim());

			System.out.print("Checking(c/C) or Savings(s/S) Account: ");
			String type = sc.nextLine().trim();

			if (type.equalsIgnoreCase("c")) {
				success = bank.addCheckingAccount(ssn, balance);

			} else if (type.equalsIgnoreCase("s")) {

				System.out.print("Please enter the interest rate: ");
				double interestRate = Double.parseDouble(sc.nextLine().trim());

				success = bank.addSavingsAccount(ssn, balance, interestRate);

			} else {
				System.out.println("Invalid account type");
			}

			if (success) {
				System.out.println("Add account operation successful");
			} else {
				System.out.println("Add account operation failed");
			}
		} else {
			System.out.println("Not valid input for social security number.");
		}

	}
	
	/**
	 * Handles the "List All Customers" menu choice
	 */
	private static void listCustomers() {
		
		// COMPLETE
		if(bank.getNbrCustomers() > 0) {
			
			for(Customer customer : bank.getCustomers()) {
			
				System.out.println(customer); 
			}
		}else {
			System.out.println("The bank has no customers at this time.");
		}
	}
	
	/**
	 * Handles the "List All Accounts" menu choice
	 */
	private static void listAccounts() {
		
		// COMPLETE
		if(bank.getNbrAccounts() > 0) {
			for (BankAccount account : bank.getAccounts()) {
				System.out.println(account);
			}
		}else {
			System.out.println("The bank has no accounts at this time.");
		}
	}
	
	/**
	 * Handles the "List Customer's Accounts" menu choice
	 */
	private static void listCustomerAccounts() {
		
		// COMPLETE
		System.out.print("Please enter 9 digit SSN: ");
		
		String ssn = sc.nextLine().trim();

		if (ssn.replace("-", "").trim().length() == 9) {
			Customer owner = bank.getCustomer(ssn);

			for (BankAccount account : bank.getAccounts()) {
				if (owner.equals(account.getOwner())) {
					System.out.println(account);
				}
			}
		} else {
			System.out.println("Not valid input for ssn");
		}
	}
	
	/**
	 * Handles the "List Account's Transactions" menu choice
	 */
	private static void listAccountTransactions() {
		
		// COMPLETE THIS METHOD
		System.out.print("Please enter your account number: ");
		String actNumber = sc.nextLine();
		BankAccount acct = bank.getAccount(actNumber);
		
		for(Transaction account : acct.getTransactions()) {
		System.out.println(account);
		}
	}
	
	/**
	 * Handles the "Account Deposit" menu choice
	 */
	private static void accountDeposit() {
		
		// COMPLETE
		System.out.print("Please enter your account number: ");
		String actNumber = sc.nextLine();

		if (bank.getAccount(actNumber) != null) {
			System.out.print("Please enter the amount to deposit: ");
			double amt = Double.parseDouble(sc.nextLine().trim());
			
			boolean successful = bank.deposit(actNumber, amt);
			if (successful) {
				System.out.println("Deposit successful");
			} else {
				System.out.println("Deposit not successful");
			}
		} else {
			System.out.println("Account number not valid");
		}
	}
	
	/**
	 * Handles the "Account Withdraw" menu choice
	 */
	private static void accountWithdraw() {

		// COMPLETE THIS METHOD
		System.out.print("Please enter your account number: ");
		String actNumber = sc.nextLine();

		if (bank.getAccount(actNumber) != null) {
			System.out.print("Please enter the amount to withdraw: ");
			double amt = Double.parseDouble(sc.nextLine().trim());

			boolean successful = bank.withdraw(actNumber, amt);

			if (successful) {
				System.out.println("Withdraw successful");
			} else {
				System.out.println("Withdraw not successful");
			}
		} else {
			System.out.println("Account number not valid");

		}
	}

	/**
	 * Handles the "Account Balance" menu choice
	 */
	private static void accountBalance() {
		
		// COMPLETE THIS METHOD
		System.out.print("Please enter your account number: ");
		String actNumber = sc.nextLine();
		
		if(bank.getAccount(actNumber) != null) {
			System.out.printf("Account Balance: $%,.2f%n", bank.getAccount(actNumber).getBalance());
		}
	}
	
	/**
	 * Handles the "Funds Transfer" menu choice
	 */
	private static void transferFunds() {

		// COMPLETE
		System.out.print("Enter account number to transfer from: ");
		String actFrom = sc.nextLine();
		System.out.print("Enter account number to transfer to: ");
		String actTo = sc.nextLine();
		
		boolean successful = false;

		if (bank.getAccount(actFrom) != null && bank.getAccount(actTo) != null) {

			System.out.print("How much to transfer: ");
			double amtTransfer = Double.parseDouble(sc.nextLine().trim());

			successful = bank.transferFunds(bank.getAccount(actFrom), bank.getAccount(actTo), amtTransfer);
		} else {
			System.out.println("Bank account numbers not valid");
		}
		
		//checks for completion
		if (successful) {
			System.out.println("Transfer successful");
		} else {
			System.out.println("Transfer not successful");
		}

}


	/**
	 * Handles the "Process Accounts" menu choice.
	 * For each CheckingAccount in the bank, fee is deducted.
	 * For each SavingsAccount in the bank, interest is added.
	 */
	private static void processAccounts() {
		ArrayList<BankAccount> acts = bank.getAccounts();
		
		if (acts == null || acts.isEmpty()) {
			System.out.println("The bank currently has no accounts to process.");
			return;
		}
		
		for (BankAccount act : acts) {
			if (act instanceof CheckingAccount) {
				((CheckingAccount) act).deductFees();
			}
			if (act instanceof SavingsAccount) {
				((SavingsAccount) act).addInterest();
			}
		}
		
		System.out.println("Accounts processed.");
	}
}
