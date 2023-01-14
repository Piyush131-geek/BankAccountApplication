import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;

public class Bank {

	ArrayList<Customer> custArr = new ArrayList<Customer>();
	
	// create customers
	public long createPersonalCustomer(String firstName, 
			String lastName, String address, String homePhone,
			String workphone, double balance) {	
		
		// child class constructor
		PersonalCustomer cust = new PersonalCustomer(firstName, 
				lastName, address, homePhone, workphone, balance);		
		custArr.add(cust);	
		return cust.getCustomerID();
	}
	
	public long createCommercialCustomer(String firstName, 
			String lastName, String address, 
			String contactPersonName, String contactPersonNumber,
			double balance) {	
		
		// child class constructor
		CommercialCustomer cust = new CommercialCustomer(
				firstName, lastName, address, contactPersonName,
				contactPersonNumber, balance);		
		custArr.add(cust);		
		return cust.getCustomerID();		
	}
	
	private Customer getCustomerFromID(long custID) {
		for(Customer cust : custArr)
			if (cust.getCustomerID() == custID)
				return cust;
		return null;
	}
	
	// withdraw
	public String withdraw(long custID, double amount) throws CustomerNotFoundException {	
		
		Customer ourCust = getCustomerFromID(custID);
		
		if(ourCust == null)
			throw new CustomerNotFoundException(); 
			
		// check that a minimum balance is maintained
		if(ourCust.getBalance() - amount < ourCust.getMinimumBalance()) {
			return "Insufficient balance";
		}
		else {
			ourCust.setBalance(ourCust.getBalance() - amount);
			return "Withdrawal successful";
		}
	}
	
	// deposit
	public String deposit(long custID, double amount) throws CustomerNotFoundException {
		
		Customer ourCust = getCustomerFromID(custID);
		
		if(ourCust == null)
			throw new CustomerNotFoundException();
		
		ourCust.setBalance(ourCust.getBalance() + amount);
		return "Deposit successful";
	}
	
	public String transfer(long fromCustomerID, long toCustomerID, double amount) throws CustomerNotFoundException {
		
		Customer fromCust = getCustomerFromID(fromCustomerID);
		Customer toCust = getCustomerFromID(toCustomerID);
		
		if(fromCust == null || toCust == null)
			throw new CustomerNotFoundException();
				
		if( (fromCust.getBalance() - amount) < fromCust.getMinimumBalance())
			return "Insufficient Balance";
		// both the customers are found and there is sufficient balance
		else {
			fromCust.setBalance(fromCust.getBalance() - amount);
			toCust.setBalance(toCust.getBalance() + amount);
			return "Transfer successful";
		}
	}
		
	
	public String getInfo(long custID) throws CustomerNotFoundException{
		Customer ourCust = getCustomerFromID(custID);
		
		if(ourCust == null)
			throw new CustomerNotFoundException();
		
		return ourCust.getCustomerInfo();
	}
	
	public String getCustROI(long custID) throws CustomerNotFoundException {
		
		Customer ourCust = getCustomerFromID(custID);
		
		if(ourCust == null)
			throw new CustomerNotFoundException();
		
		return ("Rate of Interest: " + ourCust.calcROI());
	}
	
	public void readPersonalCustomersFromFile(String filename) {
		try {
			File f = new File(filename);
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			
			String line;
			while( (line = br.readLine())  !=  null  ) {
				String[] lineSplit = line.split("\\|");
				
				long custID = this.createPersonalCustomer(lineSplit[0], 
						lineSplit[1], lineSplit[2], lineSplit[3], lineSplit[4],
						Double.valueOf(lineSplit[5]) );
				
				System.out.println("Customer created with ID: " + custID);
			}
			
			br.close();
			fr.close();
		}
		
		catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} 
		catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}






