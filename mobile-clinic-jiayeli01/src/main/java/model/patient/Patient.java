package model.patient;
import model.person.*;
import model.encounter.*;

public class Patient {
    Person person; 
    EncounterHistory history;
    
    public Patient(Person p){
        person = p;
        history = new EncounterHistory(this);
    }
    
    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public void newEncounter(Event t, int d){
        history.newEncounter(t, d);
    }
    
    public EncounterHistory getHistory() {
        return history;
    }

    public void setHistory(EncounterHistory history) {
        this.history = history;
    }

    public String getPatientName(){
        return getPerson().getName();  
    }

    public void patientInfo(){
        getHistory().patientInfo();              
    }
    
    public void findInfectious(){
        getHistory().findInfectious();
    }
     
    public void identifyPatient(){
        getHistory().identifyPatients();
    }
}
