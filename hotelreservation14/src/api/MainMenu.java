package api;

import model.Customer;
import model.IRoom;
import model.RoomType;
import service.CustomerService;
import service.ReservationService;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class MainMenu {
    private static final CustomerService customerService = CustomerService.getInstance();
    private static final ReservationService reservationService = ReservationService.getInstance();
    public static int exitApp = 5;
    public static Scanner input;

    public static void main(String[] args){
        display_Menu();
    }
    public static void display_Menu() {
        System.out.println("Welcome!");
        System.out.println("1 - Find and Reserve a room");
        System.out.println("2 - See my reservations");
        System.out.println("3 - Create an account");
        System.out.println("4 - Admin");
        System.out.println("5 - Exit");

        boolean keepRunning = true;
        try (Scanner scanner = new Scanner(System.in)) {
            while (keepRunning) {
                try {
                    System.out.println("Welcome!");
                    System.out.println("1 - Find and Reserve a room");
                    System.out.println("2 - See my reservations");
                    System.out.println("3 - Create an account");
                    System.out.println("4 - Admin");
                    System.out.println("5 - Exit");
                    int selection = Integer.parseInt(scanner.next());
                    if (selection == 1) {
                        System.out.println("Find and Reserve a Room");

                        keepRunning = false;

                    } else if (selection == 2) {
                        System.out.println("See my reservations");

                        keepRunning = false;

                    } else if (selection == 3) {
                        System.out.println("Create an account");

                        keepRunning = false;

                    } else if (selection == 4) {
                        System.out.println("Admin Menu");

                        AdminMenu adminMenu = new AdminMenu();

                    } else if (selection == 5) {
                        System.out.println("Exit");
                        MainMenu mainMenu = new MainMenu();
                        mainMenu.display_Menu();
                    } else {
                        System.out.println("Please select a number between 1 and 5");
                    }
                } catch (Exception ex) {
                    System.out.println("\nError - Invalid Input\n");
                }
            }
        }
    }

    private static void  viewMyReservation() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Email:");
        String email = scanner.next();
        System.out.println(HotelResource.getCustomersReservation(email));
    }
    private static Customer createAccount() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter First Name:");
        String firstName = scanner.next();
        System.out.println("Enter Last Name:");
        String lastName = scanner.next();
        System.out.println("Enter Email:");
        String email = scanner.next();
        HotelResource.createACustomer(email, firstName, lastName);
        return new Customer(firstName, lastName, email);
    }
    private static void findAndReserveARoom() {

        Date checkOutDate = new Date();
        Date checkInDate = new Date();

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Check in DD/MM/YYYY Format");
        String checkInString = scanner.next();

        try {
            checkInDate = (Date) formatter.parse(checkInString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println("Check Out Date");
        String checkOutString = scanner.next();
        try {
            checkOutDate = (Date) formatter.parse(checkOutString);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        System.out.println("Available Rooms ");
        System.out.println(HotelResource.findARoom(checkInDate , checkOutDate));
        System.out.println("Room number: ");
        String roomNumber = scanner.next();
        IRoom room = HotelResource.getRoom(roomNumber);
        System.out.println(room);
        System.out.println(roomNumber);
        System.out.println("Enter email: ");
        String email = scanner.next();
        HotelResource.bookARoom(email , room , checkInDate , checkOutDate);
        System.out.println(email + room + checkInDate + checkOutDate);
        System.out.println("You're booked!");
        ;
    }
}
