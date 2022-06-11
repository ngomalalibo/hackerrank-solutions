package com.company.musala;

import java.util.Arrays;
import java.util.List;

public class CountingSub
{
    public int counting(String s)
    {
        List<Character> binary = Arrays.asList(s.chars().mapToObj(c -> (char) c).toArray(Character[]::new));
        int zeros = 0;
        int ones = 0;
        int count = 0;
        for (int i = 0; i < binary.size(); i++)
        {
            if (binary.get(i).equals('0'))
            {
                zeros++;
            }
            else if (binary.get(i).equals('1'))
            {
                ones++;
            }
        
            if (i == (binary.size() - 1))
            {
                if (zeros == ones && zeros != 0)
                {
                    ++count;
                }
            }
        }
        return count;
    }
}
