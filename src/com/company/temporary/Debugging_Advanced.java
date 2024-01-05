package com.company.temporary;

import java.util.Random;

public class Debugging_Advanced
{
    
    int fff = new Random().nextInt(100);
    public void work()
    {
        int f = 9;
    }
    
    public void realWork()
    {
        for (int i=0; i<10;i++)
        {
            work();
        }
    }
    public void warmup()
    {
        for (int i=0; i<10;i++)
        {
            work();
        }
    }
    
    public static void main(String[] args)
    {
        Debugging_Advanced da= new Debugging_Advanced();
        da.warmup();
        System.out.println("Completed Warm");
        da.realWork();
    }
}
