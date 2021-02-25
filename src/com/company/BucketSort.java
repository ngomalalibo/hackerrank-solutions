package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BucketSort
{
    public static void bucketSort(int[] array)
    {
        List<Integer>[] buckets = new List[10];
        
        for (int i = 0; i < buckets.length; i++)
        {
            buckets[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < array.length; i++)
        {
            buckets[hash(array[i])].add(array[i]);
        }
        
        for (List<Integer> bucket : buckets)
        {
            Collections.sort(bucket);
        }
        
        int j=0;
        for (int i=0; i<buckets.length;i++)
        {
            for (Integer bucket: buckets[i])
            {
                array[j++] = bucket;
            }
        }
    }
    
    public static void main(String[] args)
    {
        int[] array = new int[]{54, 46, 83, 66, 95, 92, 43};
        bucketSort(array);
        System.out.println(Arrays.toString(array));
    }
    
    public static int hash(int value)
    {
        return value / (int) 10;
    }
}
