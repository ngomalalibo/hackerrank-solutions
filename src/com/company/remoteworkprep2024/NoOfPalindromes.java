package com.company.remoteworkprep2024;

import java.util.HashSet;
import java.util.Set;

public class NoOfPalindromes
{
    public static int palindrome(String s)
    {
        Set<String> palindromes = new HashSet<>();
        
        int length = s.length();
        
        // increment palindrome length until length of string
        for (int palLeng = 1; palLeng < length; palLeng++)
        {
            // increment start of palindrome across string
            for (int i = 0; i <= length - palLeng; i++)
            {
                // check for palindrome
                String subString = s.substring(i, i + palLeng);
                
                System.out.println("subString = " + subString);
                // iterate through string from start and end checking equality of each character until middle of string
                int subLength = subString.length();
                for (int j = 0, k = subLength; j <= k; j++, k--)
                {
                    char charAtJ = subString.charAt(j);
                    if (palLeng == 1)
                    {
                        palindromes.add(subString.substring(j, j + 1));
                        continue;
                    }
                    
                    char charAtk = subString.charAt(k - 1);
                    if (charAtJ != charAtk)
                    {
                        break;
                    }
                    if (j == k)
                    {
                        palindromes.add(subString);
                        break;
                    }
                }
            }
        }
        
        
        return palindromes.size();
    }
    
    public static void main(String[] args)
    {
        System.out.println(palindrome("mokkori"));
    }
}
