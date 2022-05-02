package ru.skypro;

public class Employee {

    private String firstName;
    private String middleName;
    private String lastName;
    private String department;
    private int id = 1;
    private double salary;

    public Employee(String firstName, String middleName, String lastName, double salary, String department) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.salary = salary;
        this.department = department;
        id = id++;
    }

    public String getEmployeeFirstName() {
        return this.firstName;
    }

    public String getEmployeeMiddleName() {
        return this.middleName;
    }

    public String getEmployeeLastName() {
        return this.lastName;
    }

    public double getEmployeeSalary() {
        return this.salary;
    }

    public void setEmployeeSalary(double salary) {
        this.salary = salary;
    }

    public String getEmployeeDepartment() {
        return this.department;
    }

    public void setEmployeeDepartment() {
        this.department = department;
    }

    public String getEmployeeFullName() {
        return this.middleName + " " + this.firstName + " " + this.lastName;
    }

    @Override
    public String toString() {
        return "Full name: " + this.middleName + " " + this.firstName + " " + this.lastName + ", currently works at the department '" + this.department + "' with a salary of " + this.salary + ";";
    }
}
