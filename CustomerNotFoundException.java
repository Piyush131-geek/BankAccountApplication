
public class CustomerNotFoundException extends Exception {

	private static final long serialVersionUID = -7195203172867666489L;
	private String message;
	
	public CustomerNotFoundException() {
		super();
		this.message = "Customer with ID not found.";
	}

	public CustomerNotFoundException(String message) {
		super();
		this.message = message;
	}

	@Override
	public String toString() {
		return this.message;
	}
	
	
}
