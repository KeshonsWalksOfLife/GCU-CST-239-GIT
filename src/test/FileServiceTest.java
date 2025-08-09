/*
 * Keshon D. Bowman
 * CST-239-O500
 * Milestone 7
 * 08/10/2025
 * */

package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.List;

import org.junit.Test;

import Presentation.FileService;
import inventory.Book;

public class FileServiceTest {
	
	@Test
	public void testReadInventoryFromJson() throws IOException {
		FileService fileService = new FileService();
		List<Book> books = fileService.readInventoryFromJson("Books.json");

		assertNotNull(books);
		assertTrue(books.size() > 0);
		assertEquals("The Way Of The Superior Man", books.get(0).getTitle());
	}
}
