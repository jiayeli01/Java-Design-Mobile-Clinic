package model.encounter;
import model.patient.*;
import java.util.ArrayList;

public class EncounterHistory {
    Patient patient;
    ArrayList <Encounter> encounterList;

    public EncounterHistory(Patient p){
        patient = p;
        encounterList = new ArrayList<Encounter>();
    }

    public Encounter newEncounter(Event e, int t){
        Encounter encounter = new Encounter(e, t);
        encounterList.add(encounter);
        return encounter;
    }

    public Encounter getEncounterByIndex(int index){
        return encounterList.get(index);
    }

    public int encounterSize(){
        return encounterList.size();
    }
    
    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }


    public void patientInfo(){
        if(encounterList.size() != 0){
            System.out.println("Name of Patient : " + patient.getPatientName());
            for (Encounter e : encounterList){
                e.patientInfo();
            }
        }else{
            System.out.println("Name of Patient : " + patient.getPatientName());
            System.out.println("No appointment record.");
        }
    }

    public void findInfectious(){
        for (Encounter e: encounterList){
            if (e.isInfectious()){
                System.out.println("Name : " + patient.getPatientName());
                System.out.println("Disease : " + e.findInfectious());
            }
        }
    }

    public void identifyPatients(){
        int times = 0;
        for (Encounter e : encounterList){
            if(e.isInfectious()){
                times += 1;
            }
        }
        if (times >= 2){
            System.out.println("Patient : " + patient.getPatientName() + " might deliberatly infecting others after getting infectious disease. ");
        }
    }

}
