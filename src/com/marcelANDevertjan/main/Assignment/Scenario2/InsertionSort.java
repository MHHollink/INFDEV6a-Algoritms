package com.marcelANDevertjan.main.Assignment.Scenario2;

import com.marcelANDevertjan.main.Assignment.Scenario1.Customer;
import com.marcelANDevertjan.main.Main;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.ArrayList;

/**
 * This Class was created by Marcel And Evert-Jan on 25-1-2015
 * Time of creation : 16:15
 */
public class InsertionSort {

    public static void insert(Customer c) {

        char[] letters = c.getLastName().toCharArray();
        boolean inserted = false;

        // for each Customer
        outerLoop:
        for (int i = 0; i < Main.customers.size(); i++) {
            Customer customer = Main.customers.get(i);
            char[] temp = customer.getLastName().toCharArray();

            // check each Letter
            for (int j = 0; j < letters.length; j++) {
                // if it is bigger then that of the customer
                if (letters[j] < temp[j]) {

                    // start moving customers over...
                    for (int k = Main.customers.size() - 1; k >= i; k--) {


                        if( k == Main.customers.size()-1){
                            Main.customers.add(Main.customers.get(k));
                        } else {
                            Main.customers.set(k+1, Main.customers.get(k));
                        }
                    }

                    Main.customers.set(i, c);

                    if(i == 0){
                        System.out.println(c.getLastName() +" has been inserted between '"+Main.customers.get(i).getLastName()+"' and '"+customer.getLastName()+"'.");
                    }
                    if(i != 0){
                        System.out.println(c.getLastName() +" has been inserted between '"+Main.customers.get(i-1).getLastName()+"' and '"+customer.getLastName()+"'.");
                    }
                    inserted = true;
                    break outerLoop;
                } else {
                    break;
                }
            }

        }
        if(!inserted){
            System.out.println("There was nothing to insert between, '"+c.getLastName()+"' was added at the end of the list. \n");
            Main.customers.add(c);
        }

    }
}
