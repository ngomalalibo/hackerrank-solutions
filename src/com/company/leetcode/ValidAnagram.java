package com.company.leetcode;

import java.util.Arrays;

public class ValidAnagram
{
    public boolean isAnagram(String s, String t)
    {
        char[] sc = s.toCharArray();
        Arrays.sort(sc);
        char[] tc = t.toCharArray();
        Arrays.sort(tc);
        return Arrays.equals(sc, tc);
    }
    
    public static void main(String[] args)
    {
        System.out.println(new ValidAnagram().isAnagram("anagram", "nagaram"));
        System.out.println(new ValidAnagram().isAnagram("rat", "car"));
    }
}
