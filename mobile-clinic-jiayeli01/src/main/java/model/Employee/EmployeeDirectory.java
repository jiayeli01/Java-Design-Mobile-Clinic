package model.Employee;
import model.clinic.*;
import java.util.ArrayList;

public class EmployeeDirectory {
    Clinic clinic;
    ArrayList<Employee> employees;

    public EmployeeDirectory(Clinic c){
        clinic = c;
        employees = new ArrayList<Employee>();
    }  

    public Employee newEmployee(String n, Role r){
        Employee em = new Employee(n,r);
        employees.add(em);
        return em;
    }

}