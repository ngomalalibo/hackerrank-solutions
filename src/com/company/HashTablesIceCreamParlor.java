package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HashTablesIceCreamParlor
{
    // Complete the whatFlavors function below.
    static void whatFlavors(int[] cost, int money)
    {
        int leng = cost.length;
        
        Map<Integer, Integer> costIndexMap = new HashMap<>();
        for (int i = 0; i < leng; i++) // put array into map of options to cost
        {
            if (cost[i] < money) // eliminate over budget icecream
            {
                // already added index of first purchase. i is index of second purchase. Because we only need a second cost a map works even if costs are the same. We only need one added to the map
                if (costIndexMap.containsKey(money - cost[i])) // containskey is use effeciently here. It means the map does not have to be filled
                {
                    int index = costIndexMap.get(money - cost[i]);
                    System.out.println((index + 1) + " " + (i + 1));
                    break;
                }
                costIndexMap.put(cost[i], i);
            }
        }
    }
    
    private static final Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args)
    {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        
        for (int tItr = 0; tItr < t; tItr++)
        {
            int money = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            
            int[] cost = new int[n];
            
            String[] costItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            
            for (int i = 0; i < n; i++)
            {
                int costItem = Integer.parseInt(costItems[i]);
                cost[i] = costItem;
            }
            
            whatFlavors(cost, money);
        }
        
        scanner.close();
    }
    
    
    
    /* Passed all test cases
    static void whatFlavors(int[] cost, int money)
    {
        int leng = cost.length;
        
        Map<Integer, Integer> costIndexMap = new HashMap<>();
        for (int i = 0; i < leng; i++) // put array into map of options to cost
        {
            if (cost[i] < money) // eliminate over budget icecream
            {
                // already added index of first purchase. i is index of second purchase. Because we only need a second cost a map works even if costs are the same. We only need one added to the map
                if (costIndexMap.containsKey(money - cost[i]))
                {
                    int index = costIndexMap.get(money - cost[i]);
                    System.out.println((index + 1) + " " + (i + 1));
                    break;
                }
                if (!costIndexMap.containsKey(cost[i]))// add all costs to map
                {
                    costIndexMap.put(cost[i], i);
                }
            }
        }
    }*/
    
    /* fails some test cases on time out
    static void whatFlavors(int[] cost, int money)
    {
        int leng = cost.length;
        *//**
 * 4 = money
 * 5 = ice cream options
 * 1 4 5 3 2
 * *//*
        Map<Integer, Integer> indexCostMap = new HashMap<>();
        for (int i = 0; i < leng; i++) // put array into map of options to cost
        {
            if (cost[i] < money) // eliminate over budget icecream
            {
                indexCostMap.put(i + 1, cost[i]);
            }
        }
        // System.out.println(indexCostMap.values());
        boolean done = false;
        int count = 0;
        int first = 0;
        List<Integer> purchaseIndices = new ArrayList<>();
        for (int i : indexCostMap.keySet())
        {
            if (done)
            {
                break;
            }
            int i2 = money - indexCostMap.get(i);
            if (count == 0)
            {
                first = i;
            }
            int j = first;
            while (j < indexCostMap.size())
            {
                if (indexCostMap.get(j) != null)
                {
                    if (indexCostMap.get(j) == i2 && j != i)
                    {
                        purchaseIndices.add(i);
                        purchaseIndices.add(j);
                        done = true;
                        break;
                    }
                }
                j++;
            }
            count++;
        }
        
        purchaseIndices.sort(Comparator.naturalOrder());
        for (int i = 0; i < purchaseIndices.size(); i++)
        {
            System.out.print(purchaseIndices.get(i));
            if (i < purchaseIndices.size() - 1)
            {
                System.out.print(" ");
            }
            else
            {
                System.out.println();
            }
        }
    }*/

/* works
static void whatFlavors(int[] cost, int money)
{
    int leng = cost.length;
    
    Map<Integer, Integer> iceCreamToCost = new HashMap<>();
    int[] pi = new int[2];
    for (int i = 0; i < leng; i++) // put array into map of options to cost
    {
        if (cost[i] < money)
        {
            iceCreamToCost.put(i + 1, cost[i]);
        }
        int i2 = money - cost[i];
        if (iceCreamToCost.containsValue(i2))
        {
            for (int index : iceCreamToCost.keySet())
            {
                if (iceCreamToCost.get(index) == i2 && (i + 1) != index)
                {
                    pi[0] = index;
                    pi[1] = i + 1;
                    break;
                }
            }
        }
    }
    System.out.println(pi[0] + " " + pi[1]);
}*/


/* fails time test cases
static void whatFlavors(int[] cost, int money)
{
    *//**
 * 4 = money
 * 5 = ice cream options
 * 1 4 5 3 2
 * *//*
    int leng = cost.length;
    int end;
    int start;
    
    Map<Integer, Integer> iceCreamToCost = new HashMap<>();
    for (int i = 0; i < leng; i++) // put array into map of options to cost
    {
        iceCreamToCost.put(i + 1, cost[i]);
    }
    boolean done = false;
    for (int i = 0; i < leng - 1; i++) // iterate through costs. Comparing each cost with other elements in the array using a binary search
    {
        if (done)
        {
            break;
        }
        start = i + 1;
        end = leng;
        int[] sortedCost = new int[end - start]; // create new array to sort costs being searched
        System.arraycopy(cost, start, sortedCost, 0, sortedCost.length); // copy costs into new array
        Arrays.sort(sortedCost); // sort
        start = 0;
        end = sortedCost.length;
        //System.out.println("sortedCost > " + Arrays.toString(sortedCost));
        while (start < end) // search for cost that completes purchase
        {
            int midpoint = ((end - start) / 2) + start;
            if (cost[i] + sortedCost[midpoint] == money)
            {
                System.out.print((i + 1) + " ");
                for (int d : iceCreamToCost.keySet())
                {
                    if (iceCreamToCost.get(d) == sortedCost[midpoint] && d != i + 1)
                    {
                        System.out.println(d);
                        done = true;
                        break;
                    }
                }
                break;
            }
            else if (cost[i] + sortedCost[midpoint] < money)
            {
                start = midpoint + 1;
            }
            else
            {
                end = midpoint;
            }
        }
    }
}*/

/*static void whatFlavors(int[] cost, int money)
{
    int leng = cost.length;
    for (int i = 0; i < leng - 1; i++) // iterate through costs. Comparing each cost with other elements in the array using a binary search
    {
        for (int j = i + 1; j < leng; j++)
        {
            if (cost[i] + cost[j] == money)
            {
                System.out.println((i + 1) + " " + (j + 1));
                break;
            }
        }
    }
}*/
}
