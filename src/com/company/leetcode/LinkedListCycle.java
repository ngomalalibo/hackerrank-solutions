package com.company.leetcode;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle
{
    public ListNode list;
    
    public boolean hasCycle(ListNode head)
    {
        if (head == null)
        {
            return false;
        }
        Set<ListNode> visited = new HashSet<>();
        while (head != null)
        {
            if (!visited.contains(head))
            {
                visited.add(head);
                head = head.next;
            }
            else
            {
                return true;
            }
        }
        return false;
    }
    
    public void add(int value)
    {
        if (list == null)
        {
            list = new ListNode(value, new ListNode(2));
        }
        else
        {
            list = new ListNode(value, list);
        }
    }
    
    public static void main(String[] args)
    {
        LinkedListCycle d = new LinkedListCycle();
        d.add(-4);
        d.add(0);
        d.add(2);
        d.add(3);
        System.out.println(new LinkedListCycle().hasCycle(d.list));
    }
}
