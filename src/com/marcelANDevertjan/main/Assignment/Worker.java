package com.marcelANDevertjan.main.Assignment;

import com.marcelANDevertjan.main.Main;

import static java.lang.System.currentTimeMillis;

/**
 * This Class was created by marcel on 23-1-2015
 * Time of creation : 22:45
 */
public class Worker implements Runnable{

    boolean working = false;
    boolean jobsAvailable = true;

    Order job;

    @Override
    public void run() {
        while (jobsAvailable) {


            if(!working) {
                for (int i = 0; i < Main.orders.size(); i++) {
                    if(!Main.orders.get(i).isProcessing()){

                        job = Main.orders.get(i);
                        job.startOrder();

                        working = true;
                        break;
                    }
                }
            } else if (working){

                if (job.getDuration() < (currentTimeMillis() - job.getStartTime())){
                    job.completed();
                    Main.orders.remove(job);
                    working = false;
                }
            }

            if(Main.orders.size() == 0){
                jobsAvailable = false;
            }

            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
