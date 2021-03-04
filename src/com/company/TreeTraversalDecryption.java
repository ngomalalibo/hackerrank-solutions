package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class TreeTraversalDecryption
{
    public static void main(String[] args)
    {
        CharNode root = new CharNode('i');
        root.setSide(Side.Root);
        root.insertLeft('r');
        root.insertRight('y');
        root.getLeft().insertLeft('p');
        root.getLeft().insertRight('v');
        CharTree tree = new CharTree(root);
        
        /*CharNode root = new CharNode('r');
        root.setSide(Side.Root);
        root.insertLeft('e');
        root.insertRight('t');
        root.getRight().insertLeft('e');
        root.getRight().getLeft().insertLeft('c');
        root.getRight().getLeft().getLeft().insertLeft('s');
        CharTree tree = new CharTree(root);*/
        
        List<Position> treePositions = tree.traverse();
        System.out.println(treePositions.toString());
        treePositions.sort(Comparator.comparing(Position::getHorizontal, Comparator.naturalOrder()).thenComparing(Position::getVertical, Comparator.naturalOrder()));
        System.out.println(treePositions.toString());
        Character[] characters = treePositions.stream().map(Position::getData).toArray(Character[]::new);
        System.out.println(Arrays.toString(characters));
    }
}

class CharNode
{
    private char data;
    private CharNode left;
    private CharNode right;
    private Side side = Side.Root;
    
    static List<Position> nodePositions = new ArrayList<>();
    
    static int hor = 0;
    static int ver = 0;
    
    int count = 0;
    
    // traverse method in the node gets the position of the node in the tree and saved it in its Position field
    // the travers method in the tree ads all the positions to the array list. sorts them and returns the result string
    public List<Position> traverse()
    {
        nodePositions.add(new Position(hor, ver, data));
        
        switch (side)
        {
            case Left:
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
                if (left == null || right == null)
                {
                    ++hor;
                    --ver;
                }
                break;
            case Right:
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
                if (left == null || right == null)
                {
                    --hor;
                    --ver;
                    if (hor == -1 && ver == 1)
                    {
                        hor = 0;
                        ver = 0;
                    }
                }
                break;
            case Root:
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
                /*if (left == null || right == null)
                {
                    hor = 0;
                    ver = 0;
                }*/
                break;
        }
        
        return nodePositions;
    }
    
    public void insertLeft(char c)
    {
        this.left = new CharNode(c, Side.Left);
    }
    
    public void insertRight(char c)
    {
        this.right = new CharNode(c, Side.Right);
    }
    
    public CharNode(char data)
    {
        this.data = data;
    }
    
    public CharNode(char data, Side side)
    {
        this.data = data;
        this.side = side;
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
    
    public Side getSide()
    {
        return side;
    }
    
    public void setSide(Side side)
    {
        side = side;
    }
}

class CharTree
{
    private CharNode root;
    
    
    public List<Position> traverse()
    {
        List<Position> positions = new ArrayList<>();
        if (root != null)
        {
            positions = root.traverse();// everything happens inside here
        }
        return positions;
    }
    
    public void insertRootNode(char data)
    {
        if (root == null)
        {
            root = new CharNode(data);
        }
    }
    
    public void insertRootLeft(char node)
    {
        if (this.root != null)
        {
            this.root.insertLeft(node);
        }
    }
    
    public void insertRootRight(char node)
    {
        if (this.root != null)
        {
            this.root.insertRight(node);
        }
    }
    
    
    public CharTree(CharNode root)
    {
        this.root = root;
    }
    
    public CharNode getRoot()
    {
        return root;
    }
    
    public void setRoot(CharNode root)
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

enum Side
{
    Left, Right, Root
}