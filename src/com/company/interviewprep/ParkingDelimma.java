package com.company.interviewprep;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ParkingDelimma
{
    public static int carParkingRoof(List<Integer> cars, int k)
    {
        cars.sort(Comparator.naturalOrder());
        int n = cars.size();
        int minimumDistance = Integer.MAX_VALUE;
        //sort to get cars in order
        /**  2, 6 7 12
         *   1 10 8 17 */
        
        for (int i = 0; i < n; i++)
        {
            if (i + (k - 1) < n)
            {
                // calculate the distance between k cars in the park
                int distance = (cars.get(i + (k - 1)) - cars.get(i)) + 1;
                if (distance < minimumDistance)
                {
                    // find minimum distance
                    minimumDistance = distance;
                }
            }
        }
        return minimumDistance;
    }
    
    public static void main(String[] args)
    {
        // Dynamic Array solution. ArrayList solution
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<Integer> cars = new ArrayList<>();
        for (int i = 0; i < n; i++)
        {
            cars.add(in.nextInt());
        }
        
        int k = in.nextInt();
        
        int i = carParkingRoof(cars, k);
        System.out.println("length -> " + i);
    }
}

/*
*4
2
10
8
17
3

4
6
2
12
7
3
* */