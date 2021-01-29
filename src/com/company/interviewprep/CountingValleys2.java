package com.company.interviewprep;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CountingValleys2
{
    private static int countingValleys(int n, String s)
    {
        int seaLevel = 0;
        int noOfValleys = 0;
        int noOfMountains = 0;
        int tracker = 0;
        
        if (n != s.length())
        {
            System.out.println("n and s should match");
            System.exit(0);
        }
        
        List<Character> steps = new ArrayList<>();
        if (2 <= n && n <= Math.pow(10, 6))
        {
            for (char c : s.toCharArray())
            {
                if (c != 'U' && c != 'D')
                {
                    System.out.println("string should contain U or D only");
                    System.exit(0);
                }
                steps.add(c);
            }
            for (int i = 0; i < s.length(); i++)
            {
                
                if (steps.get(i).equals('U'))
                {
                    ++seaLevel;
                    
                    if (tracker > 0 && seaLevel == 0)
                    {
                        ++noOfValleys;
                        tracker = 0;
                    }
                    ++tracker;
                }
                else if (steps.get(i).equals('D'))
                {
                    --seaLevel;
                    if (tracker > 0 && seaLevel == 0)
                    {
                        ++noOfMountains;
                        tracker = 0;
                    }
                    ++tracker;
                }
            }
        }
        else
        {
            System.out.println("n should be within range");
            System.exit(0);
        }
        
        return noOfValleys;
    }
    
    private static final Scanner scanner = new Scanner("UDDDUDUU");
    
    public static void main(String[] args) throws IOException
    {
        int n = 8;
        
        String s = scanner.nextLine();
        
        int result = countingValleys(n, s);
        
        System.out.println("valleys --> " + result);
        
        scanner.close();
    }
    
    
}
