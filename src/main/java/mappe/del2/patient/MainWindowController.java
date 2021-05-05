package mappe.del2.patient;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import mappe.del2.patient.model.Patient;
import mappe.del2.patient.model.PatientRegister;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class MainWindowController implements Initializable {

    private PatientRegister patientRegister;
    private ObservableList<Patient> observablePatientList;

    @FXML
    private TableView<Patient> patientTableView;
    @FXML
    private TableColumn<Patient, String> firstNameColumn;
    @FXML
    private TableColumn<Patient, String> lastNameColumn;
    @FXML
    private TableColumn<Patient, String> socialSecurityNumberColumn;
    @FXML
    private TableColumn<Patient, String> diagnosisColumn;
    @FXML
    private TableColumn<Patient, String> generalPractitionerColumn;
    @FXML
    public Button openAddPatientViewButton;
    @FXML
    public Button openEditPatientViewButton;
    @FXML
    public Button openDeletePatientViewButton;
    @FXML
    public MenuItem openAddPatientViewButton1;
    @FXML
    public MenuItem openEditPatientViewButton1;
    @FXML
    public MenuItem openDeletePatientViewButton1;
    @FXML
    public MenuItem openAboutView;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.patientRegister = new PatientRegister();
        this.firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        this.lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        this.socialSecurityNumberColumn.setCellValueFactory(new PropertyValueFactory<>("socialSecurityNumber"));
        this.diagnosisColumn.setCellValueFactory(new PropertyValueFactory<>("diagnosis"));
        this.generalPractitionerColumn.setCellValueFactory(new PropertyValueFactory<>("generalPractitioner"));

        this.observablePatientList = FXCollections.observableArrayList(this.patientRegister.getPatients());
        this.patientTableView.setItems(observablePatientList);
    }
    private void updateObservableList(){
        this.observablePatientList.setAll(this.patientRegister.getPatients());
    }
    @FXML
    public void openAddPatientView(ActionEvent actionEvent) throws IOException {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(PatientRegisterApplication.class.getResource("AddPatient.fxml"));
            Parent root1 = fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Add Patient");
            stage.setScene(new Scene(root1));
            AddPatientController controller = fxmlLoader.getController();
            stage.showAndWait();
            if(controller.isAddedPatientValid()){
                Patient patient = controller.getPatient();
                patientRegister.addPatient(patient);
                updateObservableList();
            }
        }catch (Exception e){
            System.out.println(e.getStackTrace());
        }
    }
    @FXML
    public void setOpenEditPatientView(ActionEvent actionEvent) throws IOException{
        try {
            Patient selectedPatient = patientTableView.getSelectionModel().getSelectedItem();
            FXMLLoader fxmlLoader = new FXMLLoader(PatientRegisterApplication.class.getResource("AddPatient.fxml"));
            Parent root1 = fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Edit Patient");
            stage.setScene(new Scene(root1));
            AddPatientController controller = fxmlLoader.getController();
            controller.setSocialSecurityNumber(selectedPatient.getSocialSecurityNumber());
            controller.setFirstName(selectedPatient.getFirstName());
            controller.setLastName(selectedPatient.getLastName());
            controller.setDiagnosis(selectedPatient.getDiagnosis());
            controller.setGeneralPractitioner(selectedPatient.getGeneralPractitioner());
            stage.showAndWait();
            if(controller.isAddedPatientValid()){
                patientRegister.removePatient(selectedPatient);
                Patient patient = controller.getPatient();
                patientRegister.addPatient(patient);
                updateObservableList();
            }
        }catch (Exception e){
            System.out.println(e.getStackTrace());
        }
    }
    @FXML
    public void openDeletePatientView(ActionEvent actionEvent) {
        try {
            Patient selectedPatient = patientTableView.getSelectionModel().getSelectedItem();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Remove patient");
            alert.setHeaderText("Confirm patient removal");
            alert.setContentText("Are you sure you want to remove: " + selectedPatient.getFirstName() + selectedPatient.getLastName());
            Optional<ButtonType> answer = alert.showAndWait();
            if (answer.get() == ButtonType.OK) {
                patientRegister.removePatient(selectedPatient);
                updateObservableList();
            }
        }catch (Exception e){
            System.out.println(e.getStackTrace());
        }
    }
    @FXML
    public void openAboutView(ActionEvent actionEvent){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Application information");
        alert.setHeaderText("This application was made by Leo");
        alert.setContentText("V 1.0 5 May 2021");
        alert.show();
    }
}
