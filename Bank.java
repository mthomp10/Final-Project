
public class Bank {

	private BankAccount[] accounts;
	private int count;

	public Bank(int size) {

		accounts = new BankAccount[size];
		count = 0;
	}

	private int indexOf(BankAccount a) {
		if(a == null) return -1;
		for(int i = 0; i < count; i++)
			if(accounts[i].equals(a)) return i;
		return -1;
	}

	private void doubleCapacity() {
		BankAccount tempArray[] = new BankAccount[accounts.length * 2];
		for (int i = 0; i < accounts.length; i++) {
			tempArray[i] = accounts[i];
		}
		accounts = tempArray;
	}

	public boolean add(BankAccount a) {
		if (contains(a))
			return false;
		if (count >= accounts.length)
			doubleCapacity();
		accounts[count] = a;
		count++;
		return true;
	}

	public boolean remove(BankAccount a) {
		if (!contains(a))
			return false;
		int x = indexOf(a);
		while(x < count){
		accounts[x] = accounts[x + 1];
		count--;
		}
		if(x == count)
			accounts[x] = null;
		return true;
	}

	public boolean contains(BankAccount a) {
		return (indexOf(a) != -1);
	}

	public int getCount() {
		return count;

	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Bank Accounts\n");
		for (int i = 0; i < count; i++)
			sb.append(accounts[i] + "\n ******************    \n");
		return sb.toString();

	}

	public void sort() {
		for (int i = 0; i < count; i++) {
			if (accounts[i].getAccountNumber() > accounts[i + 1].getAccountNumber()) {
				BankAccount temp = accounts[i];
				accounts[i] = accounts[i + 1];
				accounts[i + 1] = temp;
			}
		}
	}
		public BankAccount find(int acct) {
			for(int i = 0; i <count; i++)
				if(accounts[i].getAccountNumber() == acct) return accounts[i];
			return null;
		}
		
	

	}

