import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBUtility {
    //the user name and password should reflect YOUR system
    private static String user = "student";
    private static String password = "student";

    /**
     * This method will write a new patient into the DB and return
     * the patientID
     * @param newPatient
     * @return patientID (primary key from the DB)
     */
    public static int insertNewPatient(Patient newPatient) throws SQLException {
        //1.define connection, preparedstatement
        Connection conn = null;
        PreparedStatement ps= null;
        ResultSet rs = null;
        int patientID = -1;

        try{
            //1. connect to the DB
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/F20COMP1011S4",
                    user, password);
            //2. Create a sql command
            String sql = "INSERT INTO patients (firstName, lastName, phoneNum, streetAddress, " +
                    "city, province, birthday) VALUES (?,?,?,?,?,?,?)";

            //3. Create a prepared statement
            ps = conn.prepareStatement(sql, new String[] {"patientID"});

            //4. bind the values
            ps.setString(1, newPatient.getFirstName());
            ps.setString(2, newPatient.getLastName());
            ps.setString(3, newPatient.getPhoneNum());
            ps.setString(4, newPatient.getStreetAddress());
            ps.setString(5, newPatient.getCity());
            ps.setString(6, newPatient.getProvince());
            ps.setDate(7, Date.valueOf(newPatient.getBirthday()));

            //5. execute the insert
            ps.executeUpdate();

            //6. get the patientID returned
            rs = ps.getGeneratedKeys();

            while(rs.next())
            {
                patientID = rs.getInt(1);
            }

        } catch (SQLException e)
        {
            e.printStackTrace();
        } finally {
            if (conn != null)
                conn.close();
            if (ps != null)
                ps.close();
            if (rs != null)
                rs.close();
            return patientID;
        }
    }

    /**
     * This method will return ALL patients in the database
     */
    public static ArrayList<Patient> getAllPatientsFromDB() throws SQLException {
        ArrayList<Patient> patients = new ArrayList<>();

        //1.define connection, preparedstatement
        Connection conn = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try{
            //1. connect to the DB
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/F20COMP1011S4",
                    user, password);
            //2. Create a sql statement
            statement = conn.createStatement();

            //3.  execute the SQL statement and capture results in the resultSet
            resultSet = statement.executeQuery("SELECT * FROM patients");

            //4. loop over the result set and create patient objects
            while(resultSet.next())
            {
                Patient newPatient = new Patient(
                            resultSet.getInt("patientID"),
                            resultSet.getString("firstName"),
                            resultSet.getString("lastName"),
                            resultSet.getString("phoneNum"),
                            resultSet.getString("streetAddress"),
                            resultSet.getString("city"),
                            resultSet.getString("province"),
                            resultSet.getDate("birthday").toLocalDate()
                );
                patients.add(newPatient);
            }

        } catch (SQLException e)
        {
            e.printStackTrace();
        } finally {
            if (conn != null)
                conn.close();
            if (statement != null)
                statement.close();
            if (resultSet != null)
                resultSet.close();
            return patients;
        }

    }
}