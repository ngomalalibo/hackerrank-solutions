package com.company.musala;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class FindAnagram
{
    public static List<String> funWithAnagrams(List<String> text)
    {
        Collections.sort(text);
        // str = ["code", "doce", "ecod", "framer", "frame"]
        
        // poke pkoe okpe ekop
        AtomicReference<List<Character>> strr = new AtomicReference<>(new ArrayList<>());
        for (int j = 0; j < text.size(); j++)
        {
            strr.set(Arrays.asList(text.get(j).chars().mapToObj(c -> (char) c).toArray(Character[]::new)));
            Collections.sort(strr.get());
            List<Character> anagram;
            for (int i = 0; i < text.size(); i++)
            {
                // cdeo
                anagram = Arrays.asList(text.get(i).chars().mapToObj(c -> (char) c).toArray(Character[]::new));
                Collections.sort(anagram);
                if (strr.get().equals(anagram) && i != j)
                {
                    text.remove(i);
                    break;
                }
            }
        }
        return text;
    }
    
    public static void main(String[] args)
    {
        List<String> ddd = new ArrayList<>(Arrays.asList("poke", "pkoe", "okpe", "ekop"));
        System.out.println(funWithAnagrams(ddd));
    }
}
