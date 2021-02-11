package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CountTriplets
{
    static long countTriplets(List<Long> arr, long r)
    {
        
        Map<Long, Long> rightMap = getOccurenceMap(arr);
        Map<Long, Long> leftMap = new HashMap<>();
        long numberOfGeometricPairs = 0;
        
        for (long val : arr)
        {
            long countLeft = 0;
            long countRight = 0;
            long lhs = 0;
            long rhs = val * r;
            if (val % r == 0)
            {
                lhs = val / r;
            }
            Long occurence = rightMap.get(val);
            rightMap.put(val, occurence - 1L);
            
            if (rightMap.containsKey(rhs))
            {
                countRight = rightMap.get(rhs);
            }
            if (leftMap.containsKey(lhs))
            {
                countLeft = leftMap.get(lhs);
            }
            numberOfGeometricPairs += countLeft * countRight;
            insertIntoMap(leftMap, val);
        }
        return numberOfGeometricPairs;
    }
    
    private static Map<Long, Long> getOccurenceMap(List<Long> test)
    {
        Map<Long, Long> occurenceMap = new HashMap<>();
        for (long val : test)
        {
            insertIntoMap(occurenceMap, val);
        }
        return occurenceMap;
    }
    
    private static void insertIntoMap(Map<Long, Long> occurenceMap, Long val)
    {
        if (!occurenceMap.containsKey(val))
        {
            occurenceMap.put(val, 1L);
        }
        else
        {
            Long occurence = occurenceMap.get(val);
            occurenceMap.put(val, occurence + 1L);
        }
    }
    
    
    public static void main(String[] args) throws IOException
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        
        String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
        
        int n = Integer.parseInt(nr[0]);
        
        long r = Long.parseLong(nr[1]);
        
        List<Long> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                               .map(Long::parseLong)
                               .collect(Collectors.toList());
        
        long ans = countTriplets(arr, r);
        System.out.println("ans " + ans);
        
        bufferedReader.close();
    }
}

/* My solution. 7/13 testcases
package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CountTriplets
{
    // Complete the countTriplets function below.
    static long countTriplets(List<Long> arr, long r)
    {
        arr.sort(Comparator.naturalOrder());
        int noOfTriplets = 0;
        
        NavigableMap<Long, Integer> exps = new TreeMap<>();
        
        // create map of exponents. never used
        for (int i = 0; i < arr.size(); i++)
        {
            if (exps.containsKey(arr.get(i)))
            {
                exps.put(arr.get(i), exps.get(arr.get(i)) + 1);
            }
            else
            {
                exps.put(arr.get(i), 1);
            }
        }
        List<Long> dd = new ArrayList<>(exps.keySet());
        for (int i = 0; i < dd.size(); i++)
        {
            if (i > dd.size() - 3)
            {
                break;
            }
            long nextExp = 0;
            long thirdExp = 0;
            long initialExp = 0;
            long seed = dd.get(i);
            if (dd.get(i) == 1)
            {
                nextExp = (long) Math.pow(r, 1);
                thirdExp = (long) Math.pow(r, 2);
            }
            else if (seed % r == 0) // if not 1 check if it is a multiple of r
            {
                while (seed != 1) // get next exponents
                {
                    seed = seed / r; // 16,8,4,2
                    initialExp++;//1,1,1,1
                }
                
                nextExp = (long) Math.pow(r, initialExp + 1);
                thirdExp = (long) Math.pow(r, initialExp + 2);
            }
            
            
            int initialCount = exps.get(dd.get(i));
            Long next = dd.get(i + 1);
            Long third = dd.get(i + 2);
            int nextCount = exps.get(next);
            int thirdCount = exps.get(third);
            if (nextExp == next && thirdExp == third)
            {
                noOfTriplets++;
                noOfTriplets = noOfTriplets + (nextCount - 1) + (thirdCount - 1) + (initialCount - 1);
            }
        }
        
        return noOfTriplets;
        
    }
    
    
    public static void main(String[] args) throws IOException
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        
        String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
        
        int n = Integer.parseInt(nr[0]);
        
        long r = Long.parseLong(nr[1]);
        
        List<Long> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                               .map(Long::parseLong)
                               .collect(Collectors.toList());
        
        long ans = countTriplets(arr, r);
        System.out.println("ans " + ans);
        
        bufferedReader.close();
    }
}

**/