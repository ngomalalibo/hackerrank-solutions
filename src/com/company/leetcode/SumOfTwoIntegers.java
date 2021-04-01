package com.company.leetcode;

public class SumOfTwoIntegers
{
    public int getSum(int a, int b)
    {
        return Integer.sum(a, b);
    }
    
    public static void main(String[] args)
    {
        int a = 3;
        int b = 2;
        new SumOfTwoIntegers().getSum(a, b);
    }
}
