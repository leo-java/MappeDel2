package mappe.del2.patient;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import mappe.del2.patient.model.Patient;

/**
 * The type Add patient controller.
 */
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

    /**
     * Gets social security number.
     *
     * @return the social security number
     */
    public TextField getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    /**
     * Gets diagnosis.
     *
     * @return the diagnosis
     */
    public TextField getDiagnosis() {
        return diagnosis;
    }

    /**
     * Gets general practitioner.
     *
     * @return the general practitioner
     */
    public TextField getGeneralPractitioner() {
        return generalPractitioner;
    }

    /**
     * Gets last name.
     *
     * @return the last name
     */
    public TextField getLastName() {
        return lastName;
    }

    /**
     * Gets first name.
     *
     * @return the first name
     */
    public TextField getFirstName() {
        return firstName;
    }

    /**
     * Sets social security number.
     *
     * @param socialSecurityNumber the social security number
     */
    public void setSocialSecurityNumber(String socialSecurityNumber) {
        this.socialSecurityNumber.setText(socialSecurityNumber);
    }

    /**
     * Sets diagnosis.
     *
     * @param diagnosis the diagnosis
     */
    public void setDiagnosis(String diagnosis) {
        this.diagnosis.setText(diagnosis);
    }

    /**
     * Sets general practitioner.
     *
     * @param generalPractitioner the general practitioner
     */
    public void setGeneralPractitioner(String generalPractitioner) {
        this.generalPractitioner.setText(generalPractitioner);
    }

    /**
     * Sets last name.
     *
     * @param lastName the last name
     */
    public void setLastName(String lastName) {
        this.lastName.setText(lastName);
    }

    /**
     * Sets first name.
     *
     * @param firstName the first name
     */
    public void setFirstName(String firstName) {
        this.firstName.setText(firstName);
    }

    /**
     * Is added patient valid boolean.
     *
     * @return the boolean
     * checks if the patient has a name, practitioner and ssn
     */
    public boolean isAddedPatientValid() {
        if(getFirstName().getText().trim().isBlank() || getLastName().getText().trim().isBlank() || getSocialSecurityNumber().getText().trim().isBlank() || getGeneralPractitioner().getText().trim().isBlank()){
            return false;
        }
        return true;
    }

    /**
     * Gets patient.
     *
     * @return the patient
     */
    public Patient getPatient() {
        return new Patient(getFirstName().getText(),getLastName().getText(),getGeneralPractitioner().getText(),getSocialSecurityNumber().getText());
    }

    /**
     * Add button pressed.
     *
     * @param actionEvent the action event
     *                    Shows alert if patient has invalid data
     */
    public void addButtonPressed(ActionEvent actionEvent) {
        if(isAddedPatientValid()){
            Stage stage = (Stage) addPatientButton.getScene().getWindow();
            stage.close();
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR, "Invalid input, please fill in all text fields");
            alert.showAndWait();
        }
    }

    /**
     * Cancel button pressed.
     *
     * @param actionEvent the action event
     */
    public void cancelButtonPressed(ActionEvent actionEvent) {
        Stage stage = (Stage) addPatientButton.getScene().getWindow();
        stage.close();
    }
}
