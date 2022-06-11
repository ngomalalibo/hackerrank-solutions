package com.company.decagon;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LaptopRentals
{
    /**
     * You're given a list of time intervals during which students at a school need a laptop. These time intervals are represented by pairs of integers [start, end],
     * where 0 <= start < end. However, start and end don't represent real times; therefore, they may be greater than 24.
     * <p>
     * No two students can use a laptop at the same time, but immediately after a student is done using a laptop, another student can use that same laptop. For example,
     * if one student rents a laptop during the time interval [0, 2], another student can rent the same laptop during any time interval starting with 2.
     * <p>
     * Write a function that returns the minimum number of laptops that the school needs to rent such that all students will always have access to a laptop when they need one.
     * Challenge.laptopRentals(times)
     * <p>
     * Parameters
     * <p>
     * times: List<Integer[]> - A 2D array containing the times the student would require a laptop.
     * Return Value
     * <p>
     * Integer - Minimum number of laptops the school needs to rent.
     * <p>
     * Examples
     * times 	Return Value
     * [[0,2],[1,4],[4,6],[0,4],[7,8],[9,11],[3,10]] 	3
     * [[0,4],[2,3],[2,3],[2,3]] 	4
     * [[1,5],[5,6],[6,7],[7,9]] 	1
     */
    
    
    public static Integer laptopRentals(List<List<Integer>> times)
    {
        int minRentals = 0;
        int length = times.size();
        boolean isRented = false;
        Map<Integer, Integer> usedMap = new HashMap<>();
        
        for (int i = 0; i < length; i++)
        {
            // get slot start and end times
            List<Integer> slots = times.get(i);
            int start = slots.get(0);
            int end = slots.get(1);
            if (i == 0)
            {
                // add first slot as used slot and provide laptop for slot
                usedMap.put(start, end);
                ++minRentals;
            }
            // compare against all other slots except itself
            for (int j = 0; j < length; j++)
            {
                if (j == i)
                {
                    continue;
                }
                // get current slot start and end times
                List<Integer> cur = times.get(j);
                int curStart = cur.get(0);
                int curEnd = cur.get(1);
                // check if current start time is in range of current marked slot. If in range rent
                if (isInRangeLowerIncl(curStart, start, end))
                {
                    // before renting check if already used laptop will be available to fulfill request
                    for (Integer key : usedMap.keySet())
                    {
                        // if curStart is not out of range of used laptops rent laptop. Available laptop can be reused
                        if (!isOutRangeExcl(curStart, key, usedMap.get(key)))
                        {
                            ++minRentals;
                            isRented = true;
                            break;
                        }
                        else
                        {
                            // remove slot from available
                            usedMap.remove(key);
                        }
                    }
                    if (isRented)
                    {
                        // store used times in map
                        usedMap.put(start, end);
                        isRented = false;
                    }
                }
            }
            // empty availability hashmap of used slotsfor next slot checks
            usedMap = new HashMap<>();
        }
        return minRentals;
    }
    
    
    public static boolean isInRangeLowerIncl(int x, int min, int max)
    {
        return x >= min && x < max;
    }
    
    public static boolean isOutRangeExcl(int x, int min, int max)
    {
        return x > max || x < min;
    }
    
    
    public static void main(String[] args)
    {
        System.out.println(laptopRentals(List.of(List.of(0, 2), List.of(1, 4), List.of(4, 6), List.of(0, 4), List.of(7, 8), List.of(9, 11), List.of(3, 10))));
        System.out.println(laptopRentals(List.of(List.of(0, 4), List.of(2, 3), List.of(2, 3), List.of(2, 3))));
        System.out.println(laptopRentals(List.of(List.of(1, 5), List.of(5, 6), List.of(6, 7), List.of(7, 9))));
    }
}
