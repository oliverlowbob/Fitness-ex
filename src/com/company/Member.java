package com.company;

public class Member extends Person {
    private String membershipType;
    private boolean isPremium;
    private int fee;

    public Member() {
    }

    public Member(String firstname, String lastname, String email, String birthdate, String membershipType, int fee) {
        super(firstname, lastname, email, birthdate);
        this.membershipType = membershipType;
        this.fee = fee;
        isPremium();
    }

    public Member(String membershipType, int fee) {
        this.membershipType = membershipType;
        this.fee = fee;
        isPremium();
    }


    public String getMembershipType() {
        return membershipType;
    }

    public void setMembershipType(String membershipType) {
        this.membershipType = membershipType;
    }

    public boolean isPremium() {
        if(isPremium){
            return isPremium;
        }
        else{
            isPremium = false;
        }
        return isPremium = false;
    }

    public void setPremium(boolean premium) {
        isPremium = premium;
    }

    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }

    public String toString(String str)
    {
        str = getFirstname()+getLastname()+getEmail()+getBirthdate()+getMembershipType()+getFee();
        System.out.println(str);
        return str;
    }
}
