package kata.bank;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

	public static void main(String[] args) {

		BankAccount account = new BankAccount();

		double amount = 0;
		System.out.println("Welcome to your personal bank account");

		Scanner input;
		int choice = 0;

		while (choice != 4) {
			System.out.println(account);
			System.out.println("Choose  the number of the action you want to perform   and press enter");
			display();
			input = new Scanner(System.in);

			try {
				choice = input.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("InputMismatchException");
				System.out.println("Please choose  an authorized action");
				display();
			}

			switch (choice) {
			case 1:
				System.out.println("Enter the amount to deposit");
				try {
					amount = input.nextDouble();
					if (amount > Double.MAX_VALUE) {
						System.err.println("Number too large\n");
					} else {
						account.deposit(amount);
					}

				} catch (InputMismatchException e) {
					System.out.println("\nUnexpected amount\n");

				}

				break;
				
			case 2:
				System.out.println("Enter the amount to withdraw");

				try {
					amount = input.nextDouble();
					if (amount > Double.MAX_VALUE) {
						System.err.println("Number too large\n");
					} else {
						account.withdraw(amount);
					}

				} catch (InputMismatchException e) {
					System.out.println("Unexpected amount\n");

				}

				break;
				
			case 3:
				account.getHistory();
				break;
			case 4:
				System.out.println("Have a nice day");
				break;
			default:
				System.out.println("\nUnexpected Choice \n");

			}
		}

	}

	public static void display() {
		System.out.println("1) Deposit Money");
		System.out.println("2) Withdraw Money");
		System.out.println("3) History of operations");
		System.out.println("4) Quit");

	}

}
