package com.company;

public class Administration extends Employee {
    private int vacation;


    public Administration() {
    }

    public Administration(int vacation) {
        this.vacation = vacation;
    }

    public Administration(String firstname, String lastname, String email, String birthdate, int hours, int salary, int staffId, int vacation) {
        super(firstname, lastname, email, birthdate, hours, salary, staffId);
        this.vacation = vacation;
    }

    public Administration(int hours, int salary, int staffId, int vacation) {
        super(hours, salary, staffId);
        this.vacation = vacation;
    }

    public int getVacation() {
        return vacation;
    }

    public void setVacation(int vacation) {
        this.vacation = vacation;
    }

}
