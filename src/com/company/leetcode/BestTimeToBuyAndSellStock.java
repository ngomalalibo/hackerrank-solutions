package com.company.leetcode;

public class BestTimeToBuyAndSellStock
{
    // practice solved
    public static int maxProfit(int[] prices)
    {
        // get min_marker
        
        int min = Integer.MAX_VALUE;
        int maxProfit = 0;
        int leng = prices.length;
        for (int i = 0; i < leng; i++)
        {
            if (prices[i] < min)
            {
                min = prices[i];
            }
            int diff = prices[i] - min;
            maxProfit = Math.max(maxProfit, diff);
        }
        // 1, 3, 5
        return maxProfit;
    }
    
    /**
     * [7,1,5,3,6,4]       [7,6,4,3,1]
     */
    /*public static int maxProfit(int[] prices)
    {
        int min = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++)
        {
            if(prices[i]< min)
            {
                min = prices[i];
            }
            
            int diff = prices[i]-min;
            if(maxProfit<diff)
            {
                maxProfit = diff;
            }
        }
        return maxProfit;
    }*/
    
    /*public static int maxProfit(int[] prices)
    {
        int low = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++)
        {
            maxProfit = Math.max(maxProfit, prices[i] - low); // current price - lowest price in the past. Compare result with maxProfit
            low = Math.min(low, prices[i]); // set lowest price seen
        }
        return maxProfit;
    }*/
    public static void main(String[] args)
    {
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));
    }
}
