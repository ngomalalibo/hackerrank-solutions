package com.company.leetcode;

import java.util.*;

public class LongestRepeatingCharacterReplacement
{
    /**
     * You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.
     * <p>
     * Return the length of the longest substring containing the same letter you can get after performing the above operations.
     */
    
    public int characterReplacement(String s, int k)
    {
        int longest = 0;
        int leng = s.length();
        Set<Character> distinct = new HashSet<>(Arrays.asList(s.chars().mapToObj(d -> (char) d).toArray(Character[]::new)));
        for(char cur : distinct)
        {
            int l=0;
            int left = 0;
            int right = 0;
            
            for (right = 0; right < leng; right++)
            {
                if (s.charAt(right) != cur)
                {
                    if (l >= k)
                    {    // not enough times to replace
                        while (left < leng && s.charAt(left) == cur)
                        {
                            left++;    // find the leftmost different character
                        }
                        left++;    // and move left index rightward by one
                    }
                    l++;
                }
                longest = Math.max(longest, right - left);
            }
        }
        return longest + 1;
    }
    
    /* WORKS. not performant
    public int characterReplacement(String s, int k)
    {
        int leng = s.length();
        int longest = 0;
        int counter = 0;
        
        */
    
    /**
     * ABAB     AABABBA     AABBBB 1     AABA     ABAA
     *//*
        Set<Character> distinct = new HashSet<>(Arrays.asList(s.chars().mapToObj(d -> (char) d).toArray(Character[]::new)));
        
        for (char c : distinct) // pick existing character
        {
            int j = 0;
            while (j < leng)
            {
                int l = 0;
                for (int i = j; i < leng; i++)
                {
                    if (s.charAt(i) == c)
                    {
                        ++counter;
                    }
                    else if (l < k)
                    {
                        ++counter;
                        l++;
                    }
                    else
                    {
                        int r=i;
                        while (r < leng && s.charAt(r) == c)
                        {
                            counter++;
                            r++;
                        }
                        longest = Math.max(longest, counter);
                        counter = 0;
                        break;
                    }
                    if (i == leng -1)
                    {
                        longest = Math.max(longest, counter);
                        counter = 0;
                    }
                }
                j++;
            }
        }
        
        return longest;
    }*/
    public static void main(String[] args)
    {
        System.out.println(new LongestRepeatingCharacterReplacement().characterReplacement("ABAB", 2));
        System.out.println(new LongestRepeatingCharacterReplacement().characterReplacement("AABABBA", 1));
        System.out.println(new LongestRepeatingCharacterReplacement().characterReplacement("AABBBB", 1));
        System.out.println(new LongestRepeatingCharacterReplacement().characterReplacement("AABA", 0));
        System.out.println(new LongestRepeatingCharacterReplacement().characterReplacement("ABAA", 0));
    }
}
