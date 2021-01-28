package com.company.temporary;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class PredicateDemo implements Predicate<Integer>
{
    @Override
    public boolean test(Integer t)
    {
        if (t % 2 == 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public static void main(String[] args)
    {
        Predicate<Integer> predicate = t -> t % 2 == 0;
        Consumer<Integer> consumer = System.out::println;
        Supplier<Integer> supplier = () -> 8;
        
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5);
        BinaryOperator<Integer> reduce = (a, t) -> a = a + t;
        
        System.out.println(predicate.test(7));
        System.out.println("list1.stream().findFirst().orElseGet(supplier) = " + list1.stream().findFirst().orElseGet(supplier));
        
    }
}
