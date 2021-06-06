package com.company.leetcode;

/**
 * Given a string s, return the number of palindromic substrings in it.
 */
public class PalindromicSubstrings
{
    int count = 0;
    
    public int countSubstrings(String s)
    {
        int leng = s.length();
        
        for (int i = 0; i < leng; i++)
        {
            findPalindrome(i, i, s);
            findPalindrome(i, i + 1, s);
        }
        return count;
    }
    
    public void findPalindrome(int left, int right, String s)
    {
        while ((left >= 0 && right <= s.length() - 1) && (s.charAt(left) == s.charAt(right)))
        {
            ++count;
            --left;
            ++right;
        }
    }
    
    public static void main(String[] args)
    {
        System.out.println(new PalindromicSubstrings().countSubstrings("aaa"));
        System.out.println(new PalindromicSubstrings().countSubstrings("abc"));
    }
}
