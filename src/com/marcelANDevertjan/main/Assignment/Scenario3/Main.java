package com.marcelANDevertjan.main.Assignment.Scenario3;

import com.marcelANDevertjan.main.Assignment.Scenario3.BinTree.Tree;
import com.marcelANDevertjan.main.Assignment.Scenario3.Data.Customer;

import java.util.ArrayList;


/**
 * This Class was created by Marcel and Evert-Jan on 9-2-2015
 * Time of creation : 16:25
 */
@SuppressWarnings("UnusedDeclaration")
public class Main {

    public static ArrayList<Customer> customers = new ArrayList<Customer>();

    public static void main(String[] args) {
        customers = CreateCustomers();

        Tree tree = new Tree();
        tree.addNodes(customers);
        System.out.println("root node is : "+tree.getRoot().getCustomer());

        tree.findNode(customers.get(0).getID());
        tree.inOrderTraverse(tree.getRoot());

        tree.removeNode(customers.get(0).getID());
        tree.findNode(customers.get(0).getID());
        tree.inOrderTraverse(tree.getRoot());

    }

    private static ArrayList<Customer> CreateCustomers() {
        ArrayList<Customer> generatedCustomers = new ArrayList<Customer>();

        generatedCustomers.add(new Customer("Hollink", null, "Marcel", "Nederland", "Zuid-Holland", 21));
        generatedCustomers.add(new Customer("Heilema", null, "Evert-Jan", "Nederland", "Zuid-Holland", 21));
        generatedCustomers.add(new Customer("Kuijk", "van", "Esmee", "Nederland", "Zuid-Holland", 18));
        generatedCustomers.add(new Customer("Hollink", null, "Elizabeth", "Nederland", "Zuid-Holland", 55));
        generatedCustomers.add(new Customer("Bennik", null, "Matthew", "Nederland", "Zuid-Holland", 19));
        generatedCustomers.add(new Customer("Wodtke", null, "Vincent", "Nederland", "Zuid-Holland", 20));
        generatedCustomers.add(new Customer("Buuren", "van", "Gerrit", "Nederland", "Zuid-Holland", 20));
        generatedCustomers.add(new Customer("Duin", "van der", "Rogier", "Nederland", "Zuid-Holland", 18));
        generatedCustomers.add(new Customer("Manschot", null, "Petra", "Nederland", "Zuid-Holland", 21));
        generatedCustomers.add(new Customer("Veer", "van der", "Nick", "Nederland", "Zuid-Holland", 32));

        return generatedCustomers;
    }
}
