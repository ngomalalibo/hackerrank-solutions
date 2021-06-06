package com.company.leetcode;

public class LowestCommonAncestorOfABinarySearchTree
{
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q)
    {
        return LCA(root, p, q);
    }
    
    public TreeNode LCA(TreeNode root, TreeNode p, TreeNode q)
    {
        if (p.val < root.val && q.val < root.val)
        {
            return LCA(root.left, p, q);
        }
        else if (p.val > root.val && q.val > root.val)
        {
            return LCA(root.right, p, q);
        }
        else
        {
            return root;
        }
    }
    
    /*public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q)
    {
        while (root != null)
        {
            if (root.val > p.val && root.val > q.val)
            {
                root = root.left;
            }
            else if (root.val < p.val && root.val < q.val)
            {
                root = root.right;
            }
            else
            {
                break;
            }
        }
        return root;
        
    }*/
    
}
