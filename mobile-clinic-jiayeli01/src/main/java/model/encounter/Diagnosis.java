package model.encounter;
import model.disease.*;

public class Diagnosis {
    Encounter encounter;
    Disease disease;
    DiseaseCatalog diseaseCatalog;

    public Diagnosis(Encounter e, Disease d){
        encounter = e;
        disease = d;
    }

    public Encounter getEncounter() {
        return encounter;
    }

    public void setEncounter(Encounter encounter) {
        this.encounter = encounter;
    }

    public Disease getDisease() {
        return disease;
    }

    public void setDisease(Disease disease) {
        this.disease = disease;
    }

    //diagnose disease type through vital signs.
    public void diagnoseThroughVitalSigns(){
        if(getEncounter().getVitalSigns().getPulseRate() >= 100){
            setDisease(diseaseCatalog.getDiseaseByName("heart disease"));
        }
        if(getEncounter().getVitalSigns().getTemperature() >= 38.0){
            setDisease(diseaseCatalog.getDiseaseByName("flu"));
        }      
    }
}
