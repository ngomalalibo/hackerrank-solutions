package com.company;

/**
 * This function determines if the braces ('(' and ')') in a    string are properly matched.
 * it ignores non-brace characters.
 * Some examples:
 * "()()()()"   -> true
 * "((45+)*a3)" -> true
 * "(((())())"  -> false
 * ")())()(("  ->  true
 * "23423428"  -> false
 */


public class MatchingBraces
{
    public static boolean isMatching(String text)
    {
        int tracker = Integer.MIN_VALUE;
        char[] chars = text.toCharArray();
        for (char charr : chars)
        {
            if (charr == '(')
            {
                if (tracker == Integer.MIN_VALUE)
                {
                    tracker = 0;
                }
                ++tracker;
            }
            else if (charr == ')')
            {
                if (tracker == Integer.MIN_VALUE)
                {
                    tracker = 0;
                }
                --tracker;
            }
        }
        
        if (tracker == 0)
        {
            return true;
        }
        
        return false;
    }
    
    public static void main(String[] args)
    {
        System.out.println(isMatching("()()()()"));
        System.out.println(isMatching("((45+)*a3)"));
        System.out.println(isMatching("(((())())"));
        System.out.println(isMatching(")())()(("));
        System.out.println(isMatching("23423428"));
    }
}
