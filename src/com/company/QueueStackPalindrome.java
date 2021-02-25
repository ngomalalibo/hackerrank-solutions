package com.company;

import java.util.LinkedList;

public class QueueStackPalindrome
{
    public static boolean palindrome(String s)
    {
        s = s.toLowerCase();
        LinkedList<Character> stack = new LinkedList<>();
        LinkedList<Character> queue = new LinkedList<>();
        
        for (int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            if (c >= 'a' && c <= 'z')
            {
                if (Character.isLowerCase(c))
                {
                    queue.add(c);
                     stack.push(c);
                }
            }
        }
        
        while (!queue.isEmpty())
        {
            if(!queue.poll().equals(stack.pop()))
            {
                return false;
            }
        }
        return true;
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
