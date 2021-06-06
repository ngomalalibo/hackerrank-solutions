package com.company.interviewprep;

public class RecursionPractice
{
    public void countDownIter(int n)
    {
        for (int i = n; i > 0; i--)
        {
            System.out.print(i + " ");
        }
        System.out.println("Hoorray!");
    }
    
    public void countDownRecursive(int n)
    {
        if (n <= 0)
        {
            System.out.println("Hoorray!");
            return;
        }
        System.out.print(n + " ");
        countDownRecursive(n - 1);
    }
    
    public int sumRange(int n)
    {
        int total = 0;
        for (int i = n; i > 0; i--)
        {
            total += i;
        }
        return total;
    }
    
    public int sumRangeRecursive(int n, int total)
    {
        if (n <= 0)
        {
            return total;
        }
        return sumRangeRecursive(n - 1, n + total);
    }
    
    
    public static void main(String[] args)
    {
        new RecursionPractice().countDownIter(3);
        new RecursionPractice().countDownRecursive(3);
        System.out.println(new RecursionPractice().sumRange(3));
        System.out.println(new RecursionPractice().sumRangeRecursive(3, 0));
    }
}
