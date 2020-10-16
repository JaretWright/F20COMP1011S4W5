import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.time.LocalDate;
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

    }
}

