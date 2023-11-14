package ua.project.buyers.form;

public class AddBuyerForm {

	private String nameOfBuyer;
	private String firstNameOfRepresentative;
	private String lastNameOfRepresentative;
	private String address;
	private String telNumber;
	public AddBuyerForm() {
	
	}
	public AddBuyerForm(String nameOfBuyer, String firstNameOfRepresentative, String lastNameOfRepresentative,
			String address, String telNumber) {
		this.nameOfBuyer = nameOfBuyer;
		this.firstNameOfRepresentative = firstNameOfRepresentative;
		this.lastNameOfRepresentative = lastNameOfRepresentative;
		this.address = address;
		this.telNumber = telNumber;
	}
	public String getNameOfBuyer() {
		return nameOfBuyer;
	}
	public void setNameOfBuyer(String nameOfBuyer) {
		this.nameOfBuyer = nameOfBuyer;
	}
	public String getFirstNameOfRepresentative() {
		return firstNameOfRepresentative;
	}
	public void setFirstNameOfRepresentative(String firstNameOfRepresentative) {
		this.firstNameOfRepresentative = firstNameOfRepresentative;
	}
	public String getLastNameOfRepresentative() {
		return lastNameOfRepresentative;
	}
	public void setLastNameOfRepresentative(String lastNameOfRepresentative) {
		this.lastNameOfRepresentative = lastNameOfRepresentative;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTelNumber() {
		return telNumber;
	}
	public void setTelNumber(String telNumber) {
		this.telNumber = telNumber;
	}
	
	
}
