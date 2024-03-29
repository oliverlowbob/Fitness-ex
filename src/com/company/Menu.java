package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    List<Person> employees = new ArrayList<>();
    List<Person> members = new ArrayList<>();

    public Menu() {


        try (Scanner s = new Scanner(new File("medlemmer.txt"))) {
            while(s.hasNextLine())
            {
                String str = s.nextLine();
                Scanner skanner = new Scanner(str).useDelimiter(",");
                members.add(new Member(skanner.next(), skanner.next(), skanner.next(), skanner.next(), skanner.next()));
            }
        }
        catch (FileNotFoundException e) {
            // Handle the potential exception
        }

    }

    public void runMenu(){

        boolean runProgram = true;
        while(runProgram)
        {
            Scanner scanner = new Scanner(System.in);
            int valg;


            System.out.println("FITNESS MENU");
            System.out.println("VÆLG EN FUNKTION");
            System.out.println("1: PRINT ALLE ANSATTE OG MEDLEMMER");
            System.out.println("2: GEM MEDLEMMER OG ANSATTE I EN FIL");
            System.out.println("3: TILFØJ MEDLEM");
            System.out.println("0: AFSLUT");

            valg = scanner.nextInt();

            if(valg == 1){
                showStaffAndMembers();
            }


            else if(valg==2){
                saveToFile();
            }

            else if(valg==3){
                addMember();
            }
            else if(valg==0){
                runProgram=false;
            }
        }
    }

    public void addMember() {
        Scanner scanner = new Scanner(System.in);
        String forNavn;
        String efterNavn;
        String email;
        String birthdate;
        String memberShipType;



        System.out.println("Fornavn");
        forNavn = scanner.nextLine();
        System.out.println("Efternavn");
        efterNavn = scanner.nextLine();
        System.out.println("Email");
        email = scanner.nextLine();
        System.out.println("Fødselsdag");
        birthdate = scanner.nextLine();
        System.out.println("Medlemstype");
        memberShipType = scanner.nextLine();


        members.add(new Member(forNavn, efterNavn, email, birthdate,
                memberShipType));

        final String FNAME = "medlemmer.txt";
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(FNAME, true));


                if (members.size()==0) {
                    String str = (forNavn + "," + efterNavn + "," + email + "," + birthdate + "," +
                            memberShipType);
                    bw.write(str);

                }
                else if(members.size()>=1){
                    for (int i = 1; i==members.size()+1; i++){
                    String str = (forNavn + "," + efterNavn + "," + email + "," + birthdate + "," +
                            memberShipType);
                    bw.write("\n" + str);
                }
                    bw.flush();
                    bw.close();
                }

        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }

    public void showStaffAndMembers(){


        System.out.println("MEMBERS");
        System.out.println("Fornavn"+"\t\t\t\t"+"Efternavn"+"\t\t\t\t"+"Email"+"\t\t\t\t\t\t"+"Fødselsdato"+"\t\t\t\t"+
                "Medlemstype"+"\t\t\t\t"+"Pris");
        for(Person m : members)
        {
            if(m instanceof Member) {
                System.out.println(m.getFirstname()+"\t\t\t\t"+m.getLastname()+"\t\t\t\t"+m.getEmail()+"\t\t"+m.getBirthdate()+"\t\t\t\t" +
                        ((Member) m).getMemberType() + "\t\t\t" + ((Member) m).monthlyFee());
            }
        }
    }

        /*employees.add(new Administration("Dennis", "Larsen", "dennisl@gmail.com", "13-02-1998",
                37, 23000, 1337, 5));
        employees.add(new Instructor("Jonas", "Kofoed", "JonasTheKool@gmail.com", "24-07-2002",
                4, 4*456, 1338));
        members.add(new Member("Victor", "Madsen", "vm@hotmail.com", "17-01-1975",
                "Premium", true, 299));
        members.add(new Member("Brian", "Sand", "bkongen@live.dk", "17-02-1985",
                "Basic", false, 199));
        System.out.println("EMPLOYEES");
        System.out.printf("Fornavn"+"\t\t\t\t"+"Efternavn"+"\t\t\t\t"+"Email"+"\t\t\t\t\t\t"+"Fødselsdato"+"\t\t\t\t"+
                "Antal timer"+"\t\t\t\t"+"Løn"+"\t\t\t\t"+"Medarbejdernummer"+"\t\t"+"Ferieuger tilbage");
        System.out.println();
        for(Person e : employees)
        {
            if(e instanceof Instructor) {
                System.out.println(e.getFirstname()+"\t\t\t\t"+e.getLastname()+"\t\t\t\t"+e.getEmail()+"\t\t\t"+e.getBirthdate()
                        +"\t\t\t\t"+((Instructor) e).getHours()+"\t\t\t\t\t\t"+((Instructor) e).getSalary()+"\t\t\t\t"+((Instructor) e).getStaffId());
            }
            if(e instanceof Administration){
                System.out.println(e.getFirstname() +"\t\t\t\t"+e.getLastname()+"\t\t\t\t"+e.getEmail()+"\t\t\t\t"+e.getBirthdate()
                        +"\t\t\t\t"+((Administration) e).getHours()+"\t\t\t\t\t\t"+((Administration) e).getSalary()
                        +"\t\t\t\t"+((Administration) e).getStaffId()+"\t\t\t\t\t\t"+ ((Administration) e).getVacation());
            }
        }
        System.out.println("MEMBERS");
        System.out.println("Fornavn"+"\t\t\t\t"+"Efternavn"+"\t\t\t\t"+"Email"+"\t\t\t\t\t\t"+"Fødselsdato"+"\t\t\t\t"+
                "Medlemstype"+"\t\t\t\t"+"Pris");
        for(Person m : members)
        {
            if(m instanceof Member) {
                System.out.println(m.getFirstname()+"\t\t\t\t"+m.getLastname()+"\t\t\t\t"+m.getEmail()+"\t\t\t\t\t"+m.getBirthdate()+"\t\t\t\t" +
                        ((Member) m).getMembershipType()+"\t\t\t\t\t"+((Member) m).getFee());
            }
        }
        System.out.println();
        System.out.println("Medlemmer og medarbejderes navne og fødselsdage");
        System.out.println("Fornavn"+"\t\t\t\t"+"Efternavn"+"\t\t\t\t"+"Fødselsdato");
        for(Person m : members)
        {
            if(m instanceof Member) {
                System.out.println(m.getFirstname()+"\t\t\t\t"+m.getLastname()+"\t\t\t\t\t"+m.getBirthdate());
            }
        }
        for(Person e : employees)
        {
            if(e instanceof Instructor) {
                System.out.println(e.getFirstname()+"\t\t\t\t"+e.getLastname()+"\t\t\t\t\t"+e.getBirthdate());
            }
            if(e instanceof Administration) {
                System.out.println(e.getFirstname()+"\t\t\t\t"+e.getLastname()+"\t\t\t\t\t"+e.getBirthdate());
            }
        }*/


    public void saveToFile(){

        employees.add(new Administration("Dennis", "Larsen", "dennisl@gmail.com", "13-02-1998",
                37, 23000, 1337, 5));
        employees.add(new Instructor("Jonas", "Kofoed", "JonasTheKool@gmail.com", "24-07-2002",
                4, 4*456, 1338));


        List<Person> members = new ArrayList<>();
        members.add(new Member("Victor", "Madsen", "vm@hotmail.com", "17-01-1975",
                "Premium"));
        members.add(new Member("Brian", "Sand", "bkongen@live.dk", "17-02-1985",
                "Basic"));
        final String FNAME = "output.txt";
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(FNAME));
            for (Person m : members) {
                if (m instanceof Member) {
                    String str = (m.getFirstname() + "\t" + m.getLastname() + "\t" + m.getEmail() + "\t" + m.getBirthdate() + "\t" +
                            ((Member) m).getMemberType() + "\t" + ((Member) m).monthlyFee());
                    bw.write(str + "\n");
                }

            }
            bw.close();
        } catch(
                IOException e){
            e.printStackTrace();
        }
    }
}
