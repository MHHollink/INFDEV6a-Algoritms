package com.marcelANDevertjan.main.Assignment.Scenario1;

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

    /**
     * This is the method to create a new customer, it is called by the New Customer(...) function.
     *
     * Within the parenthesis are the following parameters :
     *
     * @param firstName will be the customers first name.
     * @param prefix is the surname prefix of the customer, only apply if he/she has one.
     * @param lastName is the surname or lastname of the customer
     * @param age will be the current age of the customer
     * @param sex will include the sex of the customer, M if male and F if female. (U if it has not been specified.)
     * @param residence the current location of living of the customer
     * @param eMail if the costumer has specified an eMail, this will be the costumer's eMail.
     */
    public Customer(String firstName, String prefix, String lastName, int age, char sex, String residence, String eMail) {
        this.firstName = firstName;
        this.prefix = prefix;
        this.lastName = lastName;
        this.age = age;
        this.sex = sex;
        this.residence = residence;
        this.eMail = eMail;

        id =  firstName.substring(0,2)+lastName.substring(0,2)+age+sex+residence.substring(0,5);
    }

    /**
     * Overload of New Customer, use this one if customer has no prefix.
     */
    public Customer(String firstName, String lastName, int age, char sex, String residence, String eMail) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.sex = sex;
        this.residence = residence;
        this.eMail = eMail;

        id = (firstName.substring(0, 3) + lastName.substring(0, 2) + age + sex + residence.substring(0, 1)).toLowerCase();
    }

    /**
     * Overload of New Customer, use this one if customer has no eMail.
     */
    public Customer(String firstName, String prefix, String lastName, int age, char sex, String residence) {
        this.firstName = firstName;
        this.prefix = prefix;
        this.lastName = lastName;
        this.age = age;
        this.sex = sex;
        this.residence = residence;

        id = (firstName.substring(0,3)+lastName.substring(0,2)+age+sex+residence.substring(0,1)).toLowerCase();
    }

    /**
     * Overload of New Customer, use this one if customer has no prefix and no Email.
     */
    public Customer(String firstName, String lastName, int age, char sex, String residence) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.sex = sex;
        this.residence = residence;

        id = (firstName.substring(0,3)+lastName.substring(0,2)+age+sex+residence.substring(0,1)).toLowerCase();
    }

    /**
     * This function can be called from an customer object, it is used to place and Order by calling the new Order method
     *
     * @param orderDuration is the duration of te order in milliseconds.
     */
    public void placeOrder(double orderDuration, boolean i){
        new Order(id, orderDuration, i);
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

}
