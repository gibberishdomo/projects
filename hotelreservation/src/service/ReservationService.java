package service;

import model.Customer;
import model.IRoom;
import model.Reservation;

import java.text.SimpleDateFormat;
import java.util.*;

public class ReservationService {
    public static ArrayList<IRoom> rooms = new ArrayList<IRoom>();
    public static ArrayList<Reservation> reservations = new ArrayList<Reservation>();

    public ReservationService() {
    }

    public void addRoom(IRoom room) {rooms.add(room);}

    public IRoom getARoom(String roomId) {
        Iterator alpha = rooms.iterator();

        IRoom room;
        do {
            if (!alpha.hasNext()){
                return null;
            }

            room = (IRoom)alpha.next();
        }while(!room.getRoomNumber().equals(roomId));

        return room;
    }

    public Reservation reserveARoom(Customer customer, IRoom room, Date checkInDate, Date checkOutDate){
        Reservation reservation = new Reservation(customer,room,checkInDate,checkOutDate);
        reservations.add(reservation);
        return reservation;
    }

    public List<Reservation> getCustomerReservation(Customer customer) {
        List<Reservation> reservationsBasedOnCustomer = new ArrayList<>();
        Iterator charlie = reservations.iterator();

        while(charlie.hasNext()){
            Reservation reservation = (Reservation)charlie.next();
            if (reservation.getCustomer().equals(customer)) {
                reservationsBasedOnCustomer.add(reservation);
            }
        }

        return reservationsBasedOnCustomer;
    }

    public List<IRoom> findARoom(Date checkInDate, Date checkOutDate) {
        ArrayList roomsBasedOnDates = new ArrayList<>();

        try {
            Iterator delta = reservations.iterator();

            while(delta.hasNext()) {
                Reservation reservation = (Reservation)delta.next();
                if (reservation.getCheckInDate() == checkInDate && reservation.getCheckOutDate() == checkOutDate) {
                    roomsBasedOnDates.add(reservation.getRoom());
                }
            }

            int[] hotelRooms = {101, 102, 103, 104, 105};
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Collection<Date> dateList = null;
            Date startDate = null;
            Date endDate = null;

        }catch (Exception delta) {
            if (reservations.isEmpty()) {
                return null;
            }
        }

        return roomsBasedOnDates;
    }

    public void printAllReservations(){System.out.println(reservations);}

    public List<Reservation> getCustomerReservation(String customerEmail) {
        List<Reservation> reservationsBasedOnEmail = new ArrayList<>();
        Iterator delta = reservations.iterator();

        while(delta.hasNext()) {
            Reservation reservation = (Reservation)delta.next();
            if (reservation.getCustomer().getEmail().equals(customerEmail)) {
                reservationsBasedOnEmail.add(reservation);
            }
        }

        return reservationsBasedOnEmail;
    }

    public List<IRoom> allRooms() {return rooms;}




}

