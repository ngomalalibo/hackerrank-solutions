package com.company;

import java.io.IOException;
import java.util.*;

public class SherlockAndAnagrams
{
    // Complete the sherlockAndAnagrams function below.
    static int sherlockAndAnagrams(String s)
    {
        int totalCount = 0;
        int sl = s.length();
        
        HashMap<String, Integer> ssc = new HashMap<>();
        if (sl < 2 || sl > 100)
        {
            System.exit(0);
        }
        Arrays.stream(s.chars().mapToObj(c -> (char) c).toArray(Character[]::new)).forEach(c ->
                                                                                           {
                                                                                               if (Character.isUpperCase(c) || Character.isDigit(c))
                                                                                               {
                                                                                                   System.exit(0);
                                                                                               }
                                                                                           });
        
        // convert string to map with integers as values
        for (int i = 0; i <= sl; i++)
        {
            for (int j = i + 1; j <= sl; j++)
            {
                String sub = s.substring(i, j);
                char[] c = sub.toCharArray();
                Arrays.sort(c);
                sub = String.valueOf(c);
                if (ssc.containsKey(sub))
                {
                    Integer subCount = ssc.get(sub);
                    ssc.put(sub, subCount + 1);
                    //totalCount+=subCount;
                }
                else
                {
                    ssc.put(sub, 1);
                }
            }
        }
        for (String ss : ssc.keySet())
        {
            Integer ii = ssc.get(ss);
            totalCount += (ii*(ii-1))/2;
        }
        
        return totalCount;
    }
    
    private static final Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) throws IOException
    {
        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        
        if (q < 1 || q > 10)
        {
            return;
        }
        
        for (int qItr = 0; qItr < q; qItr++)
        {
            String s = scanner.nextLine();
            
            int result = sherlockAndAnagrams(s);
            System.out.println(result);
            
        }
        
        scanner.close();
    }
}

/* Brutforce
static int sherlockAndAnagrams(String s)
    {
        final int[] count = {0};
        int sl = s.length();
        
        if (sl < 2 || sl > 100)
        {
            System.exit(0);
        }
        Arrays.stream(s.chars().mapToObj(c -> (char) c).toArray(Character[]::new)).forEach(c ->
                                                                                           {
                                                                                               if (Character.isUpperCase(c) || Character.isDigit(c))
                                                                                               {
                                                                                                   System.exit(0);
                                                                                               }
                                                                                           });
        
        Map<Integer, Character> ssc;
        
        for (int i = 0; i < s.length(); i++)
        {
            // iterate through string to get substrings
            for (int j = i + 1; j < sl && j - i <= ((sl / 2) + 1); j++)
            {
                String ss = s.substring(i, j);
                //System.out.println("ss " + ss);
                int ssl = ss.length();
                ssc = new HashMap<>(ssl);
                
                for (int l = 0; l < ssl; l++)
                {
                    ssc.put(l, ss.charAt(l));
                }
                
                for (int k = i + 1; k + ssl <= sl; k++)
                {
                    String ss2 = s.substring(k, k + ssl);
                    Character[] chars = ss2.chars().mapToObj(c -> (char) c).toArray(Character[]::new);
                    Arrays.sort(chars);
                    List<Character> ss2c = Arrays.asList(chars);
                    
                    if (Arrays.equals(ss2c.toArray(), ssc.values().stream().sorted().toArray()))
                    {
                        count[0]++;
                    }
                }
            }
        }
        return count[0];
    }
* */