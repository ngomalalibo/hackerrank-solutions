package com.company.leetcode;

import java.util.*;

/**
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 */
public class GroupAnagrams
{
    public List<List<String>> groupAnagrams(String[] strs)
    {
        Set<String> anagrams = new HashSet<>();
        Map<String, ArrayList<String>> strToAnagrm = new HashMap<>();
        char[] chars;
        for (String s : strs)
        {
            chars = s.toCharArray();
            Arrays.sort(chars);
            anagrams.add(String.valueOf(chars));
        }
    
        for (String s : strs)
        {
            String ss = s;
            chars = s.toCharArray();
            Arrays.sort(chars);
            s = String.valueOf(chars);
            for (String anagram : anagrams)
            {
                if (s.equals(anagram))
                {
                    if (strToAnagrm.get(anagram) != null)
                    {
                        ArrayList<String> strings = strToAnagrm.get(anagram);
                        strings.add(ss);
                        strToAnagrm.put(anagram, strings);
                        break;
                    }
                    else
                    {
                        strToAnagrm.put(anagram, new ArrayList<>(Collections.singletonList(ss)));
                    }
                }
            }
        }
        return new ArrayList<>(strToAnagrm.values());
    }
    /*public List<List<String>> groupAnagrams(String[] strs)
    {
        List<List<String>> groups = new ArrayList<>();
        ArrayList<String> slist = new ArrayList<>(Arrays.asList(strs));
        @SuppressWarnings("unchecked")
        ArrayList<String> sListClone = (ArrayList<String>) slist.clone();
    
        for (int i = 0; i < slist.size(); i++)
        {
            if (sListClone.isEmpty())
            {
                break;
            }
            if (!sListClone.contains(slist.get(i)))
            {
                continue;
            }
        
            List<String> ss = new ArrayList<>();
            for (int j = i+1; j < slist.size(); j++)
            {
                if (sListClone.isEmpty())
                {
                    break;
                }
                if (!sListClone.contains(slist.get(j)))
                {
                    continue;
                }
                if (isAnagram(slist.get(i), slist.get(j)))
                {
                    ss.add(slist.get(j));
                    sListClone.remove(slist.get(j));
                }
            }
            ss.add(slist.get(i));
            sListClone.remove(slist.get(i));
            groups.add(ss);
        }
        
        return groups;
    }*/
    
    public static void main(String[] args)
    {
        List<List<String>> lists = new GroupAnagrams().groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        lists.forEach(list ->
                      {
                          System.out.print(list.toString());
                          System.out.println();
                      });
    }
}
