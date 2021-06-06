package com.company.leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Given two strings s and t, return the minimum window in s which will contain all the characters in t. If there is no such window in s that covers all characters in t, return the empty string "".
 * <p>
 * Note that If there is such a window, it is guaranteed that there will always be only one unique minimum window in s.
 */

// Working. exceeds time limit
public class MinimumWindowSubstring
{
    public String minWindow(String s, String t)
    {
        // get them into an arrayList and compare the elements in both lists
        List<Character> tl = Arrays.asList(t.chars().mapToObj(c -> (char) c).toArray(Character[]::new));
        List<Character> sl = Arrays.asList(s.chars().mapToObj(c -> (char) c).toArray(Character[]::new));
        
        int min = Integer.MAX_VALUE;
        List<Character> minSub = new ArrayList<>();
        int sLeng = s.length();
        int startPoint = 0;
        boolean startContains = false;
        int tLeng = t.length();
        Map<Character, Integer> subMap;
        Map<Character, Integer> tMap = new HashMap<>();
        boolean contains = false;
        
        for (int m = 0; m < tLeng; m++)
        {
            tMap.put(t.charAt(m), tMap.getOrDefault(t.charAt(m), 0) + 1);
        }
        
        for (int i = tLeng; startPoint < sLeng; i++)
        {
            if (startContains)
            {
                ++startPoint;
                i = startPoint + (tLeng - 1);
                startContains = false;
                continue;
            }
            i = i > sLeng ? startPoint + 1 : i;
            List<Character> subList = sl.subList(startPoint, i);
            
            subMap = new HashMap<>();
            for (int m = 0; m < subList.size(); m++)
            {
                subMap.put(subList.get(m), subMap.getOrDefault(subList.get(m), 0) + 1);
            }
            int g = 0;
            for (char c : tMap.keySet())
            {
                g++;
                if (subMap.get(c) == null || subMap.get(c) < tMap.get(c))
                {
                    break;
                }
                if (g == tMap.size())
                {
                    contains = true;
                    startContains = true;
                }
            }
            if (contains)
            {
                if (subList.size() < min)
                {
                    min = subList.size();
                    minSub = subList;
                }
                contains = false;
            }
            
            if (startPoint == sLeng - tLeng)
            {
                break;
            }
            if (i == sLeng)
            {
                ++startPoint;
                i = startPoint + (tLeng - 1);
                startContains = false;
            }
        }
        return minSub.stream().map(String::valueOf).collect(Collectors.joining());
    }
    
    public static void main(String[] args)
    {
        System.out.println(new MinimumWindowSubstring().minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(new MinimumWindowSubstring().minWindow("a", "a"));
        System.out.println(new MinimumWindowSubstring().minWindow("a", "aa"));
        System.out.println(new MinimumWindowSubstring().minWindow("ab", "a"));
        System.out.println(new MinimumWindowSubstring().minWindow("aa", "aa"));
        System.out.println(new MinimumWindowSubstring().minWindow("ab", "b"));
        System.out.println(new MinimumWindowSubstring().minWindow("abc", "a"));
        System.out.println(new MinimumWindowSubstring().minWindow("abc", "bc"));
        System.out.println(new MinimumWindowSubstring().minWindow("abc", "b"));
        System.out.println(new MinimumWindowSubstring().minWindow("abc", "cba"));
        System.out.println(new MinimumWindowSubstring().minWindow("bbaa", "aba"));
        System.out.println(new MinimumWindowSubstring().minWindow("babb", "baba"));
        System.out.println(new MinimumWindowSubstring().minWindow("qxsncfwvbslazxuoxnedkukropehlwfbwxqycntdfgghecvdqbhcwtukkauwzzzvystcfohmupvastekunmqiidtjxriyqdyiyapohekxblrurbpgphoykjhjarhtwfduhvkpzumahdxagmivtxvgiepjvxetehnmczddurgdwdecrmzklxqubgfzfjslqizvheadvghrlnvcbxpnuhjxpqywzrkrbjokqpolxxflkapnzeatmltdbrackkwlvmwlbmxbjcmvebieilzwyszckzgulcihpgsssrtdvhaaligvvfrwaqyksegdjqmywfsoyotuxtwieefbjwxjpxvhcemnwzntgfjetdatyydecjgofdzudxbfbqsxpfsvmebijcbhcemfnuvtzupcrthujbuyiovvswdbagjdkxkyrftqbktvdcpogloqajlsgquiyfljcxjveengogbulsitexjeixwqpszoxkzzkiuooiweqxydqjywiiaqhyhwrgkosloetktjuponposfxrdhzdyibhesprjjczoyjhhgyxtnmlulextdatnecsyrlhangonsxxywutligguldpqgiemkymdjufycumwtjupfpdowjkjozzwjdivbvymrdlvzzstkmkpenfcyplnqkjzquutrsgiytdxsvsckftquzstqdihnrgfnbbevjovcutupnyburrpsjijmsqclyjzzk", "fxtusxonrfdrhxjamdkwm"));
    }
}
