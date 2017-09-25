package kata.bank;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BankAccount {

	/* Account identifier */
	private int accountNumber;
	/* Balance of account */
	private double balance;
	/* A list of operations */
	private List<Operation> operationList;

	public BankAccount(int id, double balance) {
		this.accountNumber = id;
		this.balance = balance;
		this.operationList = new ArrayList<Operation>();
	}

	public BankAccount(int id) {
		this(id, 0);
	}

	public BankAccount() {
		this(new Random().nextInt(999999999));
	}

	/**
	 * Add amount to account
	 * 
	 * @param amount
	 *            the money amount to add
	 */
	public double deposit(double amount) {
		if ((amount > 0) && (amount+balance < Double.MAX_VALUE)) {

			balance += amount;

			Operation operation = new Operation( OperationType.DEPOSIT, amount, balance);
			operationList.add(operation);
			System.out.println("\nSuccess!"
					+ " Deposit of " + amount + " eur\n");
			return balance;

		} else {
			System.out.println("You cannot deposit a negative or null  amount \n");
			return balance;
		}
	}

	/**
	 * 
	 * @param amount to withdraw
	 * @return the balance after operation
	 */
	public double withdraw(double amount) {
		if (amount <= balance) {
			balance -= amount;

			Operation operation = new Operation( OperationType.WITHDRAWAL, amount, balance);
			operationList.add(operation);
			System.out.println("\nSucess!"
					+ " Withdrawal of " + amount + " eur\n");
			return balance;
		}
		System.out.println("You can't withdraw "+amount+ "eur .Balance too low\n");
		return balance;
	}

	/**
	 * Print the list of operations realized on the account , starting with the most
	 * recent.
	 */
	public void getHistory() {
		System.out.println("History of operations from most recent to most ancient \n");
		int sizeList = operationList.size();
		if (sizeList == 0)
			System.out.println("No operation recorded\n");
		else
			for (int i = operationList.size() - 1; i >= 0; i--) {
				System.out.println(operationList.get(i));
			}
	}

	public int getIdCustomer() {
		return accountNumber;
	}

	public void setIdCustomer(int idCustomer) {
		this.accountNumber = idCustomer;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String toString() {
		return "###########################################################################\n"
				+ "Your account number: " + accountNumber + " Balance: " + balance + "\n"
				+ "###########################################################################\n";
	}

}