package com.company.leetcode;

import java.util.Arrays;

public class BinaryTreeMaximumPathSum
{
    int maxSum = Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root)
    {
        helper(root);
        return maxSum;
    }
    
    public int helper(TreeNode root)
    {
        if (root == null)
        {
            return -1000;
        }
        
        if (root.left == null && root.right == null)
        {
            maxSum = Math.max(maxSum, root.val);
            return root.val;
        }
        else if (root.left != null && root.right != null)
        {
            if (root.left.val == -1000 && root.right.val == -1000)
            {
                maxSum = Math.max(maxSum, root.val);
                return root.val;
            }
        }
        
        int lSum = helper(root.left);
        int rSum = helper(root.right);
        
        maxSum = Math.max(maxSum, root.val);
        maxSum = Math.max(maxSum, root.val + lSum + rSum);
        int ret = root.val;
        ret = Math.max(ret, root.val + lSum);
        ret = Math.max(ret, root.val + rSum);
        
        maxSum = Math.max(maxSum, ret);
        
        return ret;
    }
    
    public static void main(String[] args)
    {
        // [-10,9,20,null,null,15,7]
        /*Tree d = new Tree();
        d.root = d.insertLevelOrder(Arrays.asList(-10,9,20,null,null,15,7), d.root, 0);
        
        
        d.traverseInOrder(d.root);
        System.out.println();
        
        System.out.println(new BinaryTreeMaximumPathSum().maxPathSum(d.root));*/
        
        //[1,2,null,3,null,4,null,5]
        Tree d1 = new Tree();
        d1.root = d1.insertLevelOrder(Arrays.asList(1, 2, null, 3, null, 4, null, 5), d1.root, 0);
        // d1.root = d1.insertLevelOrder(Arrays.asList(5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1), d1.root, 0);
        // d1.root = d1.insertLevelOrder(Arrays.asList(1, 2, 3), d1.root, 0);
        // d1.root = d1.insertLevelOrder(Arrays.asList(-10, 9, 20, null, null, 15, 7), d1.root, 0);
        // d1.root = d1.insertLevelOrder(Arrays.asList(1, -2, -3, 1, 3, -2, null, -1), d1.root, 0);
        // d1.root = d1.insertLevelOrder(Arrays.asList(1, 2, 3), d1.root, 0);
        
        // d1.traverseInOrder(d1.root);
        System.out.println();
        
        System.out.println(new BinaryTreeMaximumPathSum().maxPathSum(d1.root));
        
        
        /*Tree d2 = new Tree();
        d2.root = d2.insertLevelOrder(Arrays.asList(5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1), d2.root,0);
    
        
        d2.traverseInOrder(d2.root);
        System.out.println();
        
        System.out.println(new BinaryTreeMaximumPathSum().maxPathSum(d2.root));*/
        
        // [5,4,8,11,null,13,4,7,2,null,null,null,1]
    }
}
