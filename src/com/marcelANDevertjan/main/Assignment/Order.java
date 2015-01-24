package com.marcelANDevertjan.main.Assignment;

import com.marcelANDevertjan.main.Main;

import java.util.ArrayList;
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

    public Order(String customerId, double duration) {
        this.customerId = customerId;
        this.duration = duration;

        orderId = UUID.randomUUID();

        Main.orders.add(this);
        System.out.println("Job Created with ID of: "+orderId);
    }

    public Order(String customerId, double duration, Boolean immediately) {
        this.customerId = customerId;
        this.duration = duration;
        this.immediately = immediately;

        orderId = UUID.randomUUID();

        Main.orders.add(this);
        System.out.println("Job Created with ID of: "+orderId);
    }


    public double startOrder(){
        processing = true;
        return startTime = currentTimeMillis();
    }
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

    public void hasBeenCompleted() {
        System.out.println("The job placed by _"+customerId+"_ has been Completed");
        Main.orders.remove(this);
    }


    public UUID getOrderId() {
        return orderId;
    }
}
