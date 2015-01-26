package com.marcelANDevertjan.main;

import com.marcelANDevertjan.main.Assignment.Scenario1.Customer;
import com.marcelANDevertjan.main.Assignment.Scenario1.Order;
import com.marcelANDevertjan.main.Assignment.Scenario2.BinairyTreeSearch;
import com.marcelANDevertjan.main.Assignment.Scenario2.InsertionSort;
import com.marcelANDevertjan.main.Assignment.Scenario2.LinearSearch;
import com.marcelANDevertjan.main.Assignment.Scenario2.MergeSort;
import com.marcelANDevertjan.main.Assignment.Scenario3.BinaryTree;

import java.util.ArrayList;

/**
 * This Class was created by marcel And Evert-Jan on 23-1-2015
 * Time of creation : 21:45
 */
@SuppressWarnings("unused")
public class Main{

    public static ArrayList<Order> orders = new ArrayList<Order>();
    public static ArrayList<Customer> customers = new ArrayList<Customer>();

    public static void main(String[] args) {

        /**
         *
         * SCENARIO ONE
         *
         */

        customers.add(new Customer("EvertJan", "Heilema", 20, 'M', "Papendrecht", "0855012@hr.nl"));
        customers.add(new Customer("Marcel", "Hollink", 21, 'M', "Spijkenisse", "0872955@hr.nl"));

        /*
        Random r = new Random();

        for (int i = 0; i < r.nextInt(30); i++) {
            customers.get(r.nextInt(customers.size())).placeOrder(r.nextInt(4500)+500, r.nextBoolean());
        }

        System.out.println("\n"+orders.size()+" jobs were created \n");

        Worker worker = new Worker();
        worker.run();
         */


        /**
         *
         * SCENARIO TWO
         *
         */


        InsertionSort.insert(new Customer("Vincent", "Wodtke", 20, 'M', "Spijkenisse"));
        InsertionSort.insert(new Customer("Esmee", "van", "Kuijk", 18, 'V', "Spijkenisse"));
        InsertionSort.insert(new Customer("Ben", "Hollink", 55, 'M', "Rotterdam"));
        InsertionSort.insert(new Customer("Henk", "Hollink", 53, 'V', "Spijkenisse"));
        InsertionSort.insert(new Customer("Sander", "Mijer", 35, 'M', "Oud Beijerland"));

        //    MergeSort.sortArray(customers);

        //    System.out.println(LinearSearch.searchForLastname(customers ,"Heilema"));
        //    System.out.println(BinairyTreeSearch.binarySearchLastName(customers, "Hollink"));


        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");

        BinaryTree bt = new BinaryTree();

        for (Customer customer : customers) {
            bt.addNode(customer.getId().toCharArray(), customer.getLastName());
        }

        System.out.println("before removal");
        bt.inOrderTraverse(bt.getRoot());

        System.out.println("\n");

        bt.remove(("esmku18vs").toCharArray());

        System.out.println("after removal");
        bt.inOrderTraverse(bt.getRoot());

    }
}
