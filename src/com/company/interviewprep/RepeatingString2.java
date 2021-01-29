package com.company.interviewprep;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RepeatingString2
{
    static long repeatedString(String s, long n)
    {
        long aCount = 0;
        long factor = 0;
        int testCase = 0;
        
        if (1 <= s.length() && s.length() <= 100 && 1 <= n && n <= Math.pow(10, 12))
        {
            int sl = s.length();
            
            List<Character> sc = new ArrayList<>();
            for (char c : s.toCharArray())
            {
                sc.add(c);
            }
            // aCount = sc.stream().filter(c -> c.equals('a')).count();
            
            long rem = n % sl;
            if (n < sl)
            {
                for (int i = 0; i < n; i++)
                {
                    if (sc.get(i).equals('a'))
                    {
                        ++aCount;
                    }
                }
            }
            else if (n >= sl)
            {
                aCount = sc.stream().filter(c -> c.equals('a')).count();
                if (rem != 0)
                {
                    factor = (long) Math.floor(n / sl);
                    aCount = aCount * factor;
                    for (int i = 0; i < rem; i++)
                    {
                        if (sc.get(i).equals('a'))
                        {
                            ++aCount;
                        }
                    }
                }
                else
                {
                    factor = (long) Math.floor(n / sl);
                    aCount = aCount * factor;
                }
                
            }
            
            
        }
        
        return aCount;
        
    }
    
    private static final Scanner scanner = new Scanner("ababa");
    
    public static void main(String[] args) throws IOException
    {
        String s = scanner.nextLine();
        
        long n = 3L;
        
        long result = repeatedString(s, n);
        System.out.println("count --> " + result);
        
        scanner.close();
    }
}
