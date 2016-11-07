package ua.model;

/**
 * Created by andrii on 06.11.16.
 */
public class Address {
    /**
     *
     */
    private String postalCode;

    /**
     *
     */
    private String city;

    /**
     *
     */
    private String street;

    /**
     *
     */
    private String houseNumber;

    /**
     *
     */
    private String apartmentNumber;

    /**
     *
     * @param postalCode
     * @param city
     * @param street
     * @param houseNumber
     * @param apartmentNumber
     */
    public Address(String postalCode, String city, String street, String houseNumber, String apartmentNumber) {
        this.postalCode = postalCode;
        this.city = city;
        this.street = street;
        this.houseNumber = houseNumber;
        this.apartmentNumber = apartmentNumber;
    }

    @Override
    public String toString() {
        return "Address{" +
                "postalCode='" + postalCode + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", houseNumber='" + houseNumber + '\'' +
                ", apartmentNumber='" + apartmentNumber + '\'' +
                '}';
    }
}
