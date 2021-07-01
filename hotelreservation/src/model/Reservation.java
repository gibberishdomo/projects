package model;

import java.util.Date;

public class Reservation {

    private Customer customer;
    private IRoom room;
    private Date checkInDate;
    private Date checkOutDate;

    public Reservation(Customer customer, IRoom room, Date checkInDate, Date checkOutDate) {
        this.customer = customer;
        this.room = room;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public void setCustomer(Customer customer) {
       customer = customer;
    }

    public IRoom getRoom() {
        return this.room;
    }

    public void setIRoom(IRoom room)  {
        room = room;
    }

    public Date getCheckInDate() {
        return this.checkInDate;
    }

    public void setCheckInDate(Date checkInDate)  {
       checkInDate = checkInDate;
    }

    public Date getCheckOutDate() {
        return this.checkOutDate;
    }

    public void setCheckOutDate(Date checkOutDate)  {
        checkOutDate = checkOutDate;
    }

    @Override
    public String toString() {return "Name:" + customer  +  ", " + "Room:" + room + ", " + "CheckInDate:" + checkInDate + ", " + "CheckOutDate:" + checkOutDate;}
}
