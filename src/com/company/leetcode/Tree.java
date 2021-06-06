package com.company.leetcode;

import java.util.List;

public class Tree
{
    public TreeNode root;
    
    public TreeNode insertLevelOrder(List<Integer> list, TreeNode root, Integer i)
    {
        // Base case for recursion
        if (i < list.size())
        {
            root = new TreeNode(list.get(i));
            
            // insert left child
            root.left = insertLevelOrder(list, root.left, 2 * i + 1);
            
            // insert right child
            root.right = insertLevelOrder(list, root.right, 2 * i + 2);
        }
        return root;
    }
    
    public void traverseInOrder(TreeNode root)
    {
        if (root != null)
        {
            traverseInOrder(root.left);
            System.out.print(root.val + " ");
            traverseInOrder(root.right);
        }
    }
}
