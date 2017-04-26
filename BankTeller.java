import java.util.Scanner;

public class BankTeller {

	private static Bank company = new Bank(4);

	public static void main(String[] args) {
		char command;
		Scanner input = new Scanner(System.in);
		printMenu();

		do {
			System.out.println("\nPlease Enter a Command or Type ?");
			command = input.nextLine().toLowerCase().charAt(0);

			switch (command) {
			case 'a':
				int savingsOrchecking = -1;
				while (savingsOrchecking < 1 || savingsOrchecking > 2) {
					System.out.print("\nEnter 1 for Savings Account or 2 for Checking Account: ");
					savingsOrchecking = Integer.parseInt(input.nextLine());
				}
				System.out.print("Enter account holder name: ");
				String name = input.nextLine();

				BankAccount a;
				if (savingsOrchecking == 1) {
					System.out.print("Enter interest Rate:  ");
					double interestRate = Double.parseDouble(input.nextLine());
					a = new SavingsAccount(name, interestRate);
				} else {
					System.out.print("Enter starting check number:   ");
					int checkNumber = Integer.parseInt(input.nextLine());
					a = new CheckingAccount(name, checkNumber);
				}

				if (company.add(a))
					System.out.print("\nBank Account successfully added.\n");
				else
					System.out.print("Bank Account not added. No duplicates please.\n");
				break;

			case 'b': // remove an account
				System.out.print("\nEnter account number: ");
				int accntNum = Integer.parseInt(input.nextLine());
				if (company.remove(company.find(accntNum)))
					System.out.print("\nBankAccount successfully removed.\n");
				else
					System.out.print("Bank Account not found. Cannot remove.\n");
				break;

			case 'c': // display the accounts
				System.out.println(company.toString());
				break;

			case 'd': // count the accounts
				System.out.println("\nThere are " + company.getCount() + " accounts in the bank");
				break;
			case 'e':
				company.sort();

			case 'f':
				System.out.println("\nEnter account number:   ");
				int accountNumber = Integer.parseInt(input.nextLine());
				if (company.find(accountNumber) != null) {
					int action = 0;
					System.out.print("\nEnter 1 for deposit or 2 for withdraw:  ");
					action = Integer.parseInt(input.nextLine());
					if (action == 1){
						System.out.println("\nEnter amount: ");
						double deposit = Double.parseDouble(input.nextLine());
						if (BankAccount.deposit(deposit))
							System.out.print("\nTransaction successful" + "\nChecking Account Updated:\n"+ company.find(accountNumber));
					}
					if (action == 2){
						System.out.println("\nEnter amount: ");
					double withdraw = Double.parseDouble(input.nextLine());
					if (BankAccount.withdraw(withdraw))
						System.out.print("\nTransaction successful" + "\nChecking Account Updated:\n"+ company.find(accountNumber));
					}

				}
			case '?':
				printMenu();
				break;
			}
		} while (command != 'q');
	}

	public static void printMenu() {
		System.out.print("\nBank Tell Options\n" + "-----------------------------------\n"
				+ "a: add an account to the bank\n" + "b: remove an account from the bank\n"
				+ "c: display the accounts in the bank\n" + "d: count the accounts in the bank\n"
				+ "e: sort the accounts in the bank\n" + "f: update an account in the bank\n"
				+ "?: display the menu again\n" + "q: quit this program\n\n");
	}
}
