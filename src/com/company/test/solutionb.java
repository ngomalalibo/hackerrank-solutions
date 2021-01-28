package com.company.test;

public class solutionb
{
    /*public int solution(String S, int K)
    {
        *//**
 * AAAAAAAAAAABXXAAAAAAAAAA
 *
 * ABBBCCDDCCC
 * ABCDDDEFG*//*
        char[] chars = S.toCharArray();
        List<Character> caa = new ArrayList<>();
        Set<Character> saa = new HashSet<>();
        Map<Character, Integer> maa = new HashMap<>();
        for (char c : chars)
        {
            saa.add(c);
        }
        for (char c : chars)
        {
            caa.add(c);
        }
        
        for (char c : saa)
        {
            Pattern pattern = Pattern.compile(Character.toString(c));
            Matcher matcher = pattern.matcher(S);
            int count = 0;
            while (matcher.find())
            {
                count++;
            }
            maa.put(c, count);
        }
        
        List values = new ArrayList(maa.values());
        
        for (Map.Entry<Character, Integer> entry : maa.entrySet())
        {
            int mini = Integer.MIN_VALUE;
            Integer value = entry.getValue();
            if (mini > value)
            {
                mini = value;
            }
            
            
        }
        
        
        int counter = 0;
        for (int i = 0; i < caa.size(); i++)
        {
            char c = caa.get(i);
            if (caa.get(i).equals(caa.get(i + 1)))
            {
                counter++;
            }
            else
            {
                
                counter = 0;
            }
        }
        return 0;
    }*/
}
