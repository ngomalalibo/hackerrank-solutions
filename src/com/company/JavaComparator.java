package com.company;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

// Same question with SortingComparator
class Checker implements Comparator<Player>
{
    
    
    @Override
    public int compare(Player o1, Player o2)
    {
        int compare = 0;
        boolean o1containsLetter = false;
        boolean o2containsLetter = false;
        if (0 <= o1.score && o1.score <= 1000 && 0 <= o2.score && o2.score <= 1000)
        {
            for (int i = 0; i < o1.name.length(); i++)
            {
                o1containsLetter = o1.name.chars().anyMatch(Character::isLetter);
            }
            for (int i = 0; i < o2.name.length(); i++)
            {
                o2containsLetter = o2.name.chars().anyMatch(Character::isLetter);
            }
            if (o1containsLetter && o2containsLetter)
            {
                compare = Integer.compare(o2.score, o1.score);
                if (compare == 0)
                {
                    return o1.name.compareTo(o2.name);
                }
                return compare;
            }
        }
        else
        {
            System.exit(0);
        }
        return compare;
    }
    
}

/*class ScoreComparator implements Comparator<Player>
{
    @Override
    public int compare(Player o1, Player o2)
    {
        return Integer.compare(o2.score, o1.score);
    }
}

class NameComparator implements Comparator<Player>
{
    public int compare(Player o1, Player o2)
    {
        
        return o1.name.compareTo(o2.name);
    }
}*/

class Player
{
    String name;
    int score;
    
    Player(String name, int score)
    {
        this.name = name;
        this.score = score;
    }
    
    
}

public class JavaComparator
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        
        Player[] player = new Player[n];
        Checker checker = new Checker();
        
        for (int i = 0; i < n; i++)
        {
            player[i] = new Player(scan.next(), scan.nextInt());
        }
        scan.close();
        
        Arrays.sort(player, checker);
        for (int i = 0; i < player.length; i++)
        {
            System.out.printf("%s %s\n", player[i].name, player[i].score);
        }
    }
}
