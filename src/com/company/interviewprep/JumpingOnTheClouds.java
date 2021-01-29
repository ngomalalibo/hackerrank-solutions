package com.company.interviewprep;

import java.io.IOException;
import java.util.Scanner;

public class JumpingOnTheClouds
{
    static int jumpingOnClouds(int[] c)
    {
        int n = c.length;
        int jumps = 0;
        // Map<Integer, Integer> clouds = new HashMap<>();
        for (int i = 0; i < n; i++)
        {
            if (c[i] != 0 && c[i] != 1)
            {
                System.exit(0);
            }
        }
        if (1 <= n && n <= 100)
        {
            // for (int i = 0; i < c.length; i++)
            // {
            //     clouds.put(i, c[i]);
            // }
            /** 0 0 1 0 0 1 0 */
            /** 0 0 0 1 0 0 */
            for (int i = 0; i < c.length; i++)
            {
                if (c[i] == 0)
                {
                    if (i + 2 < c.length)
                    {
                        if (c[i] == c[i + 2])
                        {
                            ++jumps;
                            i++;
                            continue;
                        }
                    }
                    if (i + 1 < c.length)
                    {
                        if (c[i] == c[i + 1])
                        {
                            ++jumps;
                        }
                    }
                }
            }
        }
        
        
        return jumps;
    }
    
    private static final Scanner scanner = new Scanner("0 0 1 0 0 1 0");
    
    public static void main(String[] args) throws IOException
    {
        int n = 7;
        
        
        int[] c = new int[n];
        
        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        
        for (int i = 0; i < n; i++)
        {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }
        
        int result = jumpingOnClouds(c);
        
        System.out.println("jumps --> " + result);
        
        scanner.close();
    }
}
