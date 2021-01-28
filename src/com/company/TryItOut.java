package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class TryItOut
{
    /*uncle sam
99912222
tom
11122222
harry
12299933*/
    public static void main(String[] args)
    {
        List<String> s = new ArrayList<>();
        String[] ss = "12 0 1 78 12".split("\\s+");
        
        for(int i=0; i<ss.length;i++)
        {
            s.add(ss[i]);
        }
        s.add(2, null);
        s.add(6, "23");
        
        System.out.println(s.toString());
    }
}
