package com.app.tester;

import static com.app.utils.PhoneBookUtils.generatePhoneBook;

import java.util.List;
import java.util.Scanner;

import com.app.core.PhoneBook;
import com.app.core.PhoneBookImplementation;
import com.app.core.PhonebookEntry;

import junit.framework.Assert;

public class PhoneBookConsoleApp {
	public static void main(String[] args) {
		int count = 0;
		PhonebookEntry tmp = null;
		List<PhonebookEntry> tmpEntry = null;
		PhoneBook phoneBook = generatePhoneBook();
		boolean exit = false;
		try (Scanner sc = new Scanner(System.in)) {
			while (!exit) {
				System.out.println("__________\n*PhoneBook*\n__________");
				System.out.println("Following are the available options: \n*1.* Add information about a user\n"
						+ "*2.* Delete user information\n*3.* Search a user based on phone number\n"
						+ "*4.* Search a user based on name\n*100.* To exit");
				switch (sc.nextInt()) {
				case 1:
					System.out.println("Option 1 selected. Add information about a user\nName  Address  Phone Number");
//					int tmpSize = phoneBook.size();
					phoneBook.put(new PhonebookEntry(sc.next(), sc.next(), sc.next()));
//					Assert.assertEquals(expected, actual);
					System.out.println("Phone number added.");
					break;
				case 2:
					System.out.println(
							"Option 2 selected. Delete user information: \n Please enter the phone number of the user to delete\nPhone Number");
					phoneBook.remove(sc.next());
					break;
				case 3:
					System.out.println(
							"Option 3 selected. Please enter the phone number to search for entry\nPhone Number");
					tmp = phoneBook.get(sc.next());
					if (tmp != null)
						System.out.println("Here is the entry : \n" + tmp);
					else
						System.out.println("Sorry, no entry found.");
					tmp = null;
					break;
				case 4:
					System.out.println("Option 4 selected. Please enter the name to search the phonebook\nName");
					tmpEntry = phoneBook.searchByName(sc.next());
					if (tmpEntry.isEmpty()) {
						System.out.println("No entry found.");
						break;
					}
					System.out.println("Here is the list of entries that was found: ");
					for (PhonebookEntry entry : tmpEntry)
						System.out.println((++count) + ". " + entry);
					tmpEntry = null;
					count = 0;
					break;
				case 98:
					((PhoneBookImplementation) phoneBook).logLoad();
					System.out.println("The number of entries in the phonebook is : "
							+ ((PhoneBookImplementation) phoneBook).size());

					break;
				case 99:
					((PhoneBookImplementation) phoneBook).dump();
					break;
				case 100:
					exit = true;
					break;
				default:
					break;
				}
			}
		} catch (Exception e) {
			System.err.println("err : " + e.getMessage());
		}

	}

}
