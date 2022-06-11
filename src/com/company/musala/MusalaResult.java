package com.company.musala;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Solution{
    
    /*
     * Complete the 'findNumber' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY arr
     *  2. INTEGER k
     */
    
    public static String findNumber(List<Integer> arr, int k) {
        boolean contains = arr.contains(k);
        return contains ? "YES": "NO";
    /* // */
    }
    
}

public class MusalaResult {
    public static void main(String[] args) throws IOException
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        
        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());
        
        List<Integer> arr = IntStream.range(0, arrCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                                     .map(String::trim)
                                     .map(Integer::parseInt)
                                     .collect(Collectors.toList());
        
        int k = Integer.parseInt(bufferedReader.readLine().trim());
        
        String result = Solution.findNumber(arr, k);
        
        bufferedWriter.write(result);
        bufferedWriter.newLine();
        
        bufferedReader.close();
        bufferedWriter.close();
    }
    
    
}
