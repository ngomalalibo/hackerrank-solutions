package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class JavaEndOfFile
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int n = 0;
        Map<Integer, String> lines = new HashMap<>();
        String s;
        while (in.hasNextLine())
        {
            s = in.nextLine();
            if (s.equals(""))
            {
                break;
            }
            lines.put(++n, s);
        }
        
        in.close();
        
        for (int i = 1; i <= lines.size(); i++)
        {
            System.out.println(i + " " + lines.get(i));
        }
    }
}
