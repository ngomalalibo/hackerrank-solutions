package com.company.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class RemoveNthNodeFromEndOfList
{
    public ListNode removeNthFromEnd(ListNode head, int n)
    {
        if (head == null)
        {
            return null;
        }
        ListNode temp = head;
        int size = 0;
        
        while (temp != null)
        {
            size++;
            temp = temp.next;
        }
        if (n < 0 || n > size)
        {
            return head;
        }
        int remove = (size - n); // calculate the position from front
        ListNode before = null;
        Deque<ListNode> queue = new ArrayDeque<>(); // queue to hold nodes
        int count = 0;
        while (head != null)
        {
            if (count == remove) // if this is the item to remove and the next item is null then add before to queue and break;
            {
                if (head.next == null)
                {
                    if (before != null)
                    {
                        queue.add(before);
                    }
                    else
                    {
                        return null;
                    }
                }
            }
            else if (count == remove - 1)
            {
                before = head;
            }
            else if (count == remove + 1)
            {
                if (before == null)
                {
                    before = head;
                    queue.add(before);
                }
                else
                {
                    before.next = head;
                    queue.add(before);
                    queue.add(head);
                }
               
            }
            else
            {
                queue.add(head);
            }
            head = head.next;
            count++;
        }
        
        ListNode list = null;
        while (!queue.isEmpty())
        {
            int val = queue.pollLast().val;
            list = add(val, list);
        }
        
        return list;
    }
    
        public ListNode add(int value, ListNode list)
        {
            if (list == null)
            {
                list = new ListNode(value);
            }
            else
            {
                list = new ListNode(value, list);
            }
            return list;
        }
    
    public static void main(String[] args)
    {
        RemoveNthNodeFromEndOfList d = new RemoveNthNodeFromEndOfList();
        ListNode head = null;
        head = d.add(5, head);
        head = d.add(4, head);
        head = d.add(3, head);
        head = d.add(2, head);
        head = d.add(1, head);
        
        ListNode listNode = d.removeNthFromEnd(head, 2);
        while (listNode != null)
        {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
        System.out.println();
        
        ListNode dd = null;
        dd = d.add(2, dd);
        dd = d.add(1, dd);
        ListNode ln = d.removeNthFromEnd(dd, 1);
        while (ln != null)
        {
            System.out.print(ln.val + " ");
            ln = ln.next;
        }
        System.out.println();
        
        ListNode dd1 = null;
        dd1 = d.add(1, dd1);
        ListNode ln1 = d.removeNthFromEnd(dd1, 1);
        while (ln1 != null)
        {
            System.out.print(ln1.val + " ");
            ln1 = ln1.next;
        }
        System.out.println();
        
        ListNode dd2 = null;
        dd2 = d.add(2, dd2);
        dd2 = d.add(1, dd2);
        ListNode ln2 = d.removeNthFromEnd(dd2, 2);
        while (ln2 != null)
        {
            System.out.print(ln2.val + " ");
            ln2 = ln2.next;
        }
        
    }
}
