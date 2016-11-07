package ua;

/**
 * Created by andrii on 06.11.16.
 */
public class GlobalConstants {
    // «Andrii»
    String REGEX_NAME = "^[A-Z][a-z]+$";
    // «an_d.»
    String REGEX_NICKNAME = "^[a-zA-Z][a-zA-Z0-9-_\\.]{1,20}$";
    // «FRIENDS»
    String REGEX_GROUP = "FRIENDS|RELATIVES|WORK|EDUCATION";
    // «+38(044)555-55-55»
    String REGEX_PHONE = "^\\+\\d{2}\\(\\d{3}\\)\\d{3}-\\d{2}-\\d{2}$";
    // «nick@mail.com»
    String REGEX_EMAIL = "^([a-z0-9_-]+\\.)*[a-z0-9_-]+@[a-z0-9_-]+(\\.[a-z0-9_-]+)*\\.[a-z]{2,6}$";
    //
    String SKYPE = "^[a-zA-Z][a-zA-Z0-9\\.,\\-_]{5,31}$";
    // Ukrainian postal code "43445"
    String POSTAL_CODE = "^[0-9]{5}$";
    // «12b»
    String HOUSE_NUMBER = "^\\d+[a-zA-Z]*$";
    // «12»
    String apartmentNumber = "^[\\d]+$";
    // «DD.MM.YYYY»
    String DATE = "^(0[1-9]|1[0-9]|2[0-9]|3[01]).(0[1-9]|1[012]).[0-9]{4}$";
}
