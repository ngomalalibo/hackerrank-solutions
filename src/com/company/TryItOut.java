package com.company;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class TryItOut
{
    public static void main(String[] args)
    {
        List<Tracks> tracks = Arrays.asList(new Tracks("Bakai", 524),
                                            new Tracks("Violets for Your Furs", 378),
                                            new Tracks("Time Was", 451));
        Tracks shortestTrack = tracks.stream()
                                     .min(Comparator.comparing(Tracks::getLength).thenComparing(Tracks::getTitle))
                                     .get();
        System.out.println("result " + shortestTrack.getLength());
    }
}

class Tracks
{
    
    public Tracks(String title, int length)
    {
        this.title = title;
        this.length = length;
    }
    
    private String title;
    private int length;
    
    public int getLength()
    {
        return this.length;
    }
    
    public void setLength(int length)
    {
        this.length = length;
    }
    
    public String getTitle()
    {
        return this.title;
    }
    
    public void setTitle(String title)
    {
        this.title = title;
    }
    
}