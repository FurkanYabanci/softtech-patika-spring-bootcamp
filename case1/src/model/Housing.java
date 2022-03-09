package model;

public class Housing {

    private long price;
    private int size;
    private String numberOfRooms;
    private String address;

    public Housing(){

    }
    public Housing(long price, int size, String numberOfRooms, String address) {
        this.price = price;
        this.size = size;
        this.numberOfRooms = numberOfRooms;
        this.address = address;
    }

    public long getPrice() {
        return price;
    }
    public void setPrice(long price) {
        this.price = price;
    }
    public int getSize() {
        return size;
    }
    public void setSize(int size) {
        this.size = size;
    }
    public String getNumberOfRooms() {
        return numberOfRooms;
    }
    public void setNumberOfRooms(String numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return  "\n" +  "{" +
                "price=" + price + " TL" +
                ", size=" + size + " m2" +
                ", numberOfRooms='" + numberOfRooms + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
