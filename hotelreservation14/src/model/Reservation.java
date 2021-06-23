package model;

import java.util.Date;

public class Reservation {
    Customer customer;
    IRoom room;
    Date checkInDate;
    Date checkOutDate;

    public Reservation(Customer customer, IRoom iroom, Date checkInDate) {

        this.customer = customer;
        this.room = iroom;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;

    }

    public Reservation(String customer, IRoom room, Date checkInDate, Date checkOutDate) {
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public IRoom getRoom() {
        return this.room;
    }

    public void setIRoom(IRoom room) {
        this.room = room;
    }

    public Date getCheckInDate() {
        return this.checkInDate;
    }

    public void setCheckInDate(Date checkInDate) {
        this.checkInDate = checkInDate;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(Date checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    @Override
    public String toString() {
        return "Reserved:customer" + " " + this.customer + ", Room:" + this.room + " " + ", CheckInDate:" + this.checkInDate + " " + "CheckOutDate:" + this.checkOutDate + '}';
    }
}

