package com.marcelANDevertjan.main.Assignment;

import com.marcelANDevertjan.main.Main;

import java.util.UUID;

import static java.lang.System.currentTimeMillis;

/**
 * This Class was created by Evert-Jan and Marcel on 23-1-2015
 * Time of creation : 21:46
 */
public class Order {

    private String customerId;
    private UUID orderId;
    private boolean processing = false;
    private boolean completed = false;
    private boolean immediately = false;
    private double startTime, duration;

    /**
     * This function is used to create an order, it has max three and at least two parameters.
     *
     * @param customerId will be referenced from the customer who placed the order.
     * @param duration of the orders will be specified in milliseconds.
     * @param immediately can be set to specify if the order has to be done "immediately".
     *                    true if it has, false if it has not (can be empty as well)
     */
    public Order(String customerId, double duration, Boolean immediately) {
        this.customerId = customerId;
        this.duration = duration;
        this.immediately = immediately;

        orderId = UUID.randomUUID();

        Main.orders.add(this);
        if (immediately){
            System.out.println("Job Created : " + customerId +", and was specified as immediately");
        }else {
            System.out.println("Job Created : " + customerId);
        }
    }

    /**
     * Overload of the new Order fucntion, this one will keep immediately as false.
     */
    public Order(String customerId, double duration) {
        this.customerId = customerId;
        this.duration = duration;

        orderId = UUID.randomUUID();

        Main.orders.add(this);
        System.out.println("Job Created : "+customerId);
    }

    /**
     *
     *
     * @return
     */
    public double startOrder(){
        processing = true;
        return startTime = currentTimeMillis();
    }

    /**
     * Getters for each order.
     *
     */
    public double getStartTime() {
        return startTime;
    }
    public double getDuration() {
        return duration;
    }
    public boolean isImmediately() {
        return immediately;
    }
    public boolean isProcessing() {
        return processing;
    }
    public boolean isCompleted() {
        return completed;
    }
    public UUID getOrderId() {
        return orderId;
    }

    /**
     * setter for completion of order.
     *
     * @param completed is true if the order has been completed.
     */
    public void hasBeenCompleted(Boolean completed) {
        System.out.println("The job placed by _"+customerId+"_ has been Completed");
        this.completed = completed;
    }



}
