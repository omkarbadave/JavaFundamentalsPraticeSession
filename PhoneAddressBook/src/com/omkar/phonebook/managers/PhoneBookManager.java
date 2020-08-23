package com.omkar.phonebook.managers;

import java.util.List;

import com.omkar.phonebook.interfaces.PhoneBookCRUD;
import com.omkar.phonebook.pojos.Contact;
import com.omkar.phonebook.pojos.PhoneBook;

public class PhoneBookManager implements PhoneBookCRUD<Contact> {
	
	PhoneBook pb;		
	
	public PhoneBookManager(PhoneBook pb) {
		super();
		this.pb = pb;
	}

	@Override
	public List<Contact> getAll() {
		// TODO Auto-generated method stub
		return this.pb.getContactsList();
		//return null;
	}

	@Override
	public Contact getDetails(String name) {
		// TODO Auto-generated method stub
		 for(Contact c:this.pb.getContactsList()) {
			 if(c.getFirst_name().contentEquals(name)) {
				 return c;
			 }
		 }		
		return null;
	}

	@Override
	public void add(Contact data) {
		// TODO Auto-generated method stub
		this.pb.getContactsList().add(data);		
	}

	@Override
	public Contact delete(int id) {
		// TODO Auto-generated method stub
		Contact c = this.find(id);
		if(this.pb.getContactsList().remove(c)) {
			return c;		
		}
		return null;
	}
	
	public Contact find(String name) {
		for(Contact c:this.pb.getContactsList()) {
			 if(c.getFirst_name().contentEquals(name)) {
				 return c;
			 }
		 }
		return null;
	}
	
	public Contact find(int id) {
		for(Contact c:this.pb.getContactsList()) {
			 if(c.getId() == id) {
				 return c;
			 }
		 }
		return null;
	}
	
	public void switchActivePhoneBook(PhoneBook pb) {
		this.pb = pb;
	}

}
