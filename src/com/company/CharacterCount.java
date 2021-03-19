package com.company;

public class CharacterCount
{
    public static void main(String[] args)
    {
        int result = charCount("Java, SDLC, MySQL, Oracle, HTML, CSS, JavaScript, PHP, MongoDB, Spring Boot, Spring Cloud, Spring Security (OAuth2), Bootstrap, SharePoint, REST API,VueJS, CI/CD, CodeDeploy, Heroku, Microservices, Docker, AWS, Software Developer, Software Engineer");
        System.out.println(result);
    }
    
    public static int charCount(String s)
    {
        
        return s.length();
        /*String[] ss = s.split("\\s+");
        int count = ss.length - 1;
        
        for (int i = 0; i < ss.length; i++)
        {
            count+=ss[i].length();
        }
        
        return count;*/
    }
}
