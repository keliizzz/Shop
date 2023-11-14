package ua.project.buyers.form;

public class FindBuyerByNameForm {

	private String nameOfBuyer;

	public FindBuyerByNameForm() {
			}

	public FindBuyerByNameForm(String nameOfBuyer) {
		this.nameOfBuyer = nameOfBuyer;
	}

	public String getNameOfBuyer() {
		return nameOfBuyer;
	}

	public void setNameOfBuyer(String nameOfBuyer) {
		this.nameOfBuyer = nameOfBuyer;
	}
	
}
