package com.company.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 */
public class ReverseLinkedList
{
    public ListNode list;
    
    public ListNode reverseList(ListNode head)
    {
        list = head;
        Deque<ListNode> queue = new ArrayDeque<>();
        while (list != null)
        {
            queue.add(list);
            list = list.next;
        }
        
        while (!queue.isEmpty())
        {
            ListNode next = queue.poll();
            add(next.val);
        }
        return list;
    }
    
    public void add(int value)
    {
        if (list == null)
        {
            list = new ListNode(value);
        }
        else
        {
            list = new ListNode(value, list);
        }
    }
    
    /*public ListNode reverseList(ListNode head)
    {
        if (head == null)
        {
            return head;
        }
        ListNode current = head.next;
        ListNode previous = head;
        
        while (current != null)
        {
            var temp = current.next;
            current.next = previous;
            previous = current;
            current = temp;
        }
        
        head.next = null;
        
        return previous;
    }*/
    
    
    public static void main(String[] args)
    {
        ReverseLinkedList linkedList = new ReverseLinkedList();
        linkedList.add(5);
        linkedList.add(4);
        linkedList.add(3);
        linkedList.add(2);
        linkedList.add(1);
        
        ListNode reversed = linkedList.reverseList(linkedList.list);
        while (reversed != null)
        {
            System.out.print(reversed.val + " ");
            reversed = reversed.next;
        }
        System.out.println();
    }
}


class ListNode
{
    int val;
    ListNode next;
    
    ListNode()
    {
    }
    
    ListNode(int val)
    {
        this.val = val;
    }
    
    ListNode(int val, ListNode next)
    {
        this.val = val;
        this.next = next;
    }
}
