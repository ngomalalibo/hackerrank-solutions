package com.company;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class LevelUpAndela
{
    private static int numPlayers(int k, ArrayList<Integer> n)
    {
        n.sort(Comparator.reverseOrder());
        int canLevelUp = 0;
        int rank = 1;
        int prevScore = Integer.MIN_VALUE;
        int leng = n.size();
        for (int i = 0; i < leng; i++)
        {
            if (prevScore != Integer.MIN_VALUE && prevScore != n.get(i))
            {
                rank = i + 1;
            }
            if (rank <= k && n.get(i) > 0)
            {
                ++canLevelUp;
            }
            else
            {
                break;
            }
            prevScore = n.get(i);
        }
        
        return canLevelUp;
    }
    
    public static void main(String[] args)
    {
        
        Scanner in = new Scanner(System.in);
        int k = in.nextInt();
        int n = in.nextInt();
        ArrayList<Integer> scores = new ArrayList<>(n);
        for (int i = 0; i < n; i++)
        {
            scores.add(in.nextInt());
        }
        
        int i = numPlayers(k, scores);
        System.out.println("numPlayer -> " + i);
    }
    /*private static int numPlayers(int k, ArrayList<Integer> n)
    {
        int rank = 0;
        int numPlayers = 0;
        int leng = n.size();
        n.sort(Comparator.reverseOrder());
        
        for (int i = 0, j = 1; i < leng - 1; i++, j++)
        {
            if (i == 0 && !n.get(i).equals(0))
            {
                rank = j;
                numPlayers++;
                continue;
            }
            if (n.get(i).equals(n.get(i + 1)) && rank <= k && n.get(i + 1) > 0)
            {
                numPlayers++;
            }
            else if (!n.get(i).equals(n.get(i + 1)) && rank <= k && n.get(i + 1) > 0 )
            {
                rank = j;
                numPlayers++;
            }
            else
            {
                break;
            }
        }
        
        return numPlayers;
    }*/
    
}
