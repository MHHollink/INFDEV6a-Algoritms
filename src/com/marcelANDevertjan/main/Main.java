package com.marcelANDevertjan.main;

import com.marcelANDevertjan.main.Assignment.Customer;
import com.marcelANDevertjan.main.Assignment.Order;
import com.marcelANDevertjan.main.Assignment.Worker;

import java.util.ArrayList;

/**
 * This Class was created by marcel on 23-1-2015
 * Time of creation : 21:45
 */
public class Main {

    public static ArrayList<Order> orders = new ArrayList<Order>();

    public static void main(String[] args) {

        Customer marcel = new Customer("Marcel", "Hollink", 21, 'M', "Spijkenisse", "0872955@hr.nl");
        Customer EvertJan = new Customer("EvertJan", "Heilema", 20, 'M', "Papendrecht", "0855012@hr.nl");

        marcel.placeOrder(1000);
        marcel.placeOrder(2000);
        EvertJan.placeOrder(1000);
        EvertJan.placeOrder(5000);
        marcel.placeOrder(1000);
        EvertJan.placeOrder(500);
        EvertJan.placeOrder(60000);
        marcel.placeOrder(100);

        System.out.println(orders.size());

        Worker worker = new Worker();
        worker.run();
    }
}
