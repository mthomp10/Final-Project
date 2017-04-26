
public class CheckingAccount extends BankAccount {

	private int checkNumber;

	public CheckingAccount(String name, int num){
		super(name);
		if(num > 1000)
			checkNumber = num;
		else 
			checkNumber = 1000;
	}
	public int getCheckNumber(){
		return checkNumber;
	}
	public String toString(){
		 return super.toString() + "\n" + "NextCheck Number:      " + "#" + checkNumber;
		
	}
	public void writeCheck(){
		
		checkNumber++;
	}
	
}
