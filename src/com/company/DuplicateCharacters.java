package com.company;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DuplicateCharacters
{
    public static void dupCharacters(String s)
    {
        /**  */
        s = s.toLowerCase();
        char[] ch = s.toCharArray();
        Arrays.sort(ch);
        Set<Character> distinctChars = new HashSet<>();
        s = String.valueOf(ch);
        
        for (int i = 0; i < s.length() - 1; i++)
        {
            if (s.charAt(i) == s.charAt(i + 1))
            {
                distinctChars.add(s.charAt(i));
            }
        }
        System.out.println(distinctChars.toString());
    }
    
    
    public static void main(String[] args)
    {
        dupCharacters("Madam");
    }
}
