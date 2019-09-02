package com.company;

public class Member extends Person {
    private boolean isPremium;

    public Member() {
    }

    public Member(String firstname, String lastname, String email, String birthdate, String membershipType) {
        super(firstname, lastname, email, birthdate);

        if(membershipType.equals("Premium")){
            isPremium=true;
        }
        else{
            isPremium=false;
        }
    }


    public String getMemberType(){
        String str;
        if(isPremium)
        {
            str="Premium";
        }
        else{
            str="Basic";
        }
        return str;
    }

    public void setPremium(boolean premium) {
        isPremium = premium;
    }

    public int monthlyFee() {
        int fee;
        if(isPremium){
            fee = 299;
        }
        else {
            fee =199;
        }
        return fee;
    }


}
