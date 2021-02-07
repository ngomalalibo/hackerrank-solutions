package com.company;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class ArrayManipulation
{
    // Complete the arrayManipulation function below.
    static long arrayManipulation(int n, int[][] queries)
    {
        int[] table = new int[n + 1];
        long sum = 0;
        long max = 0;
        
        Arrays.fill(table, 0);
        
        for (int i = 0; i < queries.length; i++)
        {
            table[queries[i][0] - 1] += queries[i][2];
            table[queries[i][1]] -= queries[i][2];
        }
        for (int j = 0; j < n; j++)
        {
            sum += table[j];
            max = Math.max(max, sum);
        }
        
        return max;
    }
    
    private static final Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) throws IOException
    {
        
        String[] nm = scanner.nextLine().trim()/*.replaceAll("[ ]{2,}", " ")*/.split(" ");
        
        int n = Integer.parseInt(nm[0]);
        
        int m = Integer.parseInt(nm[1]);
        
        if (3 <= n && n <= Math.pow(10, 7) && 1 <= m && m <= 2 * (Math.pow(10, 5)))
        {
            int[][] queries = new int[m][3];
            for (int i = 0; i < m; i++)
            {
                String[] queriesRowItems = scanner.nextLine().trim()/*.replaceAll("[ ]{2,}", " ")*/.split(" ");
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
                
                for (int j = 0; j < 3; j++)
                {
                    if (1 <= Integer.parseInt(queriesRowItems[0]) && Integer.parseInt(queriesRowItems[0]) <= Integer.parseInt(queriesRowItems[1]) && Integer.parseInt(queriesRowItems[1]) <= n && 0 <= Integer.parseInt(queriesRowItems[2]) && Integer.parseInt(queriesRowItems[2]) <= Math.pow(10, 9))
                    {
                        int queriesItem = Integer.parseInt(queriesRowItems[j]);
                        queries[i][j] = queriesItem;
                    }
                    else
                    {
                        System.exit(0);
                    }
                }
            }
            
            
            long result = arrayManipulation(n, queries);
            
            System.out.println(result);
        }
        else
        {
            System.exit(0);
        }
        
        
        scanner.close();
    }
}

/*
* static long arrayManipulation(int n, int[][] queries)
    {
        
        int max = 0;
        int o = queries.length;
        List<Integer> list = new ArrayList<>();
        
        // put zeros in the array
        // loop through array and update indexes in o
        
        if (3 <= n && n <= Math.pow(10, 7))
        {
            if (1 <= o && o <= 2 * (Math.pow(10, 5)))
            {
                for (int i = 1; i <= n; i++)
                {
                    list.add(0);
                }
                
                for (int j = 0; j < o; j++)
                {
                    // go through rows to get operations starting from row 0
                    int lower = queries[j][0];
                    int upper = queries[j][1];
                    int q = queries[j][2];
                    if (1 <= lower && lower <= upper && upper <= n && 0 <= q && q <= Math.pow(10, 9))
                    {
                        for (int k = lower-1; k < n; k++)
                        {
                            if (k == lower-1 || k <= upper-1)
                            {
                                //for every operation add q to the range
                                list.set(k, list.get(k) + q);
                            }
                            else
                            {
                                break;
                            }
                        }
                        // System.out.println(list.toString());
                        max = list.stream().mapToInt(d -> d).max().orElse(0);
                    }
                    
                }
            }
        }
        
        // find maximum value at the last iteration
        
        
        return max;
    }
    
    private static final Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) throws IOException
    {
        
        String[] nm = scanner.nextLine().split(" ");
        
        int n = Integer.parseInt(nm[0]);
        
        int m = Integer.parseInt(nm[1]);
        
        int[][] queries = new int[m][3];
        
        for (int i = 0; i < m; i++)
        {
            String[] queriesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            
            for (int j = 0; j < 3; j++)
            {
                int queriesItem = Integer.parseInt(queriesRowItems[j]);
                queries[i][j] = queriesItem;
            }
        }
        
        long result = arrayManipulation(n, queries);
        
        System.out.println("result -> " + result);
        
        scanner.close();
    }*/