package api;

import model.Customer;
import model.IRoom;
import model.Reservation;
import model.RoomType;
import service.CustomerService;
import service.ReservationService;

import java.util.Collection;
import java.util.List;

public class AdminResource {

    public static final CustomerService customerService = CustomerService.getInstance();
    public static final ReservationService reservationService = ReservationService.getInstance();

    //private static CustomerService customerService = null;
    //private CustomerService() {}
    //public static CustomerService getInstance() {
    //    if (null == customerService) {
     //       customerService = new CustomerService();
    //    }
     //   return customerService;
    //}
    public AdminResource() {

    }
    public Customer getCustomer(String email) {
        return customerService.getCustomer(email);
    }
    public static void createRoom(String roomNumber, double price, RoomType roomType) {
        reservationService.addRoom(roomNumber, price, roomType);
        System.out.println("Your Room has been Created!");
    }
    public static Collection<IRoom> getAllRooms() {
        return reservationService.allRooms();
    }
    public static Collection<Customer> getAllCustomer() {
        return customerService.getAllCustomers();
    }
    public static Collection<Reservation> getAllReservations(){
        return reservationService.getAllReservations();
    }
}
