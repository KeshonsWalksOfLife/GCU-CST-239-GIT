/*
 * Keshon D. Bowman
 * CST-239-O500
 * Milestone 6
 * 08/03/2025
 * 
 * GeeksforGeeks. (2017, May 15). Switch Statements in Java. GeeksforGeeks. 
 * https://www.geeksforgeeks.org/java/switch-statement-in-java/
 * Variables (The JavaTM Tutorials > Learning the Java Language > Language Basics). (2019). Oracle.com. 
 * https://docs.oracle.com/javase/tutorial/java/nutsandbolts/variables.html
 * W3Schools.com.(2024). Java Scanner nextInt() - W3Schools.W3schools.com. 
 * https://www.w3schools.com/java/ref_scanner_nextint.asp
 * */

package Presentation;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import adminStack.AdminService;
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
		
		// Loading inventory from Books.json
		try {
			FileService fileservice = new FileService();
			List<Book> loadedBooks = fileservice.readInventoryFromJson("Books.json");
			
			for (Book book : loadedBooks) {
				inventory.addBook(book);
			}
		} catch (IOException e) {
			System.out.println("Could not load books: " + e.getMessage());
		}
		
		// This is where the Admin service will run in the background
		Thread adminThread = new Thread(new AdminService(inventory, 2659));
		adminThread.start();
	} 
	
	public void run() {
		Scanner scanner = new Scanner(System.in);
		boolean running = true;
	
		System.out.println("Welcome to the Neighborhood Bookstore!");
		System.out.println("Story telling your vision to life.\n");
	
	while (running) {
		// Menu Items
		System.out.println("1. View Books");
		System.out.println("2. Buy a Book");
		System.out.println("3. View Cart");
		System.out.println("4. Cancel Purchase");
		System.out.println("5. Checkout");
		System.out.println("6. Exit \n");
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
			System.out.print("Enter the book title of interest: ");
			String title = scanner.nextLine();
			
			// The instance of Book initialized select to get the book from inventory 
			Book selected = inventory.getBookByTitle(title);
			
			/*If the selected variable is not out of stock, the user with then 
			 * get the book from the quantity amount and either add it to the cart
			 * or show a user that it is out of stock*/
			if(selected != null && selected.getQuantity() > 0) {
					cart.addToCart(selected);
					selected.setQuantity(selected.getQuantity() - 1);
					System.out.println("Book has been added to your cart.");
				} else {
					System.out.println("Sorry, Book is out of stock, currently working in progress.");
				}
			break;
		case 3: 
			// views the current shopping cart
			cart.viewCart();
			break;
		case 4:
			// Cancels all books in the cart
			cart.cancelCart();
			System.out.println("The Cart is now cleared.");
			break;
		case 5: 
			// Finalize payment
			System.out.println("Total: $" + cart.getTotal());
			System.out.println("Thank you for your purchase!");
			running = true;
			break;
		case 6: 
			// User exits from the app
			System.out.println("Thank you for visiting the Neighborhood Bookstore. Come Back Again!");
			running = false;
			break;
			// Error message
			default: 
				System.out.println("Invalid option. Please try again.");
			}
		
		}
		// Closes the input
		scanner.close();
	}
}
