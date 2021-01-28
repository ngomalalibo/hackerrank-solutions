package com.company.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FibonacciOC
{
    /* The name of the class has to be Main. */
    public static void main(String[] args)
    {
        int n = 0, m = 0;
        int result = -1;
        // try (Scanner scanner = new Scanner(new File(args[0])))
        {
            // String[] numberTokens = scanner.nextLine().split(",");
            // n = Integer.parseInt(numberTokens[0]);
            // m = Integer.parseInt(numberTokens[1]);
            n = 1;
            m = 1;
            
            if (n < 0 || m < 0)
            {
                System.out.println("Expected input: N >= 0 and M >= 0");
                System.exit(1);
            }
            if (n == 1 && m == 1)
            {
                result = 1;
            }
            else
            {
                List<Integer> nList = fibonacci(n);
                List<Integer> mList = fibonacci(m);
                int nPosition = 0;
                int mPosition = 0;
                
                if (nList.contains(n))
                {
                    nPosition = nList.indexOf(n);
                }
                if (mList.contains(m))
                {
                    mPosition = mList.indexOf(m);
                }
                if (m > n)
                {
                    if (mPosition - nPosition == 1)
                    {
                        result = 1;
                    }
                    else
                    {
                        result = 0;
                    }
                }
                else if (n > m)
                {
                    if (nPosition - mPosition == 1)
                    {
                        result = 1;
                    }
                    else
                    {
                        result = 0;
                    }
                }
                else
                {
                    result = 0;
                }
            }
            
            
            System.out.println(result);
        }
        
    }
    
    public static List<Integer> fibonacci(int n)
    {
        List<Integer> series = new ArrayList<>();
        //0,1,1,2,3,5,8,13,21,34,55
        series.add(0);
        series.add(1);
        for (int i = 1; i <= n; i++)
        {
            series.add(series.get(i) + series.get(i - 1));
        }
        return series;
    }
}
