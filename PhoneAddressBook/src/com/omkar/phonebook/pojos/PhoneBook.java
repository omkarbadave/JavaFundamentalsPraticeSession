package com.omkar.phonebook.pojos;

import java.util.ArrayList;
import java.util.List;

public class PhoneBook {
	
	private String phoneBookName;
	
	List<Contact> ContactsList = new ArrayList<Contact>();

	public PhoneBook(String phoneBookName, List<Contact> contactsList) {
		super();
		this.phoneBookName = phoneBookName;
		ContactsList = contactsList;
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
		return ContactsList;
	}

	/**
	 * @param contactsList the contactsList to set
	 */
	public void setContactsList(List<Contact> contactsList) {
		ContactsList = contactsList;
	}		
}
