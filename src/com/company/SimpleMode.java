package com.company;

import java.util.HashMap;
import java.util.Map;

public class SimpleMode
{
    public int mode(int[] arr)
    {
        Map<Integer, Integer> arrMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++)
        {
            if (arrMap.get(arr[i]) != null)
            {
                int count = arrMap.get(arr[i]);
                arrMap.put(arr[i], ++count);
            }
            else
            {
                arrMap.put(arr[i], 1);
            }
        }
        int same = Integer.MIN_VALUE;
        int counter = 0;
        for (int num : arrMap.values())
        {
            if (same == Integer.MIN_VALUE)
            {
                same = arrMap.get(num);
                counter++;
                continue;
            }
            counter++;
            if (arrMap.get(num) == same && counter == arrMap.size() - 1)
            {
                return -1;
            }
            else if (arrMap.get(num) == same)
            {
                continue;
            }
            else
            {
                break;
            }
        }
    
        int max = arrMap.values().stream().mapToInt(d -> d).max().orElse(-1);
    
        /*int max = Integer.MIN_VALUE;
        for (int num : arrMap.values())
        {
            if (num > max)
            {
                max = num;
            }
        }*/
        
        for (int num : arr)
        {
            if (arrMap.get(num) == max)
            {
                return num;
            }
        }
        
        return -1;
    }
    
    public static void main(String[] args)
    {
        System.out.println(new SimpleMode().mode(new int[]{5, 2, 1}));
        System.out.println(new SimpleMode().mode(new int[]{5, 5, 2, 2, 1}));
        System.out.println(new SimpleMode().mode(new int[]{5, 2, 2, 1}));
        System.out.println(new SimpleMode().mode(new int[]{1}));
    }
}
