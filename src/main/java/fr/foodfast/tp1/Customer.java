package fr.foodfast.tp1;

public class Customer {

    private String firstName;
    private String lastName;
    private String deliveryAddress;
    private String phoneNumber;

    public Customer(String firstName, String lastName, String deliveryAddress, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.deliveryAddress = deliveryAddress;
        this.phoneNumber = phoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }
}
