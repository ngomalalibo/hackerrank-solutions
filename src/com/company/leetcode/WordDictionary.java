package com.company.leetcode;

// Leetcode . Design Add and Search WordsDataStructure
public class WordDictionary
{
    
    Trie root;
    
    public WordDictionary()
    {
        root = new Trie('\0');
    }
    
    public void addWord(String word)
    {
        Trie cur = root;
        for (char c : word.toCharArray())
        {
            if (cur.children[c - 'a'] == null)
            {
                cur.children[c - 'a'] = new Trie(c);
            }
            cur = cur.children[c - 'a'];
        }
        cur.isWord = true;
    }
    
    public boolean search(String word)
    {
        return search(word, 0, root);
    }
    
    public boolean search(String word, int idx, Trie cur)
    {
        if (idx == word.length())
        {
            return cur.isWord;
        }
        char c = word.charAt(idx);
        if (c == '.')
        {
            for (int i = 0; i < 26; i++)
            {
                boolean res = cur.children[i] != null && search(word, idx + 1, cur.children[i]);
                if (res == true)
                {
                    return true;
                }
            }
            return false;
        }
        else
        {
            return cur.children[c - 'a'] != null && search(word, idx + 1, cur.children[c - 'a']);
        }
        
    }
    
    
}

class Trie
{
    char c;
    Trie[] children;
    boolean isWord;
    
    Trie(char c)
    {
        this.c = c;
        children = new Trie[26];
        isWord = false;
    }
}