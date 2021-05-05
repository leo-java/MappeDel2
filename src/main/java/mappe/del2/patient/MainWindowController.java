package mappe.del2.patient;

import javafx.application.Platform;
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
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import mappe.del2.patient.model.Patient;
import mappe.del2.patient.model.PatientRegister;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

/**
 * The type Main window controller.
 */
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
    /**
     * The Open add patient view button.
     */
    @FXML
    public Button openAddPatientViewButton;
    /**
     * The Open edit patient view button.
     */
    @FXML
    public Button openEditPatientViewButton;
    /**
     * The Open delete patient view button.
     */
    @FXML
    public Button openDeletePatientViewButton;
    /**
     * The Open add patient view button 1.
     */
    @FXML
    public MenuItem openAddPatientViewButton1;
    /**
     * The Open edit patient view button 1.
     */
    @FXML
    public MenuItem openEditPatientViewButton1;
    /**
     * The Open delete patient view button 1.
     */
    @FXML
    public MenuItem openDeletePatientViewButton1;
    /**
     * The Open about view.
     */
    @FXML
    public MenuItem openAboutView;

    /**
     * Initializes and shows the table
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.patientRegister = new PatientRegister();
        this.firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        this.lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        this.socialSecurityNumberColumn.setCellValueFactory(new PropertyValueFactory<>("socialSecurityNumber"));
        this.generalPractitionerColumn.setCellValueFactory(new PropertyValueFactory<>("generalPractitioner"));
        this.diagnosisColumn.setCellValueFactory(new PropertyValueFactory<>("diagnosis"));

        this.observablePatientList = FXCollections.observableArrayList(this.patientRegister.getPatients());
        this.patientTableView.setItems(observablePatientList);
    }
    private void updateObservableList(){
        this.observablePatientList.setAll(this.patientRegister.getPatients());
    }

    /**
     * Open add patient view.
     *
     * @param actionEvent the action event
     * @throws IOException the io exception
     * opens the AddPatient view and adds patients
     */
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

    /**
     * Sets open edit patient view.
     *
     * @param actionEvent the action event
     * @throws IOException the io exception
     * Opens the AddPatient view and deletes the old version and creates a new version
     */
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

    /**
     * Open delete patient view.
     *
     * @param actionEvent the action event
     *                    Opens a delete confirmation alert
     */
    @FXML
    public void openDeletePatientView(ActionEvent actionEvent) {
        try {
            Factory factory = new Factory();
            Patient selectedPatient = patientTableView.getSelectionModel().getSelectedItem();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Remove patient");
            alert.setHeaderText("Confirm patient removal");
            alert.setContentText("Are you sure you want to remove: " + selectedPatient.getFirstName() + selectedPatient.getLastName());
            //Button button = (Button) factory.create("button");
            Optional<ButtonType> answer = alert.showAndWait();
            if (answer.get() == ButtonType.OK) {
                patientRegister.removePatient(selectedPatient);
                updateObservableList();
            }
        }catch (Exception e){
            System.out.println(e.getStackTrace());
        }
    }

    /**
     * Open about view.
     *
     * @param actionEvent the action event
     *                    Opens an about application alert
     */
    @FXML
    public void openAboutView(ActionEvent actionEvent){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Application information");
        alert.setHeaderText("This application was made by Leo");
        alert.setContentText("V 1.0 5 May 2021");
        alert.show();
    }

    /**
     * Import csv.
     *
     * @param actionEvent the action event
     * @throws IOException the io exception
     * Opens a file browser and imports data from a csv file
     */
    public void importCSV(ActionEvent actionEvent) throws IOException{
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choose CSV file");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter(".csv", "*.csv"));
        File file = fileChooser.showOpenDialog(stage);
        try {
            FileHandler fileHandler = new FileHandler();
            patientRegister.setPatients(fileHandler.readCSV(file));
            updateObservableList();
        }catch (IOException e){
            throw e;
        }
    }

    /**
     * Export csv.
     *
     * @param actionEvent the action event
     *                    Opens a file browser and exports to a csv file
     */
    public void exportCSV(ActionEvent actionEvent) {
        FileHandler fileHandler = new FileHandler();
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter(".csv", "*.csv"));
        File file = fileChooser.showSaveDialog(new Stage());

        if(file != null){
            try{
                fileHandler.writeCSV(patientRegister.getPatients(), file.getAbsolutePath());
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    /**
     * Exit application.
     *
     * @param actionEvent the action event
     *                    Exits the application
     */
    public void exitApplication(ActionEvent actionEvent) {
        Platform.exit();
    }
}
