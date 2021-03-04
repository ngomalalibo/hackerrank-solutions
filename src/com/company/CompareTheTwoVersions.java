package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CompareTheTwoVersions
{
    
    public static int compare(String version1, String version2)
    {
        String[] s1 = version1.split("\\.");
        String[] s2 = version2.split("\\.");
        
        int[] num1 = new int[s1.length];
        int[] num2 = new int[s2.length];
        
        for (int i = 0; i < s1.length; i++)
        {
            num1[i] = Integer.parseInt(s1[i]);
        }
        for (int i = 0; i < s2.length; i++)
        {
            num2[i] = Integer.parseInt(s2[i]);
        }
        System.out.println(Arrays.toString(num1));
        System.out.println(Arrays.toString(num2));
        if (num1.length > num2.length)
        {
            int[] temp = new int[num1.length];
            System.arraycopy(num2, 0, temp, 0, num2.length);
            num2 = temp;
        }
        else if (num1.length < num2.length)
        {
            int[] temp = new int[num2.length];
            System.arraycopy(num1, 0, temp, 0, num1.length);
            num1 = temp;
        }
        
        for (int i = 0; i < num1.length; i++)
        {
            if (num1[i] > num2[i] && i == 0)
            {
                return 1;
            }
            else if (num1[i] < num2[i] && i == 0)
            {
                return -1;
            }
            else if (num1[i] == num2[i] /*&& i > 0*/ && i == num1.length-1)
            {
                return 0;
            }
            else if (num1[i] > num2[i])
            {
                return 1;
            }
            else if (num1[i] < num2[i])
            {
                return -1;
            }
        }
        return 0;
    }
    
    public static void main(String[] args) throws IOException
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        
        String version1 = bufferedReader.readLine();
        
        String version2 = bufferedReader.readLine();
        
        int result = compare(version1, version2);
        System.out.println(result);
        
    }
}
