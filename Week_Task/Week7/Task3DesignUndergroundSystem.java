/*
 * TASK 3: DESIGN UNDERGROUND SYSTEM
 *
 * PROBLEM STATEMENT:
 * Design an underground railway system that records when
 * passengers check in and check out.
 * Calculate the average travel time between two stations.
 *
 * INPUT:
 * 1
 * Alice 10 A
 * Alice 20 B
 * A B
 *
 * OUTPUT:
 * 10.0
 */
package Week7;
import java.util.*;
public class Task3DesignUndergroundSystem{
    static class CheckIn{
        String station;
        int time;
        CheckIn(String station,int time){
            this.station=station;
            this.time=time;
        }
    }
    static class Travel{
        double totalTime;
        int count;
        Travel(double totalTime,int count){
            this.totalTime=totalTime;
            this.count=count;
        }
    }
    HashMap<Integer,CheckIn> checkIns=new HashMap<>();
    HashMap<String,Travel> travels=new HashMap<>();
    public void checkIn(int id,String stationName,int t){
        checkIns.put(id,new CheckIn(stationName,t));
    }
    public void checkOut(int id,String stationName,int t){
        CheckIn in=checkIns.get(id);
        String key=in.station+"#"+stationName;
        double time=t-in.time;
        if(!travels.containsKey(key)){
            travels.put(key,new Travel(time,1));
        }else{
            Travel travel=travels.get(key);
            travel.totalTime+=time;
            travel.count++;
        }
        checkIns.remove(id);
    }
    public double getAverageTime(String startStation,String endStation){
        String key=startStation+"#"+endStation;
        Travel travel=travels.get(key);
        return travel.totalTime/travel.count;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        Task3DesignUndergroundSystem system=new Task3DesignUndergroundSystem();
        int n=sc.nextInt();
        for(int i=0;i<n;i++){
            int id=sc.nextInt();
            String station=sc.next();
            int time=sc.nextInt();
            system.checkIn(id,station,time);
        }
        int m=sc.nextInt();
        for(int i=0;i<m;i++){
            int id=sc.nextInt();
            String station=sc.next();
            int time=sc.nextInt();
            system.checkOut(id,station,time);
        }
        String start=sc.next();
        String end=sc.next();
        System.out.println(system.getAverageTime(start,end));
        sc.close();
    }
}