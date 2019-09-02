package com.company;

public class Employee extends Person {

    private int hours;
    private int salary;
    private int staffId;

    public Employee() {
    }



    public Employee(String firstname, String lastname, String email, String birthdate, int hours, int salary, int staffId) {
        super(firstname, lastname, email, birthdate);
        this.hours = hours;
        this.salary = salary;
        this.staffId = staffId;
    }

    public Employee(int hours, int salary, int staffId) {
        this.hours = hours;
        this.salary = salary;
        this.staffId = staffId;
    }


    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }

}
