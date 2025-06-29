/*
 * Keshon D. Bowman
 * CST-239-O500
 * Milestone 1
 * 06/29/2025
 * 
 * 
 * */

package businessLogic;

import java.util.ArrayList;
import inventory.Book;

public class InventoryManager {
	
	private ArrayList<Book> books;
	
	public InventoryManager() {
		books = new ArrayList<>();
	}
	
	public void addBook(Book book) {
		books.add(book);
	}
	
	public void displayBooks() {
		for(int i = 0; i < books.size(); i++) {
			System.out.println((i + 1) + ", " + books.get(i).toString());
			System.out.println();
		}
	}
	
	public Book getBookByTitle(String title) {
		for(Book book : books) {
			if (book.getTitle().equalsIgnoreCase(title)) {
				return book; 
			}
		}
		
		return null;
	}
	
	public ArrayList<Book> getBooks() {
		return books;
	}
}
