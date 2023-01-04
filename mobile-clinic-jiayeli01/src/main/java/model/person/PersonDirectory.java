package model.person;
import model.clinic.*;
import java.util.ArrayList;

public class PersonDirectory {
    Clinic clinic;
    ArrayList<Person> persons;

    public PersonDirectory(Clinic c){
        persons = new ArrayList<Person>();
        clinic = c;
    }
    
    public Person newPerson(String name){
        Person p = new Person(name);
        persons.add(p);
        return p;
    }


    
}
