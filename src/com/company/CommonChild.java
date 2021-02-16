package com.company;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;


// unsolved
public class CommonChild
{
    static int commonChild(String s1, String s2)
    {
        // get set
        // intersect
        
        int longestString = 0;
        Map<Character, Integer> s1Common = new HashMap<>();
        Map<Character, Integer> s2Common = new HashMap<>();
        char[] s1c = s1.toCharArray();
        char[] s2c = s2.toCharArray();
        List<Character> s1a = Arrays.asList(s1.chars().mapToObj(c -> (char) c).toArray(Character[]::new));
        Set<Character> s1Set = new HashSet<>(s1a);
        List<Character> s2a = Arrays.asList(s2.chars().mapToObj(c -> (char) c).toArray(Character[]::new));
        Set<Character> s2Set = new HashSet<>(s2a);
        
        for (Character c : s1c)
        {
            s1Common.merge(c, 1, Integer::sum);
        }
        for (Character c : s2c)
        {
            s2Common.merge(c, 1, Integer::sum);
        }
        
        s1Set.retainAll(s2Set);
        
        // comparer character positions and count common children
        // check multiple occurrence of same character
        Map<Character, List<Integer>> charPositions1 = new HashMap<>();
        Map<Character, List<Integer>> charPositions2 = new HashMap<>();
        for (Character c : s1Set)
        {
            List<Integer> pos1 = new ArrayList<>();
            List<Integer> pos2 = new ArrayList<>();
            
            for (int i = 0; i < s1.length(); i++)
            {
                if (c == s1.charAt(i))
                {
                    pos1.add(i);
                }
            }
            charPositions1.put(c, pos1);
            
            for (int i = 0; i < s2.length(); i++)
            {
                if (c == s2.charAt(i))
                {
                    pos2.add(i);
                }
            }
            charPositions2.put(c, pos2);
        }
        
        // charPosition1 and charPosition2
        s1Set = s1Set.stream().sorted().collect(Collectors.toCollection(LinkedHashSet::new));
        s2Set = s2Set.stream().sorted().collect(Collectors.toCollection(LinkedHashSet::new));
        int prevInt1 = Integer.MIN_VALUE;
        int prevInt2 = Integer.MIN_VALUE;
        for (int i = 0; i < s1.length(); i++)
        {
            char atI = s1.charAt(i);
            if (s1Set.contains(atI))
            {
                for (int j = 0; j < s2.length(); j++)
                {
                    if (prevInt1 != Integer.MIN_VALUE)
                    {
                    
                    }
                    
                }
                prevInt1 = i;
            }
        }
        
        
        return longestString;
    }
    
    private static final Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) throws IOException
    {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        
        String s1 = scanner.nextLine();
        
        String s2 = scanner.nextLine();
        
        int result = commonChild(s1, s2);
        
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();
        
        bufferedWriter.close();
        
        scanner.close();
    }
}
