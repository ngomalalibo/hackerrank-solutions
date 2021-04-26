package com.company.leetcode;

public class NumberOf1Bits
{
    // both methods work
    /*public int hammingWeight(int n)
    {
        int count = 0;
        for (int i = 0; i < 32; i++)
        {
            // System.out.println(Integer.toBinaryString(n));
            if ((n & 1) == 1)
            {
                count++;
            }
            n = n >> 1;
            if (Integer.toBinaryString(n).equals("0"))
            {
                break;
            }
        }
        return count;
    }*/
    
    public int hammingWeight(int n)
    {
        int ans=0;
        while(n!=0)
        {
            System.out.println(Integer.toBinaryString(n));
            ans++;
            n=n&(n-1);
        }
        return ans;
    }
    
    public static void main(String[] args)
    {
        int n = 011011;
        System.out.println(new NumberOf1Bits().hammingWeight(n));
    }
}
