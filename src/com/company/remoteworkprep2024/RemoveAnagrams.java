package com.company.remoteworkprep2024;

import java.util.*;
import java.util.stream.Collectors;

public class RemoveAnagrams
{
    /**
     * find the char and count composition of each word in the list
     * iterate through the list starting from the first word and check if they are anagrams
     * remove the subsequent anagrams
     * return the remaining list
     */
    
    // pick first word
    // put its char and count composition into a map
    // compare the word map with the subsequent words map compositions in the list
    public static List<String> funWithAnagram(List<String> text)
    {
        int size = text.size();
        List<String> result = new ArrayList<>(text);
        for (int i = 0; i < size; i++)
        {
            String word = text.get(i);
            
            Map<Character, Integer> charOccurrence = toMap(word);
    
            for (int j = i + 1; j < size; j++)
            {
                String s2 = text.get(j);
                
                Map<Character, Integer> s2CharOccurrence = toMap(s2);
    
                if (charOccurrence.equals(s2CharOccurrence))
                {
                    result.remove(s2);
                }
            }
        }
        
        result.sort(Comparator.naturalOrder());
        
        return result;
    }
    
    public static Map<Character, Integer> toMap(String word)
    {
        Map<Character, Integer> map = new HashMap<>();
        
        List<Character> chars = Arrays.asList(word.chars().mapToObj(c -> (char) c).toArray(Character[]::new));
        chars.stream().forEach(c ->
                            {
                                if (map.containsKey(c))
                                {
                                    map.put(c, map.get(c) + 1);
                                }
                                else
                                {
                                    map.put(c, 1);
                                }
                            });
        
        return map;
    }
    public static List<String> removeAnagrams_CGPT(List<String> inputList) {
        Map<String, String> sortedAnagrams = new HashMap<>();
        
        for (String str : inputList) {
            // Convert the string to char array, sort it, and then convert it back to a string
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedStr = new String(charArray);
            
            // Add the sorted string to the map if it doesn't exist
            // If it exists, it means we have an anagram and we skip the current string
            if (!sortedAnagrams.containsKey(sortedStr)) {
                sortedAnagrams.put(sortedStr, str);
            }
        }
        
        // Convert the values of the map to a list and sort it alphabetically
        List<String> result = new ArrayList<>(sortedAnagrams.values());
        result.sort(String::compareTo);
        
        return result;
    }
    
    
    public static void main(String[] args)
    {
        // System.out.println("whenCompareTwoHashMapsWithArrayValuesUsingEquals_thenFail() = " + whenCompareTwoHashMapsWithArrayValuesUsingEquals_thenFail());
        List<String> words = List.of("code", "doce", "ecod", "framer", "frame");
        // List<String> words = List.of("code", "aaagmnrs", "anagrams", "doce");
        System.out.println(funWithAnagram(words));
        System.out.println(removeAnagrams_CGPT(words));
    }
}
