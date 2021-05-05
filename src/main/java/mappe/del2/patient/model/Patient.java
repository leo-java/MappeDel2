package mappe.del2.patient.model;

public class Patient {
    private String socialSecurityNumber;
    private String firstName;
    private String lastName;
    private String diagnosis;
    private String generalPractitioner;

    public Patient( String firstName, String lastName, String generalPractitioner, String socialSecurityNumber) {
        if(firstName == null || lastName == null || firstName.equalsIgnoreCase("") || lastName.equalsIgnoreCase("")){
            throw new IllegalArgumentException("Full name is required");
        }
        try {
            Long.parseLong(socialSecurityNumber);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("Social Security Number must be a number");
        }
        this.socialSecurityNumber = socialSecurityNumber;
        this.firstName = firstName;
        this.lastName = lastName;
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

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }
}
