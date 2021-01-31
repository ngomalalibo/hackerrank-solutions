package com.company.interviewprep;

public class NoOfMeanWays
{
    public static int getNoOfWays(int[] A, int s)
    {
        int sum = 0;
        int average = 0;
        int noOfWays = 0;
        int n = A.length;
        
        if (Math.pow(-10, 9) <= s && s <= Math.pow(10, 9))
        {
            //validating against constraint
            if (1 <= n && n <= 100000)
            {
                // fixed position on array
                for (int i = 0; i < n; i++)
                {
                    // reset sum of array elements after each fixed position loop
                    sum = 0;
                    //moving position on array
                    for (int j = 1, k = i; k < n; j++, k++)// j is the average divisor starting from one, k is the moving cursor
                    {
                        // for first item. Handles division by zero situation
                        if (k == 0)
                        {
                            sum = A[k];
                            if (sum == s)
                            {
                                ++noOfWays;
                            }
                            continue;
                        }
                        
                        if (Math.pow(-10, 9) <= A[k] && A[k] <= Math.pow(10, 9))
                        {
                            sum += A[k]; // sum
                            // checks if the sum/j returns an integer. Increment index j to capture element position
                            if (sum % (j) == 0)
                            {
                                if (sum / (j) == s) // performs the check if average is equal to given s
                                {
                                    ++noOfWays; // increment noOfWays
                                }
                            }
                            
                        }
                    }
                }
            }
            if (noOfWays > 1000000000) // handles constraint
            {
                return 1000000000;
            }
        }
        
        
        return noOfWays;
    }
    
    public static void main(String[] args)
    {
        //Testcase 1
        int[] A = new int[]{2, 1, 3};
        int s = 2;
        
        //Testcase 2
        // int[] A = new int[]{0, 4, 3, -1};
        // int s = 2;
        
        //Testcase 3
        // int []A = new int[]{2,1,4};
        // int s = 3;
        
        int noOfWays = getNoOfWays(A, s);
        System.out.println("noOfWays --> " + noOfWays);
        
    }
}
