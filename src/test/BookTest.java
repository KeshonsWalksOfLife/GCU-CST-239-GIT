/*
 * Keshon D. Bowman
 * CST-239-O500
 * Milestone 7
 * 08/10/2025
 * */

package test;

import static org.junit.Assert.*;

import org.junit.Test;

import inventory.Book;


public class BookTest {

	// This test the books class for the instance of the properties
	@Test
	public void testBook() {
		Book book = new Book("This is Marketing", "Seth Godin", "Marketing Training Module", 15.99, 5);
		assertEquals("This is Marketing", book.getTitle());
		assertEquals("Seth Godin", book.getAuthor());
		assertEquals("Marketing Training Module", book.getDescription());
		assertEquals(15.99, book.getPrice(), 0.001);
		assertEquals(5 , book.getQuantity());
	}
		
	// This sets the Book and uploads it as shown to confirm its correct
	@Test 
	public void testSettersAndGetters() {
		Book book = new Book();
		book.setTitle("Atomic Habits");
		book.setAuthor("James Clear");
		book.setDescription("Habit Training");
		book.setPrice(12.99);
		book.setQuantity(3);
		
	    assertEquals("Atomic Habits", book.getTitle());
	    assertEquals("James Clear", book.getAuthor());
	    assertEquals("Habit Training", book.getDescription());
	    assertEquals(12.99, book.getPrice(), 0.001);
	    assertEquals(3, book.getQuantity());
	}

}
