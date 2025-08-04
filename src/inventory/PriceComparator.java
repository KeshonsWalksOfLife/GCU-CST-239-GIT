/*
 * Keshon D. Bowman
 * CST-239-O500
 * Milestone 6
 * 08/03/2025
 * 
 * GeeksforGeeks. (2016). Java Comparator Interface. GeeksforGeeks. 
 * https://www.geeksforgeeks.org/java/java-comparator-interface/
*/
package inventory;

import java.util.Comparator;
 // The Comparator interface in Java is used to sort the objects for User-defined classes which is the Book Class
public class PriceComparator implements Comparator<Book> {
	@Override
	// Statement will compare both books and see whose prices cost less and will ascend upward
	public int compare(Book b1, Book b2) {
		return Double.compare(b1.getPrice(), b2.getPrice());
	}
}
