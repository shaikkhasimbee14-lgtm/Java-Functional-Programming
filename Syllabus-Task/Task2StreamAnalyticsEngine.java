/*Real-Time Stream Analytics Engine
Problem Description
A cloud analytics platform receives millions of sensor readings. Each reading contains a sensor ID and temperature value. Using stream processing concepts, perform the following operations:
1.	Filter temperatures greater than 50.
2.	Group readings by sensor ID.
3.	Compute average temperature per sensor.
4.	Sort sensors based on average temperature in descending order.
Input Format
•	First line contains integer N.
•	Next N lines contain SensorID and Temperature.
Output Format
Display SensorID and average temperature sorted in descending order.
Constraints
•	1 ≤ N ≤ 10^5
•	0 ≤ Temperature ≤ 100
Sample Input:
6
S1 60
S2 40
S1 80
S3 70
S2 90
S3 30
Sample Output:
S1 70.0
S2 90.0
S3 70.0 */
import java.util.*;
public class Task2StreamAnalyticsEngine{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter number of sensor readings:");
        int n=sc.nextInt();
        sc.nextLine();
        HashMap<String, Double> sensorData=new HashMap<>();//to store key value pairs
        HashMap<String, Integer> count=new HashMap<>();//to store average temperature
        for(int i=0;i<n;i++){
            String ID=sc.next();
            double temp=sc.nextDouble();
            if(temp>50){
                sensorData.putIfAbsent(ID, 0.0);
                sensorData.put(ID, sensorData.get(ID) + temp);
                count.putIfAbsent(ID, 0);
                count.put(ID, count.get(ID) + 1);
            }
        }
         sensorData.entrySet().stream()
            .map(entry -> new AbstractMap.SimpleEntry<>(entry.getKey(), entry.getValue() / count.get(entry.getKey())))
            .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
            .forEach(entry -> System.out.println(entry.getKey() + " " + entry.getValue()));
        sc.close();
    }
}
