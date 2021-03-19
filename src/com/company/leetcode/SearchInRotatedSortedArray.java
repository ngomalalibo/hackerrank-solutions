package com.company.leetcode;

public class SearchInRotatedSortedArray
{
    public int search(int[] arr, int target)
    {
        int leng = arr.length;
        
        for (int i = 0; i < leng; i++)
        {
            if (arr[i] == target)
            {
                return i;
            }
        }
        return -1;
    }
    
    public static void main(String[] args)
    {
        int[] arr = new int[]{4, 5, 6, 7, 0, 1, 2};
        int target = 2;
        System.out.println(new SearchInRotatedSortedArray().search(arr, target));
    }
}



/* // was taking a really long route
public int search(int[] arr, int target)
    {
        // 4,5,6,7,0,1,2
        // 4,5,6,7,0
        int index = -1;
        
        int leng = arr.length;
        int mid;
        int start = 0;
        int end = leng - 1;
        int pivot = -1;
        int startValue = arr[start];
        int endValue = arr[end];
        
        if (start == end)
        {
            return arr[start] == target ? start : -1;
        }
        else if (end - start == 1)
        {
            if (arr[start] == target)
            {
                return start;
            }
            else if (arr[end] == target)
            {
                return end;
            }
            else
            {
                return -1;
            }
        }
        else if (end-start == 2)
        {
            if(arr[start]==target)
            {
                return start;
            }
            if(arr[start+1]==target)
            {
                return start+1;
            }
            if (arr[end]==target)
            {
                return end;
            }
            return -1;
        }
        
        if (endValue < startValue) // moved array
        {
            while (start < end)  // binary search for pivot point
            {
                endValue = arr[end];
                mid = (start + end) / 2;
                if (arr[mid] > arr[mid + 1])
                {
                    pivot = mid;
                    break;
                }
                else if (endValue < arr[mid])
                {
                    start = mid;
                }
                else
                {
                    end = mid;
                }
            }
        }
        
        start = 0;
        end = leng - 1;
        
        if (pivot != -1)
        {
            // Pivot point splits array into 2 sorted arrays. Choose sub array to search for target
            if (arr[pivot] == target)
            {
                return pivot;
            }
            else if (arr[pivot] > target && target <= arr[end])
            {
                start = pivot + 1;
            }
            else if (arr[pivot] > target && target > arr[end])
            {
                end = pivot;
            }
        }
        
        while (start < end )
        {
            mid = (start + end) / 2;
            if (arr[mid] == target)
            {
                return mid;
            }
            else if (arr[mid] < target)
            {
                start = mid;
            }
            else
            {
                end = mid;
            }
            if (mid != leng - 1 && arr[mid + 1] == target)
            {
                return mid + 1;
            }
            else if (mid != 0 && arr[mid - 1] == target)
            {
                return mid - 1;
            }
        }
        
        return index;
    }
*/
