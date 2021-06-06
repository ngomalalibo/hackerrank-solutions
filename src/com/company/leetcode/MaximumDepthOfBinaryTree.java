package com.company.leetcode;

/**
 * Given the root of a binary tree, return its maximum depth.
 * <p>
 * A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 */
public class MaximumDepthOfBinaryTree
{
    public int maxDepth(TreeNode root)
    {
        if (root == null)
        {
            return 0;
        }
        int l = maxDepth(root.left);
        int r = maxDepth(root.right);
        return l > r ? l + 1 : r + 1;
    }
    /*int l = 1;
    int r = 1;
    public int maxDepth(TreeNode root)
    {
        if (root == null)
        {
            return 0;
        }
        traverse(root);
        return Math.max(l, r);
    }
    
    public void traverse(TreeNode root)
    {
        if (root.left != null)
        {
            ++l;
            traverse(root.left);
        }
        if (root.right != null)
        {
            ++r;
            traverse(root.right);
        }
    }*/
    /*public int maxDepth(TreeNode root)
    {
        if (root != null)
        {
            root.traverse();
            int l = Tree.leftDepth;
            int r = Tree.rightDepth;
            Tree.leftDepth = 1;
            Tree.rightDepth = 1;
            return Math.max(l, r);
        }
        else
        {
            return 0;
        }
    }*/
    
    public static void main(String[] args)
    {
        
        /*Tree tree = new Tree();
        tree.insert(3);
        tree.insert(9);
        tree.insert(20);
        tree.insert(15);
        tree.insert(7);
        
        // tree.traverse();
        System.out.println(new MaximumDepthOfBinaryTree().maxDepth(tree.getRoot()));
        
        
        Tree tree1 = new Tree();
        tree1.insert(1);
        tree1.insert(2);
        
        // tree.traverse();
        
        System.out.println(new MaximumDepthOfBinaryTree().maxDepth(tree1.getRoot()));
        
        //0,2,4,1,null,3,-1,5,1,null,6,null,8]
    
        Tree tree2 = new Tree();
        tree2.insert(0);
        tree2.insert(2);
        tree2.insert(4);
        tree2.insert(1);
        // tree2.insert(0);
        tree2.insert(3);
        tree2.insert(-1);
        tree2.insert(5);
        tree2.insert(1);
        // tree2.insert(0);
        tree2.insert(6);
        // tree2.insert(0);
        tree2.insert(8);
    
        // tree.traverse();
        System.out.println(new MaximumDepthOfBinaryTree().maxDepth(tree2.getRoot()));*/
    }
}



