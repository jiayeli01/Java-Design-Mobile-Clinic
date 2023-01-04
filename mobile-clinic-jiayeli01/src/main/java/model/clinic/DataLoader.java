package model.clinic;
import java.util.Random;
import com.github.javafaker.Faker;
import model.Employee.Role;
import model.location.*;
import model.patient.*;
import model.encounter.*;
import model.disease.*;

public class DataLoader {
    private Faker magicBox;
    private Clinic clinic;
    private Random r;

    public DataLoader(Clinic c) {
        this.clinic = c;
        magicBox = new Faker();
        r = new Random();
    }

    public void populateClinic(int patientCount, int locationCount, int doctorCount, int nurseCount, int siteCount, int eventCount, int encounterCount){
        populatePatientDirectory(patientCount);
        populateLocation(locationCount);
        populateEmployee(doctorCount, nurseCount);
        populateSite(siteCount);
        populateEvents(eventCount);
        populateEncounter(encounterCount);
    }
    
    public void populatePatientDirectory(int num){
        for (int i = 0; i < num; i ++){
            clinic.getPatientDirectory().newPatient(magicBox.name().fullName());
        }
    }

    public void populateLocation(int num){
        for (int i = 0; i < num; i ++){
            clinic.getLocations().newLocation(magicBox.address().cityName());
        }
    }

    public void populateEmployee(int numOfDoctor, int numOfNurse){
        for (int i = 0; i < numOfDoctor; i ++){
            clinic.getEmployeeDirectory().newEmployee(magicBox.name().fullName(), Role.Doctor);           
        }
        for (int j = 0; j < numOfNurse; j ++){
            clinic.getEmployeeDirectory().newEmployee(magicBox.name().fullName(), Role.Nurse);
        }
    }

    public void populateSite(int num){
        int maxNumber = clinic.getLocations().countLocations();
        for (int i = 0; i < num; i ++){
            int randomCount = r.nextInt(maxNumber);
            Location location = clinic.getLocations().getLocationByIndex(randomCount);
            clinic.getSites().newSite(magicBox.address().fullAddress(),location);
        }
    }

    // populate event
    public void populateEvents(int num){
        int siteCount = clinic.getSites().getSiteSize();
        for (int i = 0; i < siteCount; i ++){
            for(int j = 0; j < num; j ++){
                int random_date = r.nextInt(30);
                clinic.getSites().getSiteByIndex(i).newEvent("March " + random_date + " 2022");         
            }
        }
    }
      
    // populate encounters, diagnosis, chief complaints, and vital signs. 
    public void populateEncounter(int num){
        int maxp = clinic.getPatientDirectory().patientAmount();
        int scount = clinic.getSites().getSiteSize();
        int dcount = clinic.getDiseaseCatalog().diseaseSize();
        for (int i = 0; i < num; i ++){
            int randomp = r.nextInt(maxp);
            int random_s = r.nextInt(scount);
            // randomNo represtents the time of patients' encounter, and the time range for all events would be 9 am - 16 pm.
            int randomNo = r.nextInt(7);
            randomNo += 9;
            Patient patient = clinic.getPatientDirectory().getPatientByIndex(randomp);
            Site s = clinic.getSites().getSiteByIndex(random_s);
            int ecount = s.eventSize();
            int random_e = r.nextInt(ecount);
            Event t = s.getEventByIndex(random_e);
            Encounter e = patient.getHistory().newEncounter(t,randomNo); 
            int randomd = r.nextInt(dcount);
            Disease d = clinic.getDiseaseCatalog().getDiseaseByIndex(randomd);
            e.newDiagnosis(d);
            e.newChiefComplaint();
            e.newVitalSigns();
            t.addEncounterToEvent(e);
        }
    }
}
    // Code below comes from the pricing model - you can use follow similar patterns for the clinic

    // public void populateClinic(int supplierCount, int customerCount, int productCountPerSupplier) {
    //     populateSupplierDirectory(business.getSupplierDirectory(), supplierCount);
    //     populateCustomerDirectory(business.getCustomers(), customerCount);
    //     populateProductCatalogs(business.getSupplierDirectory(), productCountPerSupplier);
    // }

    // public void populateSupplierDirectory(SupplierDirectory sd, int count) {
    //     for (int i = 0; i < count; i++) {
    //         sd.newSupplier(magicBox.company().name());
    //     }
    // }

    // public void populateCustomerDirectory(CustomerDirectory cd, int count) {
    //     for (int i = 0; i < count; i++) {
    //         cd.newCustomerProfile(new Person(magicBox.name().fullName()));
    //     }
    // }

    // public void populateProductCatalogs(SupplierDirectory sd, int countPerSupplier) {
    //     for (Supplier s : sd.getSuppliers()) {
    //         ProductCatalog pc = s.getProductcatalog();
    //         for (int i = 0; i < countPerSupplier; i++) {
    //             pc.newProduct(magicBox.commerce().productName(), getPriceInRange(50,70), getPriceInRange(90,110), getPriceInRange(70,90));
    //         }
    //     }
    // }

    // public int getPriceInRange(int minPrice, int maxPrice){ // 50-100
    //     return minPrice + r.nextInt(maxPrice - minPrice);

    //         // 50 + random(50) - same as random(100-50);
    // }


