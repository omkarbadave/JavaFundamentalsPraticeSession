package com.omkar.phonebook.pojos;

import java.util.ArrayList;
import java.util.List;

public class PhoneBook {
	private int pbid;
	private String phoneBookName;
	
	List<Contact> contactsList = new ArrayList<Contact>();
	
	public PhoneBook() {
		super();
	}
	
	public PhoneBook(int pbid, String phoneBookName, List<Contact> contactsList) {
		super();
		this.pbid = pbid;
		this.phoneBookName = phoneBookName;
		this.contactsList = contactsList;
	}

	/**
	 * @return the pbid
	 */
	public int getPbid() {
		return pbid;
	}

	/**
	 * @param pbid the pbid to set
	 */
	public void setPbid(int pbid) {
		this.pbid = pbid;
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
		return "\nPhoneBook [phonebookid="+pbid+", phoneBookName=" + phoneBookName + ", contactsList=" + contactsList + "]";
		
	}	
	
	
}
