package com.company.leetcode;

import java.util.Arrays;

// copied solution. unsolved method is commented below.
public class CoinChange
{
    public int coinChange(int[] coins, int amount)
    {
        int[] dp = new int[amount + 1];
        
        int max_value = (int) (Math.pow(10, 5));
        Arrays.fill(dp, max_value);
        dp[0] = 0;
        
        for (int coin : coins)
        {
            for (int i = coin; i < dp.length; i++)
            {
                dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
            }
        }
        return dp[amount] >= max_value ? -1 : dp[amount];
    }
    /*public int coinChange(int[] coins, int amount)
    {
        // sort array
        // start spending from highest coin
        // System.out.println(Arrays.toString(coins));
        // keep remainder and move to next coin until total amount has been spent or else return -1
        
        Set<Integer> sett = Arrays.stream(coins).boxed().sorted(Comparator.reverseOrder()).collect(Collectors.toCollection(LinkedHashSet::new));
        Arrays.sort(coins);
        int totalNoOfCoins = 0;
        int spend = amount;
        List<Integer> validCounts = new ArrayList<>();
        int leng = coins.length;
        for (int i = 0; i < leng; i++)
        {
            int noOfCoin = (int) Math.floor(spend / coins[i]);
            int mod = spend % coins[i];
            if (mod != 0)
            {
                for (int j = i - 1; j > 0; j--)
                {
                    if (mod % coins[j] == 0)
                    {
                        noOfCoin += mod / coins[j];
                    }
                    else
                    {
                    
                    }
                }
            }
        }
        return totalNoOfCoins;
    }*/
    
    /*
    public int coinChange(int[] coins, int amount)
    {
        // sort array
        // start spending from highest coin
        coins = Arrays.stream(coins).boxed().sorted(Comparator.reverseOrder()).mapToInt(Integer::intValue).toArray();
        Arrays.stream(coins).boxed().sorted(Comparator.reverseOrder());
        Set<Integer> sett = Arrays.stream(coins).boxed().sorted(Comparator.reverseOrder()).collect(Collectors.toCollection(LinkedHashSet::new));
        // System.out.println(sett.toString());
        int noOfTotalCoins = 0;
        int spend = amount;
        int length = coins.length;
        // keep remainder and move to next coin until total amount has been spent or else return -1
        int counter = 0;
        for (int coin : sett)
        {
            if (spend >= coin)
            {
                int noOfDenominationCoins = (int) Math.floor(spend / coin);
                spend -= noOfDenominationCoins * coin;
                
                for (int j = counter + 1; j < length; j++)
                {
                    if (spend % coins[j] == 0)
                    {
                        break;
                    }
                    else if (j == length - 1)
                    {
                        spend += noOfDenominationCoins * coin;
                        noOfDenominationCoins = 0;
                    }
                }
                noOfTotalCoins += noOfDenominationCoins;
                // System.out.println("coin spend: " + noOfDenominationCoins * coin);
            }
            if (counter == length - 1 && spend != 0)
            {
                return -1;
            }
            ++counter;
        }
        return noOfTotalCoins;
    }
    * */
    public static void main(String[] args)
    {
        System.out.println(new CoinChange().coinChange(new int[]{5, 2, 1}, 11));
        System.out.println(new CoinChange().coinChange(new int[]{2}, 3));
        System.out.println(new CoinChange().coinChange(new int[]{1}, 1));
        System.out.println(new CoinChange().coinChange(new int[]{1}, 2));
        System.out.println(new CoinChange().coinChange(new int[]{186, 419, 83, 408}, 6249));
    }
}
