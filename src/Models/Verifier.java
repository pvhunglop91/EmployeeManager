package Models;

import Utils.AppCurrency;
import Utils.Validator;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Verifier extends Employee{
    private int errorNumber ;

    public Verifier(double errorNumber) {
        super();
        this.errorNumber = 0;
    }

    public Verifier(String fullName, int age, String phoneNumber, String email, double basicSalary, int errorNumber) {
        super(fullName, age, phoneNumber, email, basicSalary);
        this.errorNumber = errorNumber;
    }

    public Verifier() {

    }

    @Override
    public double getSalary() {
        return this.getBasicSalary() + errorNumber*150000;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", Error Numbers: " + errorNumber
                + ", Salary: " + AppCurrency.toVnd(getSalary())
                +" (Verifier)";
    }

    @Override
    public void InputEmployee(){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter Verifier Information: ");
        super.InputEmployee();
        this.errorNumber = Validator.getInt(br, "Error Numbers: ");
    }

    @Override
    public void PrintEmployee(){
        super.PrintEmployee();
        System.out.print(", Error Numbers: "+ this.errorNumber);
        System.out.print(", Salary: "+ AppCurrency.toVnd(getSalary()));
        System.out.println(" (Verifier)");
    }

    public int getErrorNumber() {
        return errorNumber;
    }

    public void setErrorNumber(int errorNumber) {
        this.errorNumber = errorNumber;
    }
}
