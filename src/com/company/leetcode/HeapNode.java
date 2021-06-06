package com.company.leetcode;

public class HeapNode
{
    int val;
    int index;
    HeapNode next;
    
    HeapNode()
    {
    }
    
    HeapNode(int val, int index)
    {
        this.val = val;
        this.index = index;
    }
    
    public void insert(Integer value, int index)
    {
        next = new HeapNode(value, index);
    }
    
    public void traverse()
    {
        if (this.next != null)
        {
            this.next.traverse();
        }
        System.out.print(this.val + " ");
    }
}
