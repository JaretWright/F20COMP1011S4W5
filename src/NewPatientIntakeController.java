import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class NewPatientIntakeController implements Initializable {

    @FXML
    private ComboBox<String> provinceComboBox;

    @FXML
    private DatePicker birthdayDatePicker;

    @FXML
    private TextField firstNameTextField;

    @FXML
    private TextField lastNameTextField;

    @FXML
    private TextField phoneNumTextField;

    @FXML
    private TextField streetAddressTextField;

    @FXML
    private TextField cityTextField;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        provinceComboBox.getItems().addAll(Patient.getProvinces());
    }
}
