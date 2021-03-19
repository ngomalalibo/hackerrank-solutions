package com.company.leetcode;

public class ContainerWithMostWater
{
    
    public int maxArea(int[] height)
    {
        int maxArea = Integer.MIN_VALUE;
        int area;
        int j = 0; // left cursor
        int k = height.length - 1; // right cursor
        
        while (j < k) // calculate area for heights and distance
        {
            area = (k - j) * Math.min(height[j], height[k]);
            if (area > maxArea)
            {
                maxArea = area;
            }
            if (height[j] > height[k])
            {
                k--;
            }
            else
            {
                j++;
            }
        }
        return maxArea;
    }
   /* public int maxArea(int[] height)
    {
        int j = 0;
        int k = height.length - 1;
        int maxArea = 0;
        
        while (j != k)
        {
            int area = (k - j) * Math.min(height[j], height[k]);
            if (area > maxArea)
            {
                maxArea = area;
            }
            if (height[j] > height[k])
            {
                k--;
            }
            else
            {
                j++;
            }
        }
        return maxArea;
    }*/
    
    public static void main(String[] args)
    {
        int[] arr = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        // int[] arr = new int[]{4, 3, 2, 1, 4};
        
        System.out.println(new ContainerWithMostWater().maxArea(arr));
    }
}
