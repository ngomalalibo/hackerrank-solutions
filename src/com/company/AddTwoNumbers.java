package com.company;

import java.math.BigInteger;

public class AddTwoNumbers
{
    public static String getStringFromList(ListNode node)
    {
        StringBuilder sb = new StringBuilder();
        ListNode next = node.next;
        sb.append(node.val);
        while (next != null)
        {
            sb.append(next.val);
            next = next.next;
        }
        
        for (int i = sb.length() - 1; i >= 0; i--)
        {
            if (sb.charAt(i) == '0')
            {
                sb.deleteCharAt(i);
            }
            else
            {
                break;
            }
        }
        if (sb.length() == 0)
        {
            return "0";
        }
        return sb.reverse().toString();
    }
    
    public static ListNode buildList(String s)
    {
        ListNode head = null;
        for (int i = 0; i < s.length(); i++)
        {
            int val = Integer.parseInt(String.valueOf(s.charAt(i)));
            
            if (i == 0)
            {
                head = new ListNode(val);
            }
            else
            {
                head = new ListNode(val, head);
            }
        }
        
        return head;
    }
    
    
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2)
    {
        //Input: l1 = [2,4,3], l2 = [5,6,4]
        // Output: [7,0,8]
        
        String s1 = getStringFromList(l1);
        String s2 = getStringFromList(l2);
        
        BigInteger sum = new BigInteger(s1).add(new BigInteger(s2));
        
        String resultS = sum.toString();
        
        return buildList(resultS);
    }
    
    public static void main(String[] args)
    {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        
        // ListNode l1 = new ListNode(9);
        // ListNode l2 = new ListNode(1, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))))))))));
        
        ListNode listNode = addTwoNumbers(l1, l2);
        StringBuilder result = new StringBuilder();
        int counter = 0;
        if (listNode.val != 0)
        {
            result.append(listNode.val);
            counter++;
        }
        ListNode next = listNode.next;
        
        while (next != null)
        {
            if (next.val == 0 && counter == 0)
            {
            }
            else if (next.val == 0)
            {
                result.append(next.val);
            }
            else
            {
                result.append(next.val);
            }
            
            next = next.next;
            if (next == null && result.length() == 0)
            {
                result.append("0");
            }
        }
        
        System.out.println("result > " + result.toString());
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