package com.company;

import java.util.Scanner;

public class JavaIfElse
{
    private static final Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args)
    {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        
        scanner.close();
        if (n < 1 || n > 100)
        {
            System.exit(0);
        }
        if (n % 2 != 0)
        {
            System.out.println("Weird");
        }
        else if (n % 2 == 0 && n >= 2 && n <= 5)
        {
            System.out.println("Not Weird");
        }
        else if (n % 2 == 0 && n >= 6 && n <= 20)
        {
            System.out.println("Weird");
        }
        else if (n % 2 == 0 && n > 20)
        {
            System.out.println("Not Weird");
        }
    }
}
