package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class FrequencyQueries
{
    // Complete the freqQuery function below.
    static List<Integer> freqQuery(List<int[]> queries)
    {
        List<Integer> freq = new ArrayList<>();
        Map<Integer, Integer> intToFreq = new HashMap<>();
        Map<Integer, Integer> freqToOccurrence = new HashMap<>();
        int key; // get operation
        int value; // get value for operation
        
        Integer oldFreq;
        Integer newFreq = 0;
        
        Integer oldOccurrence;
        Integer newOccurrence;
        
        // loop through queries
        for (int[] query : queries)
        {
            key = query[0]; // get operation
            value = query[1]; // get value for operation
            
            if (key == 3)
            {
                // there must be a value with 0 occurrence
                if (value == 0)
                {
                    freq.add(1);
                }
                // if freq does not exist return 0 else 1;
                freq.add(freqToOccurrence.get(value) == null ? 0 : 1);
            }
            else
            {
                // get old frequency and occurrence or 0 if they dont exist.
                oldFreq = intToFreq.get(value);
                oldFreq = oldFreq == null ? 0 : oldFreq;
                oldOccurrence = freqToOccurrence.get(oldFreq);
                oldOccurrence = oldOccurrence == null ? 0 : oldOccurrence;
                
                if (key == 1)
                {
                    newFreq = oldFreq + 1;
                }
                else
                {
                    newFreq = oldFreq - 1;
                }
                
                newOccurrence = freqToOccurrence.get(newFreq);
                newOccurrence = newOccurrence == null ? 0 : newOccurrence;
    
                if (newFreq < 1)
                {
                    intToFreq.remove(value);
                }
                else
                {
                    intToFreq.put(value, newFreq);
                }
                
                if (oldOccurrence - 1 < 1)
                {
                    freqToOccurrence.remove(oldFreq);
                }
                else
                {
                    freqToOccurrence.put(oldFreq, oldOccurrence - 1);
                }
                freqToOccurrence.put(newFreq, newOccurrence + 1);
            }
        }
        
        return freq;
    }
    
    public static void main(String[] args) throws IOException
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        
        int q = Integer.parseInt(bufferedReader.readLine().trim());
        
        /*List<List<Integer>> queries = new ArrayList<>();
        
        IntStream.range(0, q).forEach(i ->
                                      {
                                          try
                                          {
                                              queries.add(
                                                      Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                                            .map(Integer::parseInt)
                                                            .collect(Collectors.toList())
                                              );
                                          }
                                          catch (IOException ex)
                                          {
                                              throw new RuntimeException(ex);
                                          }
                                      });*/
        List<int[]> queries = new ArrayList<>(q);
        Pattern p = Pattern.compile("^(\\d+)\\s+(\\d+)\\s*$");
        for (int i = 0; i < q; i++)
        {
            int[] query = new int[2];
            Matcher m = p.matcher(bufferedReader.readLine());
            if (m.matches())
            {
                query[0] = Integer.parseInt(m.group(1));
                query[1] = Integer.parseInt(m.group(2));
                queries.add(query);
            }
        }
        
        List<Integer> ans = freqQuery(queries);
        
        for (Integer i : ans)
        {
            System.out.println();
        }
        System.out.println(ans.stream()
                              .map(Object::toString)
                              .collect(Collectors.joining("\n"))
                                   + "\n");
        
        
        bufferedReader.close();
    }
}
