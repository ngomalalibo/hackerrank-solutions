package com.company;

import java.util.LinkedList;

public class StackPalindrome
{
    public static boolean palindrome(String s)
    {
        s = s.toLowerCase();
        LinkedList<Character> stack = new LinkedList<>();
        StringBuilder sb = new StringBuilder(s.length());
        
        for (int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            if (c >= 'a' && c <= 'z')
            {
                if (Character.isLowerCase(c))
                {
                    sb.append(c);
                    stack.push(c);
                }
            }
        }
        
        StringBuilder sr = new StringBuilder(s.length());
        while (!stack.isEmpty())
        {
            sr.append(stack.pop());
        }
        return sb.toString().equals(sr.toString());
        
    }
    
    public static void main(String[] args)
    {
        System.out.println(palindrome("hello"));
        System.out.println(palindrome("racecar"));
        System.out.println(palindrome("abccba"));
        System.out.println(palindrome("I did, did I?"));
        System.out.println(palindrome("Don't nod"));
        System.out.println(palindrome("Was it a car or a cat I saw?"));
    }
}
