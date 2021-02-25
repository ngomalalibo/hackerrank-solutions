package com.company;

import java.io.IOException;
import java.util.*;

public class LuckBalance
{
    static int luckBalance(int k, int[][] contests)
    {
        int maxLuckBal = 0;
        int leng = contests.length;
        //System.out.println(Arrays.deepToString(contests));
        
        Map<Integer, List<Integer>> impContests = new HashMap<>();
        for (int i = 0; i < leng; i++)
        {
            int contest = contests[i][0];
            int importance = contests[i][1];
            if (importance == 1)
            {
                if (impContests.get(1) != null)
                {
                    List<Integer> ints = impContests.get(1);
                    ints.add(contest);
                    impContests.put(1, ints);
                }
                else
                {
                    List<Integer> ints = new ArrayList<>();
                    ints.add(contest);
                    impContests.put(1, ints);
                }
            }
            else if (importance == 0)
            {
                maxLuckBal += contest;
            }
        }
        
        List<Integer> imps = impContests.get(1);
        imps.sort(Comparator.reverseOrder());
        
        //System.out.println("all important " + imps.toString());
        if (imps.size() >= k)
        {
            List<Integer> ss = imps.subList(0, k);
            maxLuckBal += ss.stream().mapToInt(s -> s).sum();
            ss = imps.subList(k, imps.size());
            maxLuckBal -= ss.stream().mapToInt(s -> s).sum();
        }
        else
        {
            List<Integer> ss = imps.subList(0, imps.size());
            maxLuckBal += ss.stream().mapToInt(s -> s).sum();
        }
        
        return maxLuckBal;
    }
    
    private static final Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) throws IOException
    {
        String[] nk = scanner.nextLine().split(" ");
        
        int n = Integer.parseInt(nk[0]);
        
        int k = Integer.parseInt(nk[1]);
        
        int[][] contests = new int[n][2];
        
        for (int i = 0; i < n; i++)
        {
            String[] contestsRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            
            for (int j = 0; j < 2; j++)
            {
                int contestsItem = Integer.parseInt(contestsRowItems[j]);
                contests[i][j] = contestsItem;
            }
        }
        
        int result = luckBalance(k, contests);
        
        System.out.println(result);
        scanner.close();
    }
}
    
    /*static int luckBalance(int k, int[][] contests)
    {
        int maxLuckBal = 0;
        int leng = contests.length;
        System.out.println(Arrays.deepToString(contests));
        
        Arrays.sort(contests, (a, b) -> -1 * Integer.compare(a[0], b[0])); // reverse sort. Multiply by -1
        // sorting 2d array
        *//*Arrays.sort(contests, new Comparator < int[]>() {
            public int compare(int []a, int []b)
        {
            return -1 * Integer.compare(a[0], b[0]);
        }*//*
        
        for (int i = 0; i < leng; i++)
        {
            int contest = contests[i][0];
            int importance = contests[i][1];
            if (importance == 1 && k > 0)
            {
                k--;
                maxLuckBal += contest;
            }
            else if (importance == 1 && k == 0)
            {
                maxLuckBal -= contest;
            }
            else if (importance == 0)
            {
                maxLuckBal += contest;
            }
        }
        
        return maxLuckBal;
    }*/