package com.marcelANDevertjan.main.Assignment.Scenario1;

import com.marcelANDevertjan.main.Main;

import java.util.Random;

import static java.lang.System.currentTimeMillis;

/**
 * This Class was created by Evert-Jan and Marcel on 24-1-2015
 * Time of creation : 10:59
 */
public class Worker implements Runnable{

    // Boolean for checking if process is running.
    private boolean running = true;
    // Boolean to check if order is being processed.
    private boolean working = false;

    // Order object to place the current order while being processed.
    private Order currentJob;

    // Random to add new jobs on the fly
    private Random r = new Random();

    @Override
    public void run() {

        // As long as process is running.
        while(running){

            // Check if there is an order being processed.
            if(working) {

                if(currentJob.getStartTime() + currentJob.getDuration()  < currentTimeMillis()) {
                    currentJob.hasBeenCompleted(true);

                    working = false;

                    if(r.nextBoolean()){
                        Main.customers.get(r.nextInt(Main.customers.size())).placeOrder(r.nextInt(4500)+500, r.nextBoolean());
                    }
                }

            // If not, search for an unprocessed order.
            } else {

                // Check each order ...
                for (Order order : Main.orders) {

                    // If it is an order that has to be done immediately and has not been done yet.
                    if (!order.isProcessing() && !order.isCompleted() && order.isImmediately()) {
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

                // If no order was found in the previous search, it means there are no order to be done immediately and working is still false.
                if (!working) {

                    // In this case, just check each order again...
                    for (Order order : Main.orders) {

                        // To find an regular, and open order.
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
            }

            // Check each order...
            for (Order order : Main.orders) {
                // if it has been completed in the previous steps.
                if(order.isCompleted()) {
                    // Remove the order from the list of orders.
                    System.out.println("order "+order.getOrderId()+" was removed from the queue");
                    Main.orders.remove(order);

                    break;
                }
            }

            // If all orders have been done,
            if(Main.orders.size() == 0){
                // set running to false,
                // this will exit the out of the while loop to finish the process.
                running = false;
            }



            // This wil keep the process running at lower speed to keep from memory overflowing.
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
