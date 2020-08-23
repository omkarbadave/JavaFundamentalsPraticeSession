package com.omkar.phonebook.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
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
		boolean readSuccessFull = readDataFromYAMLFile();
		if(readSuccessFull == false) {
			System.out.println("No phonebooks found hence creating a default phonebook..");
		}
	}

	public PhoneBookService(Scanner in) {
		super();
		if(PhonebookList.size() == 0) {
			this.addNewPhoneBook("Default");
		}else {
			this.switchActivePhonebook(PhonebookList.get(0).getPbid());
		}
		this.phoneBookManager = new PhoneBookManager(PhonebookList.get(0));		
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
			Contact deletedContact = this.phoneBookManager.delete(this.in.nextInt());
			if(deletedContact instanceof Contact) {
				System.out.println("The updated contact list is as follows:");
				this.viewAllContacts();
			}else {
				System.out.println("The contact with specified id doesnt exist.");
			}
			
		}
	}

	public void viewAllContacts() {
		System.out.println(this.phoneBookManager.getAll());
	}
	
	public String getActivePhoneBook() {
		return this.pj.getPhoneBookName();
	}
	
	public void getAllPhoneBooks() {		
		System.out.println("Following are the list of active phone books:");
		for (Iterator<PhoneBook> iterator = PhonebookList.iterator(); iterator.hasNext();) {
			PhoneBook phoneBook = (PhoneBook) iterator.next();
			if(phoneBook.getPbid() == pj.getPbid()) {
				System.out.println("* Id: "+phoneBook.getPbid()+", Name: "+phoneBook.getPhoneBookName());
			}else {
			System.out.println("  Id: "+phoneBook.getPbid()+", Name: "+phoneBook.getPhoneBookName());
			}
		}				
	}
	
	public void triggerChangeActivePhoneBook(boolean triggerChnage) {
		if(triggerChnage) {
			System.out.print("\nDo you wish to change the active phone book (Y/N): ");
			String choice = in.next();
			if(choice.equals("Y")) {
				this.switchActivePhonebook(-1);
			}
		}
	}
	
	public void switchActivePhonebook(int pbid) {
		int activePhoneBookId;
		if(PhonebookList.size() == 0) {
			System.out.println("There are no phonebooks currently available, Please create a few and retry.");
			return;
		}else if(pbid<0) {
			System.out.print("Enter the id of phone book you want to set as active phone book: ");
			activePhoneBookId = in.nextInt();	
		}else {
			activePhoneBookId = pbid;
		}
		if(PhonebookList.size()>0) {
			for (Iterator<PhoneBook> iterator = PhonebookList.iterator(); iterator.hasNext();) {
				PhoneBook phoneBook = (PhoneBook) iterator.next();
				if(phoneBook.getPbid() == activePhoneBookId) {
					this.pj = phoneBook;
				}
			}
		}else{
			this.pj = PhonebookList.get(0);
		}
		if(this.phoneBookManager != null) {
			this.phoneBookManager.switchActivePhoneBook(this.pj);
		}		
		System.out.println("Changed the active phone book to :"+this.pj.getPhoneBookName());
	}
	
	public void addNewPhoneBook(String phoneBookName) {
		if(phoneBookName == null) {
			System.out.println("Please enter a name for new phonebook: ");
			phoneBookName = in.next();
		}
		PhonebookList.add(new PhoneBook(PhonebookList.size(), phoneBookName, new ArrayList<Contact>()));
		
		this.switchActivePhonebook(PhonebookList.get(PhonebookList.size()-1).getPbid());
		this.writeToYAMLFile(PhonebookList);
	}

	public static boolean readDataFromYAMLFile() {		
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
		    	return false;
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

	public void deletePhoneBook() {
		// TODO Auto-generated method stub
		this.getAllPhoneBooks();
		System.out.println("Please enter the id of the phone book to be delete: ");
		int pbid = in.nextInt();
		boolean wasActivePhoneBook = false,phonebookFound = false;
		for (Iterator<PhoneBook> iterator = PhonebookList.iterator(); iterator.hasNext();) {
			PhoneBook phoneBook = (PhoneBook) iterator.next();
			if(phoneBook.getPbid() == pbid) {
				wasActivePhoneBook = true;
				phonebookFound = true;
				iterator.remove();
			}			
		}
		if(phonebookFound == false) {
			System.out.println("The phone book with specified id was not found and cannot be deleted");
		}else if(wasActivePhoneBook == true) {
			System.out.println("The active phonebook was deleted successfully.");
			this.getAllPhoneBooks();
			triggerChangeActivePhoneBook(true);
		}else {
			System.out.println("The specified phone book entry was deleted.");
		}
		this.writeToYAMLFile(PhonebookList);
	}

}
