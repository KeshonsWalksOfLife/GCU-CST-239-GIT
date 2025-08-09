/*
 * Keshon D. Bowman
 * CST-239-O500
 * Milestone 6
 * 08/03/2025
 * ArrayList (Java Platform SE 8 ). (2019, September 11). Oracle.com. 
 * https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html
 * Collections (Java Platform SE 8 ). (2025). Docs.oracle.com. 
 * https://docs.oracle.com/javase/8/docs/api/java/util/Collections.html
 * Jakob Jenkov. (2024). Jackson ObjectMapper. Jenkov.com. 
 * https://jenkov.com/tutorials/java-json/jackson-objectmapper.html#jackson-objectmapper-example
 * Pratt, M. (2023, December 5). All the Ways Java Uses the Colon Character.Baeldung. 
 * https://www.baeldung.com/java-colon
 * */

package businessLogic;

import java.util.Collections;

import java.util.ArrayList;
import inventory.Book;
import inventory.PriceComparator;

/*
 * The InventoryManager class will handle the storage for the bookstore
 * This will display the books that are in the inventory 
 * based upon the ArrayList for all the current books in stock.*/
public class InventoryManager {
	// List all books in the inventory
	private ArrayList<Book> books;
	// Constructor initialized an empty book in the inventory list
	public InventoryManager() {
		// Storage for books
		books = new ArrayList<>();
	}
	
	// This will add the book into the inventory list
	public void addBook(Book book) {
		books.add(book);
	}
	// This will remove the book from the inventory list
	public void removeBook(Book book) {
		books.remove(book);
	}
	/* 
	 * Books will display from the index, 
	 * each book will be called out to the toString method to format the output. */
	public void displayBooks() {
		// This will sort all books by their alphabet
		Collections.sort(books, new PriceComparator());
		
		for(int i = 0; i < books.size(); i++) {
			System.out.println((i + 1) + ", " + books.get(i).toString());
			// line break for better readability
			System.out.println();
		}
	}
	
	  public void clearInventory() {
	    	books.clear();
	    }
	
	/*
	 * The user can search for the book by its title
	 * The search is case-insensitive*/
	public Book getBookByTitle(String title) {
		for(Book book : books) {
			if (book.getTitle().equalsIgnoreCase(title)) {
				return book; 
			}
		}
		// Returns null if nothing is found
		return null;
	}
	
	// Returns the list of books into inventory
	public ArrayList<Book> getBooks() {
		return books;
	}
}
