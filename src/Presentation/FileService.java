package Presentation;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;
import inventory.Book;

public class FileService {
	public List<Book> readInventoryFromJson(String fileName) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		return Arrays.asList(mapper.readValue(new File(fileName), Book[].class));
	}
}
