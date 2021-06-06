package com.company.leetcode;

/**
 * Given a string s, return the longest palindromic substring in s.
 */
public class LongestPalindromeSubstring
{
    int start = 0, end = 0;
    int longest = 0;
    
    public String longestPalindrome(String s)
    {
        int leng = s.length();
        int left, right;
        
        for (int i = 0; i < leng; i++)
        {
            left = i;
            right = i;
            
            findPalindrome(left, right, s);
            findPalindrome(left, right + 1, s);
        }
        return s.substring(start, end + 1);
    }
    
    public void findPalindrome(int left, int right, String s)
    {
        while ((left >= 0 && right <= s.length() - 1) && (s.charAt(left) == s.charAt(right)))
        {
            --left;
            ++right;
        }
        
        --right;
        ++left;
        if ((right + 1) - left > longest)
        {
            longest = (right + 1) - left;
            start = left;
            end = right;
        }
    }
    
    
    
    
    /*public String longestPalindrome(String s)
    {
        String longest = "";
        int leng = s.length();
        for (int j = leng; j > 0; j--)
        {
            if (j < longest.length())
            {
                break;
            }
            
            int m = 0;
            int n = j;
            while (n <= leng)
            {
                String sub = s.substring(m++, n++);
                if (isPalindrome(sub))
                {
                    longest = sub.length() > longest.length() ? sub : longest;
                    break;
                }
            }
        }
        return longest;
    }
    
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
    }*/
    
    public static void main(String[] args)
    {
        System.out.println(new LongestPalindromeSubstring().longestPalindrome("babad"));
        System.out.println(new LongestPalindromeSubstring().longestPalindrome("a"));
        System.out.println(new LongestPalindromeSubstring().longestPalindrome("cbbd"));
        System.out.println(new LongestPalindromeSubstring().longestPalindrome("ccc"));
        System.out.println(new LongestPalindromeSubstring().longestPalindrome("jglknendplocymmvwtoxvebkekzfdhykknufqdkntnqvgfbahsljkobhbxkvyictzkqjqydczuxjkgecdyhixdttxfqmgksrkyvopwprsgoszftuhawflzjyuyrujrxluhzjvbflxgcovilthvuihzttzithnsqbdxtafxrfrblulsakrahulwthhbjcslceewxfxtavljpimaqqlcbrdgtgjryjytgxljxtravwdlnrrauxplempnbfeusgtqzjtzshwieutxdytlrrqvyemlyzolhbkzhyfyttevqnfvmpqjngcnazmaagwihxrhmcibyfkccyrqwnzlzqeuenhwlzhbxqxerfifzncimwqsfatudjihtumrtjtggzleovihifxufvwqeimbxvzlxwcsknksogsbwwdlwulnetdysvsfkonggeedtshxqkgbhoscjgpiel"));
        System.out.println("*******");
    }
}
