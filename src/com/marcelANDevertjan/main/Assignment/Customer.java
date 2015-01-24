package com.marcelANDevertjan.main.Assignment;

import java.util.ArrayList;

import static java.lang.System.currentTimeMillis;

/**
 * This Class was created by Evert-Jan and Marcel on 23-1-2015
 * Time of creation : 21:46
 */
public class Customer {

    private String id;
    private String firstName, prefix, lastName;
    private int age;
    private char sex;
    private String residence;
    private String eMail;

    private ArrayList<Order> orders = new ArrayList<Order>();

    public Customer(String firstName, String prefix, String lastName, int age, char sex, String residence, String eMail) {
        this.prefix = prefix;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.sex = sex;
        this.residence = residence;
        this.eMail = eMail;

        id =  firstName.substring(0,2)+lastName.substring(0,2)+age+sex+residence.substring(0,5);
    }

    public Customer(String firstName, String lastName, int age, char sex, String residence, String eMail) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.sex = sex;
        this.residence = residence;
        this.eMail = eMail;

        id = (firstName.substring(0,3)+lastName.substring(0,2)+age+sex+residence.substring(0,1)).toLowerCase();
    }


    public void placeOrder(double orderDuration){
        new Order(id, orderDuration);
    }


    /**
     * All Getters for class variables are below.
     */
    public String getMail() {
        return eMail;
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getPrefix() {
        return prefix;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public char getSex() {
        return sex;
    }

    public String getResidence() {
        return residence;
    }

    public ArrayList<Order> getOrders(){
        return orders;
    }

}
