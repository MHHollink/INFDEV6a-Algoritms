package com.marcelANDevertjan.main;

import com.marcelANDevertjan.main.Assignment.Scenario1.CustomQueue;
import com.marcelANDevertjan.main.Assignment.Scenario1.Customer;
import com.marcelANDevertjan.main.Assignment.Scenario1.Order;
import com.marcelANDevertjan.main.Assignment.Scenario1.Worker;

import java.util.*;

import static java.lang.System.currentTimeMillis;

/**
 * Created by Evert-Jan on 25-1-2015.
 */
public class MainByEJ {
    public static CustomQueue<Order> orders;
    static ArrayList<Customer> customers;
    static CustomQueue<Order> normalOrders;
    static CustomQueue<Order> immediateOrders;

    static Thread normalWorker;
    static Thread immediateWorker;

    public static void main(String[] args) {
        orders = new CustomQueue<Order>();
        customers = new ArrayList<Customer>();
        normalOrders = new CustomQueue<Order>();
        immediateOrders = new CustomQueue<Order>();

        customers.add(new Customer("Marcel", "Hollink", 21, 'M', "Spijkenisse", "0872955@hr.nl"));
        customers.add(new Customer("EvertJan", "Heilema", 20, 'M', "Papendrecht", "0855012@hr.nl"));
        customers.add(new Customer("Esmee", "van", "Kuijk", 18, 'V', "Spijkenisse"));

        addOrdersToQueue();
        System.out.println("\n"+orders.size()+" jobs were created \n");

        updateQueue();
        normalWorker = new Thread(new Runnable() {
            private Boolean working = false;
            private Order currentJob;
            private Random r = new Random();
            @Override
            public void run() {
                while (!normalOrders.isEmpty()) {
                    // Check if there is an order being processed.
                    if(working) {

                        if(currentJob.getStartTime() + currentJob.getDuration()  < currentTimeMillis()) {
                            currentJob.hasBeenCompleted(true);

                            working = false;
                        }

                    // If not, search for an unprocessed order.
                    } else {

                        // Check each order ...
                        for (Order order : normalOrders) {

                            // If it is an order that has to be done immediately and has not been done yet.
                            if (!order.isProcessing() && !order.isCompleted()) {
                                // Set the order as current order
                                currentJob = order;

                                // Start the order
                                currentJob.startOrder();

                                // and set working to true, so no other orders will be picked up at the same time.
                                working = true;

                                // Break out of this for loop so the search ends.
                                break;
                            }
                        }
                    }

                    // Check each order...
                    for (Order order : normalOrders) {
                        // if it has been completed in the previous steps.
                        if(order.isCompleted()) {
                            // Remove the order from the list of orders.
                            System.out.println("order "+order.getOrderId()+" was removed from the queue");
                            normalOrders.remove(order);

                            break;
                        }
                    }

                    // This wil keep the process running at lower speed to keep from memory overflowing.
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        normalWorker.start();

        immediateWorker = new Thread(new Runnable() {
            private Boolean working = false;
            private Order currentJob;
            private Random r = new Random();
            @Override
            public void run() {
                while (!immediateOrders.isEmpty()) {
                    // Check if there is an order being processed.
                    if(working) {

                        if(currentJob.getStartTime() + currentJob.getDuration()  < currentTimeMillis()) {
                            currentJob.hasBeenCompleted(true);

                            working = false;
                        }

                        // If not, search for an unprocessed order.
                    } else {

                        // Check each order ...
                        for (Order order : immediateOrders) {

                            // If it is an order that has to be done immediately and has not been done yet.
                            if (!order.isProcessing() && !order.isCompleted()) {
                                // Set the order as current order
                                currentJob = order;

                                // Start the order
                                currentJob.startOrder();

                                // and set working to true, so no other orders will be picked up at the same time.
                                working = true;

                                // Break out of this for loop so the search ends.
                                break;
                            }
                        }
                    }

                    // Check each order...
                    for (Order order : immediateOrders) {
                        // if it has been completed in the previous steps.
                        if(order.isCompleted()) {
                            // Remove the order from the list of orders.
                            System.out.println("order "+order.getOrderId()+" was removed from the queue");
                            immediateOrders.remove(order);

                            break;
                        }
                    }

                    // This wil keep the process running at lower speed to keep from memory overflowing.
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        immediateWorker.start();
    }

    private static void updateQueue() {
        while (true) {
            for (Order order : orders) {
                if (order.isImmediately()) {
                    immediateOrders.add(order);
                    orders.remove(order);
                    break;
                } else {
                    normalOrders.add(order);
                    orders.remove(order);
                    break;
                }
            }
            if(orders.size() == 0) {
                break;
            }
        }
    }

    private static void addOrdersToQueue() {
        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            customers.get(r.nextInt(customers.size())).placeOrder(r.nextInt(4500)+500, r.nextBoolean());
        }
    }
}
