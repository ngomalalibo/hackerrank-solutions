package com.company.leetcode;

import java.util.ArrayList;

public class KthSmallestElementInABSTree
{
    ArrayList<Integer> list = new ArrayList<>();
    public int kthSmallest(TreeNode root, int k)
    {
        traverse(root);
        
        return list.get(k-1);
    }
    
    public void traverse(TreeNode root)
    {
        if (root == null)
        {
            return;
        }
        traverse(root.left);
        list.add(root.val);
        traverse(root.right);
    }
}
