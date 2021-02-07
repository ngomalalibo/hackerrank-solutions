package com.company;

import java.util.Scanner;

public class JavaSubstringComparisons
{
    public static String getSmallestAndLargest(String s, int k)
    {
        String smallest = "";
        String largest = "";
        
        int n = s.length();
        if (!s.chars().allMatch(Character::isLetter))
        {
            System.exit(0);
        }
        if (1 <= n && n <= 1000)
        {
            for (int i = 0; i < n; i++)
            {
                if (i == 0 && k <= n)
                {
                    smallest = s.substring(i, i + k);
                    largest = s.substring(i, i + k);
                }
                
                if (i + k <= n)
                {
                    String substring = s.substring(i, i + k);
                    
                    /**   welcometojava */
                    /**   A < B < C < D < E < a < b < c < d < y < z */
                    if (substring.compareTo(smallest) < 0)
                    {
                        smallest = substring;
                    }
                    if (largest.compareTo(substring) < 0)
                    {
                        largest = substring;
                    }
                    
                }
            }
        }
        else
        {
            System.exit(0);
        }
        
        
        return smallest + "\n" + largest;
    }
    
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        int k = scan.nextInt();
        scan.close();
        
        System.out.println(getSmallestAndLargest(s, k));
    }
}

/*
Sample input
ASDFHDSFHsdlfhsdlfLDFHSDLFHsdlfhsdlhkfsdlfLHDFLSDKFHsdfhsdlkfhsdlfhsLFDLSFHSDLFHsdkfhsdkfhsdkfhsdfhsdfjeaDFHSDLFHDFlajfsdlfhsdlfhDSLFHSDLFHdlfhs
144
* */