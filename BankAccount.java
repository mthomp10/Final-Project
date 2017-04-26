
// Name: Max Thompson
//Assignment: PA11 BankAccount
//Description: This class is used to create BankAccount objects
//Time spent:
import java.util.Date;

public class BankAccount {
	protected String name;
	protected static double balance;
	protected static int acctNum;
	protected Date date;
	static int accountsCreated;

	public BankAccount(String name) {
		this.name = name;
		balance = 0;
		acctNum = generateAcctNum();
		date = new Date();
		accountsCreated++;
	}

	public Double getBalance() {

		return balance;
	}

	public int getAccountNumber() {
		return acctNum;
	}

	public static boolean deposit(double deposit) {
		if (deposit > 0) {
			balance = deposit + balance;
			return true;
		} else 
		{
			return false;
		}

	}

	public static boolean withdraw(double withdraw) {
		if (withdraw > 0 && withdraw <= balance) {
			balance = balance - withdraw;
			return true;
		} else {
			return false;
		}
	}

	public String toString() {
		return name + " " + "[" + acctNum + "]\n" + date.toString() + "\n" + "$" + String.format("%,.2f", balance);
	}

	public boolean equals(BankAccount that) {
		if (this.acctNum == that.acctNum)
			return true;
		else
			return false;

	}

	protected int generateAcctNum() {
		int x = 0;
		for (int i = 0; i < 9; i++) {
			x += (x * 10) + (Math.random() * 9 + 1);
		}
		return x;
	}

	public boolean transfer(BankAccount that, double money) {
		if (money < 0 || this.balance < money){
			return false;
		}
			that.deposit(money);
			this.withdraw(money);
			return true;
	}
	
	public static int getAccountsCreated(){
		return accountsCreated;
	}
		

}
