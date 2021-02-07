package com.company;

import java.util.Scanner;

public class JavaStaticInitializerBlock
{
    private static int B;
    private static int H;
    
    private static boolean flag = false;
    
    private static Scanner in = new Scanner(System.in);
    
    static
    {
        B = in.nextInt();
        H = in.nextInt();
        if (B <= 0 || H <= 0)
        {
            System.out.println("java.lang.Exception: Breadth and height must be positive");
            
        }
        else
        {
            flag = true;
        }
    }
    
    public static void main(String[] args)
    {
        if (flag)
        {
            int area = B * H;
            System.out.print(area);
        }
        
    }//end of main
    
}//end of class

