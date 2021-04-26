package com.company;

import java.util.*;
import java.util.stream.Collectors;

public class TryItOut
{
    public static void main(String[] args)
    {
        Set<Integer> coins = new HashSet<>(Arrays.asList(11, 9, 7, 5, 1));
        Set<Integer> collect = coins.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toCollection(LinkedHashSet::new));
        System.out.println(collect);
        /*int d = 100111;
        for (int i = 0; i < 6; i++)
        {
            System.out.println(d & 1);
            d>>=1;
        }*/
        // System.out.println(d < 12 ? "Morning" : d < 16 ? "Afternoon" : "Evening");
        /*BigInteger i = new BigInteger("1000000000000000000000000000001");
        System.out.println(i);*/
        /*char c='a';
        char c2='1';
        int a=c;
        int b=c2;
        System.out.println(a);
        System.out.println(b);*/
        /*List<Integer> iceCream = new ArrayList<>();
        iceCream.add(1);
        iceCream.add(2);
        for (int i = 0; i< iceCream.size(); i++)
        {
            System.out.println(iceCream.get(i));
        }*/
       
       /* int count = 0;
        Map<Integer, Character> dd = new HashMap<>()
        {{
            put(1, 'i');
            put(2, 'f');
            put(3, 'a');
        }};
        Map<Integer, Character> ss = new HashMap<>()
        {{
            put(1, 'f');
            put(2, 'a');
            put(3, 'i');
        }};
        
        if(Arrays.equals(dd.values().stream().sorted().toArray(), dd.values().stream().sorted().toArray()))
        {
            count++;
        }*/
        
        
        
        /*List<Integer> cars = new ArrayList<>();
        for (int i = 0; i < 10; i++)
        {
            cars.add(null);
        }
        
        cars.set(1, 1);
        cars.set(3, 3);
        cars.set(5, 5);
        cars.set(7, 7);
        System.out.println(cars.toString());*/
    
        /*List<Tracks> tracks = Arrays.asList(new Tracks("Bakai", 524),
                                            new Tracks("Violets for Your Furs", 378),
                                            new Tracks("Time Was", 451));
        Tracks shortestTrack = tracks.stream()
                                     .min(Comparator.comparing(Tracks::getLength).thenComparing(Tracks::getTitle))
                                     .get();
        System.out.println("result " + shortestTrack.getLength());*/
        
        
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