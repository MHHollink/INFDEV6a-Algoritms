package com.marcelANDevertjan.main.Assignment.Scenario3.BinTree;


import com.marcelANDevertjan.main.Assignment.Scenario3.Data.Customer;

/**
 * This Class was created by marcel on 9-2-2015
 * Time of creation : 16:26
 */
@SuppressWarnings("unused")
public class Node {

    private Node left, right;
    private Customer customer;
    private String identifier;

    public Node(Customer customer) {
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

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
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
