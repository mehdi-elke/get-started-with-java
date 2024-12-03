package fr.baretto.tp3;

public class Customer {
    private String lastname;
    private String firstname;
    private String address;
    private String phoneNumber;

    public Customer(String lastname, String phoneNumber, String address, String firstname) {
        this.lastname = lastname;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
