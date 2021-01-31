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
        int positionOfLastDigit = 0;
        String groupName;
        String numberOfGroups;
        StringBuilder num = null;
        //loop through all the test cases
        for (String t : T)
        {
            //convert the test cases to character arrays
            sc = new ArrayList<>();
            for (char c : t.toCharArray())
            {
                sc.add(c);
            }
            
            for (int i = 0; i < sc.size(); ++i)
            {
                // search the test case letters for the group number. Ignore characters
                if (Character.isLetter(sc.get(i)))
                {
                    continue;
                }
                if (Character.isDigit(sc.get(i)))
                {
                    num = new StringBuilder();
                    
                    if (i == sc.size() - 1)  // group number found. Check if it is last digit/letter
                    {
                        positionOfLastDigit = i + 1;
                        groupName = t.substring(0, positionOfLastDigit);
                        num.append(sc.get(i).toString());
                        numberOfGroups = num.toString();
                        noOfGroups = Integer.parseInt(numberOfGroups);
                    }
                    else
                    {
                        num.append(sc.get(i).toString());
                        //number of groups is the max number in the test case name.
                        for (int j = i + 1; j < sc.size(); j++) //continue searching current test case name to ensure digit is last digit
                        {
                            if (Character.isDigit(sc.get(j)))
                            {
                                positionOfLastDigit = j;
                                num.append(sc.get(j));
                            }
                            else
                            {
                                positionOfLastDigit = j;
                                numberOfGroups = num.toString();
                                noOfGroups = Integer.parseInt(numberOfGroups);
                                break;
                            }
                        }
                    }
                }
                /**"test1a", "test2", "test1b", "test1c", "test3"*/
                groupName = t.substring(0, positionOfLastDigit); // group name is a substring of the test case name up till the last digit
                positionOfLastDigit = 0; // reset the digit position
                // iterate test cases to get number in group name
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
                        --groupTestCases; //tracks group test cases as they are checked against the result array
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
            }
            
        }
        score = (int) Math.floor((groupScore * 100) / noOfGroups);
        return score;
    }
    
    public static void main(String[] args)
    {
        // String[] T = new String[]{"test1a", "test2", "test1b", "test1c", "test3"};
        // String[] R = new String[]{"Wrong answer", "OK", "Runtime error", "OK", "Time limit exceeded"};
        String[] T = new String[]{"codility1", "codility3", "codility2", "codility4b", "codility4a"};
        String[] R = new String[]{"Wrong answer", "OK", "OK", "Runtime error", "OK"};
        
        int score = score(T, R);
        System.out.println("score --> " + score);
    }
}
