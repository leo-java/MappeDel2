package mappe.del2.patient;

import mappe.del2.patient.model.Patient;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PatientTest {

    @Test
    @DisplayName("Patient doesn't instantiate if there is invalid data")
    public void instantiatePatientWithInvalidDataThrows(){
        assertThrows(IllegalArgumentException.class, () -> new Patient("","","",""));
        assertThrows(IllegalArgumentException.class, () -> new Patient("","","","a"));
        assertThrows(IllegalArgumentException.class, () -> new Patient("a","","","12345678910"));
        assertDoesNotThrow((() -> new Patient("A","B","C","12345678910")));
    }

    @Test
    @DisplayName("Instantiate without name throws")
    public void instantiatePatientWithoutNameThrows(){
        assertThrows(IllegalArgumentException.class, () -> new Patient("","","a","12345678910"));
        assertThrows(IllegalArgumentException.class, () -> new Patient("","a","b","12345678910"));
        assertThrows(IllegalArgumentException.class, () -> new Patient("a","","b","12345678910"));
        assertDoesNotThrow((() -> new Patient("A","B","C","12345678910")));
    }
}
