package com.company.temporary;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerDemo
{
    public static void main(String[] args)
    {
        
        Consumer<Integer> consumer = t -> System.out.println("Printing : " + t);
        consumer.accept(16);
        
        List<Integer> listl = Arrays.asList(1, 12, 3, 4, 5);
        listl.forEach(t -> System.out.println("Printing : " + t));
    }
}