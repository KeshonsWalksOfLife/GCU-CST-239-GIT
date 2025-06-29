/*
 * Keshon D. Bowman
 * CST-239-O500
 * Milestone 1
 * 06/29/2025
 * 
 * W3Schools.com.(2024). Java Scanner nextInt() - W3Schools.W3schools.com. 
 * https://www.w3schools.com/java/ref_scanner_nextint.asp
 * GeeksforGeeks. (2017, May 15). Switch Statements in Java. GeeksforGeeks. 
 * https://www.geeksforgeeks.org/java/switch-statement-in-java/
 * Variables (The JavaTM Tutorials > Learning the Java Language > Language Basics). (2019). Oracle.com. 
 * https://docs.oracle.com/javase/tutorial/java/nutsandbolts/variables.html
 * */

package Presentation;

import java.util.Scanner;
import businessLogic.InventoryManager;
import businessLogic.ShoppingCart;
import inventory.Book;

/**
 *The store class is what will be shown for the bookstore application
 *It will allow the user to interact with the book store by being able to view
 *the books, buy a book and view their cart to complete a purchase.  */
public class Store {

	private InventoryManager inventory;
	private ShoppingCart cart;
	
	/*
	 * Constructors to create a new store for its own inventory and shopping cart
	 * */
	public Store() {
		
		inventory = new InventoryManager();
		cart = new ShoppingCart();
	} 
	/*
	 * Loads the sample books into the inventory
	 * */
	public void loadBooks() {
		inventory.addBook(new Book ("The Way Of The Superior Man", "David Deida", "A Mans Awareness", 19.99, 2));
		inventory.addBook(new Book ("Million Dollar Weekend", "Noah Kagan", "Creating a million dollar business", 29.99, 4));
		inventory.addBook(new Book ("Contagious", "Jonah Berger", "What makes things popular?", 18.95, 3));
	} 
	/*
	 * Runs the Main.java loop that starts the application loop 
	 *  display will present the menu to get the user decision until the user
	 * is ready to leave.*/
	public void run() {
		Scanner scanner = new Scanner(System.in);
		boolean running = true;
		loadBooks(); 
	
	
	while (running) {
		// Menu Items
		System.out.println("Welcome To The Don's Fortress Of Knowledge");
		System.out.println("1. View Books");
		System.out.println("2. Buy a Book");
		System.out.println("3. View Cart");
		System.out.println("4. Cancel Purchase");
		System.out.println("5. Checkout");
		System.out.println("6. Exit");
		System.out.print("Choose an option: ");
		
		int choice = scanner.nextInt();
		scanner.nextLine();
		
		switch (choice) {
		case 1: 
			// views all available books
			inventory.displayBooks();
			break;
		case 2: 
			// purchases a book by title
			System.out.print("Enter the book title to purchase: ");
			String title = scanner.nextLine();
			
			// The instance of Book initialized select to get the book from inventory 
			Book selected = inventory.getBookByTitle(title);
			
			/*If the selected variable is not out of stock, the user with then 
			 * get the book from the quantity amount and either add it to the cart
			 * or show a user that it is out of stock*/
			if(selected != null && selected.getQuantity() > 0) {
					cart.addToCart(selected);
					selected.setQuantity(selected.getQuantity() - 1);
					System.out.println("Book has been added to cart.");
				} else {
					System.out.println("Book is out of stock");
				}
			break;
		case 3: 
			// views the current shopping cart
			cart.viewCart();
			break;
		case 4:
			// Cancels all books in the cart
			cart.cancelCart();
			System.out.println("Cart is cleared.");
			break;
		case 5: 
			// Finalize payment
			System.out.println("Total: $" + cart.getTotal());
			System.out.println("Thank you for your purchase!");
			running = true;
			break;
		case 6: 
			// User exits from the app
			System.out.println("Goodbye, Come Back Again!");
			running = false;
			break;
			// Error message
			default: 
				System.out.println("Invalid option.");
			}
		
		}
		// Closes the input
		scanner.close();
	}
}
