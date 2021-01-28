package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.System.in;

public class JavaList
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        int n = Integer.parseInt(br.readLine());
        
        if (1 <= n && n <= 4000)
        {
            String s1 = br.readLine();
            
            List<String> items = new ArrayList<>();
            String[] ss = s1.trim().split("\\s+");
    
            for(int i=0; i<ss.length;i++)
            {
                items.add(ss[i]);
            }
            
            
            if (items.size() != n)
            {
                System.exit(0);
            }
            
            int q = Integer.parseInt(br.readLine());
            
            if (1 <= q && q <= 4000)
            {
                while (q > 0)
                {
                    String query = br.readLine();
                    List<String> action = Arrays.asList(br.readLine().split("\\s+"));
                    
                    if (query.equals("Insert"))
                    {
                        if (action.size() == 2)
                        {
                            int addIndex = Integer.parseInt(action.get(0));
                            if (addIndex < items.size())
                            {
                                items.add(addIndex, action.get(1));
                            }
                            else
                            {
                                while (addIndex >= items.size())
                                {
                                    items.add("");
                                }
                                items.add(addIndex, action.get(1));
                            }
                        }
                        else
                        {
                            System.exit(0);
                        }
                    }
                    else if (query.equals("Delete"))
                    {
                        items.remove(Integer.parseInt(action.get(0)));
                    }
                    else
                    {
                        System.exit(0);
                    }
                    
                    q--;
                }
                int count = 0;
                items.forEach(item ->
                              {
                                  System.out.print(item);
                                  if (count != items.size() - 1)
                                  {
                                      System.out.print(" ");
                                  }
                              });
                System.out.println();
                
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
