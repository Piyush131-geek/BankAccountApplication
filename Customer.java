
abstract public class Customer {
	
	private long customerID;
	private String firstName;
	private String lastName;
	private String address;
	private double balance;
	private double minimumBalance;
	
	static long counter = 1000; // -> 1001 -> 1002
	
	
	public Customer() {
		System.out.println("No values were given, customer not created");
	}
	
	public Customer(String firstName, String lastName,
			String address, double balance, double minimumBalance) {
		
		// auto increment customer ID
		this.customerID = counter;
		counter++;
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.balance = balance;
		// System.out.println("Customer created with ID " + this.customerID);
		this.minimumBalance = minimumBalance;
	}

	// parent class for all the classes in java -> object class
	// default -> object type @ hash code (8 characters) 
	// representing the object
	
//	@Override
//	public String toString() {
//		return "Customer [customerID=" + customerID + ", firstName=" +
//	firstName + ", lastName=" + lastName + 
//	", address=" + address + ", balance=" + balance + "]";
//	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public long getCustomerID() {
		return customerID;
	}
	
	public double getMinimumBalance() {
		return minimumBalance;
	}
	
	abstract String getCustomerInfo();
	
	abstract double calcROI();
}
