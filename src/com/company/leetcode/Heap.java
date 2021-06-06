package com.company.leetcode;

public class Heap
{
    private HeapNode root;
    public int size = 0;
    
    public void insert(int value)
    {
        root.insert(value, ++size);
    }
    
    public void traverse()
    {
        root.traverse();
    }
    
    public HeapNode getRoot()
    {
        return root;
    }
    
    public int getSize()
    {
        return size;
    }
}
