package com.company.leetcode;

public class TreeNode
{
    int val;
    TreeNode left;
    TreeNode right;
    
    
    TreeNode()
    {
    }
    
    TreeNode(Integer val)
    {
        if (val == null)
        {
            val = -1000;
        }
        this.val = val;
    }
    
    TreeNode(int val, TreeNode left, TreeNode right)
    {
        this.val = val;
        this.left = left;
        this.right = right;
    }
    
    public void traverse()
    {
        if (this.left != null)
        {
            this.left.traverse();
        }
        System.out.print(this.val + " ");
        if (this.right != null)
        {
            this.right.traverse();
        }
    }
}