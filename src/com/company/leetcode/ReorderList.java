package com.company.leetcode;


import java.util.ArrayDeque;
import java.util.Deque;

/**
 * You are given the head of a singly linked-list. The list can be represented as:
 * <p>
 * L0 → L1 → … → Ln - 1 → Ln
 * <p>
 * Reorder the list to be on the following form:
 * <p>
 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 * <p>
 * You may not modify the values in the list's nodes. Only nodes themselves may be changed.
 */
public class ReorderList
{
    public void reorderList(ListNode head)
    {
        Deque<ListNode> queue = new ArrayDeque<>();
        while (head != null)
        {
            queue.add(head);
            head = head.next;
        }
        
        int i = 1;
        while (!queue.isEmpty())
        {
            ListNode dd = (i % 2) == 0 ? queue.pollLast() : queue.pollFirst();
            if (dd != null)
            {
                head = add(dd.val, head);
            }
            ++i;
        }
        
        head = reverseList(head);
        while (head != null)
        {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
    
    public ListNode reverseList(ListNode head)
    {
        ListNode list = head;
        Deque<ListNode> queue = new ArrayDeque<>();
        while (list != null)
        {
            queue.add(list);
            list = list.next;
        }
        
        while (!queue.isEmpty())
        {
            ListNode next = queue.poll();
            list = add(next.val, list);
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
        ReorderList rl = new ReorderList();
        ListNode head = null;
        head = rl.add(8, head);
        head = rl.add(7, head);
        head = rl.add(6, head);
        head = rl.add(5, head);
        head = rl.add(4, head);
        head = rl.add(3, head);
        head = rl.add(2, head);
        head = rl.add(1, head);
        
        rl.reorderList(head);
        
    }
}
