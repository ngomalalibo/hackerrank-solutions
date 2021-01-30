package com.company.interviewprep;

import java.util.ArrayList;

public class ProgrammingScore
{
    public static int score(String T[], String R[])
    {
        int score;
        ArrayList<Character> sc;
        int groupScore = 0;
        int noOfGroups = 0;
        int groupTestCases = 0;
        int positionOfLastInt = 0;
        String groupName;
        String numberOfGroups;
        StringBuilder num = null;
        for (String t : T)
        {
            sc = new ArrayList<>();
            for (char c : t.toCharArray())
            {
                sc.add(c);
            }
            for (int i = 0; i < sc.size(); ++i)
            {
                if (Character.isLetter(sc.get(i)))
                {
                    continue;
                }
                if (Character.isDigit(sc.get(i)))
                {
                    num = new StringBuilder();
                    if (i == sc.size() - 1)
                    {
                        positionOfLastInt = i + 1;
                        groupName = t.substring(0, positionOfLastInt);
                        num.append(sc.get(i).toString());
                        numberOfGroups = num.toString();
                        noOfGroups = Integer.parseInt(numberOfGroups);
                    }
                    else
                    {
                        num.append(sc.get(i).toString());
                        //get number of groups from test case name
                        for (int j = i + 1; j < sc.size(); j++)
                        {
                            if (Character.isDigit(sc.get(j)))
                            {
                                positionOfLastInt = j;
                                num.append(sc.get(j));
                            }
                            else
                            {
                                positionOfLastInt = j;
                                numberOfGroups = num.toString();
                                noOfGroups = Integer.parseInt(numberOfGroups);
                                break;
                            }
                        }
                    }
                }
                /**"test1a", "test2", "test1b", "test1c", "test3"*/
                groupName = t.substring(0, positionOfLastInt);
                positionOfLastInt=0;
                // iterate test cases to get no in group
                for (int d = 0; d < T.length; d++)
                {
                    if (T[d].contains(groupName))
                    {
                        ++groupTestCases;
                    }
                }
                //iterate to get group score
                for (int d = 0; d < T.length; ++d)
                {
                    
                    if (T[d].contains(groupName) || R[d].equals(groupName))
                    {
                        --groupTestCases;
                        if (!R[d].equals("OK"))
                        {
                            groupTestCases = 0;
                            break;
                        }
                        else if (R[d].equals("OK") && groupTestCases == 0)
                        {
                            ++groupScore;
                            break;
                        }
                    }
                }
                    /*if (R[i].equals("OK"))
                    {
                        ++groupScore;
                    }*/
            }
            
        }
        score = (int) Math.floor((groupScore * 100) / noOfGroups);
        return score;
    }
    
    public static void main(String[] args)
    {
        String[] T = new String[]{"test1a", "test2", "test1b", "test1c", "test3"};
        String[] R = new String[]{"Wrong answer", "OK", "Runtime error", "OK", "Time limit exceeded"};
        // String[] T = new String[]{"codility1", "codility3", "codility2", "codility4b", "codility4a"};
        // String[] R = new String[]{"Wrong answer", "OK", "OK", "Runtime error", "OK"};
        
        int score = score(T, R);
        System.out.println("score --> " + score);
    }
}
