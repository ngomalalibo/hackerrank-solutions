package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ParkingDelimma_Revisited
{
    public static int carParkingRoof(List<Integer> cars, int k)
    {
        /** 6 2 12 7   3*/
        Collections.sort(cars);
        int minRoofLength = Integer.MAX_VALUE;
        int roofLength;
        int leng = cars.size();
        k--; // indices are read from zero
        for (int j = 0; j < leng; j++)
        {
            if (j + k < leng)
            {
                roofLength = (cars.get(j + k) - cars.get(j)) + 1;
                if (roofLength < minRoofLength)
                {
                    minRoofLength = roofLength;
                }
            }
            else
            {
                break;
            }
        }
        return minRoofLength;
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
