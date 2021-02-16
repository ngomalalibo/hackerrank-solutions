package com.company;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AlternatingCharacters
{
    static int alternatingCharacters(String s)
    {
        int noOfDeletions = 0;
        Character prevChar = null;
        int ctr = 0;
        
        Map<Character, Integer> letterFreq = new HashMap<>();
        for (Character c : s.toCharArray())
        {
            // short for copying into map.
            letterFreq.merge(c, 1, Integer::sum);
        }
        if (letterFreq.get('B') == null)
        {
            noOfDeletions = letterFreq.get('A') - 1;
        }
        else if (letterFreq.get('A') == null)
        {
            noOfDeletions = letterFreq.get('B') - 1;
        }
        else if (letterFreq.get('A') != null && letterFreq.get('B') != null)
        {
            for (int i = 0; i < s.length(); i++)
            {
                if (prevChar != null && s.charAt(i) == prevChar)
                {
                    ++ctr;
                    // close loop technique
                    if (i == s.length() - 1)
                    {
                        noOfDeletions += ctr;
                        ctr = 0;
                    }
                }
                else
                {
                    noOfDeletions += ctr;
                    ctr = 0;
                }
                prevChar = s.charAt(i);
            }
        }
        
        return noOfDeletions;
        
    }
    
    private static final Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) throws IOException
    {
        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        
        for (int qItr = 0; qItr < q; qItr++)
        {
            String s = scanner.nextLine();
            
            int result = alternatingCharacters(s);
            System.out.println(result);
        }
        
        scanner.close();
    }
}
