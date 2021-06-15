package com.app.core;

public class PhonebookEntry {
	private String name;// name of the entry
	private String address;// address of the entry
	private String phoneNo;// phone number of the entry

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	//equals and hashcode using phone number...
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((phoneNo == null) ? 0 : phoneNo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PhonebookEntry other = (PhonebookEntry) obj;
		if (phoneNo == null) {
			if (other.phoneNo != null)
				return false;
		} else if (!phoneNo.equals(other.phoneNo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PhonebookEntry [name=" + name + ", address=" + address + ", phoneNo=" + phoneNo + "]";
	}

	public PhonebookEntry(String name, String address, String phoneNo) {
		super();
		this.name = name;
		this.address = address;
		this.phoneNo = phoneNo;
	}

	public PhonebookEntry(String name, String phoneNo) {
		this.address = null;
		this.name = name;
		this.phoneNo = phoneNo;
	}

}
