package com.company.vanhack;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class StringToBase64
{
    /*public void toBase64(String s)
    {
        System.out.println(Base64.getEncoder().encodeToString(s.getBytes()));
    }*/
    
    public void toBase64(String s)
    {
        byte[] base64Encoded = Base64.getEncoder().encode(s.getBytes(StandardCharsets.UTF_8));
        Charset ascii = StandardCharsets.US_ASCII;
        String asciiEncoded = new String(base64Encoded, StandardCharsets.US_ASCII);
        System.out.println(asciiEncoded);
    }
    
    
    public static void main(String[] args)
    {
    new StringToBase64().toBase64("this is a string!!");
    }
}
