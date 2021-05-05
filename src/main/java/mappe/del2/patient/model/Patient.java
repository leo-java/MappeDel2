package mappe.del2.patient.model;

public class Patient {
    private String socialSecurityNumber;
    private String firstName;
    private String lastName;
    private String diagnosis;
    private String generalPractitioner;

    public Patient(String socialSecurityNumber, String firstName, String lastName, String diagnosis, String generalPractitioner) {
        this.socialSecurityNumber = socialSecurityNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.diagnosis = diagnosis;
        this.generalPractitioner = generalPractitioner;
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public String getGeneralPractitioner() {
        return generalPractitioner;
    }
}
