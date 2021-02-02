package com.company;

import java.util.*;

public class CompetitiveGaming
{
    
    public static void storeDup(List<Integer> dups, List<Integer> scores, int n, int i, int j, Map<Integer, List<Integer>> posScores)
    {
        // check if position (j) exists in posScores before initializing a new array.
        if (posScores.containsKey(j))
        {
            List<Integer> exists = posScores.get(j);
            exists.add(scores.get(i));
            posScores.put(j, exists);
        }
        else
        {
            dups.add(scores.get(i));
            posScores.put(j, dups);
        }
        
    }
    
    // static List<Integer> dups = new ArrayList<>();
    public static int numPlayers(int k, List<Integer> scores)
    {
        // reverse sort scores to get highest to lowest
        scores.sort(Comparator.reverseOrder());
        
        int n = scores.size();
        int playerPosition = 0;
        int numPlayers = 0;
        int counter = 0;
        Map<Integer, List<Integer>> posScores = new HashMap<>(n);
        
        // rank players. find their positions. use list to store players with same rank
        for (int i = 0, j = 1; i < n; i++, j++)
        {
            List<Integer> dups = new ArrayList<>();
            /**  100, 50, 50, 25 */
            if (i == 0)
            {
                storeDup(dups, scores, n, i, j, posScores);
                continue;
            }
            
            if (scores.get(i).equals(scores.get(i - 1)))
            {
                --j;
                ++counter;
                storeDup(dups, scores, n, i, j, posScores);
                continue;
            }
            if (counter != 0 && !scores.get(i).equals(scores.get(i - 1)))
            {
                j += counter;
                counter = 0;
                storeDup(dups, scores, n, i, j, posScores);
                
                continue;
            }
            storeDup(dups, scores, n, i, j, posScores);
        }
        //eliminate players with 0 score
        posScores.values().forEach(arr -> arr.removeIf(score -> score.equals(0)));
        
        playerPosition = Long.valueOf(posScores.keySet().stream().filter(d -> d <= k).count()).intValue();
        // find players who will level up
        for (int i = 1; i <= playerPosition; i++)
        {
            List<Integer> integers = posScores.get(i);
            numPlayers += integers.size();
        }
        return numPlayers;
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
}
