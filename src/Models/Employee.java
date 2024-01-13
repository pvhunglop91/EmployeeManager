package Models;

import Utils.AppCurrency;
import Utils.Validator;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public abstract class Employee {
    //luu ID, lan sau add thi tang ID len 1; bien nay gan voi class. Static sinh ra truoc khi objet dc new
    //va chiem 1 vung nho duy nhat
    private static int increment = 0;
    private int employeeCode;
    private String fullName;
    private int age;
    private String phoneNumber;
    private String email;
    private double basicSalary;

    public abstract double getSalary();
    public Employee() {
        increment++;
        this.employeeCode = increment;
        this.fullName="";
        this.age = 0;
        this.phoneNumber = "";
        this.email = "";
        this.basicSalary = 0;
    }

    public Employee(String fullName, int age, String phoneNumber, String email, double basicSalary) {
        increment++;
        this.employeeCode = increment;
        this.fullName = fullName;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.basicSalary = basicSalary;
    }

    @Override
    public String toString() {
        return  "EmployeeCode: " + employeeCode +
                ", FullName: '" + fullName +
                ", Age: " + age +
                ", PhoneNumber: '" + phoneNumber +
                ", Email: '" + email +
                ", BasicSalary: " + AppCurrency.toVnd(basicSalary);
    }

    public int getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(int employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(double basicSalary) {
        this.basicSalary = basicSalary;
    }

    public void InputEmployee(){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        this.fullName = Validator.getString(br, "Enter Name: ");
        this.age = Validator.getInt(br, "Enter age: ");
        do {
            this.phoneNumber = Validator.getString(br, "Enter PhoneNumber: ");
            if(!Validator.validPhone(this.phoneNumber)){
                System.out.println("Invalid Phone Number format. Pls Enter a valid Phone number");
            }
        }while (!Validator.validPhone(this.phoneNumber));
        do {
            this.email = Validator.getString(br, "Enter Email: ");
            if(!Validator.validEmail(this.email)){
                System.out.println("Invalid Email format. Pls Enter a valid Email");
            }
        }while (!Validator.validEmail(this.email));
        this.basicSalary = Validator.getDouble(br, "Eneter Basic Salary: ");
    }

    public void PrintEmployee(){
        String st = "EmployeeCode: " + employeeCode +
                ", FullName: '" + fullName +
                ", Age: " + age +
                ", PhoneNumber: '" + phoneNumber +
                ", Email: '" + email +
                ", BasicSalary: " + AppCurrency.toVnd(basicSalary);
        System.out.print(st);
    }
}
