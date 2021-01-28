package com.company.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DavidsStaircase
{
    
    
    static int stepPerms(int n)
    {
        if (n <= 1 && n >= 36)
        {
            System.out.println("n should be bw 1 and 36");
            System.exit(1);
        }
        if (n == 1)
        {
            return 1;
        }
        if (n == 2)
        {
            return 2;
        }
        if (n == 3)
        {
            return 4;
        }
        /**
         * 1 1 1 1 1
         * 1 1 1 2
         * 1 1 2 1
         * 1 2 1 1
         * 2 1 1 1
         * 1 2 2
         * 2 2 1
         * 2 1 2
         * 1 1 3
         * 1 3 1
         * 3 1 1
         * 2 3
         * 3 2
         */
        int noOfPerms = 0;
        for (int i = 0; i < n; i++)
        {
            //1,2,3
            int remainder = n;
            // Map<Integer, List<Integer>> ways = new HashMap<>();
            List<List<Integer>> ways = new ArrayList<>();
            List<Integer> way = new ArrayList<>();
            
            for (int stepsTaken = 1; stepsTaken <= 3; stepsTaken++)
            {
                stepsTaken++;
            }
            noOfPerms++;
        }
        return noOfPerms;
    }
    
    public List<Integer> getWay(int n, int stepsTaken)
    {
        List<Integer> way = new ArrayList<>();
        List<List<Integer>> ways = new ArrayList<>();
        int rem = n;
        for (int i = 0; i < n; i++)
        {
            //1
            if (stepsTaken == 1)
            {
                rem -= stepsTaken;
                way.add(stepsTaken);
                
                if (rem == 0)
                {
                    ways.add(way);
                }
            }
            //2
            if (stepsTaken == 2)
            {
                rem -= stepsTaken;
                way.add(stepsTaken);
        
                if(rem<2)
                {
                    way.add(rem);
                    rem=0;
                }
                if (rem == 0)
                {
                    for (int d=0;d<way.size();d++)
                    {
                        way.get(i);
                    }
                    ways.add(way);
                    
                }
            }
            //3
        }
        
        return null;
    }
    
    private static final Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) throws IOException
    {
        // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        
        // int s = scanner.nextInt();
        int s = 1;
        // scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        
        int n = 5;
        // scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        
        int res = stepPerms(n);
        /*if(s<=5)
        {
             for (int sItr = 0; sItr < s; sItr++)
        {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            
            int res = stepPerms(n);
            
            bufferedWriter.write(String.valueOf(res));
            bufferedWriter.newLine();
        }
        }*/
        
        
        // bufferedWriter.close();
        
        scanner.close();
    }
}
