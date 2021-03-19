package com.company;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class FreeCalendarSlots
{
    /**
     * Given the calendars of two individuals and their start and end bounds within which they can schedule meetings in a work day. Return free slots where they can schedule meetings with each other.
     * // Return list of available slots when meetings between them can be held between them
     * // Sample Input
     * // [['9:00', '10:30'], ['12:00', '13:00'], ['16:00', '18:00']]
     * // Bounds: ['9:00', '20:00']
     * // [['10:00', '11:30'], ['12:30', '14:30'], ['14:30', '15:00'], ['16:00', '17:00']]
     * // Bounds: ['10:00', '18:30']
     * // Duration: 30
     * // Sample Output: [['11:30', '12:00'], ['15:00', '16:00'], ['18:00', '18:30']]
     */
    
    public static List<Slot> freeSlots(List<Slot> c1, Slot b1, List<Slot> c2, Slot b2, long duration)
    {
        LocalTime startBound = b1.getStart().isAfter(b2.getStart()) ? b1.getStart() : b2.getStart();
        LocalTime endBound = b1.getEnd().isBefore(b2.getEnd()) ? b1.getEnd() : b2.getEnd();
        
        Set<LocalTime> allTimes = new HashSet<>();
        LocalTime current = startBound;
        while (current.compareTo(endBound) != 0)
        {
            allTimes.add(current);
            current = current.plusMinutes(duration);
        }
        
        Set<LocalTime> takenTimes1 = getTakenTimes(c1);
        Set<LocalTime> takenTimes2 = getTakenTimes(c2);
        takenTimes1.addAll(takenTimes2);
        
        allTimes.removeAll(takenTimes1);
        
        List<Slot> freeSlots = new ArrayList<>();
        LocalTime startTime = LocalTime.MIN;
        LocalTime timeCursor = LocalTime.MAX;
        
        List<LocalTime> allTimesList = new ArrayList<>(allTimes);
        LocalTime currentTime;
        
        for (int i = 0; i < allTimesList.size(); i++)
        {
            currentTime = allTimesList.get(i);
            if (startTime.equals(LocalTime.MIN))
            {
                startTime = currentTime;
                timeCursor = currentTime;
                continue;
            }
            if (timeCursor.plusMinutes(duration).equals(currentTime))
            {
                timeCursor = currentTime;
                continue;
            }
            else
            {
                freeSlots.add(new Slot(startTime, timeCursor.plusMinutes(duration)));
                startTime = currentTime;
                timeCursor = currentTime;
                if (i == allTimesList.size() - 1)
                {
                    freeSlots.add(new Slot(startTime, currentTime.plusMinutes(duration)));
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
    
    public static int[] getTimes(String ss)
    {
        String[] s1 = ss.split(":");
        int i1 = Integer.parseInt(s1[0]);
        int i2 = Integer.parseInt(s1[1]);
        
        return new int[]{i1, i2};
    }
    
    public static List<Slot> getSlots(String[][] times)
    {
        List<Slot> c = new ArrayList<>();
        
        for (int i = 0; i < times.length; i++)
        {
            int[] start = getTimes(times[i][0]);
            int[] end = getTimes(times[i][1]);
            c.add(new Slot(LocalTime.of(start[0], start[1]), LocalTime.of(end[0], end[1])));
        }
        return c;
    }
    
    public static void main(String[] args)
    {
        String[][] times1 = new String[][]{{"9:00", "10:30"}, {"12:00", "13:00"}, {"16:00", "18:00"}};
        String[][] times2 = new String[][]{{"10:00", "11:30"}, {"12:30", "14:30"}, {"14:30", "15:00"}, {"16:00", "17:00"}};
        String[] bound1 = new String[]{"9:00", "20:00"};
        String[] bound2 = new String[]{"10:00", "18:30"};
        
        List<Slot> c1 = getSlots(times1);
        List<Slot> c2 = getSlots(times2);
        
        int[] boundStart = getTimes(bound1[0]);
        int[] boundEnd = getTimes(bound1[1]);
        Slot c1Bounds = new Slot(LocalTime.of(boundStart[0], boundStart[1]), LocalTime.of(boundEnd[0], boundEnd[1]));
        
        boundStart = getTimes(bound2[0]);
        boundEnd = getTimes(bound2[1]);
        Slot c2Bounds = new Slot(LocalTime.of(boundStart[0], boundStart[1]), LocalTime.of(boundEnd[0], boundEnd[1]));
        
        long duration = 30;
        
        List<Slot> freeSlots = freeSlots(c1, c1Bounds, c2, c2Bounds, duration);
        
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
                "['" + start + "', '" + end + "']";
    }
}