package Models;

import Utils.AppCurrency;
import Utils.Validator;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Programmer extends Employee {
    private int overTimeHours ;

    public Programmer(int overTimeHours) {
        super();
        this.overTimeHours = 0;
    }

    public Programmer(String fullName, int age, String phoneNumber, String email, double basicSalary, int overTimeHours) {
        super(fullName, age, phoneNumber, email, basicSalary);
        this.overTimeHours = overTimeHours;
    }

    public Programmer() {

    }

    @Override
    public double getSalary() {
        return this.getBasicSalary() + overTimeHours*400000;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", OverTime Hours: " + overTimeHours
                + ", Salary: " + AppCurrency.toVnd(getSalary())
                +" (Programmer)";
    }

    @Override
    public void InputEmployee(){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter Programmer Information: ");
        super.InputEmployee();
        this.overTimeHours = Validator.getInt(br, "OverTime Hours: ");
    }

    @Override
    public void PrintEmployee(){
        super.PrintEmployee();
        System.out.print(", Overtime Hour: "+ this.overTimeHours);
        System.out.print(", Salary: "+ AppCurrency.toVnd(getSalary()));
        System.out.println(" (Programmer)");
    }

    public int getOverTimeHours() {
        return overTimeHours;
    }

    public void setOverTimeHours(int overTimeHours) {
        this.overTimeHours = overTimeHours;
    }
}
