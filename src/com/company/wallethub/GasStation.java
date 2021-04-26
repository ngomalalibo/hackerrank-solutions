package com.company.wallethub;

public class GasStation
{
    
    public static String GasStation(String[] strArr)
    {
        int noOfGasStations = Integer.parseInt(strArr[0]); // no of gas stations
        int indexOfStartingGasPosition = 1; // starting index of gas stations is 1
        int remainder = 0;
        String[] gc;
        
        // iterate through the gas stations to find the index of the first gas station where a journey is possible
        for (int i = indexOfStartingGasPosition, j = 0; i <= noOfGasStations || j < indexOfStartingGasPosition; i++) // to complete the journey use j to continue next route from first gas station
        {
            int index = j > 0 ? j : i;
            gc = strArr[index].split(":"); // split string on colon to get gas (g) and consumption (c)
            
            int g = Integer.parseInt(gc[0]);
            int c = Integer.parseInt(gc[1]);
            int total = g + remainder; // total is the gas available on reaching a gas station during a journey
            if (total < c && indexOfStartingGasPosition <= noOfGasStations) // not enough to reach next gas station. Keep attempting by starting from next gas stations
            {
                i = indexOfStartingGasPosition++; // start journey from next gas station. For loop takes care of incrementing i hence the use of post increment operator.
                
                if (indexOfStartingGasPosition == noOfGasStations) // if the index is that of the last gas station, then get remainder before continuing to first gas station
                {
                    gc = strArr[index + 1].split(":");
                    g = Integer.parseInt(gc[0]);
                    c = Integer.parseInt(gc[1]);
                }
                remainder = g - c;
                if (indexOfStartingGasPosition > noOfGasStations && remainder < 0) // if all gas stations have been attempted and theres not enough gas to get to next gas station, journey is impossible.
                {
                    return "impossible";
                }
            }
            else
            {
                remainder = total - c; // remainder is used to calculate total gas for journey to next gas station
            }
            if (i >= noOfGasStations) // reached last gas station? complete journey starting from first gas station
            {
                j++;
            }
        }
        return String.valueOf(indexOfStartingGasPosition);
    }
    
    public static void main(String[] args)
    {
        // keep this function call here
        System.out.println(GasStation(new String[]{"4", "3:1", "2:2", "1:2", "0:1"}));
        System.out.println(GasStation(new String[]{"4", "1:1", "2:2", "1:2", "0:1"}));
        System.out.println(GasStation(new String[]{"4", "0:1", "2:2", "1:2", "3:1"}));
        
    }
}
