import java.util.InputMismatchException;
import java.util.Scanner;

public class Run {

	public static void main(String[] args) {
		
		Bank myBank = new Bank();
		String result;
		int option;
		long newID;
		
		while(true) {
			System.out.println("****************************");
			System.out.println("1. Create a new personal customer");
			System.out.println("2. Create a new commercial customer");
			System.out.println("3. Withdraw");
			System.out.println("4. Deposit");
			System.out.println("5. Transfer");
			System.out.println("6. Display Customer Info");
			System.out.println("7. Calculate ROI on the current balance");
			System.out.println("8. Create personal customers from file");
			System.out.println("9. Exit");
			System.out.println("****************************");
			System.out.println("Enter an option from above");
			Scanner sc = new Scanner(System.in);
			option = sc.nextInt();
			
			try {
				switch(option) {
				case 1:
					
					try {
						System.out.println("Enter first name, last name, "
								+ "address, home phone, work phone, opening balance");
						
						newID = myBank.createPersonalCustomer(sc.next(), 
								sc.next(), sc.next(), sc.next(),
								sc.next(), sc.nextDouble());
						System.out.println("Customer created with ID: " + newID + "\n");
						break;
					}
					
					catch(InputMismatchException ime) {
						System.out.println("Please enter a valid balance");
					}
					
				case 2:
					System.out.println("Enter first name, last name, "
							+ "address, contact person name, contact person phone, "
							+ "opening balance");
					
					newID = myBank.createCommercialCustomer(sc.next(), 
							sc.next(), sc.next(), sc.next(),
							sc.next(), sc.nextDouble());
					System.out.println("Customer created with ID: " + newID + "\n");
					break;
					
				case 3:
					System.out.println("Enter the customer ID and the amount to"
							+ " be withdrawn");
					result = myBank.withdraw(sc.nextLong(), sc.nextDouble());
					System.out.println(result + "\n");
					break;
					
				case 4:
					System.out.println("Enter the customer ID and the amount to"
							+ " be deposited");
					result = myBank.deposit(sc.nextLong(), sc.nextDouble());
					System.out.println(result + "\n");
					break;
					
				case 5:
					System.out.println("Enter the from customer ID, to customer ID and the amount to be transferred");
					result = myBank.transfer(sc.nextLong(), sc.nextLong(), sc.nextDouble());
					System.out.println(result + "\n");
					break;
					
				case 6:
					System.out.println("Enter the customer ID:");
					result = myBank.getInfo(sc.nextLong());
					System.out.println(result + "\n");
					break;
					
				case 7:
					System.out.println("Enter the customer ID:");
					result = myBank.getCustROI(sc.nextLong());
					System.out.println(result + "\n");
					break;
					
				case 8:
					System.out.println("Enter the file name:");
					myBank.readPersonalCustomersFromFile(sc.next());
					break;
					
				case 9:
					sc.close();
					System.exit(0);
					
				default:
					System.out.println("Invalid option entered");
				}
			}
			
			catch(InputMismatchException ipe) {
				System.out.println(ipe.getMessage());
			}
			
			catch(CustomerNotFoundException cnfe) {
				System.out.println(cnfe);
			}
			
			catch(Exception e) {
				System.out.println(e);
			}
		}	
	}
}
