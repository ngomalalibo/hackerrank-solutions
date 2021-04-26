package com.company.leetcode;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MissingNumber
{
    //put in a map and then use the keys of the map to get
    
    public static int missingNumber(int[] arr)
    {
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++)
        {
            if (i != arr[i])
            {
                return i;
            }
        }
        return arr.length;
    }
    
    // also work
    /*public static int missingNumber(int[] arr)
    {
        Arrays.sort(arr);
        int []arrr = new int[arr.length];
        for(int i=0;i<arrr.length;i++)
        {
            arrr[i]=i;
        }
        
        Set<Integer> sedd = new HashSet<>(Arrays.asList(Arrays.stream(arr).boxed().toArray(Integer[]::new)));
        Set<Integer> seddd = new HashSet<>(Arrays.asList(Arrays.stream(arrr).boxed().toArray(Integer[]::new)));
        seddd.removeAll(sedd);
        for(int f : seddd)
        {
            return f;
        }
        
        return arr.length;
    }*/
    /*public static int missingNumber(int[] arr)
    {
        Set<Integer> sett = Arrays.stream(arr).boxed().sorted().collect(Collectors.toSet());
        for (int i = 0; i < arr.length; i++)
        {
            if(!sett.contains(i))
            {
                return i;
            }
        }
        return arr.length;
    }*/
    
    public static void main(String[] args)
    {
        System.out.println(missingNumber(new int[]{3, 0, 1}));
        System.out.println(missingNumber(new int[]{0, 1}));
    }
}
