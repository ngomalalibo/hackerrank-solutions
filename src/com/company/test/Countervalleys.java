package com.company.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Countervalleys
{
    static int countingValleys(int n, String s)
    {
        if (s == null || s.equals(""))
        {
            System.out.println("String cannot be null or empty");
            System.exit(1);
        }
        // check if no of steps (n) is between 2 and 10^6
        if (n <= 2 && n >= Math.pow(10, 6))
        {
            System.out.println("no of steps (n) should be between 2 and 10^6... ");
            System.exit(1);
        }
        // check if no of steps matches length of string
        if ((n != s.length()))
        {
            System.out.println("No of steps should match length of string");
            System.exit(1);
        }
        int noOfValleys = 0;
        int noOfMountains = 0;
        int fromSeaLevel = 0;
        int starting = 0;
        
        //create arraylist of single characters
        List<Character> ss = new ArrayList<>();
        for (char step : s.toCharArray())
        {
            ss.add(step);
        }
        // exit if string contains characters other than U and D
        ss.stream().filter(step -> !step.equals('U') && !step.equals('D')).findAny().ifPresent(f ->
                                                                                               {
                                                                                                   System.out.println("String must contain only U or D");
                                                                                                   System.exit(1);
                                                                                               });
        for (int i = 0; i < n; i++)
        {
            if (i != 0)
            {
                if (!ss.get(i).equals(ss.get(i - 1)))
                {
                    starting = 0;
                }
            }
            // based on checks increment valleys and mountains at each change of topography // UDDDUDUU
            if (ss.get(i).equals('U'))
            {
                ++fromSeaLevel;
                ++starting;
            }
            else
            {
                --fromSeaLevel;
                ++starting;
            }
            
            //evaluate topography
            //if the next step is downhill and sea level is 0 its a valley
            if (ss.get(i).equals('D'))
            {
                --fromSeaLevel;
                if (i != 0 && fromSeaLevel == 0 && starting > 0)
                {
                    ++noOfMountains;
                }
            }
            //if the next step is uphill and sea level is 0 its a mountain
            else if (ss.get(i).equals('U'))
            {
                ++fromSeaLevel;
                if (i != 0 && fromSeaLevel == 0 && starting > 0)
                {
                    ++noOfValleys;
                }
            }
        }
        
        return noOfValleys;
    }
    
    // private static final Scanner scanner = new Scanner(System.in);
    private static final Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) throws IOException
    {
        int n = 10;
        
        String s = "UDUUUDUDDD";
        
        int result = countingValleys(n, s);
        
        System.out.println("result -> " + result);
        
        scanner.close();
    }
}
