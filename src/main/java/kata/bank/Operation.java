package kata.bank;

import java.util.Date;

public class Operation {

	private Date date;

	private OperationType operation;

	private double amount;

	private double balance;

	public Operation(Date date, OperationType operation, double amount, double balance) {
		this.date = date;
		this.operation = operation;
		this.amount = amount;
		this.balance = balance;
	}

	public Operation(OperationType operation, double amount, double balance) {
		this.date = new Date();
		this.operation = operation;
		this.amount = amount;
		this.balance = balance;
	}

	public String toString() {
		return operation + " of " + amount + " eur at Date: " + date + " Your balance  after this operation was of "
				+ balance + " $\n";
	}

}
