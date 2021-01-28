package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import static java.lang.System.in;

class Prime
{
    public void checkPrime(int... numbers)
    {
        List<Integer> primes = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++)
        {
            if (BigInteger.valueOf(numbers[i]).isProbablePrime(1))
            {
                primes.add(numbers[i]);
            }
        }
        for(int prime: primes)
        {
            System.out.print(prime + " ");
        }
        System.out.println();
    }
}

public class PrimeChecker
{
    public static void main(String[] args)
    {
        try
        {
            BufferedReader br=new BufferedReader(new InputStreamReader(in));
            int n1 = Integer.parseInt(br.readLine());
            int n2 = Integer.parseInt(br.readLine());
            int n3 = Integer.parseInt(br.readLine());
            int n4 = Integer.parseInt(br.readLine());
            int n5 = Integer.parseInt(br.readLine());
            
            Prime ob = new Prime();
            ob.checkPrime(n1);
            ob.checkPrime(n1, n2);
            ob.checkPrime(n1, n2, n3);
            ob.checkPrime(n1, n2, n3, n4, n5);
            Method[] methods = Prime.class.getDeclaredMethods();
            Set<String> set = new HashSet<>();
            boolean overload = false;
            for (int i = 0; i < methods.length; i++)
            {
                if (set.contains(methods[i].getName()))
                {
                    overload = true;
                    break;
                }
                set.add(methods[i].getName());
                
            }
            if (overload)
            {
                throw new Exception("Overloading not allowed");
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
}
