package com.company;

import java.util.*;
import java.util.stream.Collectors;

public class CompleteWorkSchedule
{
    public List<String> findSchedules(int workHours, int dayHours, String pattern)
    {
        // get the position in the pattern that can hold values
        char[] chars = pattern.toCharArray();
        int totalFixedHours = 0;
        int unfixedHours = 0;
        List<Integer> positionOfQMarks = new ArrayList<>();
        
        
        for (int i = 0; i < chars.length; i++)
        {
            if (chars[i] == '?')
            {
                positionOfQMarks.add(i);
            }
            else if (chars[i] != '0')
            {
                // get the total fixed hours and subtract from workHours to get remainder
                totalFixedHours += Integer.parseInt(String.valueOf(chars[i]));
            }
        }
        int unfixedNoOfDays = positionOfQMarks.size(); // 2
        unfixedHours/*4*/ = workHours - totalFixedHours;
        // get the integers that make up an allowed schedule from the unfixed hours
        if (unfixedHours % dayHours == 0 && unfixedNoOfDays == unfixedHours / dayHours)
        {
            return Collections.singletonList(pattern.replaceAll("[\\?+]", String.valueOf(dayHours)));
        }
        Set<String> validSchedules = new HashSet<>();
        numbersThatSum = new HashMap<>();
        
        findCombinations(unfixedHours);
        List<int[]> splitHoursList = new ArrayList<>();
        
        numbersThatSum.values().stream().filter(d -> d.size() <= unfixedNoOfDays).forEach(d ->
                                                                                          {
                                                                                              int[] splitHours = new int[unfixedNoOfDays];
                                                                                              for (int i = 0; i < d.size(); i++)
                                                                                              {
                                                                                                  splitHours[i] = d.get(i);
                                                                                              }
                                                                                              // System.out.println();
                                                                                              splitHoursList.add(splitHours);
                                                                                          });
        splitHoursList.forEach(list ->
                               {
                                   for (int j = 0; j < unfixedNoOfDays; j++)
                                   {
                                       int count = 0;
                                       for (int i : positionOfQMarks)
                                       {
                                           char c = String.valueOf(list[count++]).charAt(0);
                                           chars[i] = c;
                                       }
                                       validSchedules.add(String.valueOf(chars));
                                       list = rotate(list, 1);
                                   }
            
                               });
        
        
        return validSchedules.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList());
    }
    
    static Map<Integer, List<Integer>> numbersThatSum;
    static int counter = 0;
    
    static void findCombinationsUtil(int arr[], int index,
                                     int num, int reducedNum)
    {
        // Base condition
        if (reducedNum < 0)
        {
            return;
        }
        
        // If combination is
        // found, print it
        if (reducedNum == 0)
        {
            List<Integer> ss = new ArrayList<>();
            for (int i = 0; i < index; i++)
            {
                ss.add(arr[i]);
            }
            numbersThatSum.put(++counter, ss);
            return;
        }
        
        // Find the previous number
        // stored in arr[]. It helps
        // in maintaining increasing
        // order
        int prev = (index == 0) ?
                1 : arr[index - 1];
        
        // note loop starts from
        // previous number i.e. at
        // array location index - 1
        for (int k = prev; k <= num; k++)
        {
            // next element of
            // array is k
            arr[index] = k;
            
            // call recursively with
            // reduced number
            findCombinationsUtil(arr, index + 1, num,
                                 reducedNum - k);
        }
    }
    
    /* Function to find out all
    combinations of positive
    numbers that add upto given
    number. It uses findCombinationsUtil() */
    static void findCombinations(int n)
    {
        // array to store the combinations
        // It can contain max n elements
        int arr[] = new int[n];
        
        // find all combinations
        findCombinationsUtil(arr, 0, n, n);
    }
    
    public static int[] rotate(int[] nums, int k)
    {
        int l = nums.length;
        int index = Math.abs(l - k);
        int[] result = new int[l];
        for (int j = 0; j < l; j++)
        {
            if (index == l)
            {
                index = 0;
            }
            if (index < l)
            {
                result[j] = nums[index];
            }
            index++;
        }
        
        return result;
    }
    
    public static void main(String[] args)
    {
        new CompleteWorkSchedule().findSchedules(24, 4, "08??840").forEach(System.out::println);
        System.out.println();
        new CompleteWorkSchedule().findSchedules(56, 8, "???8???").forEach(System.out::println);
        System.out.println();
        new CompleteWorkSchedule().findSchedules(3, 2, "??2??00").forEach(System.out::println);
    }
}
