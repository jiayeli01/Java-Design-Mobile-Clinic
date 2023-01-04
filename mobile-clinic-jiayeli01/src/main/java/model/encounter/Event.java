package model.encounter;
import java.util.ArrayList;
import model.location.*;

public class Event {
    String date;
    String community;
    Site site; 
    ArrayList<Encounter> encounterDatabase;

    public Event(Site s, String d){
        site = s;
        date = d;
        encounterDatabase = new ArrayList<Encounter>();
    }
    
    public Encounter addEncounterToEvent(Encounter e){
        encounterDatabase.add(e);
        return e;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Site getSite() {
        return site;
    }

    public void setSite(Site site) {
        this.site = site;
    }

    public int encounterSize(){
        return encounterDatabase.size();
    }
    
    public void infectionRate(){
        float covid_count = 0;
        float flu_count = 0;
        if(encounterSize() != 0){
            for (Encounter e : encounterDatabase){
                covid_count += e.covidSize();
                flu_count += e.fluSize();
            }            
            float flu_rate = flu_count/encounterSize();
            float covid_rate = covid_count/encounterSize();
            System.out.println("Event Address : " + getSite().getName() + "      Event Date : " + getDate());
            System.out.println("Total Encounter : " + encounterSize());
            System.out.println("Flu Cases : " +  flu_count + "      Flu Rate : " + String.format("%.2f",flu_rate));
            System.out.println("Covid Cases : " +  covid_count + "      Covid Rate : " + String.format("%.2f",covid_rate));  
        }
    }

   
    // public void infectionRate(){
    //     ArrayList<Disease> infectiousDiseases = diseaseCatalog.getInfectiousDiseases();
    //     if(encounterSize() == 0){
    //         return;
    //     }
    //     for (Disease disease : infectiousDiseases)
    //     {
    //         int diseaseCnt = 0;
    //         for (Encounter e : encounterDatabase){
    //             diseaseCnt += e.getDiagnosis().getDisease().getDescription().equals(disease.getDescription()) ? 1:0;
    //         }
    //     }
    // }

}
