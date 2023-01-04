package model.clinic;

import model.Employee.EmployeeDirectory;
import model.disease.DiseaseCatalog;
import model.location.LocationCatagory;
import model.location.SiteList;
import model.patient.PatientDirectory;
import model.person.PersonDirectory;

public class Clinic {
    String name;
    PatientDirectory patientDirectory;
    EmployeeDirectory employeeDirectory;
    PersonDirectory personDirectory;
    LocationCatagory locations;
    SiteList sites;
    DiseaseCatalog diseaseCatalog;

    public Clinic(String name){
        this.name = name;
        patientDirectory = new PatientDirectory(this);
        employeeDirectory = new EmployeeDirectory(this);
        personDirectory = new PersonDirectory(this);
        locations = new LocationCatagory(this);
        sites = new SiteList(this);
        diseaseCatalog = new DiseaseCatalog(this);
    }

    
    public DiseaseCatalog getDiseaseCatalog() {
        return diseaseCatalog;
    }


    public void setDiseaseCatalog(DiseaseCatalog diseaseCatalog) {
        this.diseaseCatalog = diseaseCatalog;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PatientDirectory getPatientDirectory() {
        return patientDirectory;
    }

    public void setPatientDirectory(PatientDirectory patientDirectory) {
        this.patientDirectory = patientDirectory;
    }

    public EmployeeDirectory getEmployeeDirectory() {
        return employeeDirectory;
    }

    public void setEmployeeDirectory(EmployeeDirectory employeeDirectory) {
        this.employeeDirectory = employeeDirectory;
    }

    public PersonDirectory getPersonDirectory() {
        return personDirectory;
    }

    public void setPersonDirectory(PersonDirectory personDirectory) {
        this.personDirectory = personDirectory;
    }

    public LocationCatagory getLocations() {
        return locations;
    }

    public void setLocations(LocationCatagory locations) {
        this.locations = locations;
    }

    public SiteList getSites() {
        return sites;
    }

    public void setSites(SiteList sites) {
        this.sites = sites;
    }



}
