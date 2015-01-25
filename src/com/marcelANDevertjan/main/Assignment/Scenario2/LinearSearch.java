package com.marcelANDevertjan.main.Assignment.Scenario2;

import com.marcelANDevertjan.main.Main;

/**
 * This Class was created by marcel on 25-1-2015
 * Time of creation : 15:02
 */
public class LinearSearch {

    public static String searchForLastname(String lastname) {

        for (int fucks = 0; fucks < Main.customers.size(); fucks++) {
            if (Main.customers.get(fucks).getLastName().equals(lastname)) {
                if (Main.customers.get(fucks).getPrefix() != null) {
                    return Main.customers.get(fucks).getFirstName() + " " + Main.customers.get(fucks).getPrefix() + " " + Main.customers.get(fucks).getLastName();
                } else {
                    return Main.customers.get(fucks).getFirstName() + " " + Main.customers.get(fucks).getLastName();
                }
            }
        }
        return "nothing found";
    }
}
