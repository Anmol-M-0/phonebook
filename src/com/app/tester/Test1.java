package com.app.tester;

import static com.app.utils.PhoneBookUtils.generatePhoneBook;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.app.core.PhoneBook;
import com.app.core.PhonebookEntry;

import static junit.framework.Assert.*;

public class Test1 {

	@Test
	public void test() {
//		int count = 0;
//		PhonebookEntry tmp = null;
//		List<PhonebookEntry> tmpEntry = null;
		PhoneBook phoneBook = generatePhoneBook();
		int size = phoneBook.size();
		phoneBook.put(new PhonebookEntry("someName", "9687346342"));
		//testing the put method of the phonepbook
		assertEquals(size+1, phoneBook.size());
//		testing search by name
		
		assertEquals(0, phoneBook.searchByName("zoo").size());
		
		
		
		
		
		
//		fail("Not yet implemented");
		
	}

}
