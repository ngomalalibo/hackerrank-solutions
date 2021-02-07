package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

class Results
{
    
    /*
     * Complete the 'findDay' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. INTEGER month
     *  2. INTEGER day
     *  3. INTEGER year
     */
    
    public static String findDay(int month, int day, int year)
    {
        Date date = new GregorianCalendar(year, month - 1, day).getTime();
        SimpleDateFormat format1 = new SimpleDateFormat("EEEE");
        String date1 = format1.format(date);
        return date1.toUpperCase();
    }
    
}

public class JavaDateAndTime
{
    
    
    public static void main(String[] args) throws IOException
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        
        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
        
        int month = Integer.parseInt(firstMultipleInput[0]);
        
        int day = Integer.parseInt(firstMultipleInput[1]);
        
        int year = Integer.parseInt(firstMultipleInput[2]);
        
        String res = Results.findDay(month, day, year);
        
        System.out.println("day -> " + res);
    }
}
