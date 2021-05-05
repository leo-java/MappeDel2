package mappe.del2.patient.model;

import java.util.ArrayList;

/**
 * The type Patient register.
 */
public class PatientRegister {
    private ArrayList<Patient> patients;

    /**
     * Instantiates a new Patient register.
     */
    public PatientRegister() {
        this.patients = new ArrayList<>();
    }

    /**
     * Gets patients.
     *
     * @return the patients
     */
    public ArrayList<Patient> getPatients() {
        return this.patients;
    }

    /**
     * Add patient.
     *
     * @param patient the patient
     *                throws if an instance of a patient already exists
     *                checks that the to-be added patient isn't null
     */
    public void addPatient(Patient patient) {
        if(patients.contains(patient)){
            throw new IllegalArgumentException("Patient is already registered");
        }
        if(patient != null){
            this.patients.add(patient);
        }
    }

    /**
     * Remove patient.
     *
     * @param patient the patient
     */
    public void removePatient(Patient patient) {
        if(patients.contains(patient)){
            this.patients.remove(patient);
        }
    }

    /**
     * Sets patients.
     *
     * @param newPatients the new patients
     *                    removes patients from the existing table and adds new ones
     */
    public void setPatients(ArrayList<Patient> newPatients) {
        for (Patient patient:patients) {
            removePatient(patient);
        }
        for (Patient patient:newPatients) {
            patients.add(patient);
        }
    }
}
