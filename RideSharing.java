/*Ride Sharing Platform Simulator
Problem Description
Design an object-oriented ride sharing system with reusable classes for Driver, Rider, Vehicle, and Trip. Support polymorphic fare calculation for Bike, Auto, and Cab rides. Include exception handling for invalid bookings.
Input Format
First line contains integer N.
Next N lines contain ride type and distance.
Output Format
Display fare for each trip.
Constraints
1 ≤ N ≤ 10^5*/

import java.util.*;
abstract class Vehicle {
    abstract double calculateFare(double distance);
}
class Bike extends Vehicle {
    @Override
    double calculateFare(double distance) {
        return distance * 5;
    }
}
class Auto extends Vehicle {
    @Override
    double calculateFare(double distance) {
        return distance * 12;
    }
}
class Cab extends Vehicle {

    @Override
    double calculateFare(double distance) {
        return distance * 12;
    }
}
class Driver {
    String name;
    Driver(String name) {
        this.name = name;
    }
}
class Rider {
    String name;
    Rider(String name) {
        this.name = name;
    }
}
class Trip {
    Vehicle vehicle;
    double distance;
    Trip(Vehicle vehicle, double distance) {
        this.vehicle = vehicle;
        this.distance = distance;
    }
    double getFare() {
        return vehicle.calculateFare(distance);
    }
}
public class RideSharing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Trip> trips = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double distance = sc.nextDouble();
            try {
                Vehicle vehicle;
                switch (type.toLowerCase()) {
                    case "bike":
                        vehicle = new Bike();
                        break;
                    case "auto":
                        vehicle = new Auto();
                        break;
                    case "cab":
                        vehicle = new Cab();
                        break;
                    default:
                        throw new IllegalArgumentException(
                            "Invalid ride type"
                        );
                }
                if (distance <= 0) {
                    throw new IllegalArgumentException(
                        "Invalid distance"
                    );
                }
                trips.add(new Trip(vehicle, distance));
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid Booking");
            }
        }
        trips.stream()
             .mapToDouble(Trip::getFare)
             .forEach(System.out::println);
        sc.close();
    }
}