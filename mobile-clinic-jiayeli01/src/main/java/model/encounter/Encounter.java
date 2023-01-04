package model.encounter;
import model.disease.*;
import java.util.Random;



public class Encounter {
    Event event;
    int time;
    Diagnosis diagnosis;
    VitalSigns vitalSigns;
    ChiefComplaint chiefComplaint;
    Assessment assessment;
    Random random;

    public Encounter(Event e, int t){
        event = e;
        time = t;
        random = new Random();
    }

    public VitalSigns getVitalSigns() {
        return vitalSigns;
    }

    public void setVitalSigns(VitalSigns vitalSigns) {
        this.vitalSigns = vitalSigns;
    }

    public Diagnosis getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(Diagnosis diagnosis) {
        this.diagnosis = diagnosis;
    }

    
    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public Diagnosis newDiagnosis(Disease d){
        diagnosis = new Diagnosis(this, d);
        return diagnosis;
    }

    public String findDate(){
        return this.getEvent().getDate();
    }

    public String getLocation(){
        return this.getEvent().getSite().getName();
    }

    public void patientInfo(){        
        System.out.println("Check-up Location : " + getLocation());
        System.out.println("Check-up time : " + getTime() + "：00 on " + findDate());
    }

    public boolean isInfectious(){
        return getDiagnosis().getDisease().isInfectious();
    } 
    
    
    public String findInfectious(){      
        return getDiagnosis().getDisease().getDescription();
    }  

    public int fluSize(){
        if (findInfectious() == "flu"){
            return 1;
        }return 0;
    }

    public int covidSize(){
        if (findInfectious() == "Coronavirus"){
            return 1;
        }return 0;
    }

    public void newVitalSigns(){
        Double random_temperature = 36.3 + random.nextDouble(1.7);
        Double random_pulse = 60.0 + random.nextDouble(40.0);
        Double random_breath = 12.0 + random.nextDouble(8.0);
        Double random_pressure = 120 + random.nextDouble(9.0);
        vitalSigns = new VitalSigns(random_temperature, random_pulse, random_breath, random_pressure);
    }

    public void newChiefComplaint(){
        int pick = random.nextInt(ChiefComplaint.values().length);
        chiefComplaint = ChiefComplaint.values()[pick];
    }


}
