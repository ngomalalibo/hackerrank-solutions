package com.company.leetcode;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters
{
    /**
     * Given a string s, find the length of the longest substring without repeating characters.
     */
    
    Set<Character> seen = new HashSet<>();
    int longest = 0;
    
    public int lengthOfLongestSubstring(String s)
    {
        int i = 0;
        int leng = s.length();
        int startPoint = 0;
        while (startPoint < leng)
        {
            char c = s.charAt(i); // i is cursor
            if (seen.contains(c)) // if char exists the end substring. clear set and reset cursor (i).
            {
                checkLongestAndSClearSet();
                seen.add(s.charAt(++startPoint));
                i = startPoint;
            }
            else
            {
                seen.add(c); // add char to substring (set)
            }
            
            if (i == leng - 1) // if end of string then get substring length, clear set, start set from next start point and reset cursor
            {
                checkLongestAndSClearSet();
                if (startPoint == leng - 1)
                {
                   break;
                }
                seen.add(s.charAt(++startPoint));
                i = startPoint;
                continue;
            }
            i++;
        }
        
        return longest;
    }
    
    public void checkLongestAndSClearSet()
    {
        int seenSize = seen.size();
        if (seenSize > longest)
        {
            longest = seenSize;
        }
        seen.clear();
    }
    
    
    public static void main(String[] args)
    {
        System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("abcabcbb"));
        System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring(" "));
        System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("dvdf"));
    }
}
