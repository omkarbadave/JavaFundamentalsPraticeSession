package com.omkar.phonebook.pojos;

import java.util.ArrayList;
import java.util.List;

public class PhoneBook {
	
	private String phoneBookName;
	
	List<Contact> contactsList = new ArrayList<Contact>();
	
	public PhoneBook() {
		super();
	}
	
	public PhoneBook(String phoneBookName, List<Contact> contactsList) {
		super();
		this.phoneBookName = phoneBookName;
		this.contactsList = contactsList;
	}

	/**
	 * @return the phoneBookName
	 */
	public String getPhoneBookName() {
		return phoneBookName;
	}

	/**
	 * @param phoneBookName the phoneBookName to set
	 */
	public void setPhoneBookName(String phoneBookName) {
		this.phoneBookName = phoneBookName;
	}

	/**
	 * @return the contactsList
	 */
	public List<Contact> getContactsList() {
		return contactsList;
	}

	/**
	 * @param contactsList the contactsList to set
	 */
	public void setContactsList(List<Contact> contactsList) {
		this.contactsList = contactsList;
	}

	@Override
	public String toString() {
		return "PhoneBook [phoneBookName=" + phoneBookName + ", contactsList=" + contactsList + "]";
	}	
	
	
}
