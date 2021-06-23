package api;

import model.IRoom;
import model.Room;
import model.RoomType;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdminMenu {
    private static final AdminResource adminResource = new AdminResource();
    public void start() {
        boolean keepRunning = true;
        try (Scanner scanner = new Scanner(System.in)) {
            while (keepRunning) {
                try {
                    System.out.println("1. See Customers");
                    System.out.println("2. See Rooms");
                    System.out.println("3. See  Reservations");
                    System.out.println("4. Add Room");
                    System.out.println("5. Main Menu");
                    int selection = Integer.parseInt(scanner.next());
                    if (selection == 1) {
                        System.out.println("See Customers");
                        //keepRunning = false;
                    } else if (selection == 2) {
                        System.out.println("See Rooms");
                        keepRunning = false;
                    } else if (selection == 3) {
                        System.out.println("See Reservations");

                    } else if (selection == 4) {
                        System.out.println("Add Room");
                        Scanner userInput = new Scanner(System.in);
                        System.out.println("....................................................");
                        System.out.println("Enter room number");
                        String numberOfRoom = userInput.next();
                        System.out.println("Enter price per night");
                        Double pricePerNight = userInput.nextDouble();
                        System.out.println("Enter room type: 1 for single bed, or 2 for double bed");
                        String bedType = userInput.next();
                        RoomType roomType = userInput.nextInt() == 1 ? RoomType.SINGLE : RoomType.DOUBLE;
                        adminResource.createRoom(numberOfRoom, pricePerNight, roomType);
                        System.out.println("Would you like to book another room: Y/N?");
                        String option = userInput.next();

                    } else if (selection == 5) {
                        System.out.println("Main Menu");
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
}
