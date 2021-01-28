package com.company.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FibonacciHR
{
    
    public static int fibonacci(int n)
    {
        /*List<Integer> series = new ArrayList<>();
        //0,1,1,2,3,5,8,13,21,34,55
        series.add(0);
        series.add(1);
        for (int i = 1; i <= n; i++)
        {
            series.add(series.get(i)+series.get(i-1));
            
            if (i == n)
            {
                return series.get(i);
            }
        }*/
        return 0;
    }
    
    
    public static void main(String[] args)
    {
        //Scanner scanner = new Scanner(System.in);
        // int n = scanner.nextInt();
        int n = 10;
        // scanner.close();
        System.out.println(fibonacci(n));
    }
}