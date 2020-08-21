package com.omkar.phonebook.pojos;

public class Contact extends Person {

	private int ph_no;

	public Contact(int id, String first_name, String last_name, int ph_no) {
		super(id, first_name, last_name);
		this.ph_no = ph_no;
	}

	/**
	 * @return the ph_no
	 */
	public int getPh_no() {
		return ph_no;
	}

	/**
	 * @param ph_no the ph_no to set
	 */
	public void setPh_no(int ph_no) {
		this.ph_no = ph_no;
	}

	@Override
	public String toString() {
		return "\nContact [id=" + this.getId() + ", first_name=" + this.getFirst_name() + ", last_name=" + this.getLast_name()  +"Ph.No=" + this.getPh_no() + "]";
	}		
	
}
