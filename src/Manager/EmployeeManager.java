package Manager;

import Models.Employee;
import Models.Programmer;
import Models.Verifier;
import Utils.AppCurrency;
import Utils.Validator;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class EmployeeManager {
    private List<Employee> employees = new ArrayList<>();

    public EmployeeManager(){

    }
    public EmployeeManager(List<Employee> employees) {
        this.employees = employees;
    }

    public void addEmployee(){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in ));
        System.out.println("\t1. Input a Programmer");
        System.out.println("\t2. Input a Verifier");
        int choice;
        do {
            choice = Validator.getInt(br, "Choice: ");
        }while ((choice!=1) && (choice != 2));

        Employee emp;
        if(choice == 1){
            emp = new Programmer();
        }
        else {
            emp = new Verifier();
        }

        emp.InputEmployee();
        employees.add(emp);
    }

    public void showAllEmployeeList(){
        System.out.println("Show all Employee List");
        for(Employee emp : employees){
            emp.PrintEmployee();
        }
    }

    public void showAllProgrammerList(){
        System.out.println("Show all Programmer List");
        for(Employee emp : employees){
            if(emp instanceof Programmer){
                emp.PrintEmployee();
            }
        }
    }

    public void showAllVerifierList(){
        System.out.println("Show all Verifier List");
        for(Employee emp : employees){
            if(emp instanceof Verifier){
                emp.PrintEmployee();
            }
        }
    }

    public double averageSalary(){
        double sum = 0;
        for(Employee emp : employees){
            sum+=emp.getSalary();
        }
        return sum/employees.size();
    }

    public void showAverageSalary(){
        String a = AppCurrency.toVnd(averageSalary());
        System.out.println(a);
    }


    public void showListLowerAverageSalaryEmployee(){
        System.out.println("Show List Lower Average Salary Employee");
        List<Employee> lowerSalaryEmployees = new ArrayList<>();
        double averageSalary = averageSalary();
        for(Employee emp : employees){
            if(emp.getSalary() < averageSalary){
                lowerSalaryEmployees.add(emp);
            }
        }
        for (Employee emp : lowerSalaryEmployees){
            emp.PrintEmployee();
        }
    }

    public void sortEmployeeBySalaryAscending(){
        System.out.println("Sort Employee By Salary Ascending");
        List<Employee> sortList = new ArrayList<>();
        sortList.addAll(employees);
        Collections.sort(sortList, new Comparator<Employee>() {
            @Override
            public int compare(Employee e1, Employee e2) {
                if(e1.getSalary() > e2.getSalary()){
                    return 1;
                }else if(e1.getSalary() < e2.getSalary()){
                    return -1;
                }else {
                    int checkName = e1.getFullName().compareToIgnoreCase(e2.getFullName());
                    if(checkName != 0){
                        return checkName;
                    }else {
                        return e1.getAge() - e2.getAge();
                    }
                }
            }

        });
        for(Employee employee : sortList){
            employee.PrintEmployee();
        }

    }

}
