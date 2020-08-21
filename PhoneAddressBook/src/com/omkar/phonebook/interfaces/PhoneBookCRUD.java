package com.omkar.phonebook.interfaces;

import java.util.List;

public interface PhoneBookCRUD<T>{		
	
	public List<T> getAll();
	
	public T getDetails(String name);
		
	public void add(T data);
	
	public T delete(int id);
				
}
