package com.company;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SherlockAndTheValidString
{
    
    
    static String isValid(String s)
    {
        char[] sc = s.toCharArray();
        Arrays.sort(sc);
        s = String.valueOf(sc);
        
        boolean valid = true;
        int counter = 0;
        Integer requiredLength = Integer.MIN_VALUE;
        
        Map<Character, Integer> charToLength = new HashMap<>();
        Map<Integer, Integer> lengthToOccurrence = new HashMap<>();
        for (Character c : s.toCharArray())
        {
            charToLength.merge(c, 1, Integer::sum);
        }
        
        // map freq to Occurrence
        for (Character c : charToLength.keySet())
        {
            lengthToOccurrence.merge(charToLength.get(c), 1, Integer::sum);
        }
        
        int maxOccurringLength = lengthToOccurrence.values().stream().mapToInt(d -> d).max().orElse(0);
        
        // use maxOccurringLength to find length. Use length to get requireLength
        for (Integer i : lengthToOccurrence.keySet())
        {
            if (lengthToOccurrence.get(i).equals(maxOccurringLength))
            {
                if (i > requiredLength)
                {
                    requiredLength = i;
                }
            }
        }
        
        Map<Character, Integer> charToLengthClone = new HashMap<>(charToLength);
        
        for (Character c : charToLength.keySet())
        {
            if (charToLength.get(c).equals(requiredLength))
            {
                charToLengthClone.remove(c);
            }
        }
        
        for (Character c : charToLengthClone.keySet())
        {
            int i = 0;
            if (charToLengthClone.get(c) > requiredLength)
            {
                i = charToLengthClone.get(c) - requiredLength;
                counter += i;
            }
            else
            {
                i = charToLengthClone.get(c) % requiredLength;
                counter += i;
            }
            
            if (counter > 1)
            {
                valid = false;
                break;
            }
            
        }
        
        return valid ? "YES" : "NO";
    }
    
    private static final Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) throws IOException
    {
        String s = scanner.nextLine();
        
        String result = isValid(s);
        System.out.println(result);
        
        scanner.close();
    }
}
