package com.marcelANDevertjan.main.Assignment.Scenario3.BinTree;


import com.marcelANDevertjan.main.Assignment.Scenario3.Data.Customer;

/**
 * This Class was created by Marcel and Evert-Jan on 9-2-2015
 * Time of creation : 16:26
 */
@SuppressWarnings("UnusedDeclaration")
public class Node {

    protected Node left, right;
    protected Customer customer;
    protected String identifier;

    protected Node(Customer customer) {
        this.customer = customer;
        identifier = customer.getID();
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public Customer getCustomer(){
        return customer;
    }

    public String getID() {
        return identifier;
    }

    protected void setLeft(Node left) {
        this.left = left;
    }

    protected void setRight(Node right) {
        this.right = right;
    }

    @Override
    public String toString() {
        if(customer.getTussenvoegsel() != null){
            return customer.getAchternaam()+", "+customer.getVoornaam() +" "+customer.getTussenvoegsel();
        }
        return customer.getAchternaam() +", "+customer.getVoornaam();
    }
}
