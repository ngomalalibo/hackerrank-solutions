package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//Palindrome
public class SimplePasswordToRemember
{
    public static boolean isSimplePasscode(String pwd)
    {
        char[] c = pwd.toCharArray();
        // for (int i=0;i<pwd.length();i++)
        int leng = pwd.length();
        int i = 0;
        int j = leng - 1;
        
        while (i <= j)
        {
            /** 1234321 12344321*/
            if (pwd.charAt(i++) != pwd.charAt(j--))
            {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) throws IOException
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        
        String pwd = bufferedReader.readLine();
        
        boolean result = isSimplePasscode(pwd);
        
        System.out.println(result);
    }
}
