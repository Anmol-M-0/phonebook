package com.app.utils;

import com.app.core.PhoneBookImplementation;
import com.app.core.PhonebookEntry;

public interface PhoneBookUtils {
	/*
	 * the following phone book has been generated to simulate a realistic scenario where 
	 * many phone numbers could be equal. this is to test the performance of our hashtable
	 */
	static PhoneBookImplementation generatePhoneBook() {
		PhoneBookImplementation phoneBook= new PhoneBookImplementation();
		phoneBook.put(new PhonebookEntry("Aditya K", "Mumbai", "8789562145"));
		phoneBook.put(new PhonebookEntry("Aniket L", "Latur", "7874556665"));
		phoneBook.put(new PhonebookEntry("Anil M", "Mandi","9998758456"));
		phoneBook.put(new PhonebookEntry("Bunty N", "Jintur", "6687954231"));
		phoneBook.put(new PhonebookEntry("Hitesh O", "Vishakhapatnam", "7987521245"));
		phoneBook.put(new PhonebookEntry("Guddu P", "Pune", "7895465421"));
		phoneBook.put(new PhonebookEntry("Sanjay K","Raipur", "9922345588"));
		phoneBook.put(new PhonebookEntry("Aditya K", "Mumbai", "8789531452"));
		phoneBook.put(new PhonebookEntry("Aniket L", "Latur", "7874552325"));
		phoneBook.put(new PhonebookEntry("Anil M", "Mandi","9998758789"));
		phoneBook.put(new PhonebookEntry("Bunty C", "Jintur", "6687954123"));
		phoneBook.put(new PhonebookEntry("Hitesh D", "Vishakhapatnam", "7456521245"));
		phoneBook.put(new PhonebookEntry("Guddu v", "Pune", "7895445221"));
		phoneBook.put(new PhonebookEntry("Sanjay S", "Raipur", "9922345688"));
		phoneBook.put(new PhonebookEntry("Aditya K", "Mumbai", "87895785445"));
		phoneBook.put(new PhonebookEntry("Aniket L", "Latur", "7874545665"));
		phoneBook.put(new PhonebookEntry("Anil M", "Mandi","9998758545"));
		phoneBook.put(new PhonebookEntry("Bunty N", "Jintur", "6687954875"));
		phoneBook.put(new PhonebookEntry("Hitesh O", "Vishakhapatnam", "7784521245"));
		phoneBook.put(new PhonebookEntry("Guddu P", "Pune", "7895465777"));
		phoneBook.put(new PhonebookEntry("Sanjay Q", "Raipur", "992242588"));
		phoneBook.put(new PhonebookEntry("Aditya W", "Mumbai", "6899562456"));
		phoneBook.put(new PhonebookEntry("Aniket E", "Latur", "7874748665"));
		phoneBook.put(new PhonebookEntry("Anil R", "Mandi","9998758465"));
		phoneBook.put(new PhonebookEntry("Bunty T", "Jintur", "6687954222"));
		phoneBook.put(new PhonebookEntry("Hitesh Y", "Vishakhapatnam", "7456121245"));
		phoneBook.put(new PhonebookEntry("Guddu U", "Pune", "7854669991"));
		phoneBook.put(new PhonebookEntry("Sanjay I", "Raipur", "9958248888"));
		phoneBook.put(new PhonebookEntry("Aditya", "Mumbai", "8789567775"));
		phoneBook.put(new PhonebookEntry("Aniket", "Latur", "7874556968"));
		phoneBook.put(new PhonebookEntry("Anil", "Mandi","9998754656"));
		phoneBook.put(new PhonebookEntry("Bunty", "Jintur", "6687978731"));
		phoneBook.put(new PhonebookEntry("Hitesh", "Vishakhapatnam", "7459521245"));
		phoneBook.put(new PhonebookEntry("Guddu", "Pune", "7895468991"));
		phoneBook.put(new PhonebookEntry("Sanjay", "Raipur", "9922349988"));
		return phoneBook;
	}
}
