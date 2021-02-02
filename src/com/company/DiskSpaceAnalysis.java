package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


class Result
{
    
    /*public static int segment(int x, List<Integer> space)
    {
        ArrayList<List<Integer>> segments = new ArrayList<>();
        ArrayList<Integer> mindiskspace = new ArrayList<>();
        
        for (int i = 0; i < space.size(); i++)
        {
            if (x > space.size())
            {
                break;
            }
            
            segments.add(space.subList(i, x++));
        }
        System.out.println(segments.toString());
        segments.forEach(d ->
                                  {
                                      mindiskspace.add(d.stream().mapToInt(e->e).min().orElse(0));
                                  });
        return mindiskspace.stream().mapToInt(d -> d).max().orElse(0);
    }*/
    
    public static int segment(int x, List<Integer> space)
    {
        /**   8 2 4 6 */
        ArrayList<Integer> segment;
        ArrayList<Integer> mindiskspace = new ArrayList<>();
        int n = space.size();
        boolean last = false;
        for (int i = 0; i < n; i++)
        {
            if (last)
            {
                break;
            }
            segment = new ArrayList<>();
            for (int k = 0, j = i; k < x; k++, j++)
            {
                if (last)
                {
                    break;
                }
                segment.add(space.get(j));
                if (i == (n - x))
                {
                    while (j < n)
                    {
                        if (j != n - 1)
                        {
                            j++;
                        }
                        else
                        {
                            last = true;
                            break;
                        }
                        segment.add(space.get(j));
                    }
                }
                
            }
            System.out.println(segment.toString());
            mindiskspace.add(segment.stream().mapToInt(d -> d).min().orElse(0));
        }
        return mindiskspace.stream().mapToInt(d -> d).max().orElse(0);
        
    }
    
}

public class DiskSpaceAnalysis
{
    
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
        
        int result = Result.segment(x, space);
        
        System.out.println("result -> " + result);
    }
}
