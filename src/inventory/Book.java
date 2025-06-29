/*
 * Keshon D. Bowman
 * CST-239-O500
 * Milestone 1
 * 06/29/2025
 * 
 * 
 * */

package inventory;

public class Book {
	
	private String title;
	private String author;
	private String description;
	private double price;
	private int quantity;

	public Book(String title, String author, String description, 
			double price, int quantity) {
		this.title = title;
		this.author = author;
		this.description = description;
		this.price = price;
		this.quantity = quantity;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public String getDesc() {
		return description;
	}
	public double getPrice() {
		return price;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
// This will display the books as a string

	public String toString() {
	    return "\"" + title + "\" by " + author + " - $" + price +
	           "\n" + description + " [" + quantity + " in stock]";
	}

}
