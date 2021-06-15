package com.app.core;

import java.util.ArrayList;
import java.util.List;

public interface PhoneBook {
	/*
	 * inserts the phonebook entry, use phone number as the value
	 */
	void put(PhonebookEntry value);
/*
 * using the phone number remove the contact
 */
	/*
	 * get the specified by the phone number
	 */
	PhonebookEntry get(String key);
	void remove(String key);
	/*
	 * check if the entry of the phone number exists
	 */

	boolean containsPhoneNumber(String key);
	/*
	 * returns the count of phonebook entries inside the phonebook
	 */
	int size();
/*
 * returns a list of all phonebook entries inside the phonebook
 */
	List<PhonebookEntry> valueSet();
	/*
	 * searchByName() internally calls valueset and searches for all the entries in the phonebook with the given name.
	 * It returns a list of matching phonebook entries 
	 */
	default List<PhonebookEntry> searchByName(String name){
		if(name.equals(""))return valueSet();
		List<PhonebookEntry> entries = valueSet();
		List<PhonebookEntry> result = new ArrayList<>();
		for(PhonebookEntry entry : entries) {
			if(entry.getName().contains(name)) 
				result.add(entry);
		}
		return result;
	}
}
