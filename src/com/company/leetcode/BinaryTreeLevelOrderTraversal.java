package com.company.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).
 */
public class BinaryTreeLevelOrderTraversal
{
    public List<List<Integer>> levelOrder(TreeNode root)
    {
        return printLevelOrder(root);
    }
    
    /* function to print level order traversal of tree*/
    List<List<Integer>> printLevelOrder(TreeNode root)
    {
        List<List<Integer>> levels = new ArrayList<>();
        int h = height(root);
        for (int i = 1; i <= h; i++)
        {
            levels.add(printCurrentLevel(root, i));
        }
        return levels;
    }
    
    /* Print nodes at the current level */
    ArrayList<Integer> printCurrentLevel(TreeNode root, int level)
    {
        if (root == null)
        {
            return new ArrayList<>();
        }
        if (level == 1)
        {
            return new ArrayList<>(Collections.singletonList(root.val));
        }
        else
        {
            ArrayList<Integer> left = printCurrentLevel(root.left, level - 1);
            ArrayList<Integer> right = printCurrentLevel(root.right, level - 1);
            left.addAll(right);
            return left;
        }
    }
    
    /* Compute the "height" of a tree -- the number of
    nodes along the longest path from the root node
    down to the farthest leaf node.*/
    int height(TreeNode root)
    {
        if (root == null)
        {
            return 0;
        }
        else
        {
            /* compute  height of each subtree */
            int lheight = height(root.left);
            int rheight = height(root.right);
            
            /* use the larger one */
            return Math.max(lheight + 1, rheight + 1); // + 1 to include root
        }
    }
    
    
    public static void main(String[] args)
    {
        Tree d1 = new Tree();
        d1.root = d1.insertLevelOrder(Arrays.asList(3, 9, 20, null, null, 15, 7), d1.root, 0);
        
        
        System.out.println(new BinaryTreeLevelOrderTraversal().levelOrder(d1.root));
    }
}
