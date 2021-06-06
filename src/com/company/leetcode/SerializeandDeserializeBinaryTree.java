package com.company.leetcode;

import java.util.Arrays;
import java.util.Stack;

public class SerializeandDeserializeBinaryTree
{
    // Encodes a tree to a single string.
    public String serialize(TreeNode root)
    {
        StringBuilder sb = new StringBuilder();
        traverseInOrderToString(root, sb);
        return sb.toString();
    }
    
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data)
    {
        System.out.println(data);
        String split[] = data.split(" ");
        Stack<Pair> st = new Stack<>();
        TreeNode root = null;
        if (split[0].equals("$"))
        {
            return root; // if root is null return null
        }
        root = new TreeNode(Integer.parseInt(split[0]));
        st.push(new Pair(root, 0)); // initial state is 0 for all nodes
        int idx = 1;
        while (idx < split.length)
        {
            String str = split[idx];
            TreeNode toAdd = null;
            if (!str.equals("$"))
            { // if str equals "$" then that means its null node
                toAdd = new TreeNode(Integer.parseInt(str));
            }
            Pair pair = st.peek();
            if (pair.state == 0)
            {
                TreeNode parent = pair.node;
                parent.left = toAdd; // children added to left when state is 0
                pair.state++; // increment state , next time we will add a child to the right
            }
            else if (pair.state == 1)
            {
                TreeNode parent = pair.node;
                parent.right = toAdd; // children added to right when state is 1
                st.pop();// children added to left , children added to right , our work is done for this node , remove it from the stack
            }
            if (toAdd != null)
            {
                pair = new Pair(toAdd, 0);
                st.push(pair);
            }
            idx++;
        }
        return root;
    }
    
    public void traverseInOrderToString(TreeNode root, StringBuilder sb)
    {
        if (root == null)
        {
            sb.append("$").append(" ");
            return;
        }
        sb.append(root.val).append(" ");
        traverseInOrderToString(root.left, sb);
        traverseInOrderToString(root.right, sb);
        return;
    }
    
    public static void main(String[] args)
    {
        SerializeandDeserializeBinaryTree sdbt = new SerializeandDeserializeBinaryTree();
        Tree dd = new Tree();
        
        dd.root = dd.insertLevelOrder(Arrays.asList(1, 2, 3, null, null, 4, 5), dd.root, 0);
        
        TreeNode deserialize = sdbt.deserialize(sdbt.serialize(dd.root));
    }
    
}

class Pair
{
    /*
    state == 0 means attach the child node to left
    state == 1 means attach the child node to right
    */
    TreeNode node;
    int state;
    
    public Pair(TreeNode node, int state)
    {
        this.node = node;
        this.state = state;
    }
}