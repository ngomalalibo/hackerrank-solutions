package com.company.leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class MergeKSortedLists
{
    ListNode combined;
    ListNode l1;
    ListNode l2;
    ListNode l3;
    
    public ListNode mergeKLists(ListNode[] lists)
    {
        Map<Integer, Integer> valueNodes = new HashMap<>();
        for (ListNode list : lists)
        {
            while (list != null)
            {
                valueNodes.put(list.val, valueNodes.getOrDefault(list.val, 0) + 1);
                list = list.next;
            }
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
        if (l1 == null)
        {
            l1 = new ListNode(value);
        }
        else
        {
            l1 = new ListNode(value, l1);
        }
    }
    
    public void addL2(int value)
    {
        if (l2 == null)
        {
            l2 = new ListNode(value);
        }
        else
        {
            l2 = new ListNode(value, l2);
        }
    }
    
    public void addL3(int value)
    {
        if (l3 == null)
        {
            l3 = new ListNode(value);
        }
        else
        {
            l3 = new ListNode(value, l3);
        }
    }
    
    public static void main(String[] args)
    {
        MergeKSortedLists d = new MergeKSortedLists();
        d.addL1(5);
        d.addL1(4);
        d.addL1(1);
    
        d.addL2(4);
        d.addL2(3);
        d.addL2(1);
        
        d.addL3(6);
        d.addL3(2);
        
        ListNode [] lists = new ListNode[]{d.l1,d.l2,d.l3};
        ListNode listNode = new MergeKSortedLists().mergeKLists(lists);
        while (listNode != null)
        {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
    }
}
