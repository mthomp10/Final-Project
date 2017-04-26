
public class SavingsAccount extends BankAccount {
	private double interestRate;

	public SavingsAccount(String name, double rate) {
		super(name);
		if (rate > 0 && rate < .1)
			interestRate = rate;
		else
			interestRate = .01;
	}

	public double getRate() {
		return interestRate;
	}

	public String toString() {
		return super.toString() + "\n" + "Interest Rate:    " + "%" + String.format("%.003f", interestRate * 100.00);
	}

	public void addInterst() {

		super.balance = (balance * interestRate) + super.balance;

	}

}
