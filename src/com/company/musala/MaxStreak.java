package com.company.musala;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class MaxStreak
{
    public static int maxStreak(int m, List<String> data)
    {
        int n = data.size();
        if (data == null)
        {
            return 0;
        }
        if (n<1)
        {
            return 0;
        }
        if (m < 1 || m>10)
        {
            return 0;
        }
        if (n < 1 || n>100000 )
        {
            return 0;
        }
        // data = ["YYY", "YYY", "YNN", "YYN", "YYN"]
        int maxStreak=0;
        int streak=0;
        AtomicInteger noOfDays = new AtomicInteger();
    
        for (int i = 0; i< n; i++)
        {
            List<Character> emps = Arrays.asList(data.get(i).chars().mapToObj(c -> (char) c).toArray(Character[]::new));
            if(!emps.contains('N'))
            {
                noOfDays.incrementAndGet();
                streak++;
            }
            else
            {
                maxStreak = Math.max(streak, maxStreak);
                streak = 0;
            }
        }
        return maxStreak;
    }
    
    public static void main(String[] args)
    {
       List<String> data = List.of("YYY", "YYY", "YYY", "YNY", "YYY");
        System.out.println(maxStreak(3, data));
    }
}
