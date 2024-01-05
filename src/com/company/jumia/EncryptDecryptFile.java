package com.company.jumia;

import java.util.List;

public class EncryptDecryptFile
{
    public static int getMaxValueSum(List<Integer> encrypted_file, List<Integer> binary, int k)
    {
        /* enc_files [7,4,3,5]  bin [1,0,0,0] k = 2 */
        // sum of all decrypted values
        int totalSum = 0;
        int length = encrypted_file.size();
        int finalMax=0;
        // single operation
        for (int i = 0; i <= (length-1) - k; i++)
        {
            // add all decrypt values first to sum
            if (i==0)
            {
                for (int r = 0; r < length; r++)
                {
                    if (binary.get(r) == 1)
                    {
                        totalSum += encrypted_file.get(r);
                    }
                }
            }
            
            
            boolean binarySimCheck = true;
            
            for (int e=i; e < e+k; e++)
            {
                int sum = 0;
                // binary sim check
                for (int j = i; j < j + k; j++)
                {
                    // check if decrypted
                    if (binary.get(j) == 1)
                    {
                        binarySimCheck = false;
                        break;
                    }
                }
                // decryption after binary sim check
                if (binarySimCheck)
                {
                    for (int j = i; j < j + k; j++)
                    {
                        sum += encrypted_file.get(j);
                    }
                    if (sum > finalMax)
                    {
                        finalMax = sum;
                    }
                }
            }
           
        }
        return totalSum+finalMax;
    }
    
    public static void main(String[] args)
    {
        System.out.println(getMaxValueSum(List.of(7, 4, 3, 5), List.of(1, 0, 0, 0), 2));
        
    }
}
