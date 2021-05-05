package mappe.del2.patient;

import mappe.del2.patient.model.Patient;
import mappe.del2.patient.model.PatientRegister;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PatientRegisterTest {

    private PatientRegister patientRegister;

    @BeforeEach
    public void init() {
        patientRegister = new PatientRegister();

    }
    @Test
    @DisplayName("Asserts add patients is possible")
    public void addingPatientsToRegisterDoesNotThrow(){
        Patient patient = new Patient("A","B","C","12345678910");
        assertDoesNotThrow(() -> patientRegister.addPatient(patient));
    }

    @Test
    @DisplayName("Asserts duplicate patients causes throw")
    public void addingDuplicatePatientsThrows(){
        Patient patient = new Patient("A","B","C","12345678910");
        patientRegister.addPatient(patient);
        assertThrows(IllegalArgumentException.class, () -> patientRegister.addPatient(patient));
    }

    @Test
    @DisplayName("Asserts removing patients is possible")
    public void removingPatientsDoesNotThrow(){
        Patient patient = new Patient("A","B","C","12345678910");
        assertDoesNotThrow(() -> patientRegister.removePatient(patient));
    }
}
