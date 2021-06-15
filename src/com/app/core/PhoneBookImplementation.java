package com.app.core;

import java.util.ArrayList;
import java.util.List;

public class PhoneBookImplementation implements PhoneBook{

	private static class ListNode {
		/*
		 * keys having same hash code are kept together in the linked list. this private
		 * nested class impl LL. A list node contains (Key, Value) pair
		 */
		String key;
		PhonebookEntry value;
		ListNode next;// points to next list node
	}

	private static int INITIAL_SIZE = 16;
	// the hash table containing array of linked lists
	private ListNode[] table;
	/*
	 * the number of (k,v) pairs in the hashtable
	 */
	private int count;

	public PhoneBookImplementation() {
		// create a hash table of initial size 64
		table = new ListNode[INITIAL_SIZE];
	}

	public PhoneBookImplementation(int initialSize) {
		/*
		 * create the hash table with specified initial size precondition -> initial
		 * size > 0
		 * 
		 */
		table = (initialSize > INITIAL_SIZE ? new ListNode[initialSize] : new ListNode[16]);
	}

	public void dump() {
		/*
		 * this method is only for testing purposes and not the part of the general impl
		 */
		System.out.println();
		for (int i = 0; i < table.length; i++) {
			/*
			 * print the location and no of key val pairs in the location
			 */
			System.out.println(i + " : ");
			ListNode list = table[i];// for traversing the list number i
			while (list != null) {
				System.out.println(" (" + list.key + ", " + list.value + ")");
				list = list.next;
			}
			System.out.println();

		}
		// end dump
	}

	public void logLoad() {
		/*
		 * load factor determines when to increase the size of Hashtable automatically
		 * getLoad() gives the current load of the phonebookimplementation hash table
		 */
		int count = 0;
		for (int i = 0; i < table.length; i++)
			if (table[i] != null)
				count++;
		double load = (double) count / table.length;
		System.out.println("The current load of the table is = " + count + "/" + table.length + " = " + load);
		
	}

	public void put(PhonebookEntry value) {
		/*
		 * associate the specified key with the specified value precondition : the key
		 * is not null
		 */
		String key = value.getPhoneNo();
		int bucket = hash(key);// which location should the key be in
		ListNode list = table[bucket];// for traversing the LL at appropriate position
		while (list != null) {
			// search the nodes in the list to see if the key already exists
			if (list.key.equals(key))
				break;
			list = list.next;

		}
		// at this point either list is null or match found
		if (list != null) {
			// match found : associate the value
			list.value = value;
		} else {
//			since list == null, the key is not already in the list
//			add a new node at the head of the list to contain the new key and it's associated values
			if (count >= 0.75 * table.length) {
				/*
				 * the table is becoming too full. increase it's size before adding the new node
				 */
				resize();
			}
			ListNode newNode = new ListNode();
			newNode.key = key;
			newNode.value = value;
			newNode.next = table[bucket];// which is null
			table[bucket] = newNode;
			count++;// count the newly added key
		}
	}

	public void remove(String key) {
		/*
		 * remove the key and it's associated value from the table. if it does not occur
		 * then nothing is done
		 */
		int bucket = hash(key);
		if (table[bucket] == null) {
			/*
			 * there are no keys in that location so key does not occur in the table. there
			 * is nothing to do so return;
			 */
			return;
		}
		if (table[bucket].key.equals(key)) {
			/*
			 * if key is the first node in the list then table bucket must be changed to
			 * eliminate the first node from the list.
			 */
			table[bucket] = table[bucket].next;
			count--;
			return;
		}
		/*
		 * we have to remove a node from somewhere in the middle of the list or the end.
		 * use a pointer to traverse the list, looking for a node that contains the
		 * specified key, and remove if found. here a node that precedes the current is
		 * in the list prev.next is always equal to current
		 */
		ListNode prev = table[bucket];
		ListNode curr = prev.next;// for traversing the list starting from the second node
		while (curr != null & !curr.key.equals(key)) {
			prev = curr;
			curr = prev.next;
		}
		/*
		 * either curr == null i.e. end of the LL or we have got a matching key. In the
		 * later case, we have to remove the curr from the list. Do this by making
		 * prev.next point to the node after curr, i.e. curr.next or prev.next.next; if
		 * curr is null it means that the key was not found, so return.
		 */
		if (curr != null) {
			prev.next = curr.next;
			count--;// reduce the number of items by 1
		}
	}

	public boolean containsPhoneNumber(String key) {
		/*
		 * test whether the specified key has an associated value in the table.
		 * 
		 */
		int bucket = hash(key);// location of the key
		ListNode list = table[bucket];// for traversing the list
		while (list != null) {
			// if we find the key in this node return true
			if (list.key.equals(key))
				return true;
			list = list.next;
		}
		/*
		 * if we get to this point, we know that the key does not exist
		 */
		return false;
	}

	public PhonebookEntry get(String key) {
		/*
		 * get the value specified by the key
		 */
		int bucket = hash(key);
		ListNode list = table[bucket];
		while (list != null) {
//			if we find the key in this node we return the value associated with it
			if (list.key.equals(key))
				return list.value;
			list = list.next;
		}
		return null;
	}

	public int size() {
		// return the number of key value pairs in the table
		return count;
	}

	private int hash(String key) {
		/*
		 * compute a hash code for the key; key can't be null. the hash code depends on
		 * the size of the table as well as on the value retunrned by key.hashCode()
		 */
		return (Math.abs(key.hashCode())) % table.length;//hashing
	}

	private void resize() {
		/*
		 * 1. double the size of the table; 2. redistribute the key value pairs i.e.
		 * rehash the table
		 */
		ListNode[] newTable = new ListNode[table.length * 2];
		for (int i = 0; i < table.length; i++) {
			/*
			 * move all the nodes in the linked list number i into the new table. No new
			 * ListNodes are created. the existing ListNode for each key/value pair is moved
			 * to the new table. this is done by changing the next pointer in the node and
			 * making the pointer in the new table point to the node
			 */
			ListNode list = table[i];// for traversing the linked list number i
			while (list != null) {
				// move the node pointed to by the list to the new table
				ListNode next = list.next;// this is next node in the list, save it's ref before changing the val of the
											// list
				int hash = (Math.abs(list.key.hashCode())) % newTable.length;
				/*
				 * hash is the hashcode of the list.key that is appropriate for the new table
				 * size the next two lines add the node pointed to by the list onto the head of
				 * the linked liist in the new table at the position number hash
				 */
				list.next = newTable[hash];// i.e. null or the LL
				newTable[hash] = list;// i.e. splice, now in list, one down... continue rehashing
				list = next;// move onto next node in the old table
			}

		}
		table = newTable;
	}// end resize()

	public List<PhonebookEntry> valueSet() {
		List<PhonebookEntry> values = new ArrayList<>(count);
		// traversing every bucket
		for (int i = 0; i < table.length; i++) {
//				at ith bucket, traversing the LL to collect all the values in the values array
			ListNode list = table[i];
			while (list != null) {
				values.add(list.value);
				list = list.next;
			}
		}
		// the returned array is unordered
		return values;

	}

}
