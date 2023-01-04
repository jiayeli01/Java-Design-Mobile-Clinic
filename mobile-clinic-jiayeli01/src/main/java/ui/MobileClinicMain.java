package ui;

import model.clinic.Clinic;
import model.clinic.DataLoader;

/**
 * Hello world!
 *
 */
public class MobileClinicMain 
{
    public static void main( String[] args )
    {
        // Northeastern Health and Counceling Services
        Clinic uhcs = new Clinic("Northeastern Health and Counceling Services."); 
        DataLoader loader = new DataLoader(uhcs);
        
        // populate diseases
        // uhcs.getDiseaseCatalog().newDisease("flu", true);
        // uhcs.getDiseaseCatalog().newDisease("Coronavirus", true);
        // uhcs.getDiseaseCatalog().newDisease("heart disease", false);
        // uhcs.getDiseaseCatalog().newDisease("Gastroenteritis", false);
        // uhcs.getDiseaseCatalog().newDisease("depression", false);
        
        
        // loader.populateClinic();
        loader.populateClinic(30, 4, 4, 6, 12, 3, 30);
        
        //list all patients, the times the showed up, and the locations they showed up for checkups
        uhcs.getPatientDirectory().patientInfo();
        System.out.println("--------------------------------------");

        // prepare a report to show the list patients who show symtoms contiguous that are of concern
        uhcs.getPatientDirectory().findInfectious();
        System.out.println("--------------------------------------");
        
        // identify and show patients that might be deliberately infecting others.
        uhcs.getPatientDirectory().identifyPatients();
        System.out.println("--------------------------------------");

        // analysis the rate of infectious diseases in all events
        uhcs.getSites().infectiousRate();
        
        
    }
}
