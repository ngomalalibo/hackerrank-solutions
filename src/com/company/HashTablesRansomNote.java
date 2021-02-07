package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HashTablesRansomNote
{
    // Lession on HashMaps
    static void checkMagazine(String[] magazine, String[] note)
    {
        Map<String, Integer> magMap = new HashMap<>();
        
        int magCount;
        
        for (String m : magazine)
        {
            // magCount = (int)Arrays.stream(magazine).filter(d -> d.equals(m)).count(); // Not effecient
            if (magMap.containsKey(m))
            {
                magCount = magMap.get(m);
                magMap.put(m, ++magCount);
            }
            else
            {
                magMap.put(m, 1);
            }
        }
        
        for (String s : note)
        {
            if (magMap.containsKey(s))
            {
                Integer integer = magMap.get(s);
                if (integer <= 0)
                {
                    System.out.println("No");
                    System.exit(0);
                }
                magMap.put(s, --integer);
            }
            else if (!magMap.containsKey(s))
            {
                System.out.println("No");
                System.exit(0);
            }
        }
        System.out.println("Yes");
    }
    
    private static final Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args)
    {
        String[] mn = scanner.nextLine().split(" ");
        
        int m = Integer.parseInt(mn[0]);
        
        int n = Integer.parseInt(mn[1]);
        if (1 <= m && n <= 30000)
        {
            String[] magazine = new String[m];
            
            String[] magazineItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            
            for (int i = 0; i < m; i++)
            {
                String magazineItem = magazineItems[i];
                magazine[i] = magazineItem;
            }
            
            String[] note = new String[n];
            
            String[] noteItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            
            for (int i = 0; i < n; i++)
            {
                String noteItem = noteItems[i];
                note[i] = noteItem;
            }
            checkMagazine(magazine, note);
        }
        
        
        scanner.close();
    }
}
