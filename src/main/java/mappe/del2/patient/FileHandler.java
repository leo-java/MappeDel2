package mappe.del2.patient;

import mappe.del2.patient.model.Patient;

import java.io.*;
import java.util.ArrayList;

/**
 * The type File handler.
 */
public class FileHandler {
    /**
     * Instantiates a new File handler.
     */
    public FileHandler(){
    }

    /**
     * Read csv array list.
     *
     * @param file the file
     * @return the array list
     * @throws IOException the io exception
     * reads from a csv file
     */
    public ArrayList<Patient> readCSV(File file) throws IOException {
        ArrayList<Patient> newPatients = new ArrayList<>();
        try(FileReader fileReader = new FileReader(file)){
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String row = bufferedReader.readLine();
            row = bufferedReader.readLine();

            while (row!=null){
                String[] list = row.split(";");
                try{
                    Patient newPatient = new Patient(list[0],list[1],list[2],list[3]);
                    if(list.length == 5){
                        newPatient.setDiagnosis("" + list[4]);
                    }
                    newPatients.add(newPatient);
                }catch (IllegalArgumentException e){
                    System.out.println("Patient could not be created");
                }
                row = bufferedReader.readLine();
            }
        }catch (IOException e){
            throw new IOException("File couldn't be opened");
        }
        return newPatients;
    }

    /**
     * Write csv.
     *
     * @param patientList the patient list
     * @param filePath    the file path
     * @throws IOException the io exception
     * writes to a csv file
     */
    public void writeCSV(ArrayList<Patient> patientList, String filePath) throws IOException{
        try (FileWriter fileWriter = new FileWriter(String.valueOf(filePath))){
            fileWriter.write("firstName;lastName;generalPractitioner;socialSecurityNumber;diagnosis\n");
            for (Patient patient:patientList) {
                String row = patient.getFirstName() + ";" + patient.getLastName() + ";" + patient.getGeneralPractitioner() + ";" + patient.getSocialSecurityNumber() + ";" + "\n";
                fileWriter.append(row);
            }
        }catch (IOException e){
            throw e;
        }
    }
}
