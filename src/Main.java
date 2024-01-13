import Manager.EmployeeManager;
import Models.Employee;
import Models.Programmer;
import Models.Verifier;
import Utils.AppCurrency;
import Utils.MenuUtil;
import Utils.Validator;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        double d = 1000000000.0;
//        String number = AppCurrency.toVnd(d);
//        System.out.println(number);

//        Employee pr = new Programmer();
//        pr.InputEmployee();
//        pr.PrintEmployee();
//        System.out.println(pr);
//        System.out.println();
//
//        Employee vr = new Verifier();
//        vr.InputEmployee();
//        vr.PrintEmployee();
//        System.out.println(vr);
//        System.out.println();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Employee> employees = new ArrayList<>();
        employees.add(new Programmer("A", 21, "123", "a@a.b", 1000000, 10));
        employees.add(new Programmer("B", 22, "123", "a@a.b", 1300000, 10));
        employees.add(new Programmer("C", 23, "123", "a@a.b", 1600000, 10));
        employees.add(new Verifier("D", 24, "123", "a@a.b", 1000000, 25));
        employees.add(new Verifier("E", 25, "123", "a@a.b", 1300000, 36));
        employees.add(new Verifier("F", 26, "123", "a@a.b", 1600000, 40));

        EmployeeManager employeeManager = new EmployeeManager(employees);

        int choice;
        do {
            MenuUtil.PrintMenu();
            do {
                choice = Validator.getInt(br, "Enter choice: ");
                if((choice < 1) || (choice > 7)){
                    System.out.println("Enter a number from 1 to 7");
                }
            }while ((choice < 1) || (choice > 7));
            switch (choice){
                case 1:
                    employeeManager.addEmployee();
                    break;
                case 2:
                    employeeManager.showAllEmployeeList();
                    break;
                case 3:
                    employeeManager.showAllProgrammerList();
                    break;
                case 4:
                    employeeManager.showAllVerifierList();
                    break;
                case 5:
                    System.out.print("Average Salary Employee is: ");
                    employeeManager.showAverageSalary();
                    employeeManager.showListLowerAverageSalaryEmployee();
                    break;
                case 6:
                    employeeManager.sortEmployeeBySalaryAscending();
                    break;
                case 7:
                    System.out.println("Finish");
            }
            System.out.println();
        }while (choice != 7);
    }
}