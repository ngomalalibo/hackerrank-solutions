package com.company;

import java.util.Scanner;
import java.util.stream.IntStream;

public class CountPrimes
{
    public static void main(String[] args)
    {
        CountPrimes countPrimes = new CountPrimes();
        Scanner scanner = new Scanner(System.in);
        int upTo = scanner.nextInt();
        System.out.println("Prime numbers between 1 and " + upTo + ": " + countPrimes.countPrimes(upTo));
        scanner.close();
        
    }
    
    public long countPrimes(int upTo)
    {
        return IntStream.range(1, upTo)
                        .parallel()
                        .filter(this::isPrime)
                        .count();
    }
    
    private boolean isPrime(int number)
    {
        return IntStream.range(2, number)
                        .allMatch(x -> (number % x) != 0);
    }
}
