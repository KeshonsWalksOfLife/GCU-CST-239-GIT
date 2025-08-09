/*
 * Keshon D. Bowman
 * CST-239-O500
 * Milestone 6
 * 08/03/2025
 */

package adminStack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class AdminClient {

	public static void main(String[] args) {
		try (Socket socket = new Socket("Localhost", 2659);
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			Scanner scanner = new Scanner(System.in);
			) {
			
			System.out.println("Connected to Admin Service.");
			System.out.println(" Type commands (R or U).");
			System.out.println(" R = return all inventory");
			System.out.println(" U[{json}] = update inventory with JSON");
			System.out.println(" EXIT = quit \n");
			
			while (true) {
                System.out.print("Enter command: ");
                String command = scanner.nextLine();

                if ("EXIT".equalsIgnoreCase(command)) {
                    break; // quit client
                }
                
                // if command is "U", Send U first, then ask for JSON next
                if (command.equalsIgnoreCase("U")) {
                	out.println("U");
                	
                	System.out.println("Enter JSON payload: ");
                	String jsonPayload = scanner.nextLine();
                	out.println(jsonPayload);
                } else {
                out.println(command); // send to server
                out.flush();
                }
                
               
                String response;
                while ((response = in.readLine()) != null) { 
                	System.out.println("Client received: " + response);
                	break; 
                } 
            }
		} catch (IOException e) {
			System.out.println("Error in the Admin Client: " + e.getMessage());
		}

	}

}
