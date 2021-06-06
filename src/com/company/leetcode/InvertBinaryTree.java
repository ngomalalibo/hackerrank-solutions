package com.company.leetcode;

/**
 * Given the root of a binary tree, invert the tree, and return its root.
 */
public class InvertBinaryTree
{
    /* TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        
        return root;*/
    public TreeNode invertTree(TreeNode root)
    {
        return invert(root);
    }
    
    public TreeNode invert (TreeNode root)
    {
        if (root == null)
        {
            return null;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invert(root.left);
        invert(root.right);
        return root;
    }
}
