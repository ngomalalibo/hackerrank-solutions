package com.company.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * This is a demo task.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(int[] A); }
 * <p>
 * that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.
 * <p>
 * For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.
 * <p>
 * Given A = [1, 2, 3], the function should return 4.
 * <p>
 * Given A = [−1, −3], the function should return 1.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * N is an integer within the range [1..100,000];
 * each element of array A is an integer within the range [−1,000,000..1,000,000].
 */
class solution1
{
    public static int solution(int[] A)
    {
        Set<Integer> dd = new HashSet<>();
        if (A.length >= 1 && A.length <= 100000)
        {
            // System.out.println("Array length must be between 1 and 1000000");
            // System.exit(1);
        }
        for (int i = 0; i < A.length; i++)
        {
            if (A[i] > -1000000 && A[i] < 1000000)
            {
                // System.out.println("Number must be between -1000000 and 1000000 ");
                // System.exit(1);
            }
        }
        for (int i = 0; i < A.length; i++)
        {
            
            dd.add(A[i]);
        }
        ArrayList<Integer> integers = new ArrayList<>(dd);
        Collections.sort(integers);
        //integers.forEach(System.out::print);
        for (int i = 0; i < A.length; i++)
        {
            if (!integers.contains(integers.get(i) + 1))
            {
                System.out.println(integers.get(i) + 1);
                return A[i] + 1;
            }
        }
        // write your code in Java SE 8
        return 0;
    }
    
    public static void main(String[] args)
    {
        int a[] = {1, 3, 6, 4, 1, 2};
        solution(a);
    }
}
