package com.marcelANDevertjan.main.Assignment.Scenario2;

import com.marcelANDevertjan.main.Assignment.Scenario1.Customer;

import java.util.ArrayList;

/**
 * This Class was created by Marcel And Evert-Jan on 25-1-2015
 * Time of creation : 16:16
 */
public class BinairyTreeSearch {
    public static String binarySearchLastName(ArrayList<Customer> customers,String lastname){
        int left = 0;
        int right = customers.size()-1;
        int mid;

        while (left <= right) {
            mid = (left+right)/2;

            if (customers.get(mid).getLastName().compareToIgnoreCase(lastname) > 0) {
                right = mid;
            } else if(customers.get(mid).getLastName().compareToIgnoreCase(lastname) < 0) {
                left = mid +1;
            } else {
                if(customers.get(mid).getPrefix() != null)
                    return customers.get(mid).getFirstName() + " " + customers.get(mid).getPrefix() + " " + customers.get(mid).getLastName();
                else
                    return customers.get(mid).getFirstName() + " " + customers.get(mid).getLastName();
            }
        }
        return "Not found";
    }
}
