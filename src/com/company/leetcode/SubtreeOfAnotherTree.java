package com.company.leetcode;

public class SubtreeOfAnotherTree
{
    
    public boolean isSubtree(TreeNode root, TreeNode subRoot)
    {
        if (root == null && subRoot == null)
        {
            return true;
        }
        if (root == null && subRoot != null || root != null && subRoot == null)
        {
            return false;
        }
    
        if (isEqual(root, subRoot))
        {
            return true;
        }
        
        return (isSubtree(root.left, subRoot) || (isSubtree(root.right, subRoot)));
    }
    
    public boolean isEqual(TreeNode root, TreeNode subRoot)
    {
        if (root == null && subRoot == null)
        {
            return true;
        }
        if (root == null && subRoot != null || root != null && subRoot == null)
        {
            return false;
        }
        return isEqual(root.left, subRoot.left) && (root.val == subRoot.val) && isEqual(root.right, subRoot.right);
    }
    
    public void traverse(TreeNode root)
    {
        if (root == null)
        {
            return;
        }
        System.out.println(root.val);
        traverse(root.left);
        traverse(root.right);
    }
}
