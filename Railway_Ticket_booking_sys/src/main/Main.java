package main;

import modules.Passengers;
import berth.Berth;
import service.BookingService;

import java.util.Scanner;
public class Main {
	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        BookingService bookingService = new BookingService();
	        String choice = "Y";

	        int PId = 1;
	        while (choice.equalsIgnoreCase("Y")) {
	            System.out.println("Railway Ticket Booking");
	            System.out.println("Select your choice");
	            System.out.println("1.Book Ticket \t 2.Print Ticket \t 3.Cancel Ticket \t");
	            int Choice = sc.nextInt();

	            switch (Choice) {
	                case 1:
	                    System.out.println("Name: ");
	                    String name = sc.next();
	                    System.out.println("Preferred Berth (UPPER/LOWER/MIDDLE): ");
	                    String preferredBerth = sc.next().toUpperCase();
	                    Passengers newPassenger = new Passengers(PId, name, Berth.valueOf(preferredBerth));
	                    bookingService.bookTicket(newPassenger);
	                    System.out.println("Your ID is: " + PId);
	                    PId++;
	                    break;

	                case 2:
	                    System.out.println("Enter Your ID: ");
	                    int id = sc.nextInt();
	                    bookingService.printTicket(id);
	                    break;

	                case 3:
	                    System.out.println("Enter Your ID to Cancel: ");
	                    int cancelId = sc.nextInt();
	                    bookingService.cancelTicket(cancelId);
	                    break;

	                case 4:
	                    System.out.println("Exiting...");
	                    choice = "N";
	                    break;

	                default:
	                    System.out.println("Invalid choice! Please try again.");
	            }

	            if (!choice.equalsIgnoreCase("N")) {
	                System.out.println("Do you want to continue? (Y/N): ");
	                choice = sc.next();
	            }
	        }

	        sc.close();
	    }
	

}
