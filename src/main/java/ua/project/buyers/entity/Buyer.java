package ua.project.buyers.entity;

import java.util.Objects;

public class Buyer {
	
	private int id;
	private String nameOfBuyer;
	private String firstNameOfRepresentative;
	private String lastNameOfRepresentative;
	private String address;
	private String telNumber;
	public Buyer() {
		super();
	}
	public Buyer(String nameOfBuyer, String firstNameOfRepresentative, String lastNameOfRepresentative,
			String address, String telNumber) {
		super();
		this.nameOfBuyer = nameOfBuyer;
		this.firstNameOfRepresentative = firstNameOfRepresentative;
		this.lastNameOfRepresentative = lastNameOfRepresentative;
		this.address = address;
		this.telNumber = telNumber;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	@Override
	public String toString() {
		return "Buyer [id = " + id + ", nameOfBuyer = " + nameOfBuyer + ", firstNameOfRepresentative = "
				+ firstNameOfRepresentative + ", lastNameOfRepresentative = " + lastNameOfRepresentative + ", address = "
				+ address + ", telNumber = " + telNumber + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(address, firstNameOfRepresentative, id, lastNameOfRepresentative, nameOfBuyer, telNumber);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Buyer other = (Buyer) obj;
		return Objects.equals(address, other.address)
				&& Objects.equals(firstNameOfRepresentative, other.firstNameOfRepresentative) && id == other.id
				&& Objects.equals(lastNameOfRepresentative, other.lastNameOfRepresentative)
				&& Objects.equals(nameOfBuyer, other.nameOfBuyer) && Objects.equals(telNumber, other.telNumber);
	}
	
	
	
}
