package com.omkar.phonebook.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.omkar.phonebook.interfaces.PhoneBookCRUD;
import com.omkar.phonebook.managers.PhoneBookManager;
import com.omkar.phonebook.pojos.Contact;
import com.omkar.phonebook.pojos.PhoneBook;

public class PhoneBookController {
	
	PhoneBook pj;
	PhoneBookCRUD<Contact> phoneBookManager;
	Scanner in;
	
	public PhoneBookController() {
		super();			
		List<Contact> contactList = new ArrayList<Contact>();	
		contactList.add(new Contact(0, "Adi", "Nath", 123456789));
		contactList.add(new Contact(1, "Aditi", "Nath", 123456788));
		this.pj = new PhoneBook("Friends", contactList);
		this.phoneBookManager = new PhoneBookManager(this.pj);
		this.in = new Scanner(System.in);
	}

	public void run() {
		int choice = 0;
		do{
			System.out.println("\nWelcome to phone book app");
			System.out.println("==========Menu========");
			System.out.println("1. View Contacts in phone book \n2. Add a contact to current phone book. \n3. Delete a contact from phone book ");
			choice = this.in.nextInt();
			switch(choice) {
				case 1: this.viewAllContacts();
					break;
				case 2: this.addNewContact();						
					break;
				case 3: this.deleteContact();
					break;
				default :
					System.out.println("Invalid choice please retry.");
			}
		}while(choice>0);
	}

	private void deleteContact() {
		// TODO Auto-generated method stub
		if(this.phoneBookManager.getAll().size() == 0) {
			this.viewAllContacts();
			System.out.println("There are no contacts in the phone book to delete");
		}else {
			System.out.println("Please enter an id of a contact that you want to delete:");
			this.viewAllContacts();
			this.phoneBookManager.delete(this.in.nextInt());
			System.out.println("The updated contact list is as follows:");
			this.viewAllContacts();
		}
	}

	private void addNewContact() {
		// TODO Auto-generated method stub
		System.out.print("Please enter the First Name: ");
		String fname = this.in.next();
		System.out.print("Please enter the Last Name: ");
		String lname = this.in.next();
		System.out.print("Please enter the phone number: ");
		int pno = this.in.nextInt();
		this.phoneBookManager.getAll().add(new Contact(this.phoneBookManager.getAll().size(),fname,lname,pno));		
		System.out.println("The updated contact list is :");
		this.viewAllContacts();
	}

	public void viewAllContacts() {
		System.out.println(this.phoneBookManager.getAll());
	}
	
}
