package com.company;

import java.io.IOException;
import java.util.Scanner;

public class FraudulentActivityNotifications
{
    // Complete the activityNotifications function below.
    // Counting sort
    static int activityNotifications(int[] expenditure, int d)
    {
        int notificationCount = 0;
        
        int[] data = new int[201];
        for (int i = 0; i < d; i++)
        {
            data[expenditure[i]]++;
        }
        
        for (int i = d; i < expenditure.length; i++)
        {
            
            double median = getMedian(d, data);
            
            if (expenditure[i] >= 2 * median)
            {
                notificationCount++;
                
            }
            
            data[expenditure[i]]++;
            data[expenditure[i - d]]--;
            
        }
        
        return notificationCount;
        
    }
    
    private static double getMedian(int d, int[] data)
    {
        double median = 0;
        if (d % 2 == 0)
        {
            Integer m1 = null;
            Integer m2 = null;
            int count = 0;
            for (int j = 0; j < data.length; j++)
            {
                count += data[j];
                if (m1 == null && count >= d / 2)
                {
                    m1 = j;
                }
                if (m2 == null && count >= d / 2 + 1)
                {
                    m2 = j;
                    break;
                }
            }
            median = (m1 + m2) / 2.0;
        }
        else
        {
            int count = 0;
            for (int j = 0; j < data.length; j++)
            {
                count += data[j];
                if (count > d / 2)
                {
                    median = j;
                    break;
                }
            }
        }
        return median;
    }
    
    private static final Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) throws IOException
    {
        String[] nd = scanner.nextLine().split(" ");
        
        int n = Integer.parseInt(nd[0]);
        
        int d = Integer.parseInt(nd[1]);
        
        int[] expenditure = new int[n];
        
        String[] expenditureItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        
        for (int i = 0; i < n; i++)
        {
            int expenditureItem = Integer.parseInt(expenditureItems[i]);
            expenditure[i] = expenditureItem;
        }
        
        int result = activityNotifications(expenditure, d);
        System.out.println(result);
        
        scanner.close();
    }
}
/* Sample input
9 5
2 3 4 2 3 6 8 4 5

5 3
10 20 30 40 50

5 4
1 2 3 4 4
* */
/* Bubble Sort
static int activityNotifications(int[] expenditure, int d)
    {
        int notifications = 0;
        int median;
        int medianIndex = (d / 2);
        int leng = expenditure.length;
        List<Integer> exp = Arrays.asList(Arrays.stream(expenditure).boxed().toArray(Integer[]::new));
        *//**
 * 10 20 30 40 50    3
 *//*
        for (int i = 0; i < (leng - d); i++)
        {
            //trailingDays = new int[d];
            int[] trailDays = exp.subList(i, i + d).stream().mapToInt(s -> s).toArray();
            boolean sorted = false;
            int counter;
            int n = d;
            while (n > 1 && !sorted)
            {
                counter = 0;
                
                for (int j = 0; j < n - 1; j++)
                {
                    if (j <= n - 2)
                    {
                        if (trailDays[j] > trailDays[j + 1])
                        {
                            int temp = trailDays[j];
                            trailDays[j] = trailDays[j + 1];
                            trailDays[j + 1] = temp;
                            sorted = false;
                            counter++;
                        }
                        else if (j == n - 1 && counter == 0)
                        {
                            sorted = true;
                        }
                    }
                }
                n--;
            }
            System.out.println(Arrays.toString(trailDays));
            
            if (d % 2 != 0)
            {
                median = trailDays[medianIndex];
            }
            else
            {
                median = (trailDays[medianIndex] + trailDays[medianIndex + 1]) / 2;
            }
            if (expenditure[i + d] >= median * 2)
            {
                notifications++;
            }
            
        }
        return notifications;
    }*/