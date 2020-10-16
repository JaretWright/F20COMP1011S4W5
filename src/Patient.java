import java.sql.SQLException;
import java.time.LocalDate;

public class Patient {
    private int patientID;
    private String firstName, lastName;
    private String phoneNum;
    private String streetAddress, city, province;
    private LocalDate birthday;

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
        this.streetAddress = streetAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }
}
