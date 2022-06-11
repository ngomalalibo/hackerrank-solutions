package com.company.deliveryhero;

import java.util.*;

public class Solution
{
    public int solution(String p, String d, int s)
    {
        // get a map to hold device and intervals
        int noOfTimesOffline = 0;
        Map<String, List<Integer>> deviceIntervalMap = new HashMap<>();
        // split requests on space
        String[] sar = p.split("\\s+");
        for (String ss : sar)
        {
            // split each ping on comma to get device name and interval and add to map
            String[] ping = ss.split(",");
            // interval already exists for device
            // filter requests for our specific device
            if (!ping[0].equals(d))
            {
                continue;
            }
            if (deviceIntervalMap.get(ping[0]) != null)
            {
                List<Integer> intervals = deviceIntervalMap.get(ping[0]);
                intervals.add(Integer.parseInt(ping[1]));
            }
            else
            {
                // first interval for device
                deviceIntervalMap.put(ping[0], new ArrayList<>(List.of(Integer.parseInt(ping[1]))));
            }
        }
        // get device using key in map
        List<Integer> intervals = deviceIntervalMap.get(d);
        int length = intervals.size();
        //iterate to get intervals that exceed the pre-defined interval and increment counter for intervals greater than the predefined
        for (int i = 0; i < length - 1; i++)
        {
            int curr = intervals.get(i);
            int next = intervals.get(i + 1);
            if (next - curr > s)
            {
                ++noOfTimesOffline;
            }
        }
        
        return noOfTimesOffline;
    }
    
    public static void main(String[] args)
    {
        System.out.println(new Solution().solution("a,0 b,0 a,10 a,20 b,20 b,40 b,50 b,60 a,60", "b", 10));
        System.out.println(new Solution().solution("a,0 b,0 a,10 a,20 b,20 b,40 b,50 b,60 a,60", "a", 10));
    }
    
}
