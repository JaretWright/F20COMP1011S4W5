import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Patient {
    private int patientID;
    private String firstName, lastName;
    private String phoneNum;
    private String streetAddress, city, province;
    private LocalDate birthday;

    /**
     * This constructor will automatically add a valid Patient to the
     * database
     * @param firstName
     * @param lastName
     * @param phoneNum
     * @param streetAddress
     * @param city
     * @param province
     * @param birthday
     * @throws SQLException
     */
    public Patient(String firstName, String lastName, String phoneNum, String streetAddress, String city, String province, LocalDate birthday) throws SQLException {
        setFirstName(firstName);
        setLastName(lastName);
        setPhoneNum(phoneNum);
        setStreetAddress(streetAddress);
        setCity(city);
        setProvince(province);
        setBirthday(birthday);
        patientID = DBUtility.insertNewPatient(this);
    }

    public int getPatientID() {
        return patientID;
    }

    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName.matches("[A-Z][a-zA-Z]*[-]?[A-z]*?"))
            this.firstName = firstName;
        else
            throw new IllegalArgumentException("First name must start with a capital and have more than 1 letter");
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName.matches("[A-Z][a-zA-Z]*[-]?[A-z]*?"))
            this.lastName = lastName;
        else
            throw new IllegalArgumentException("Last name must start with a capital and have more than 1 letter");

    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        if (phoneNum.matches("\\(?[2-9]\\d{2}\\)?[-.\\s]?[2-9]\\d{2}[-.\\s]?\\d{4}"))
            this.phoneNum = phoneNum;
        else
            throw new IllegalArgumentException("Phone number must match North American Dialing plan");
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        if (streetAddress.matches("[0-9]*\\s[A-z\\s]*"))
            this.streetAddress = streetAddress;
        else
            throw new IllegalArgumentException("street address must have a number " +
                    "followed by the street name");
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        if (city.matches("^[a-zA-Z]+(?:[\\s-][a-zA-Z]+)*$"))
            this.city = city;
        throw new IllegalArgumentException("City must have letters");
    }

    public String getProvince() {
        return province;
    }

    public static List<String> getProvinces()
    {
        List<String> provinces = Arrays.asList("NL","PE","NS","NB","QC","ON",
                        "MB","SK","AB","BC","YT","NT","NU");
        Collections.sort(provinces);
        return provinces;
    }

    public void setProvince(String province) {
        if (getProvinces().contains(province))
            this.province = province;
        else
            throw new IllegalArgumentException("Province must be in the list: "+
                    getProvinces());

    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        if (birthday.isAfter(LocalDate.now()))
            throw new IllegalArgumentException("Birthday cannot be in the future");
        if (Period.between(LocalDate.now(), birthday).getYears()>250)
            throw new IllegalArgumentException("Birthday for a new patient cannot be over 250 years ago");
        this.birthday = birthday;
    }
}
