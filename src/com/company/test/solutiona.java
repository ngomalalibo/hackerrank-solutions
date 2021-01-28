package com.company.test;

public class solutiona
{
    /*public int solution(String S)
    {
        *//**babaa
 ababa
 aba
 bbbbb*//*
        int N = S.length();
        
        char[] ca = S.toCharArray();
        List<Character> caa = new ArrayList<>();
        for (char c : ca)
        {
            caa.add(c);
        }
        
        String one="";
        String two="";
        String three="";
        if (N < 1 || N > 40000)
        {
            System.exit(1);
        }
        *//*if (!caa.contains('a') || !caa.contains('b'))
        {
            System.exit(1);
        }*//*
        
        int count = 0;
        for(char c : caa)
        {
            if(c=='a' && count==0)
            {
                one = S.substring(0,caa.indexOf(c));
                count++;
            }
            if(c=='a' && count==1)
            {
                two = S.substring(one.length(),caa.indexOf(c));
                count++;
            }
            if(c=='a' && count==2)
            {
                three = S.substring(two.length(),caa.indexOf(c));
                count++;
            }
        }
        
        return 0;
    }*/
}
