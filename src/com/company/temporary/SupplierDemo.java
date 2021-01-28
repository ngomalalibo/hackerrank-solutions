package com.company.temporary;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class SupplierDemo
{
    public static void main(String[] args)
    {
        Supplier<Integer> supplier = () -> 8;
        List<Integer> list = Arrays.asList();
        list.stream().findFirst().orElse(supplier.get());
        System.out.println(list.stream().findFirst().orElse(8));
    }
}
