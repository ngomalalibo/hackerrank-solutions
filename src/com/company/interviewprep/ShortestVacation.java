package com.company.interviewprep;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class ShortestVacation
{
    public static int shortestVacation(int[] A)
    {
        int n = A.length; // no of vacation days
        int shortestVacation = Integer.MAX_VALUE; // set shortestVacation to largest possible int
        Set<Integer> allTrips = new HashSet<>(); // will hold unique trips
        ArrayList<Integer> subarray = new ArrayList<>(); // will hold subarray of possible vacations
        
        // handles constraint
        if (n < 1 || n > 100000)
        {
            System.exit(0);
        }
        
        for (int a = 0; a < n; a++)
        {
            //handles constraint
            if (0 <= A[a] && A[a] <= n - 1)
            {
                allTrips.add(A[a]); // add unique trips to trip set
            }
            else
            {
                System.exit(0);
            }
        }
        /**  2, 1, 1, 3, 2, 1, 1, 3*/
        
        //loop through trips/days
        for (int i = 0; i < n; i++)
        {
            subarray = new ArrayList<>(); // reset array for every fixed position array loop/traversal
            // moving position of array
            for (int j = i; j < n; j++)
            {
                subarray.add(A[j]);
                if (subarray.containsAll(allTrips))
                {
                    if (subarray.size() <= shortestVacation)
                    {
                        shortestVacation = subarray.size();
                    }
                }
            }
        }
        return shortestVacation;
    }
    
    public static void main(String[] args)
    {
        // int[] A = new int[]{2, 1, 1, 3, 2, 1, 1, 3};
        int[] A = new int[]{7, 3, 7, 3, 1, 3, 4, 1};
        // int[] A = new int[]{7, 5, 2, 7, 2, 7, 4, 7};
        
        int i = shortestVacation(A);
        System.out.println("result -> " + i);
    }
}
