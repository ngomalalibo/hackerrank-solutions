package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import static java.lang.System.in;

public class JavaMap
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        int n = Integer.parseInt(br.readLine());
        // br.readLine();
        
        Map<String, Integer> phoneBook = new HashMap<>();
        List<String> keys = new ArrayList<>();
        if (1 <= n && n <= 100000)
        {
            for (int i = 0; i < n; i++)
            {
                String name = br.readLine();
                int phone = Integer.parseInt(br.readLine());
                // br.readLine();
                phoneBook.put(name, phone);
            }
            //phoneBook.keySet().forEach(d -> System.out.println("key: " + d));
        }
        while (br.ready())
        {
            // System.out.println("Read Query");
            String s = br.readLine();
            if (s.chars().anyMatch(Character::isLetter))
            {
                keys.add(s);
            }
            else
            {
                System.exit(0);
            }
        }
        int q = keys.size();
        if (1 <= q && q <= 100000)
        {
            printPhoneBook(phoneBook, keys);
        }
        else
        {
            System.exit(0);
        }
    }
    
    public static void printPhoneBook(Map<String, Integer> phoneBook, List<String> keys)
    {
        // System.out.println("Print Query");
        AtomicInteger phone = new AtomicInteger();
        keys.forEach(key ->
                     {
                         if (phoneBook.containsKey(key))
                         {
                             phone.set(phoneBook.get(key));
                             System.out.println(key + "=" + phone.get());
                         }
                         else
                         {
                             System.out.println("Not found");
                         }
                     });
        
    }
}
