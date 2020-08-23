package com.omkar.phonebook.controllers;

import java.util.Scanner;

import com.omkar.phonebook.services.PhoneBookService;

public class PhoneBookController {
	
	Scanner in;
	PhoneBookService phoneBookService;
	
	public PhoneBookController() {
		super();		
		this.in = new Scanner(System.in);
		this.phoneBookService = new PhoneBookService(in);	
	}

	public void run() {
		int choice = 0;
		do{
			System.out.println("\nWelcome to phone book app");
			System.out.println("==========Menu========");
			System.out.println("Active PhoneBook: "+this.phoneBookService.getActivePhoneBook());
			System.out.println("1. View All Phonebooks\n2. View Contacts in current phone book\n3. Add a contact to current phone book.\n4. Delete a contact from phone book");
			choice = this.in.nextInt();
			switch(choice) {
				case 1: this.getAllPhoneBooks();
					break;
				case 2: this.viewAllContacts();; 											
					break;
				case 3: this.addNewContact();
					break;
				case 4:	this.deleteContact();
					break;
				default :
					System.out.println("Invalid choice please retry.");
			}
		}while(choice>0);
	}

	private void getAllPhoneBooks() {
		// TODO Auto-generated method stub
		this.phoneBookService.getAllPhoneBooks();
	}

	private void viewAllContacts() {
		// TODO Auto-generated method stub
		this.phoneBookService.viewAllContacts();
	}

	private void deleteContact() {
		// TODO Auto-generated method stub
		this.phoneBookService.delete();
	}

	private void addNewContact() {
		// TODO Auto-generated method stub
		this.phoneBookService.add();
	}	
	
}
