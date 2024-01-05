package com.company.remoteworkprep2024;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NonAdjacentCharacters
{
    // get the list of words
    // iterate through each word
    // check each letter in the word to ensure adjacent chars are not the same  while checking leng of scring is not reached
    // change adjacent chars that are and update array count
    
    public static List<Integer> matchingCharacters(List<String> words)
    {
        int size = words.size();
        List<Integer> result = new ArrayList<Integer>(size);
        
        for (int i = 0; i < size; i++)
        {
            result.add(0);
        }
        
        for (int j = 0; j < size; j++)
        {
            String word = words.get(j);
            int leng = word.length();
            for (int i = 0; i < leng - 1; i++)
            {
                char cAti = word.charAt(i);
                char cAtiPlus1 = word.charAt(i + 1);
                if (cAti == cAtiPlus1)
                {
                    // if equal change next char adjust char before changing word
                    if (i <= leng - 3)
                    {
                        char cAtiPlus2 = word.charAt(i + 2);
                        char newChar = ++cAtiPlus1;
                        if (cAtiPlus1 == cAtiPlus2)
                        {
                            word = word.substring(0, i + 1) + ++newChar + word.substring(i + 2);
                        }
                    }
                    word = word.substring(0, i + 1) + ++cAtiPlus1 + word.substring(i + 2);
                    
                    result.set(j, result.get(j) + 1);
                }
            }
        }
        
        return result;
    }
    
    private static List<Integer> getMinChanges(List<String> words)
    {
        
        List<Integer> result = new ArrayList<>();
        
        for (String word : words)
        {
            int replacement = 0;
            
            char[] charArray = word.toCharArray();
            int changes = 0;
            
            for (int i = 1; i < charArray.length; i++)
            {
                if (charArray[i] == charArray[i - 1])
                {
                    // Replace one of the adjacent matching characters with a different one
                    charArray[i] = 'X'; // You can use any character other than the matching one
                    changes++;
                }
            }
            
            result.add(changes);
        }
        
        
        return result;
    }
    
    public static List<Integer> minimalOperations(List<String> words)
    {
        List<Integer> result = new ArrayList<>();
        
        for (String word : words)
        {
            int replacements = 0;
            
            for (int i = 1; i < word.length(); i++)
            {
                if (word.charAt(i) == word.charAt(i - 1))
                {
                    replacements++;
                    i++;
                }
            }
            
            result.add(replacements);
        }
        
        return result;
    }
    
    public static void main(String[] args)
    {
        List<String> words = List.of("add", "boook", "break", "ab", "abab", "aab", "abb", "abaaaba");
        // List<String> words = List.of("add", "boook", "break");
        System.out.println(matchingCharacters(words));
        System.out.println(minimalOperations(words));
        System.out.println(getMinChanges(words));
        
    }
}
