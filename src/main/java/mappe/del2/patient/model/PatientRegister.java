package mappe.del2.patient.model;

import java.util.ArrayList;
import java.util.List;

public class PatientRegister {
    private ArrayList<Patient> patients;

    public PatientRegister() {
        this.patients = new ArrayList<>();
    }

    public List<Patient> getPatients() {
        return this.patients;
    }

    public void addPatient(Patient patient) {
        if(patient != null){
            this.patients.add(patient);
        }
    }
    public void removePatient(Patient patient) {
        this.patients.remove(patient);
    }
}
