package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class JumpingGame
{
    
    public static int flip(int hp, List<Integer> arr)
    {
        //arr.sort(Comparator.reverseOrder());
        /** 1 2 2 -5 10 */
        int leng = arr.size();
        int coins = 0;
        for (int i = 0; i < leng; )
        {
            int jump = arr.get(i);
            
            if (jump < 0)
            {
                if (hp + jump <= 0)
                {
                    
                    int j = i + 1;
                    if (j == leng - 1)
                    {
                        return 0;
                    }
                    while (j < leng)
                    {
                        Integer nextJump = arr.get(j);
                        int highJump = (int) Math.pow(i - j, 2);
                        if ((hp + nextJump) - highJump < 0) // if jump is greater than arr[j] jump does more dam so use j
                        {
                            j++;
                            continue;
                        }
                        else
                        {
                        
                        }
                    }
                }
                
            }
            else
            {
                i++;
            }
            coins = i;
            
        }
        return coins;
    }
    
    public static void main(String[] args) throws IOException
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        
        int hp = Integer.parseInt(bufferedReader.readLine().trim());
        
        int array1Count = Integer.parseInt(bufferedReader.readLine().trim());
        
        List<Integer> array1 = IntStream.range(0, array1Count).mapToObj(i ->
                                                                        {
                                                                            try
                                                                            {
                                                                                return bufferedReader.readLine().replaceAll("\\s+$", "");
                                                                            }
                                                                            catch (IOException ex)
                                                                            {
                                                                                throw new RuntimeException(ex);
                                                                            }
                                                                        })
                                        .map(String::trim)
                                        .map(Integer::parseInt)
                                        .collect(Collectors.toList());
        
        int result = flip(hp, array1);
        System.out.println(result);
        
        bufferedReader.close();
    }
}
