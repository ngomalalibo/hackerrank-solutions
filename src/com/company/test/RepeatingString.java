package com.company.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RepeatingString
{
    
    // Complete the repeatedString function below.
    static long repeatedString(String s, long n)
    {
        if (s.length() < 1 || s.length() > 100)
        {
            System.out.println("s should be between 1 and 100");
            System.exit(1);
        }
        if (n > Math.pow(10, 12))
        {
            System.out.println("n cannot be greater than 10^12");
            System.exit(1);
        }
        int countOfA = 0;
        Pattern p;
        Matcher m;
        while (n >= s.length())
        {
            if (s.length() == 1 && s.charAt(0) == 'a')
            {
                return n;
            }
            else if (s.length() == 2 && (s.charAt(0) == 'a') || s.charAt(1) == 'a')
            {
                if (s.charAt(0) == s.charAt(1))
                {
                    return n;
                }
                else
                {
                    return (n / 2);
                }
            }
            else
            {//abc aba
                List<String> dd = new ArrayList<>();
                String substring = "";
                for (int f = 2; f < s.length(); f++)
                {
                    p = Pattern.compile(s.substring(0, f));
                    m = p.matcher(s);
                    int count = 0;
                    while (m.find())
                    {
                        count += 1;
                    }
                    if (count > 0)
                    {
                        substring = s.substring(0, f);
                        dd.add(substring);
                    }
                    if (count == 1)
                    {
                        if (!dd.isEmpty())
                        {
                            //abaabaabaab
                            substring = dd.get(dd.size() - 2);
                            break;
                        }
                    }
                }
                
                for (int i = 0; i < substring.length(); i++)
                {
                    if(s.contains("a"))
                    {
                        if(substring.charAt(i)=='a')
                        {
                            countOfA++;
                        }
                    }
                    else
                    {
                        return 0;
                    }
                    
                }
                p = Pattern.compile(substring);
                m = p.matcher(s);
                int count = 0;
                while (m.find())
                {
                    count += 1;
                }
                if (count == 1)
                {
                    return (n / substring.length())*countOfA;
                }
                else if (count > 1)
                {
                    return (n / substring.length()) * countOfA;
                }
            }
        }
    
        return 0;
       /*
      
        while (lastIndexOf != -1)
        {
            
            lastIndexOf = s.indexOf(substring, lastIndexOf);
            if (lastIndexOf != -1)
            {
                lastIndexOf += substring.length();
                d = lastIndexOf;
            }
            else
            {
                s = s.substring(0, d);
                System.out.println("s = " + s.substring(0, 30));
            }
            
        }*/
        /*for (int i = 0; i < s.length(); i++)
        {
            if (s.charAt(i) == 'a')
            {
                occurrences++;
            }
        }*/
        
        
    }
    
    //private static final Scanner scanner = new Scanner("abcacabcac");
    
    public static void main(String[] args) throws IOException
    {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        
        String s = "aba";
        
        long n = 10L;
        //scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        
        long result = repeatedString(s, n);
        
        System.out.println("result -> " + result);
        
        /*bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();
        
        bufferedWriter.close();*/
        
        //scanner.close();
    }
}
