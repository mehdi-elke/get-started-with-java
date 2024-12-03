package fr.tp2;

public class Customer {
    private final String firstName;
    private final String lastName;
    private final String deliveryAddress;
    private final String phoneNumber;

    public Customer(String firstName, String lastName, String deliveryAddress, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.deliveryAddress = deliveryAddress;
        this.phoneNumber = phoneNumber;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public Customer getPhoneNumber() {
        return phoneNumber;
    }
}
