package menu;

import api.AdminResource;
import api.HotelResource;
import model.Customer;
import model.Room;
import model.RoomType;

import java.util.Date;
import java.util.Scanner;

public class MainMenu {
    public static AdminResource admin = new AdminResource();
    public static HotelResource hotel = new HotelResource();
    public static int exitProgram = 5;
    public static Scanner input;

    public MainMenu() {}

    public static void main(String[] args) {
        input = new Scanner(System.in);
        int selection = 0;

        while(selection != exitProgram) {
            selection = displayMenu();
            switch(selection) {
                case 0:
                    findAndReserveRoom();
                    break;
                case 1:
                    seeMyReservations();
                    break;
                case 2:
                    createAccount();
                case 3:
                    AdminMenu.setAdminResource(admin);
                    AdminMenu.displayAdmin();
                    break;
                case 4:
                    input.close();
                    System.exit(0);
                default:
                    displayMenu();
            }
    }

    }

    private static void seeMyReservations() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Customer Email:");
        String email = scanner.next();
        System.out.println(hotel.getCustomerReservations(email));
    }

    private static Customer createAccount() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Customer First Name:");
        String firstName = scanner.next();
        System.out.println("Enter Customer Last Name:");
        String lastName = scanner.next();
        System.out.println("Enter Customer Email:");
        String email = scanner.next();
        hotel.createACustomer(email, firstName, lastName);
        return new Customer(firstName, lastName, email);
    }

    private static void findAndReserveRoom() {
        hotel.getRoom("roomNumber");
        hotel.bookARoom(createAccount(), room, new Date(), new Date());
        System.out.println("Reserved");
    }

    private static int displayMenu() {
        String[] menus = new String[]{"Find and reserve a room", "See my reservations", "Create an account", "Admin", "Exit"};

        for(int i = 0; i < menus.length; ++i) {
            System.out.println(" " + i + " " + menus[i]);
        }


        System.out.println("Enter menu:");
        return input.nextInt();
    }
}


