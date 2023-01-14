
public class CommercialCustomer extends Customer{
	private String contactPersonName;
	private String contactPersonNumber;
	static private double minimumBalance = 5000.00;
	
	public CommercialCustomer() {
		super();
	}

	public CommercialCustomer(String firstName, String lastName, 
			String address, String contactPersonName,
			String contactPersonNumber, double balance) {
		super(firstName, lastName, address, balance, minimumBalance);
		this.contactPersonName = contactPersonName;
		this.contactPersonNumber = contactPersonNumber;
	}

	public String getContactPersonName() {
		return contactPersonName;
	}

	public void setContactPersonName(String contactPersonName) {
		this.contactPersonName = contactPersonName;
	}

	public String getContactPersonNumber() {
		return contactPersonNumber;
	}

	public void setContactPersonNumber(String contactPersonNumber) {
		this.contactPersonNumber = contactPersonNumber;
	}
	
	@Override
	public String getCustomerInfo() {
		return "CommercialCustomer [customerID=" + this.getCustomerID() + 
				", firstName=" + this.getFirstName() +
				", lastName=" + this.getLastName() + 
				", address=" + this.getAddress() +
				", contact person=" + contactPersonName +
				", contact number=" + contactPersonNumber +
				", balance=" + this.getBalance() + "]";
	}
	
	@Override
	public double calcROI() {
		return (0.06 * this.getBalance());
	}
}
