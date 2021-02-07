package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class JavaStringTokens
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        s = s.trim();
        if (1 <= s.length() && s.length() <= 4 * (Math.pow(10, 5)))
        {
            String[] ss = s.split("[\b ,\\!\\?._'@\\+]+");
            System.out.println(ss.length);
            
            Arrays.asList(ss).forEach(System.out::println);
            scan.close();
        }
        else
        {
            System.out.println(0);
        }
        
    }
}

/*
          YES      leading spaces        are valid,    problemsetters are         evillllll
* */