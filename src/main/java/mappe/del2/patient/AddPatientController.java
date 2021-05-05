package mappe.del2.patient;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import mappe.del2.patient.model.Patient;

public class AddPatientController {
    @FXML
    private TextField socialSecurityNumber;
    @FXML
    private TextField diagnosis;
    @FXML
    private TextField generalPractitioner;
    @FXML
    private TextField lastName;
    @FXML
    private TextField firstName;
    @FXML
    private Button closeButton;
    @FXML
    private Button addPatientButton;

    private boolean CreatePatientValid;

    public TextField getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public TextField getDiagnosis() {
        return diagnosis;
    }

    public TextField getGeneralPractitioner() {
        return generalPractitioner;
    }

    public TextField getLastName() {
        return lastName;
    }

    public TextField getFirstName() {
        return firstName;
    }

    public void setSocialSecurityNumber(String socialSecurityNumber) {
        this.socialSecurityNumber.setText(socialSecurityNumber);
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis.setText(diagnosis);
    }

    public void setGeneralPractitioner(String generalPractitioner) {
        this.generalPractitioner.setText(generalPractitioner);
    }

    public void setLastName(String lastName) {
        this.lastName.setText(lastName);
    }

    public void setFirstName(String firstName) {
        this.firstName.setText(firstName);
    }

    public boolean isAddedPatientValid() {
        if(getFirstName().getText().trim().isBlank() || getLastName().getText().trim().isBlank() || getSocialSecurityNumber().getText().trim().isBlank() || getDiagnosis().getText().trim().isBlank() || getGeneralPractitioner().getText().trim().isBlank()){
            return false;
        }
        return true;
    }

    public Patient getPatient() {
        return new Patient(getFirstName().getText(),getLastName().getText(),getGeneralPractitioner().getText(),getSocialSecurityNumber().getText());
    }

    public void addButtonPressed(ActionEvent actionEvent) {
        if(isAddedPatientValid()){
            CreatePatientValid = true;
            Stage stage = (Stage) addPatientButton.getScene().getWindow();
            stage.close();
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR, "Invalid input, please fill in all text fields");
            alert.showAndWait();
        }
    }

    public void cancelButtonPressed(ActionEvent actionEvent) {
        Stage stage = (Stage) addPatientButton.getScene().getWindow();
        stage.close();
    }
}
