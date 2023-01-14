
public class PersonalCustomer extends Customer{
	private String homePhone;
	private String workPhone;
	static private double minimumBalance = 1000.00;
	
	public PersonalCustomer() {
		super();
	}
	
	public PersonalCustomer(String firstName, String lastName, 
			String address, String homePhone,
			String workPhone, double balance) {
		super(firstName, lastName, address, balance, minimumBalance);
		this.homePhone = homePhone;
		this.workPhone = workPhone;
	}

	public String getHomePhone() {
		return homePhone;
	}

	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}

	public String getWorkPhone() {
		return workPhone;
	}

	public void setWorkPhone(String workPhone) {
		this.workPhone = workPhone;
	}

	@Override
	public String getCustomerInfo(){
		return "PersonalCustomer [customerID=" + this.getCustomerID() + 
				", firstName=" + this.getFirstName() +
				", lastName=" + this.getLastName() + 
				", address=" + this.getAddress() +
				", home phone=" + homePhone +
				", work phone=" + workPhone +
				", balance=" + this.getBalance() + "]";
	}

	@Override
	public double calcROI() {
		return (0.04 * this.getBalance());
	}
}






