package com.marcelANDevertjan.main.Assignment.Scenario3.Data;

/**
 * This Class was created by marcel on 9-2-2015
 * Time of creation : 16:27
 */
@SuppressWarnings("UnusedDeclaration")
public class Customer {

    private String achternaam, tussenvoegsel, voornaam, land, regio;
    private int Age;

    private String ID;

    public Customer(String achternaam, String tussenvoegsel, String voornaam, String land, String regio, int age) {
        this.achternaam = achternaam;
        this.tussenvoegsel = tussenvoegsel;
        this.voornaam = voornaam;
        this.land = land;
        this.regio = regio;
        Age = age;

        ID = achternaam.substring(0, 3) +
                voornaam.substring(0,2) +
                voornaam.substring(voornaam.length()-1) +
                (age*2)/3;
    }

    public String getAchternaam() {
        return achternaam;
    }

    public String getTussenvoegsel() {
        return tussenvoegsel;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public String getLand() {
        return land;
    }

    public String getRegio() {
        return regio;
    }

    public int getAge() {
        return Age;
    }

    public String getID() {
        return ID;
    }
}
