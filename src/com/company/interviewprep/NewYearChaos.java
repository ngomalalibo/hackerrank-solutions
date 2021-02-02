package com.company.interviewprep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class NewYearChaos
{
    static boolean isValid(int[] q)
    {
        return Arrays.stream(q).min().getAsInt() == 1 && Arrays.stream(q).max().getAsInt() == q.length
                && Arrays.stream(q).distinct().count() == q.length;
    }
    
    static int minimumBribes(int[] q)
    {
        if (!isValid(q))
        {
            return -1;
        }
        
        int swapNum = 0;
        ArrayList<Integer> target = new ArrayList<>(Arrays.stream(q).sorted().boxed().collect(Collectors.toList()));
        /**
         * 5 1 2 3 7 8 6 4
         * 1 2 5 3 7 8 6 4
         * */
        for (int number : q)
        {
            int index = target.indexOf(number);
            if (index >= 3)
            {
                return -1;
            }
            
            swapNum += index;
            target.remove(index);
        }
        return swapNum;
    }
    
    private static final Scanner scanner = new Scanner(System.in);
    
    
    public static void main(String[] args)
    {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        
        if (1 <= t && t <= 10)
        {
            for (int tItr = 0; tItr < t; tItr++)
            {
                int n = scanner.nextInt();
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
                
                if (1 <= n && n <= Math.pow(10, 5))
                {
                    int[] q = new int[n];
                    
                    String[] qItems = scanner.nextLine().split(" ");
                    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
                    
                    for (int i = 0; i < n; i++)
                    {
                        int qItem = Integer.parseInt(qItems[i]);
                        q[i] = qItem;
                    }
                    int solution = minimumBribes(q);
                    System.out.println(solution >= 0 ? solution : "Too chaotic");
                }
                else
                {
                    System.exit(0);
                }
                
                
            }
        }
        
        
        scanner.close();
    }
}
