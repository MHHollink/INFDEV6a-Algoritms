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

        String returnString = "";

        while (left <= right) {
            mid = (left+right)/2;

            if (customers.get(mid).getLastName().compareToIgnoreCase(lastname) > 0) {
                right = mid-1;
            } else if(customers.get(mid).getLastName().compareToIgnoreCase(lastname) < 0) {
                left = mid+1;
            } else {
                int count = mid;
                if(count > 0) {
                    while (customers.get(count - 1).getLastName().equals(lastname)) {
                        if (customers.get(count - 1).getPrefix() != null)
                            returnString = customers.get(count - 1).getFirstName() + " " + customers.get(count - 1).getPrefix() + " " + customers.get(count - 1).getLastName() + " " + returnString;
                        else
                            returnString = customers.get(count - 1).getFirstName() + " " + customers.get(count - 1).getLastName() + " " + returnString;
                        count--;
                    }
                }

                if(customers.get(mid).getPrefix() != null)
                    returnString = returnString + customers.get(mid).getFirstName() + " " + customers.get(mid).getPrefix() + " " + customers.get(mid).getLastName();
                else
                    returnString = returnString + customers.get(mid).getFirstName() + " " + customers.get(mid).getLastName();

                count = mid;
                if(count < customers.size()-1) {
                    while (customers.get(count + 1).getLastName().equals(lastname)) {
                        if (customers.get(count + 1).getPrefix() != null)
                            returnString = returnString + " " + customers.get(count + 1).getFirstName() + " " + customers.get(count + 1).getPrefix() + " " + customers.get(count + 1).getLastName();
                        else
                            returnString = returnString + " " + customers.get(count + 1).getFirstName() + " " + customers.get(count + 1).getLastName();
                        count++;
                    }
                }

                return returnString;
            }
        }
        return "Not found";
    }
}
