package com.company.temporary;

public class Unchecked_Demo extends ArithmeticException
{
    public Unchecked_Demo()
    {
        super("Handled by Unchecked Class");
    }
    
    public Unchecked_Demo(String wrong_answer)
    {
        super("Wrong Answer");
    }
}