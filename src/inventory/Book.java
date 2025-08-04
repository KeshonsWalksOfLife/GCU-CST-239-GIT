/* 
 * Keshon D. Bowman
 * CST-239-O500
 * Milestone 6
 * 08/03/2025
 * 
 * How to use the toString method in Java? - Stack Overflow.(2015, March 7). Stack Overflow.
 * https://stackoverflow.com/questions/3615721/how-to-use-the-tostring-method-in-java
 * Oracle. (2019, September 11). Comparator (Java Platform SE 8 ). Oracle.com. 
 * https://docs.oracle.com/javase/8/docs/api/java/util/Comparator.html
 * */

package inventory;

// This class represents the books for the inventory system
public class Book implements Comparable<Book> {
	// the title of the book
	private String title;
	// the author of the book
	private String author;
	// the description of the book
	private String description;
	// The price amount for the book
	private double price;
	// the number of books we have an inventory
	private int quantity;
	
	public Book() {}

	// Parameterized Constructor
	// This initializes all of the fields when the book is created
	public Book(String title, String author, String description, 
			double price, int quantity) {
		this.title = title;
		this.author = author;
		this.description = description;
		this.price = price;
		this.quantity = quantity;
	}
	
	// The Getters
	public String getTitle() {
		return title;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public String getDescription() {
		return description;
	}
	
	public double getPrice() {
		return price;
	}
	
	public int getQuantity() {
		return quantity;
	}
	// The Setter
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
// This will display the books into a readable string format

	public String toString() {
	    return "\"" + title + "\" by " + author + " - $" + price +
	           "\n" + description + " [" + quantity + " in stock]";
	}
	
/*this will compare one book title to the other books title
 * it will ignore all upper/lower cases */
@Override
public int compareTo(Book book) {
	return this.title.compareToIgnoreCase(book.title);
	}
}
