package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static java.lang.System.in;

public class JavaArrayList
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        Map<Integer, ArrayList<String>> linesAndArrays = new HashMap<>();
        int n = Integer.parseInt(br.readLine());
        long totalInts = 0;
        if (1 <= n && n <= 20000)
        {
            for (int i = 1; i <= n; i++)
            {
                String s1 = br.readLine();
                String[] ss = s1.split("\\s+");
                int d = Integer.parseInt(ss[0]);
                if (0 <= d && d <= 50000)
                {
                    ArrayList<String> arrays = new ArrayList<String>(d);
                    for (int j = 0; j < ss.length; j++)
                    {
                        arrays.add(ss[j]);
                    }
                    totalInts += arrays.size();
                    linesAndArrays.put(i, arrays);
                }
                else
                {
                    System.exit(0);
                }
                
                if (totalInts > Math.pow(10, 5))
                {
                    // System.exit(0);
                }
                
            }
            
            
            int q = Integer.parseInt(br.readLine());
            if (1 <= q && q <= 1000)
            {
                for (int k = 0; k < q; k++)
                {
                    String query = br.readLine();
                    String[] ss1 = query.split("\\s+");
                    // System.out.println(Arrays.toString(ss1));
                    if (ss1.length != 2)
                    {
                        System.out.println("ERROR!");
                    }
                    int x = Integer.parseInt(ss1[0]);
                    int y = Integer.parseInt(ss1[1]);
                    if (1 <= x && x <= n)
                    {
                        ArrayList<String> qlist = linesAndArrays.get(x);
                        if (y >= qlist.size())
                        {
                            System.out.println("ERROR!");
                        }
                        else
                        {
                            System.out.println(qlist.get(y));
                        }
                    }
                    else
                    {
                        System.out.println("ERROR!");
                    }
                }
            }
            else
            {
                System.exit(0);
            }
        }
        else
        {
            System.exit(0);
        }
        
    }
}
