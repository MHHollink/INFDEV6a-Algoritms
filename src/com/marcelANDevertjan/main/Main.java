package com.marcelANDevertjan.main;

import com.marcelANDevertjan.main.Assignment.Customer;
import com.marcelANDevertjan.main.Assignment.Order;
import com.marcelANDevertjan.main.Assignment.Worker;

import java.util.ArrayList;

import static java.lang.System.currentTimeMillis;

/**
 * This Class was created by marcel on 23-1-2015
 * Time of creation : 21:45
 */
public class Main{

    public static ArrayList<Order> orders = new ArrayList<Order>();
    public static ArrayList<Customer> customers = new ArrayList<Customer>();

    public static void main(String[] args) {
        customers.add(new Customer("Marcel", "Hollink", 21, 'M', "Spijkenisse", "0872955@hr.nl"));
        customers.add(new Customer("EvertJan", "Heilema", 20, 'M', "Papendrecht", "0855012@hr.nl"));

        for (Customer customer : customers) {
            if (customer.getLastName().equals("Hollink")) {
                customer.placeOrder(5000);
                break;
            }
        }

        System.out.println(orders.size());

        Worker worker = new Worker();
        worker.run();
    }
}
