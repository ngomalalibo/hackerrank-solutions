package com.company.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordBreak
{
    private HashMap<String, Boolean> memo;
    
    public boolean wordBreak(String s, List<String> wordDict)
    {
        //Hashmap for memoization
        memo = new HashMap<String, Boolean>();
        //We know that ,if string is empty ,return true
        memo.put("", true);
        //Start Depth-first-Search
        return recur(s, wordDict);
    }
    
    private boolean recur(String s, List<String> dictionary)
    {
        //If given string is already computed,then return stored result
        if (memo.containsKey(s))
        {
            return memo.get(s);
        }
        //Variable to store result
        boolean res = false;
        //For every word in Dictionary,check if the word is prefix of input string
        for (String word : dictionary)
        {
            if (s.startsWith(word))
            {
                //If you find string can be broken ,then stop searching
                if (recur(s.substring(word.length()), dictionary))
                {
                    res = true;
                    break;
                }
            }
        }
        //Store result to prevent same computations in future
        memo.put(s, res);
        return res;
    }
    
    public static void main(String[] args)
    {
        System.out.println(new WordBreak().wordBreak("leetcode", Arrays.asList("leet", "code")));
        System.out.println(new WordBreak().wordBreak("applepenapple", Arrays.asList("apple", "pen")));
        System.out.println(new WordBreak().wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat")));
        System.out.println(new WordBreak().wordBreak("cars", Arrays.asList("car", "ca", "rs")));
        System.out.println(new WordBreak().wordBreak("aaaaaaa", Arrays.asList("aaa", "aaaa")));
    }
}
