package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DiskSpaceAnalysis_Revisited
{
    public static int segment(int x, List<Integer> space)
    {
        /** 8 2 4 6   2*/
        /** 1 2 3 1 2    1*/
        int leng = space.size();
        int minima;
        List<Integer> minimas = new ArrayList<>();
        for (int i = 0; i <= leng - 1; i++)
        {
            minima = space.get(i);
            if (x == 1)
            {
                minimas.add(minima);
            }
            else if (x > 1)
            {
                for (int j = i; j < (i + x) - 1; j++)
                {
                    if (j <= leng - 2)
                    {
                        if (space.get(j) > space.get(j + 1))
                        {
                            minima = space.get(j + 1);
                        }
                        if (j == (i + x) - 2)
                        {
                            minimas.add(minima);
                            // System.out.println(minima);
                        }
                    }
                    if (j == leng - x)
                    {
                        while (j < leng - 1)
                        {
                            if (space.get(j) > space.get(j + 1))
                            {
                                minima = space.get(j + 1);
                            }
                            if (j == leng - 2)
                            {
                                minimas.add(minima);
                                // System.out.println(minima);
                                break;
                            }
                            j++;
                        }
                    }
                }
            }
        }
        return minimas.stream().mapToInt(c -> c).max().orElse(0);
    }
    
    public static void main(String[] args) throws IOException
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        
        int x = Integer.parseInt(bufferedReader.readLine().trim());
        
        int spaceCount = Integer.parseInt(bufferedReader.readLine().trim());
        
        List<Integer> space = IntStream.range(0, spaceCount).mapToObj(i ->
                                                                      {
                                                                          try
                                                                          {
                                                                              return bufferedReader.readLine().replaceAll("\\s+$", "");
                                                                          }
                                                                          catch (IOException ex)
                                                                          {
                                                                              throw new RuntimeException(ex);
                                                                          }
                                                                      })
                                       .map(String::trim)
                                       .map(Integer::parseInt)
                                       .collect(Collectors.toList());
        
        int result = segment(x, space);
        
        System.out.println("result -> " + result);
    }
}
