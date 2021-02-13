package com.company;

import java.io.IOException;
import java.util.*;

public class StringsMakingAnagrams
{
    // Complete the makeAnagram function below.
    static int makeAnagram(String a, String b)
    {
        int totalCount = 0;
        
        int al = a.length();
        int bl = b.length();
        
        if (bl > al)
        {
            String temp = a;
            a = b;
            b = temp;
        }
        char[] ac = a.toCharArray();
        char[] bc = b.toCharArray();
        Arrays.sort(ac);
        Arrays.sort(bc);
        
        HashMap<Character, Integer> aMap = new HashMap<>();
        HashMap<Character, Integer> bMap = new HashMap<>();
        
        // get a string into a map
        for (Character c : a.toCharArray())
        {
            if (aMap.get(c) != null)
            {
                Integer freq = aMap.get(c);
                aMap.put(c, freq + 1);
            }
            else
            {
                aMap.put(c, 1);
            }
        }
        
        // get b into a map
        for (Character c : b.toCharArray())
        {
            if (bMap.get(c) != null)
            {
                Integer freq = bMap.get(c);
                bMap.put(c, freq + 1);
            }
            else
            {
                bMap.put(c, 1);
            }
        }
        // clone both maps
        Map<Character, Integer> aMapClone = new HashMap<>(aMap);
        Map<Character, Integer> bMapClone = new HashMap<>(bMap);
        
        // remove all of b in a
        aMapClone.keySet().removeAll(bMap.keySet());
        //remove all of a in b
        bMapClone.keySet().removeAll(aMap.keySet());
        
        // count characters in the a difference and add to total
        for (Character c : aMapClone.keySet())
        {
            int aaas = aMap.get(c);
            totalCount += aaas;
        }
    // count characters in the b difference and add to total
        for (Character c : bMapClone.keySet())
        {
            int bees = bMap.get(c);
            totalCount += bees;
        }
        
        
        // get distince characters
        Set<Character> aSet = new HashSet<>(aMap.keySet());
        Set<Character> bSet = new HashSet<>(bMap.keySet());
        // get character intersect of a and b characters
        bSet.retainAll(aSet);
        // count characters in the a/b character intersect difference
        for (Character c : bSet)
        {
            int bees = bMap.get(c);
            int aaas = aMap.get(c);
    
            int abs = Math.abs(bees - aaas);
            totalCount += abs;
        }
        
        return totalCount;
    }
    
    private static final Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) throws IOException
    {
        String a = scanner.nextLine();
        
        String b = scanner.nextLine();
        
        int res = makeAnagram(a, b);
        
        System.out.println(res);
        scanner.close();
    }
}
