/*
 * Keshon D. Bowman
 * CST-239-O500
 * Milestone 7
 * 08/10/2025
 * */

package test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import businessLogic.ShoppingCart;
import inventory.Book;

public class ShoppingCartTest {

	private ShoppingCart cart;
	private Book book;
	
	@Before
	public void setUp() {
		cart = new ShoppingCart();
		book = new Book("Atomic Habits", "James Clear", "Self Development", 17.99, 3);
	}
	
	@Test
	public void testAddBookToCart() {
		cart.addToCart(book);
		assertEquals(1, cart.getCartItems().size());
		assertEquals(book, cart.getCartItems().get(0));
	}
	
	@Test
	public void testClearCart() {
		cart.addToCart(book);
		cart.cancelCart();
		assertEquals(0, cart.getCartItems().size());
	}
	
	@Test
	public void testCalculateTotal() {
		cart.addToCart(book);
		cart.addToCart("Build A StoryBrand", "Donald Miller", "Reaching Message To Audience", 24.99, 6);
		
		double total = cart.getTotal();
		assertEquals(17.99, total, 0.01);
	}
}
