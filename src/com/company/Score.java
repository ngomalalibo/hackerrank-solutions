package com.company;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

//unfinished toptal test
public class Score
{
    public static void main(String[] args)
    {
    
    }
    
    public int solution(String[] T, String[] R)
    {
        List<String> t = Arrays.asList(T);
        List<String> r = Arrays.asList(R);
        
        AtomicInteger count = new AtomicInteger();
        AtomicReference<String> s = new AtomicReference<>();
        t.forEach(d ->
                  {
                      Character[] dc = new Character[d.length()];
                      for (int i = 0; i < d.length(); i++)
                      {
                
                          dc[i] = d.charAt(i);
                      }
                      for (int i = 0; i < d.length(); i++)
                      {
                          if (Character.isDigit(d.charAt(i)) && d.length() - 1 == i)
                          {
                              if (r.get(i).equals("Ok"))
                              {
                                  count.getAndIncrement();
                              }
                    
                              s.set(d.substring(0, i));
                          }
                      }
            
                  });
        return 0;
        
    }
}
