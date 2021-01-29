package com.company;

import java.util.*;

public class TryItOut
{
    public static void main(String[] args)
    {
        String INPUT = new StringBuilder()
                .append("magic\tproject\n")
                .append("     database: oracle\n")
                .append("dependencies:\n")
                .append("spring:foo:bar\n")
                .append("\n")  // Note that the input ends with a blank line
                .toString();
        Scanner scanner = new Scanner(INPUT);
        while (scanner.hasNext()) {
            System.out.println(scanner.next());
        }
        System.out.println(("--------OUTPUT--END---------"));
    }
}
