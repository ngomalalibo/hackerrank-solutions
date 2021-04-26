package com.company;

import java.util.Arrays;

public class CountingBits
{
    public int[] countBits(int num)
    {
        int[] noOfOnes = new int[num+1];
        
        for (int i = 0; i <= num; i++)
        {
            int j = i;
            int ans = 0;
            while (j != 0)
            {
                ans++;
                j = j & (j - 1);
            }
            /*for (int k = 0; k < 32; k++)
            {
                // System.out.println(Integer.toBinaryString(n));
                if ((j & 1) == 1)
                {
                    ans++;
                }
                j = j >> 1;
                if (Integer.toBinaryString(j).equals("0"))
                {
                    break;
                }
            }*/
            noOfOnes[i] = ans;
        }
        return noOfOnes;
    }
    
    public static void main(String[] args)
    {
        System.out.println(Arrays.toString(new CountingBits().countBits(2)));
    }
}
