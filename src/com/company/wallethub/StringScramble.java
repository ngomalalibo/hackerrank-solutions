package com.company.wallethub;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class StringScramble
{
    public static String StringScramble(String str1, String str2) {
        // convert strings to characters, sort them . check if 1 contains 2
        List<Character> ch1 = Arrays.asList(str1.chars().mapToObj(c -> (char) c).toArray(Character[]::new));
        List<Character> ch2 = Arrays.asList(str2.chars().mapToObj(c -> (char) c).toArray(Character[]::new));
        if(ch1.containsAll(ch2))
        {
            return "true";
        }
        
        return "false";
    }
    
    public static void main (String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        String s1 = "rkqodlw";
        String s2 = "world";
        
        System.out.print(StringScramble(s1,s2));
    }
}
