package com.company;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class TwoStrings
{
    // Complete the twoStrings function below.
    static String twoStrings(String s1, String s2)
    {
        //ensure s1 is the longer string
        Set<Character> s1Set = new HashSet<>(Arrays.asList(s1.chars().mapToObj(c -> (char) c).toArray(Character[]::new)));
        Set<Character> s2Set = new HashSet<>(Arrays.asList(s2.chars().mapToObj(c -> (char) c).toArray(Character[]::new)));
        
        s2Set.retainAll(s1Set);// intersection of two sets. Return all the elements that appear in both sets
        if (!s2Set.isEmpty())
        {
            return "YES";
        }
        return "NO";
        
        /*for (Character c : s2Set)
        {
            if (s1Set.contains(c))
            {
                return "YES";
            }
        }*/
    }
    
    private static final Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) throws IOException
    {
        
        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        
        for (int qItr = 0; qItr < q; qItr++)
        {
            String s1 = scanner.nextLine();
            
            String s2 = scanner.nextLine();
            
            String result = twoStrings(s1, s2);
            
            System.out.println(result);
        }
        
        
        scanner.close();
    }
}
