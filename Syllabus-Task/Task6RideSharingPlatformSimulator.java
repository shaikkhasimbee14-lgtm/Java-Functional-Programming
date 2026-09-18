/*Ride Sharing Platform Simulator
Problem Description
Design an object-oriented ride sharing system with reusable classes for Driver, Rider, Vehicle, and Trip. Support polymorphic fare calculation for Bike, Auto, and Cab rides. Include exception handling for invalid bookings.
Input Format
•	First line contains integer N.
•	Next N lines contain ride type and distance.
Output Format
Display fare for each trip.
Constraints
•	1 ≤ N ≤ 10^5
Sample Input
3
Bike 10
Cab 15
Auto 8
Sample Output
50
180
96
*/
import java.util.Scanner;
public class Task6RideSharingPlatformSimulator {
    static int calculateFare(String rideType, int distance) {
        switch (rideType) {
            case "Bike":
                return distance * 5;
            case "Auto":
                return distance * 12;
            case "Cab":
                return distance * 12;
            default:
                throw new IllegalArgumentException("Invalid ride type");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String rideType = sc.next();
            int distance = sc.nextInt();
            try {
                int fare = calculateFare(rideType, distance);
                System.out.println(fare);
            }
            catch (IllegalArgumentException e) {
                System.out.println("Invalid booking");
            }
        }
        sc.close();
    }
}