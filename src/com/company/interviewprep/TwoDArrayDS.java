package com.company.interviewprep;

import java.io.IOException;
import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.Scanner;

public class TwoDArrayDS
{
    static int hourglassSum(int[][] arr)
    {
        ArrayList<Integer> sums = new ArrayList<>();
        int max=0;
        for (int x = 0; x < 6; x++)
        {
            for (int y = 0; y < 6; y++)
            {
                if (-9 <= arr[x][y] && arr[x][y] <= 9)
                {
                    int sum1 = arr[0][0] + arr[0][1] + arr[0][2] + arr[1][1] + arr[2][0] + arr[2][1] + arr[2][2];
                    int sum2 = arr[0][1] + arr[0][2] + arr[0][3] + arr[1][2] + arr[2][1] + arr[2][2] + arr[2][3];
                    int sum3 = arr[0][2] + arr[0][3] + arr[0][4] + arr[1][3] + arr[2][2] + arr[2][3] + arr[2][4];
                    int sum4 = arr[0][3] + arr[0][4] + arr[0][5] + arr[1][4] + arr[2][3] + arr[2][4] + arr[2][5];
                    
                    int sum5 = arr[1][0] + arr[1][1] + arr[1][2] + arr[2][1] + arr[3][0] + arr[3][1] + arr[3][2];
                    int sum6 = arr[1][1] + arr[1][2] + arr[1][3] + arr[2][2] + arr[3][1] + arr[3][2] + arr[3][3];
                    int sum7 = arr[1][2] + arr[1][3] + arr[1][4] + arr[2][3] + arr[3][2] + arr[3][3] + arr[3][4];
                    int sum8 = arr[2][3] + arr[2][4] + arr[2][5] + arr[2][4] + arr[3][3] + arr[3][4] + arr[3][5];
                    
                    int sum9 = arr[2][0] + arr[2][1] + arr[2][2] + arr[3][1] + arr[4][0] + arr[4][1] + arr[4][2];
                    int sum10 = arr[2][1] + arr[2][2] + arr[2][3] + arr[3][2] + arr[4][1] + arr[4][2] + arr[4][3];
                    int sum11 = arr[2][2] + arr[2][3] + arr[2][4] + arr[3][3] + arr[4][2] + arr[4][3] + arr[4][4];
                    int sum12 = arr[2][3] + arr[2][4] + arr[2][5] + arr[3][4] + arr[4][3] + arr[4][4] + arr[4][5];
                    
                    int sum13 = arr[3][0] + arr[3][1] + arr[3][2] + arr[4][1] + arr[5][0] + arr[5][1] + arr[5][2];
                    int sum14 = arr[3][1] + arr[3][2] + arr[3][3] + arr[4][2] + arr[5][1] + arr[5][2] + arr[5][3];
                    int sum15 = arr[3][2] + arr[3][3] + arr[3][4] + arr[4][3] + arr[5][2] + arr[5][3] + arr[5][4];
                    int sum16 = arr[3][3] + arr[3][4] + arr[3][5] + arr[4][4] + arr[5][3] + arr[5][4] + arr[5][5];
                    
                    sums.add(sum1);
                    sums.add(sum2);
                    sums.add(sum3);
                    sums.add(sum4);
                    sums.add(sum5);
                    sums.add(sum6);
                    sums.add(sum7);
                    sums.add(sum8);
                    sums.add(sum9);
                    sums.add(sum10);
                    sums.add(sum11);
                    sums.add(sum12);
                    sums.add(sum13);
                    sums.add(sum14);
                    sums.add(sum15);
                    sums.add(sum16);
                    IntSummaryStatistics intSummaryStatistics = sums.stream().mapToInt(d -> d).summaryStatistics();
                    max = intSummaryStatistics.getMax();
                }
            }
            
        }
        
        
        return max;
    }
    
    private static final Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) throws IOException
    {
        int[][] arr = new int[6][6];
        
        for (int i = 0; i < 6; i++)
        {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            
            for (int j = 0; j < 6; j++)
            {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }
        
        int result = hourglassSum(arr);
        System.out.println("sum ---> " + result);
        
        scanner.close();
    }
}
