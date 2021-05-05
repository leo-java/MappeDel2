package mappe.del2.patient.model;

import java.util.ArrayList;
import java.util.List;

public class PatientRegister {
    private ArrayList<Patient> patients;

    public PatientRegister() {
        this.patients = new ArrayList<>();
    }

    public ArrayList<Patient> getPatients() {
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

    public void setPatients(ArrayList<Patient> newPatients) {
        for (Patient patient:patients) {
            removePatient(patient);
        }
        for (Patient patient:newPatients) {
            patients.add(patient);
        }
    }
}
