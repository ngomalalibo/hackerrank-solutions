package com.company;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;


public class JavaSort
{
    public static boolean containsLeadingZeros(String s)
    {
        return s.matches("^[0]+");
    }
    
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());
        
        List<Student> studentList = new ArrayList<Student>();
        if (2 <= testCases && testCases <= 1000)
        {
            while (testCases > 0)
            {
                int id = in.nextInt();
                String fname = in.next();
                double cgpa = in.nextDouble();
                
                //id = Integer.parseInt(replaceLeadingZeros(String.valueOf(id)));
                // cgpa = new BigDecimal(String.valueOf(cgpa)).setScale(2, RoundingMode.HALF_UP).doubleValue();
                
                cgpa = new BigDecimal(String.format("%.2f", cgpa)).doubleValue();
                
                if (!containsLeadingZeros(String.valueOf(id)) && 0 <= id && id <= 100000 && 0.00 <= cgpa && cgpa <= 4.00 && String.valueOf(id).chars().allMatch(Character::isDigit))
                {
                    
                    Student st = new Student(id, fname, cgpa);
                    studentList.add(st);
                }
                
                sort(studentList);
                
                testCases--;
            }
            
            for (Student st : studentList)
            {
                System.out.println(st.getFname());
            }
        }
        else
        {
            System.exit(0);
        }
        
    }
    
    public static void sort(List<Student> students)
    {
        students.sort(Comparator.comparing(Student::getCgpa, Comparator.reverseOrder())
                                .thenComparing(Student::getFname)
                                .thenComparingInt(Student::getId));
    }
    
}

class Student
{
    
    
    private int id;
    private String fname;
    private double cgpa;
    
    public Student(int id, String fname, double cgpa)
    {
        super();
        this.id = id;
        this.fname = fname;
        this.cgpa = cgpa;
    }
    
    public int getId()
    {
        return id;
    }
    
    public String getFname()
    {
        return fname;
    }
    
    public double getCgpa()
    {
        return cgpa;
    }
    
    
}
