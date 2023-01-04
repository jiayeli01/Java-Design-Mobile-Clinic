package model.patient;
import model.clinic.*;
import java.util.ArrayList;
import model.person.*;
public class PatientDirectory {
    Clinic clinic;
    ArrayList<Patient> patients;

    public PatientDirectory(Clinic c){
        clinic = c;
        patients = new ArrayList<Patient>();
    }

    public Patient newPatient(String n){
        Person person = new Person(n);
        Patient patient = new Patient(person);
        patients.add(patient);
        return patient;
    }

    public int patientAmount(){
        return patients.size();
    }

    public Patient getPatientByIndex(int index){
        return patients.get(index);
    }

    public void patientInfo(){
        for (Patient p : patients){
            p.patientInfo();
        }
    }

    public void findInfectious(){
        for (Patient p : patients){
            p.findInfectious();
        }
    }

    public void identifyPatients(){
        for (Patient p : patients){
            p.identifyPatient();
        }
    }
    
}
