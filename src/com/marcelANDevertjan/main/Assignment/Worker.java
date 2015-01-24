package com.marcelANDevertjan.main.Assignment;

import com.marcelANDevertjan.main.Main;

import static java.lang.System.currentTimeMillis;

/**
 * This Class was created by marcel on 24-1-2015
 * Time of creation : 10:59
 */
public class Worker implements Runnable{

    private boolean running = true;
    private boolean working = false;

    Order currentJob;

    @Override
    public void run() {
        // As long as process is running.
        while(running){

            if(working) {

                if(currentJob.getStartTime() + currentJob.getDuration()  < currentTimeMillis()) {
                    currentJob.hasBeenCompleted();

                    working = false;
                }

            } else {
                // Check all the jobs from 0 until you find one which is not already in process, and is not finished
                for (Order order : Main.orders) {
                    if (!order.isProcessing() && !order.isCompleted()) {
                        currentJob = order;

                        currentJob.startOrder();
                        working = true;

                        break;
                    }
                }
            }

            for (Order order : Main.orders) {
                if(order.isCompleted()) {
                    Main.orders.remove(order);
                }
            }

            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
