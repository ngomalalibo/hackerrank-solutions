package com.company.wallethub;

import java.util.Scanner;

public class Palindrome
{
    public static boolean Palindrome(String str)
    {
        str = str.replaceAll("[^A-Za-z]", "");
        if (str.equals(new StringBuilder(str).reverse().toString()))
        {
            return true;
        }
        return false;
    }
    
    public static void main(String[] args)
    {
        // keep this function call here
        Scanner s = new Scanner("eye");
        System.out.print(Palindrome(s.nextLine()));
    }
}
