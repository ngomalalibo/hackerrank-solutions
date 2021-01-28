package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JavaLoopsII
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        
        int q = in.nextInt();
        List<int[]> queries = new ArrayList<>();
        List<int[]> results = new ArrayList<>();
        
        if (0 <= q && q <= 500)
        {
            for (int i = 0; i < q; i++)
            {
                int a = in.nextInt();
                int b = in.nextInt();
                int n = in.nextInt();
                
                if (0 <= a && b <= 50 && 1 <= n && n <= 15)
                {
                    queries.add(new int[]{a, b, n});
                    
                }
                else
                {
                    System.exit(0);
                }
            }
        }
        else
        {
            System.exit(0);
        }
        
        
        in.close();
        
        for (int i = 0; i < queries.size(); i++)
        {
            int[] query = queries.get(i);
            int a = query[0];
            int b = query[1];
            int n = query[2];
            int[] result = new int[n];
            
            if (n == 1)
            {
                result[0] = a + (1 * b);
                results.add(result);
                continue;
            }
            if (n == 2)
            {
                result[0] = a + (1 * b);
                result[1] = a + (1 * b) + (2 * b);
                results.add(result);
                continue;
            }
            
            result[0] = a + (1 * b);
            result[1] = a + (1 * b) + (2 * b);
            
            for (int j = 2; j < n; j++)
            {
                result[j] += result[j - 1];
                result[j] += (Double.valueOf(Math.pow(2, j)).intValue() * b);
            }
            results.add(result);
        }
        
        results.forEach(result ->
                        {
                            for (int g = 0; g < result.length; g++)
                            {
                                System.out.print(result[g]);
                                if (g < (result.length - 1))
                                {
                                    System.out.print(" ");
                                }
                            }
                            System.out.println();
                        });
    }
}
