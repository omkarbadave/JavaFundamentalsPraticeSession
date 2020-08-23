package com.omkar.phonebook.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;

import com.omkar.phonebook.interfaces.PhoneBookCRUD;
import com.omkar.phonebook.managers.PhoneBookManager;
import com.omkar.phonebook.pojos.Contact;
import com.omkar.phonebook.pojos.PhoneBook;

public class PhoneBookService {

	PhoneBook pj;
	static List<PhoneBook> PhonebookList = new ArrayList<PhoneBook>();
	PhoneBookCRUD<Contact> phoneBookManager;
	Scanner in;

	static {
		boolean readSuccessFull = readPersonsFromYAMLFile();
		System.out.println(readSuccessFull);
	}

	public PhoneBookService(Scanner in) {
		super();		
		this.phoneBookManager = new PhoneBookManager(PhoneBookService.PhonebookList.get(0));
		this.in = in;
	}

	public void add() {
		// TODO Auto-generated method stub
		System.out.print("Please enter the First Name: ");
		String fname = this.in.next();
		System.out.print("Please enter the Last Name: ");
		String lname = this.in.next();
		System.out.print("Please enter the phone number: ");
		int pno = this.in.nextInt();
		this.phoneBookManager.getAll().add(new Contact(this.phoneBookManager.getAll().size(), fname, lname, pno));
		System.out.println("The updated contact list is :");
		this.viewAllContacts();
		this.writeToYAMLFile(PhonebookList);
	}

	public void delete() {
		// TODO Auto-generated method stub
		if (this.phoneBookManager.getAll().size() == 0) {
			this.viewAllContacts();
			System.out.println("There are no contacts in the phone book to delete");
		} else {
			System.out.println("Please enter an id of a contact that you want to delete:");
			this.viewAllContacts();
			this.phoneBookManager.delete(this.in.nextInt());
			System.out.println("The updated contact list is as follows:");
			this.viewAllContacts();
		}
	}

	public void viewAllContacts() {
		System.out.println(this.phoneBookManager.getAll());
	}

	public List<Contact> loadContacts() {
		List<Contact> contactList = new ArrayList<Contact>();
		contactList.add(new Contact(0, "Adi", "Nath", 123456789));
		contactList.add(new Contact(1, "Aditi", "Nath", 123456788));
		return contactList;
	}

	public static boolean readPersonsFromYAMLFile() {		
		try {
			File f1 = new File("resources\\phonebook.yaml");
			InputStream input = new FileInputStream(f1);
		    Yaml yaml2 = new Yaml();
		    try {
		    	List<PhoneBook> pb = (List<PhoneBook>) yaml2.load(input);
		    	PhonebookList.addAll(pb);
		    }catch (Exception e) {
				// TODO: handle exception
		    	System.out.println("ClassCastException");
			}		    	
		    System.out.println(PhonebookList);
		    return true;
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}   
		return false;
	}
	
	public void writeToYAMLFile(List<PhoneBook> pb) {
		final DumperOptions options = new DumperOptions();
	    options.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK);
	    options.setPrettyFlow(true);
	    final Yaml yaml = new Yaml(options);		   
		   try {
			
			  FileWriter writer = new FileWriter("resources\\phonebook.yaml"); 
			  yaml.dump(pb,writer);
			 
		   }catch (Exception e) {
			// TODO: handle exception
			   System.out.println(e);
		}
	}

}
