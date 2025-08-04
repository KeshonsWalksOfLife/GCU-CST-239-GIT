package adminStack;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import com.fasterxml.jackson.databind.ObjectMapper;

import businessLogic.InventoryManager;
import inventory.Book;

public class AdminService implements Runnable {

    private InventoryManager inventory;
    private int port;

    public AdminService(InventoryManager inventory, int port) {
        this.inventory = inventory;
        this.port = port;
    }

    public void run() {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Admin Service started on port " + port);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                handleClient(clientSocket);
            }
        } catch (IOException e) {
            System.out.println("Error with Admin Service: " + e.getMessage());
        }
    }

    private void handleClient(Socket clientSocket) {
       
    	try (
        		
            BufferedReader in = new BufferedReader(new InputStreamReader
            		(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter
            		(clientSocket.getOutputStream(), true)
        ) {
            String command;

            while ((command = in.readLine()) != null) {
            	
            	System.out.println("Received command: " + command);
            	
            	
                if (command.equals("R")) {
                    // Return all inventory as JSON
                    ObjectMapper mapper = new ObjectMapper();
                   
                    String json = mapper.writeValueAsString(inventory.getBooks());
                    System.out.println("Sending response: " + json);
                    
                    out.println(json);
                    out.flush();
                    
                    System.out.println("Server sent JSON response to client");
            

                } else if (command.startsWith("U")) {
                    
                	// Update inventory with new products
                    String jsonPayload = command.substring(1); 
                    System.out.println("Server received update payload: " + jsonPayload);
                    
                    ObjectMapper mapper = new ObjectMapper();
                    Book[] newBooks = mapper.readValue(jsonPayload, Book[].class);
                    
                    for (Book b : newBooks) {
                        inventory.addBook(b);
                        System.out.println("Added Book: " + b.getTitle());
                    }
                    
                    // Write updated inventory to file
                    File file = new File("Books.json");
                    mapper.writeValue(file, inventory.getBooks());

                    out.println("Inventory has updated successfully!");
                    out.flush();
                    System.out.println("Inventory has updated, Sending Confirmation now...");

                } else {
                	System.out.println("Unknown Command: " + command);
                    out.println("This command is unknown");
                    out.flush();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("There's an Error: " + e.getMessage());
        }
    }
}

