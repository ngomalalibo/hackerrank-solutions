package com.company.wallethub;

import java.util.*;
import java.util.stream.Collectors;

public class CoinDelimiter
{
    public static int CoinDeterminer(int num)
    {
        // 25
        Set<Integer> coins = new HashSet<>(Arrays.asList(11, 9, 7, 5, 1));  // create set from distinct sorted coins
        coins = coins.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toCollection(LinkedHashSet::new)); // sort so we spend bigger coins first
        int spend = num;
        int noOfCoins = 0;
        for (int coin : coins)
        {
            while (spend > 0) // simulate spending with num
            {
                if (spend >= coin) // if spend is >= current coin
                {
                    int coinCount = (int) Math.floor(spend / coin); // check how many coins can go into spend with a remainder that is in coins
                    if (spend % coin != 0) // true
                    {
                        if (!coins.contains(spend - (coin * coinCount))) // check if remainder is not in coins set
                        {
                            spend -= coin * (--coinCount); // remove one coin in this denomination and spend
                            noOfCoins += coinCount; // add to total coins spent
                            break;
                        }
                    }
                    spend -= coin * coinCount;
                    noOfCoins += coinCount;
                    break;
                }
                else
                {
                    break;
                }
            }
        }
        return noOfCoins;
    }
    
    public static void main(String[] args)
    {
        // keep this function call here
        Scanner s = new Scanner("16");
        // Scanner s = new Scanner("25");
        // Scanner s = new Scanner("26");
        System.out.print(CoinDeterminer(Integer.parseInt(s.nextLine())));
    }
}
