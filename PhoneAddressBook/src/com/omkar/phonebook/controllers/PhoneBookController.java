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
			System.out.println(""
					+ "1. View All Phonebooks.\n"
					+ "2. Add new phone book.\n"
					+ "3. Delete phone book.\n"
					+ "4. View Contacts in current phone book.\n"
					+ "5. Add a contact to current phone book.\n"
					+ "6. Delete a contact from current phone book."
					);
			choice = this.in.nextInt();
			switch(choice) {
				case 1: this.getAllPhoneBooks();
					break;
				case 2:	this.addNewPhoneBook();
					break;
				case 3: this.deletePhoneBook();
					break;
				case 4: this.viewAllContacts();; 											
					break;
				case 5: this.addNewContact();
					break;
				case 6:	this.deleteContact();
					break;
				default :
					System.out.println("Invalid choice please retry.");
			}
		}while(choice>0);
	}

	private void deletePhoneBook() {
		// TODO Auto-generated method stub
		this.phoneBookService.deletePhoneBook();
	}

	private void addNewPhoneBook() {
		// TODO Auto-generated method stub
		this.phoneBookService.addNewPhoneBook(null);
	}

	private void getAllPhoneBooks() {
		// TODO Auto-generated method stub
		this.phoneBookService.getAllPhoneBooks();
		this.phoneBookService.triggerChangeActivePhoneBook(true);
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
