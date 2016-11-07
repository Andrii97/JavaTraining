package ua.model;

import java.util.Date;

/**
 * Created by andrii on 06.11.16.
 */
public class Record {
    /**
     *
     */
    private String firstName;

    /**
     *
     */
    private String lastName;

    /**
     *
     */
    private String middleName;

    /**
     *
     */
    private String compositeName;

    /**
     *
     */
    private String nickname;

    /**
     *
     */
    private String comment;

    /**
     *
     */
    private Group group;

    /**
     *
     */
    private String homePhone;

    /**
     *
     */
    private String mobilePhone;

    /**
     *
     */
    private String additionalMobilePhone;

    /**
     *
     */
    private String email;

    /**
     *
     */
    private String skype;

    /**
     *
     */
    private Address address;

    /**
     *
     */
    private String fullAddress;

    /**
     *
     */
    private Date dateOfCreation;

    /**
     *
     */
    private Date dateOfLastModified;

    public Record(String firstName, String lastName, String middleName, String nickname,
                  String comment, Group group, String homePhone, String mobilePhone,
                  String additionalMobilePhone, String email, String skype, Address address,
                  Date dateOfCreation, Date dateOfLastModified) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.compositeName = lastName + " " + firstName.charAt(0) + '.';
        this.nickname = nickname;
        this.comment = comment;
        this.group = group;
        this.homePhone = homePhone;
        this.mobilePhone = mobilePhone;
        this.additionalMobilePhone = additionalMobilePhone;
        this.email = email;
        this.skype = skype;
        this.address = address;
        this.fullAddress = address.toString();
        this.dateOfCreation = dateOfCreation;
        this.dateOfLastModified = dateOfLastModified;
    }

    @Override
    public String toString() {
        return "Record{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", compositeName='" + compositeName + '\'' +
                ", nickname='" + nickname + '\'' +
                ", comment='" + comment + '\'' +
                ", group=" + group +
                ", homePhone='" + homePhone + '\'' +
                ", mobilePhone='" + mobilePhone + '\'' +
                ", additionalMobilePhone='" + additionalMobilePhone + '\'' +
                ", email='" + email + '\'' +
                ", skype='" + skype + '\'' +
                ", address=" + address +
                ", fullAddress='" + fullAddress + '\'' +
                ", dateOfCreation=" + dateOfCreation +
                ", dateOfLastModified=" + dateOfLastModified +
                '}';
    }
}
