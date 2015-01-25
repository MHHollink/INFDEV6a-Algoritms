package com.marcelANDevertjan.main.Assignment.Scenario2;

import com.marcelANDevertjan.main.Assignment.Scenario1.Customer;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * This Class was created by Marcel and Evert-Jan on 25-1-2015
 * Time of creation : 14:24
 */
public class MergeSort {


    public void sortArray(ArrayList<Customer> customers) {

        int[] ages = new int[customers.size()];

        for (int i = 0; i < customers.size(); i++) {
            Customer customer = customers.get(i);

            ages[i]= customer.getAge();
        }

        System.out.println("BEFORE : ");
        System.out.println(Arrays.toString(ages));

        ages = mergeSort(ages, 0, ages.length-1);

        System.out.println("\n AFTER : ");
        System.out.println(Arrays.toString(ages));
    }

    private static int[] mergeSort(int[] array, int leftSide, int rightSide)
    {
        if (rightSide-leftSide < 1){
            return array;
        }
        int center = (rightSide+leftSide)/2;

        mergeSort(array, leftSide, center);
        mergeSort(array, center+1, rightSide);
        return merge(array, leftSide, rightSide, center);
    }

    private static int[] merge(int[] array, int left, int right, int mid)
    {
        // Helper variables
        int[] helper = new int[array.length / 2 + 1];
        int helperSize = 0;
        int helperIndex = 0;
        int firstLeftInt = left;
        int firstRightInt = mid+1;

        // Keeps comparing both parts of the array unless it hit one of the boundaries
        while(firstLeftInt <= mid && firstRightInt <= right){
            // if there is no data from the helper (0-0=0), use left and right to compare
            if((helperSize - helperIndex) == 0){
                //when right is less than left we overwrite left with right and store left in the helper
                if(array[firstLeftInt] > array[firstRightInt]){
                    helper[helperSize] = array[firstLeftInt];
                    array[firstLeftInt] = array[firstRightInt];
                    helperSize++;
                    firstRightInt++;
                }
            }
            // if there is some data in the helper,
            // we use the helpers (instead of left) for comparison with right
            else{
                // when right is less than the helper
                if(helper[helperIndex] > array[firstRightInt]){
                    // we save left in the helper and we overwrite next left
                    helper[helperSize] = array[firstLeftInt];
                    array[firstLeftInt] = array[firstRightInt];
                    firstRightInt++;
                    helperSize++;
                }
                // when right is bigger then helper,
                // we use the helper value (but save the overwritten value in the helper)
                else{
                    helper[helperSize] = array[firstLeftInt];
                    array[firstLeftInt] = helper[helperIndex];
                    helperSize++;
                    helperIndex++;
                }
            }
            firstLeftInt++;
        }

        //now we hit the end of either partition - now we have only two of them (helper and either left or right)
        //so we do traditional merge using these two
        while(firstLeftInt <= right && (helperSize - helperIndex) > 0){
            if(firstRightInt <= right && array[firstRightInt] < helper[helperIndex]){
                array[firstLeftInt] = array[firstRightInt];
                firstRightInt++;
            }
            else{
                if(firstLeftInt <= mid){
                    helper[helperSize] = array[firstLeftInt];
                    helperSize++;
                }
                array[firstLeftInt] = helper[helperIndex];
                helperIndex++;
            }
            firstLeftInt++;
        }
        return array;
    }
}
