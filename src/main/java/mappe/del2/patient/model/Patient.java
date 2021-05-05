package mappe.del2.patient.model;

/**
 * The type Patient.
 */
public class Patient {
    private String socialSecurityNumber;
    private String firstName;
    private String lastName;
    private String diagnosis;
    private String generalPractitioner;

    /**
     * Instantiates a new Patient.
     *
     * @param firstName            the first name
     * @param lastName             the last name
     * @param generalPractitioner  the general practitioner
     * @param socialSecurityNumber the social security number
     *                             checks that the first and last name isn't null or empty and throws if ssn is not a number
     */
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

    /**
     * Gets social security number.
     *
     * @return the social security number
     */
    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    /**
     * Gets first name.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Gets last name.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Gets diagnosis.
     *
     * @return the diagnosis
     */
    public String getDiagnosis() {
        return diagnosis;
    }

    /**
     * Gets general practitioner.
     *
     * @return the general practitioner
     */
    public String getGeneralPractitioner() {
        return generalPractitioner;
    }

    /**
     * Sets diagnosis.
     *
     * @param diagnosis the diagnosis
     */
    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }
}
