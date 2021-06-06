package com.company.leetcode;

public class ValidPalindrome
{
    /** Given a string s, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases. */
    public boolean isPalindrome(String s)
    {
        s = s.toLowerCase().replaceAll("[^a-z0-9]", "");
        for (int i = 0, j = s.length() - 1; i <= j; i++, j--)
        {
            if (s.charAt(i) != s.charAt(j))
            {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args)
    {
        System.out.println(new ValidPalindrome().isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(new ValidPalindrome().isPalindrome("race a car"));
        System.out.println(new ValidPalindrome().isPalindrome("a"));
    }
}
