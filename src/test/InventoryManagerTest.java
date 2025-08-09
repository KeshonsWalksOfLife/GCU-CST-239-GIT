/*
 * Keshon D. Bowman
 * CST-239-O500
 * Milestone 7
 * 08/10/2025
 * */

package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import businessLogic.InventoryManager;
import inventory.Book;

public class InventoryManagerTest {
	private InventoryManager inventory;
	
	@Before
	public void setUp() {
		inventory = new InventoryManager();
		// This is to make sure inventory starts cleared
		inventory.clearInventory();
	}
	
	@Test
	public void testAddAndGetBook() {
		Book book = new Book("Think and Grow Rich", 
					"Napoleon Hill", 
					"Growing your mind and mindset to achieve the ultimate riches", 
					22.95, 8);
		inventory.addBook(book);
		
		Book found = inventory.getBookByTitle("Think and Grow Rich");
		assertNotNull(found);
		assertEquals("Napoleon Hill", found.getAuthor());
	}
	
	@Test
	public void testRemoveBook() {
		Book Book = new Book("Contagious","Jonah Berger", "What makes things popular", 18.95, 5);
		inventory.addBook(Book);
		inventory.removeBook(Book);
		
		Book found = inventory.getBookByTitle("Contagious");
		assertNull(found);
	}
	
	@Test
	public void testClearInventory() {
		Book book1 = new Book("Book One", "Author A", "Desc A", 10.0, 1);
        Book book2 = new Book("Book Two", "Author B", "Desc B", 15.0, 2);
        
        inventory.addBook(book1);
        inventory.addBook(book2);
        inventory.clearInventory();
        
        assertEquals(0, inventory.getBooks().size());
	}
}
