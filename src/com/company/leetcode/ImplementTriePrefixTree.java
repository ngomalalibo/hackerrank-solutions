package com.company.leetcode;

import java.util.HashMap;

// ImplementTriePrefixTree
public class ImplementTriePrefixTree
{
    
    private static class TrieNode
    {
        HashMap<Character, TrieNode> children = null;
        boolean isEndOfWord;
        
        TrieNode()
        {
            children = new HashMap<>();
            isEndOfWord = false;
        }
    }
    
    private final TrieNode root;
    
    /**
     * Initialize your data structure here.
     */
    public ImplementTriePrefixTree()
    {
        root = new TrieNode();
    }
    
    /**
     * Inserts a word into the trie.
     */
    public void insert(String word)
    {
        
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++)
        {
            char w = word.charAt(i);
            if (!cur.children.containsKey(w))
            {
                cur.children.put(w, new TrieNode());
            }
            
            cur = cur.children.get(w);
            
        }
        cur.isEndOfWord = true;
    }
    
    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word)
    {
        
        TrieNode trieNode = root;
        
        for (int i = 0; i < word.length(); i++)
        {
            char w = word.charAt(i);
            TrieNode node = trieNode.children.get(w);
            if (node == null)
            {
                return false;
            }
            trieNode = node;
        }
        return trieNode.isEndOfWord;
    }
    
    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix)
    {
        TrieNode trieNode = root;
        
        for (int i = 0; i < prefix.length(); i++)
        {
            char w = prefix.charAt(i);
            TrieNode node = trieNode.children.get(w);
            if (node == null)
            {
                return false;
            }
            trieNode = node;
        }
        return true;
    }
}
