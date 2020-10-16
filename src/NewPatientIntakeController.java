import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
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

    @FXML
    private Label msgLabel;

    @FXML
    private HBox hBox;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        hBox.getChildren().remove(msgLabel);
        provinceComboBox.getItems().addAll(Patient.getProvinces());
    }

    @FXML
    private void createNewPatient()
    {
        if (!hBox.getChildren().contains(msgLabel))
            hBox.getChildren().add(1,msgLabel);

        try{
            Patient newPatient = new Patient(
                    firstNameTextField.getText(),
                    lastNameTextField.getText(),
                    phoneNumTextField.getText(),
                    streetAddressTextField.getText(),
                    cityTextField.getText(),
                    provinceComboBox.getValue(),
                    birthdayDatePicker.getValue());

            msgLabel.setTextFill(Color.BLACK);
            msgLabel.setText(newPatient.toString());
        } catch (Exception e)
        {
            msgLabel.setTextFill(Color.RED);
            msgLabel.setText(e.getMessage());
        }
    }

    @FXML
    private void viewAllPatients(ActionEvent event) throws IOException {
        SceneChanger.changeScene(event,"patientTableView.fxml","Dr's Office");
    }
}
