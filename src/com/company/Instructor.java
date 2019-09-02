package com.company;

public class Instructor extends Employee{

    public Instructor() {
    }

    public Instructor(String firstname, String lastname, String email, String birthdate, int hours, int salary, int staffId) {
        super(firstname, lastname, email, birthdate, hours, salary, staffId);
    }

    public Instructor(int hours, int salary, int staffId) {
        super(hours, salary, staffId);
    }

}
