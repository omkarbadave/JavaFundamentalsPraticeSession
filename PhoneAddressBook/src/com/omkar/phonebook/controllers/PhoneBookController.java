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
