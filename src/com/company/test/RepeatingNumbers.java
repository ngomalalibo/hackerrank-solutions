package com.company.test;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class RepeatingNumbers
{
    /* The name of the class has to be Main. */
    public static void main(String[] args)
    {
        //{9, 31, 38, 5, 62, 44, 38, 17, 19, 38, 50, 74}, the output is 38. // sample data
        // int[] inputVector = new int[]{9, 31, 38, 5, 62, 44, 38, 17, 19, 38, 50, 74};
        // int[] inputVector = new int[]{9, 31, 5, 62, 44, 17, 19, 38, 50, 74};
        // int[] inputVector = new int[]{9, 31, 38, 5, 62, 44, 38, 17, 19, 38, 50, 74, 50};
    
        int[] inputVector = new int[]{9, 31, 38, 5, 62, 44, 38, 17, 19, 38, 50, 31};
    
        // int[] inputVector = new int[]{4, 3, 14, 15, 18, 39, 56, 89, 101, 150, 165, 187};
        int n = inputVector.length;
        
        // set to hold repeating numbers
        Set<Integer> repeatingNumbers = new HashSet<>();
        
        //take a number and compare it with all other numbers in the array
        for (int i = 0; i < n; i++)
        {
            int count = 0;
            for (int j = 0; j < n; j++)
            {
                if (inputVector[i] <= 1000 && inputVector[i] >= 1 && inputVector[j] <= 1000 && inputVector[j] >= 1)
                {
                    if (inputVector[i] == (inputVector[j]))
                    {
                        count++;
                    }
                }
                
            }
            if (count > 1)
            {
                repeatingNumbers.add(inputVector[i]);
            }
        }
        if (repeatingNumbers.size() > 0)
        {
            repeatingNumbers = repeatingNumbers.stream().sorted().collect(Collectors.toCollection(LinkedHashSet::new));
            repeatingNumbers.forEach(num -> System.out.print(num+" "));
            System.out.println();
        }
        else
        {
            System.out.println(0);
        }
    }
}