package com.company;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class MinimumSwaps2
{
    // Complete the minimumSwaps function below.
    static int minimumSwaps(int[] arr)
    {
        int minSwaps = 0;
        List<Integer> target = new ArrayList<Integer>();
        Collections.addAll(target, Arrays.stream(arr).boxed().toArray(Integer[]::new));
        for (int i = 0; i < arr.length; i++)
        {
            if (target.get(i) == i + 1)
            {
                continue;
            }
            else
            {
                minSwaps++;
                Collections.swap(target, i, target.get(i) - 1);
                i--;
            }
        }
        
        return minSwaps;
    }
    
    private static final Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) throws IOException
    {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        
        int[] arr = new int[n];
        
        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        
        for (int i = 0; i < n; i++)
        {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }
        
        int res = minimumSwaps(arr);
        
        System.out.println("res -> " + res);
        
        scanner.close();
    }
}
