package com.company.leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Merge two sorted linked lists and return it as a sorted list. The list should be made by splicing together the nodes of the first two lists.
 */
public class MergeTwoSortedLists
{
    ListNode combined;
    ListNode l11;
    ListNode l22;
    
    public ListNode mergeTwoLists(ListNode l1, ListNode l2)
    {
        Map<Integer, Integer> valueNodes = new HashMap<>();
        while (l1 != null)
        {
            valueNodes.put(l1.val, valueNodes.getOrDefault(l1.val, 0) + 1);
            l1 = l1.next;
        }
        while (l2 != null)
        {
            valueNodes.put(l2.val, valueNodes.getOrDefault(l2.val, 0) + 1);
            l2 = l2.next;
        }
        
        ArrayList<Integer> ss = valueNodes.keySet().stream().sorted(Comparator.reverseOrder()).collect(Collectors.toCollection(ArrayList::new));
        
        ss.forEach(item ->
                   {
                       Integer integer = valueNodes.get(item);
                       while (integer != null && integer > 0)
                       {
                           add(item);
                           integer--;
                       }
                   });
        return combined;
    }
    
    public void add(int value)
    {
        if (combined == null)
        {
            combined = new ListNode(value);
        }
        else
        {
            combined = new ListNode(value, combined);
        }
    }
    
    public void addL1(int value)
    {
        if (l11 == null)
        {
            l11 = new ListNode(value);
        }
        else
        {
            l11 = new ListNode(value, l11);
        }
    }
    
    public void addL2(int value)
    {
        if (l22 == null)
        {
            l22 = new ListNode(value);
        }
        else
        {
            l22 = new ListNode(value, l22);
        }
    }
    
    
    public static void main(String[] args)
    {
        MergeTwoSortedLists d = new MergeTwoSortedLists();
        d.addL1(4);
        d.addL1(2);
        d.addL1(1);
        
        d.addL2(4);
        d.addL2(3);
        d.addL2(1);
        
        ListNode listNode = new MergeTwoSortedLists().mergeTwoLists(d.l11, d.l22);
        while (listNode != null)
        {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
    }
    
    
}
