package kata.bank;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class BankAccountTest {

	protected BankAccount bankAcc;

	@Before
	public void setUp() throws Exception {
		bankAcc = new BankAccount();

	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testDeposit() {
		final double delta = 1e-15;
		final double amount1 = 100.5;
		final double amount2 = -10;
		double previousBalance  ;
		
		/*Test deposit of 100 �*/
		previousBalance = bankAcc.getBalance();
		bankAcc.deposit(amount1);
		assertEquals(previousBalance+ amount1,bankAcc.getBalance(),delta);
		
		/*Test Deposit of a negative amount*/
		previousBalance = bankAcc.getBalance();
		bankAcc.deposit(amount2);
		assertEquals(previousBalance,bankAcc.getBalance(),delta);
		
	}
	@Test
	public void testWithdraw() {
		final double delta = 1e-15;
		final double amount1 = 10;
		final double amount2 = -10;
		final double amount3 = 200.20;

		double previousBalance  ;
		
		/*Test withdrawal of an amount that is superior to the balance*/
		bankAcc.setBalance(0);
		previousBalance = bankAcc.getBalance();
		bankAcc.withdraw(amount1);
		assertEquals(previousBalance,bankAcc.getBalance(),delta);
		
		/*Test withdrawal of an amount that is inferior to the balance*/
		bankAcc.setBalance(amount3);
		previousBalance = bankAcc.getBalance();
		bankAcc.withdraw(amount1);
		assertEquals(previousBalance-amount1 ,bankAcc.getBalance(),delta);
		
		/*Test Withdrawal of a negative amount*/
		previousBalance = bankAcc.getBalance();
		bankAcc.deposit(amount2);
		assertEquals(previousBalance,bankAcc.getBalance(),delta);
		
	}
}
