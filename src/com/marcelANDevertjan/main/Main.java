package com.marcelANDevertjan.main;

import com.marcelANDevertjan.main.Assignment.Scenario1.Customer;
import com.marcelANDevertjan.main.Assignment.Scenario1.Order;
import com.marcelANDevertjan.main.Assignment.Scenario1.Worker;
import com.marcelANDevertjan.main.Assignment.Scenario2.LinearSearch;
import com.marcelANDevertjan.main.Assignment.Scenario2.MergeSort;

import java.util.ArrayList;
import java.util.Random;

/**
 * This Class was created by marcel And Evert-Jan on 23-1-2015
 * Time of creation : 21:45
 */
public class Main{

    public static ArrayList<Order> orders = new ArrayList<Order>();
    public static ArrayList<Customer> customers = new ArrayList<Customer>();

    public static void main(String[] args) {

        /**
         *
         * SCENARIO ONE
         *
         */

        customers.add(new Customer("Marcel", "Hollink", 21, 'M', "Spijkenisse", "0872955@hr.nl"));
        customers.add(new Customer("EvertJan", "Heilema", 20, 'M', "Papendrecht", "0855012@hr.nl"));

        customers.add(new Customer("Esmee", "van", "Kuijk", 18, 'V', "Spijkenisse"));
        customers.add(new Customer("Vincent", "Wodtke", 20, 'M', "Spijkenisse"));
        customers.add(new Customer("Petra", "Manschot", 21, 'V', "Spijkenisse"));
        customers.add(new Customer("Paula", "de", "Bijer", 51, 'V', "Spijkenisse"));
        customers.add(new Customer("Ben", "Hollink", 58, 'M', "Rotterdam"));
        customers.add(new Customer("Sander", "Mijer", 35, 'M', "Oud Beijerland" ));


        /**

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

        MergeSort ms = new MergeSort();
        ms.sortArray(customers);

         */

        System.out.println(LinearSearch.searchForLastname("Heilema"));
    }
}
