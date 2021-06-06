package com.company.leetcode;

public class SameTree
{
    public boolean isSameTree(TreeNode p, TreeNode q)
    {
        if (p == q && p == null)
        {
            return true;
        }
        else if (q != null && p == null)
        {
            return false;
        }
        else if (p != null && q == null)
        {
            return false;
        }
        return (isSameTree(p.left, q.left) && (p.val == q.val) && (isSameTree(p.right, q.right)));
    }
    
    public static void main(String[] args)
    {
    
    }
}
