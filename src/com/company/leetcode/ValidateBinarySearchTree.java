package com.company.leetcode;

public class ValidateBinarySearchTree
{
    boolean result = true;
    Integer prev = null;
    public boolean isValidBST(TreeNode root)
    {
        return isValid(root);
    }
    
    public boolean isValid(TreeNode root)
    {
        if (root == null)
        {
            return true;
        }
    
        isValid(root.left);
        if (prev !=null && prev >= root.val)
        {
            result = false;
            prev = root.val;
        }
        else
        {
            prev = root.val;
        }
        
        isValid(root.right);
        
        return result;
    }
}
