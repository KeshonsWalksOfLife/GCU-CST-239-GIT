/*
 * Keshon D. Bowman
 * CST-239-O500
 * Milestone 1
 * 06/29/2025
 * 
 * ArrayList (Java Platform SE 8 ). (2019, September 11). Oracle.com. 
 * https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html
 * How to use the toString method in Java? - Stack Overflow.(2015, March 7). Stack Overflow.
 * https://stackoverflow.com/questions/3615721/how-to-use-the-tostring-method-in-java
 * Pratt, M. (2023, December 5). All the Ways Java Uses the Colon Character.  Baeldung. 
 * https://www.baeldung.com/java-colon
 * Variables (The JavaTM Tutorials > Learning the Java Language > Language Basics). (2019). Oracle.com. 
 * https://docs.oracle.com/javase/tutorial/java/nutsandbolts/variables.html
 * */

package businessLogic;

import java.util.ArrayList;
import inventory.Book;
import businessLogic.ShoppingCart;

/*
 *This represents the shopping cart in the application which will allow user
 *to add the book to the cart and view what the user ordered. It will then calculate how 
 *much is owed and tell the user.
 */
public class ShoppingCart {
	
// List of the books added to the cart
private ArrayList<Book> cartItem;

	/*This will build from an empty shopping cart*/
	public ShoppingCart() {
		cartItem = new ArrayList<>();
	}
	/*Adds a book to the shopping cart*/
	public void addToCart(Book book) {
		cartItem.add(book);
	}
	/*Clears all the items from the cart*/
	public void cancelCart() {
		cartItem.clear();
	}
	/*Displays the content of the cart and shows the books with its detail*/
	public void viewCart() {
		if(cartItem.isEmpty()) {
			System.out.println("The cart is empty");
		} else {
			for (Book book : cartItem) {
			System.out.println(book.toString());
			System.out.println();
			}
		}
	}
	// Calculate the total price of all the books in the cart
	public double getTotal() {
		double total = 0.0;
		for (Book book : cartItem) {
			total += book.getPrice();
		}
		return total;
	}
	/*Returns the list of books that are currently in the users cart.*/
	public ArrayList<Book> getCartItems() {
		return cartItem;
	}
}
