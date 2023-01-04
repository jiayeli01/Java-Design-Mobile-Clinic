package model.disease;
import model.clinic.*;
import java.util.ArrayList;

public class DiseaseCatalog {
    Clinic clinic;
    ArrayList<Disease> diseaseList;
    public ArrayList<Disease> infectiousDisease;

    public DiseaseCatalog(Clinic c){
        clinic = c;
        diseaseList = new ArrayList<>();
        infectiousDisease = new ArrayList<>();
        Disease flu = newDisease("flu", true);
        infectiousDisease.add(flu);
        Disease Covid = newDisease("Coronavirus", true);
        infectiousDisease.add(Covid);
        Disease heartDisease = newDisease("heart disease", false);
        newDisease("Gastroenteritis", false);
        newDisease("depression", false);
    }
    
    public Disease newDisease(String d, boolean i){
       Disease disease = new Disease(d, i);
       diseaseList.add(disease);
       return disease;
    }

    public int diseaseSize(){
        return diseaseList.size();
    }

    public Disease getDiseaseByIndex(int index){
        return diseaseList.get(index);       
    }

    public Disease getDiseaseByName(String n){
        Disease result = new Disease(null, false);
        for (Disease d : diseaseList){
            if (d.getDescription() == n){
                result.setDescription(n);
                result.setInfectious(d.isInfectious());
            }
        }
        return result;
    }
}

