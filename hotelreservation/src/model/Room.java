package model;

public class Room implements IRoom{

    String roomNumber;
    Double price;
    RoomType enumeration;

    public Room(String roomNumber,Double price,RoomType enumeration) {
        this.roomNumber = roomNumber;
        this.price = price;
        this.enumeration = enumeration;
    }

    @Override
    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
       roomNumber = roomNumber;
    }

    @Override
    public Double getRoomPrice() {
        return price;
    }

    public void setRoomPrice(Double price) {
        price = price;
    }

    @Override
    public RoomType getRoomType() {
        return enumeration;
    }

    public void setRoomType(RoomType enumeration){
        enumeration = enumeration;
    }

    @Override
    public boolean isFree() {
        return false;
    }

    public int hashCode(){return super.hashCode();}
    public boolean equals(Object obj) {return super.equals(obj);}

    @Override
    public String toString() {return "Room Number:" + roomNumber + ", " + "Price:" + price + ", " + "RoomType:" + enumeration;}
}
