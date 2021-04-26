package com.company.wallethub;

import java.util.Scanner;

public class LongestString
{
    public static String LongestWord(String sen)
    {
        sen = sen.replaceAll("[^A-Za-z0-9\\s_]", "");
        String [] words = sen.split("\\s+");
        String longest=words[0];
        for(String ss : words)
        {
            if(longest.length()<ss.length())
            {
                longest = ss;
            }
        }
        return longest;
    }
    
    public static void main(String[] args)
    {
        // keep this function call here
        Scanner s = new Scanner("fun&!! time");
        System.out.print(LongestWord(s.nextLine()));
    }
}
