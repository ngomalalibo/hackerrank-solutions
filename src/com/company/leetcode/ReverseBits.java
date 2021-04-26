package com.company.leetcode;

import java.text.NumberFormat;

public class ReverseBits
{
    public int reverseBits(int n)
    {
        int ans = 0;
        for (int i = 0; i < 32; i++)
        {
            ans <<= 1;
            ans = (n & 1) | ans;
            n >>= 1;
        }
        return ans;
    }
    
    public static void main(String[] args)
    {
        System.out.println(new ReverseBits().reverseBits(0010));
    }
}
