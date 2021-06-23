package model;

import java.util.Date;

public class Room implements IRoom {

    String roomNumber;
    Double price;
    RoomType enumeration;

    public Room(String roomNumber,Double price,RoomType enumeration) {

        this.roomNumber = roomNumber;
        this.price = price;
        this.enumeration = enumeration;
    }

    public Room(){

    }



    @Override
    public String getRoomNumber() {
        return this.roomNumber;
    }

    @Override
    public Double getRoomPrice() {
        return this.price;
    }

    @Override
    public RoomType getRoomType() {
        return this.enumeration;
    }

    @Override
    public boolean isFree() {
        return false;
    }



    @Override
    public String toString() {
        return "model.Room{roomNumber='" + this.roomNumber + '\'' + ", price=" + this.price + ", roomType=" + this.enumeration + '}';
    }

}
