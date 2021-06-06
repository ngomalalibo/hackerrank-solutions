package com.company.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 */

// stack, dequeue, queue. open and closing brackets/parenthesis
public class ValidParenthesis
{
    public boolean isValid(String s)
    {
        String openBrackets = "([{";
        String closingBrackets = ")]}";
        
        int leng = s.length();
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < leng; i++)
        {
            char c = s.charAt(i);
            if (openBrackets.indexOf(c) != -1)
            {
                stack.push(c);
            }
            else
            {
                if (stack.isEmpty() || !(openBrackets.indexOf(stack.pop()) == closingBrackets.indexOf(c)))
                {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
    
    
    public static void main(String[] args)
    {
        System.out.println(new ValidParenthesis().isValid("()"));
        System.out.println(new ValidParenthesis().isValid("()[]{}"));
        System.out.println(new ValidParenthesis().isValid("(]"));
        System.out.println(new ValidParenthesis().isValid("([)]"));
        System.out.println(new ValidParenthesis().isValid("{[]}"));
        System.out.println(new ValidParenthesis().isValid("["));
        System.out.println(new ValidParenthesis().isValid("]"));
        System.out.println(new ValidParenthesis().isValid("[({])}"));
    }
}
