package model;

public class FreeRoom extends Room {

    public FreeRoom() {this.price = 0.0;}

    @Override
    public String toString() {
        return "model.FreeRoom{roomNumber='" + this.roomNumber + '\'' + ", price=" + this.price + ", roomType=" + this.enumeration + '}';
    }
}
