package com.company.temporary;

public class PrimeNumbers
{
    public static int[] primeNumber(int limit)
    {
        int[] primeNumbers = new int[limit];
        int primeIndex = 0;
        int noOfDivisors = 0;
        
        for (int i = 2; i < limit; i++)
        {
            noOfDivisors = 0;
            for (int j = 1, k = i; k > 1; k--)
            {
                //(i % 2) == 0 || (i % 3) == 0 ||
                if ((i % k) == 0)
                {
                    ++noOfDivisors;
                }
            }
            if (noOfDivisors == 1)
            {
                primeNumbers[primeIndex] = i;
                primeIndex++;
            }
        }
        return primeNumbers;
    }
    
    public static void main(String[] args)
    {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.print("Enter a number: ");
        String input = scanner.nextLine();
        
        try
        {
            int integer = Integer.valueOf(input);
            int[] primes = primeNumber(integer);
            
            for (int i = 0; i < primes.length; i++)
            {
                if (primes[i] != 0)
                {
                    if (i == 0)
                    {
                        System.out.print(primes[i]);
                    }
                    else
                    {
                        System.out.print(", " + primes[i]);
                    }
                }
            }
        }
        catch (NumberFormatException e)
        {
            e.getMessage();
        }
    }
}
