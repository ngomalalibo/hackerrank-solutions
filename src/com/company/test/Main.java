package com.company.test;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Main
{
    /* The name of the class has to be Main. */
    public static void main(String[] args)
    {
        int[] inputVector = null;
        int result = Integer.MAX_VALUE;
        int n;
        try (Scanner scanner = new Scanner("9, 31, 38, 5, 62, 44, 38, 17, 19, 38, 50, 74"))
        {
            // n = Integer.parseInt(scanner.nextLine());
            String[] numberTokens = scanner.nextLine().split(", ");
            n = numberTokens.length;
            inputVector = new int[n];
            
            for (int i = 0; i < n; i++)
            {
                inputVector[i] = Integer.parseInt(numberTokens[i]);
            }
        }
        catch (Exception ex)
        {
            throw new RuntimeException(ex);
        }
        
        // set to hold distinct but repeating numbers
        Set<Integer> repeatingNumbers = new HashSet<>();
        
        //take a number and compare it with all other numbers in the array
        for (int i = 0; i < n; i++)
        {
            int count = 0;
            for (int j = 1; j < n; j++)
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
            repeatingNumbers.forEach(num -> System.out.print(num + " "));
            System.out.println();
        }
        else
        {
            System.out.println(0);
        }
    }
}