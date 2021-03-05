package com.company;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class FreeCalendarSlots
{
    /**
     *  Given two peoples calenders and their start and end bounds within which they can schedule meetings in a day. Return free slots where they can schedule meetings with each other.
     * // Return list of available slots when meetings can be held
     * // Sample Input
     * // [['9:00', '10:30'], ['12:00', '13:00'], ['16:00', '18:00']]
     * // Bounds: ['9:00', '20:00']
     * // [['10:00', '11:30'], ['12:30', '14:30'], ['14:30', '15:00'], ['16:00', '17:00']]
     * // Bounds: ['10:00', '18:30']
     * // 30
     * // Sample Output: [['11:30', '12:00'], ['15:00', '16:00'], ['18:00', '18:30']]
     */
    
    public static List<Slot> freeSlots(List<Slot> c1, Slot b1, List<Slot> c2, Slot b2)
    {
        LocalTime startBound = b1.getStart().isAfter(b2.getStart()) ? b1.getStart() : b2.getStart();
        LocalTime endBound = b1.getEnd().isBefore(b2.getEnd()) ? b1.getEnd() : b2.getEnd();
        
        Set<LocalTime> allTimes = new HashSet<>();
        LocalTime current = startBound;
        while (current.compareTo(endBound) != 0)
        {
            allTimes.add(current);
            current = current.plusMinutes(30);
        }
        
        Set<LocalTime> takenTimes1 = getTakenTimes(c1);
        Set<LocalTime> takenTimes2 = getTakenTimes(c2);
        takenTimes1.addAll(takenTimes2);
       
        allTimes.removeAll(takenTimes1);
        
        List<Slot> freeSlots = new ArrayList<>();
        LocalTime startTime = LocalTime.MIN;
        LocalTime prevTime = LocalTime.MAX;
        
        List<LocalTime> allTimesList = new ArrayList<>(allTimes);
        LocalTime time;
        
        for (int i = 0; i < allTimes.size(); i++)
        {
            time = allTimesList.get(i);
            if (startTime.equals(LocalTime.MIN))
            {
                startTime = time;
                prevTime = time;
                continue;
            }
            if (prevTime.plusMinutes(30).equals(time))
            {
                prevTime = time;
                continue;
            }
            else
            {
                freeSlots.add(new Slot(startTime, prevTime.plusMinutes(30)));
                startTime = time;
                prevTime = time;
                if (i == allTimes.size()-1)
                {
                    freeSlots.add(new Slot(startTime, time.plusMinutes(30)));
                    break;
                }
            }
    
            
        }
        return freeSlots;
    }
    
    public static Set<LocalTime> getTakenTimes(List<Slot> slots)
    {
        Set<LocalTime> taken = new HashSet<>();
        slots.forEach(slot ->
                      {
                          LocalTime start = slot.getStart();
                          while (start.isBefore(slot.getEnd()))
                          {
                              taken.add(start);
                              start = start.plusMinutes(30);
                          }
                      });
        return taken;
    }
    
    public static void main(String[] args)
    {
        List<Slot> c1 = new ArrayList<>();
        c1.add(new Slot(LocalTime.of(9, 0), LocalTime.of(10, 30)));
        c1.add(new Slot(LocalTime.of(12, 0), LocalTime.of(13, 0)));
        c1.add(new Slot(LocalTime.of(16, 0), LocalTime.of(18, 0)));
        Slot c1Bounds = new Slot(LocalTime.of(9, 0), LocalTime.of(20, 0));
        
        List<Slot> c2 = new ArrayList<>();
        c1.add(new Slot(LocalTime.of(10, 0), LocalTime.of(11, 30)));
        c1.add(new Slot(LocalTime.of(12, 30), LocalTime.of(14, 30)));
        c1.add(new Slot(LocalTime.of(14, 30), LocalTime.of(15, 0)));
        c1.add(new Slot(LocalTime.of(16, 0), LocalTime.of(17, 0)));
        Slot c12Bounds = new Slot(LocalTime.of(10, 0), LocalTime.of(18, 30));
        
        List<Slot> freeSlots = freeSlots(c1, c1Bounds, c2, c12Bounds);
        
        System.out.println(freeSlots.toString());
    }
}


class Slot
{
    private LocalTime start;
    private LocalTime end;
    
    public Slot(LocalTime start, LocalTime end)
    {
        this.start = start;
        this.end = end;
    }
    
    public LocalTime getStart()
    {
        return start;
    }
    
    public void setStart(LocalTime start)
    {
        this.start = start;
    }
    
    public LocalTime getEnd()
    {
        return end;
    }
    
    public void setEnd(LocalTime end)
    {
        this.end = end;
    }
    
    @Override
    public String toString()
    {
        return
                "['" + start +
                        "', '" + end + "']";
    }
}