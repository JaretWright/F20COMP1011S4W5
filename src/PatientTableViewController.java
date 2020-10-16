import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class PatientTableViewController implements Initializable {

    @FXML
    private TableView<Patient> tableView;

    @FXML
    private TableColumn<Patient, Integer> idColumn;

    @FXML
    private TableColumn<Patient, String> firstNameColumn;

    @FXML
    private TableColumn<Patient, String> lastNameColumn;

    @FXML
    private TableColumn<Patient, String> phoneColumn;

    @FXML
    private TableColumn<Patient, String> streetColumn;

    @FXML
    private TableColumn<Patient, String> cityColumn;

    @FXML
    private TableColumn<Patient, String> provinceColumn;

    @FXML
    private TableColumn<Patient, LocalDate> birthdayColumn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        idColumn.setCellValueFactory(new PropertyValueFactory<Patient, Integer>("patientID"));
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<Patient, String>("firstName"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<Patient, String>("lastName"));
        phoneColumn.setCellValueFactory(new PropertyValueFactory<Patient, String>("phoneNum"));
        streetColumn.setCellValueFactory(new PropertyValueFactory<Patient, String>("streetAddress"));
        cityColumn.setCellValueFactory(new PropertyValueFactory<Patient, String>("city"));
        provinceColumn.setCellValueFactory(new PropertyValueFactory<Patient, String>("province"));
        birthdayColumn.setCellValueFactory(new PropertyValueFactory<Patient, LocalDate>("birthday"));

        try {
            ArrayList<Patient> patients = DBUtility.getAllPatientsFromDB();
            tableView.getItems().addAll(DBUtility.getAllPatientsFromDB());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

