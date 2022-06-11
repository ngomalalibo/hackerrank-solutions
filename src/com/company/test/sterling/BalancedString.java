package com.company.test.sterling;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BalancedString
{
    public static int BalancedString(String S)
    {//ABfaF
        //this is default OUTPUT. You can change it.
        int result = 0;
        int leng = S.length();
        
        List<Character> sett = new ArrayList<>();
        
        for (int i = 0; i < leng; i++)
        {
            sett.add(S.charAt(i));
        }
        for (int i = 0; i < leng; i++)
        {
            char c = S.charAt(i);
            if (Character.isUpperCase(c))
            {
                if (!sett.contains(Character.toLowerCase(c)))
                {
                    result++;
                }
            }
            else if (Character.isLowerCase(c))
            {
                if (!sett.contains(Character.toUpperCase(c)))
                {
                    result++;
                }
            }
        }
        
        return result;
    }
    
    // executes windows program. Noteapd
    /*public static void main(String[] args)
    {
        try
        {
            Runtime.getRuntime().exec("notepad");
        }
        catch (Exception e)
        {
        
        }
    }*/
    
    static public void main(String[] args)
    {
        // INPUT [uncomment & modify if required]
        //xdUKBqscHOpriG
        //
        Scanner sc = new Scanner("xqdQWnUKBqNscwHOpriG");
        String S = sc.next();
        
        // OUTPUT [uncomment & modify if required]
        System.out.print(BalancedString(S));
        sc.close();
    }
}
