package com.marcelANDevertjan.main.Assignment.Scenario2;

import com.marcelANDevertjan.main.Assignment.Scenario1.Customer;
import com.marcelANDevertjan.main.Main;

/**
 * This Class was created by Marcel And Evert-Jan on 25-1-2015
 * Time of creation : 15:02
 */
public class LinearSearch {

    public static String searchForLastname(String lastname) {

        for (Customer customer : Main.customers) {
            if (customer.getLastName().equals(lastname)) {
                if (customer.getPrefix() != null) {
                    return customer.getFirstName() + " " + customer.getPrefix() + " " + customer.getLastName();
                } else {
                    return customer.getFirstName() + " " + customer.getLastName();
                }
            }
        }
        return "nothing found";
    }
}
