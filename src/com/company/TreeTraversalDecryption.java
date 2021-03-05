package com.company;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TreeTraversalDecryption
{
    public static void main(String[] args)
    {
        // Case 1
        /*CharNode root = new CharNode('i');
        root.insertLeft('r');
        root.insertRight('y');
        root.getLeft().insertLeft('p');
        root.getLeft().insertRight('v');*/
        
        // Case 2
        /*CharNode root = new CharNode('a');
        root.insertLeft('i');
        root.getLeft().insertLeft('c');*/
        
        // Case 3
        /*CharNode root = new CharNode('c');
        root.insertRight('i');
        root.getRight().insertRight('a');*/
        
        //Case 4
        /*CharNode root = new CharNode('r');
        root.insertLeft('e');
        root.insertRight('t');
        root.getRight().insertLeft('e');
        root.getRight().getLeft().insertLeft('c');
        root.getRight().getLeft().getLeft().insertLeft('s');*/
        
        // Case 5
        CharNode root = new CharNode('e');
        root.insertLeft('s');
        root.insertRight('r');
        root.getLeft().insertRight('c');
        root.getLeft().getRight().insertRight('e');
        root.getLeft().getRight().getRight().insertRight('t');
        
        CharTree tree = new CharTree(root);
        String result = tree.traverse();
        System.out.println(result);
    }
}

class CharNode
{
    private char data;
    private CharNode left;
    private CharNode right;
    private boolean isLeft;
    
    static List<Position> nodePositions = new ArrayList<>();
    
    static int hor = 0;
    static int ver = 0;
    
    // traverse method in the node gets the position of the node in the tree, saved it in its Position field and adds each Position object to the list
    public void setHorVer(int hor, int ver)
    {
        this.hor = hor;
        this.ver = ver;
        nodePositions = new ArrayList<>();
    }
    
    public List<Position> traverse()
    {
        nodePositions.add(new Position(hor, ver, data));
        if (left != null)
        {
            --hor;
            ++ver;
            left.traverse();
        }
        if (right != null)
        {
            ++hor;
            ++ver;
            right.traverse();
        }
        
        if (isLeft)
        {
            ++hor;
            --ver;
        }
        else
        {
            --hor;
            --ver;
        }
        
        return nodePositions;
    }
    
    public void insertLeft(char c)
    {
        this.left = new CharNode(c, true);
    }
    
    public void insertRight(char c)
    {
        this.right = new CharNode(c, false);
    }
    
    public CharNode(char data)
    {
        this.data = data;
    }
    
    public CharNode(char data, boolean isLeft)
    {
        this.data = data;
        this.isLeft = isLeft;
    }
    
    
    public char getData()
    {
        return data;
    }
    
    public void setData(char data)
    {
        this.data = data;
    }
    
    public CharNode getLeft()
    {
        return left;
    }
    
    public void setLeft(CharNode left)
    {
        this.left = left;
    }
    
    public CharNode getRight()
    {
        return right;
    }
    
    public void setRight(CharNode right)
    {
        this.right = right;
    }
    
}

class CharTree
{
    private CharNode root;
    
    
    public String traverse()
    {
        if (root != null)
        {
            List<Position> positions = new ArrayList<>();
            positions.add(new Position(0, 0, root.getData()));
            if (root.getLeft() != null)
            {
                root.setHorVer(-1, 1);
                positions.addAll(root.getLeft().traverse());
            }
            if (root.getRight() != null)
            {
                root.setHorVer(1, 1);
                positions.addAll(root.getRight().traverse());
            }
            positions.sort(Comparator.comparing(Position::getHorizontal, Comparator.naturalOrder()).thenComparing(Position::getVertical, Comparator.naturalOrder())); // sort Positions on hor, vert positions
            StringBuilder sb = new StringBuilder();
            positions.stream().map(Position::getData).forEach(sb::append);
            return sb.toString();
        }
        return null;
    }
    
    
    public CharTree(CharNode root)
    {
        this.root = root;
    }
}


class Position
{
    private int horizontal;
    private int vertical;
    private char data;
    
    public Position(int horizontal, int vertical, char data)
    {
        this.horizontal = horizontal;
        this.vertical = vertical;
        this.data = data;
    }
    
    public int getHorizontal()
    {
        return horizontal;
    }
    
    public void setHorizontal(int horizontal)
    {
        this.horizontal = horizontal;
    }
    
    public int getVertical()
    {
        return vertical;
    }
    
    public void setVertical(int vertical)
    {
        this.vertical = vertical;
    }
    
    public char getData()
    {
        return data;
    }
    
    public void setData(char data)
    {
        this.data = data;
    }
    
    @Override
    public String toString()
    {
        return "Position{" +
                "horizontal=" + horizontal +
                ", vertical=" + vertical +
                ", data=" + data +
                '}';
    }
}