/*
 * TASK 1: DESIGN PARKING SYSTEM
 *
 * PROBLEM STATEMENT:
 * Design a parking system with three types of parking spaces:
 * big, medium and small.
 * A car can park only in a space of its corresponding type.
 * Return true if a space is available and false otherwise.
 *
 * INPUT:
 * 1 1 0
 * 1
 * 2
 * 3
 * 1
 *
 * OUTPUT:
 * true
 * true
 * false
 * false
 */
package Week7;
import java.util.*;
public class Task1DesignParkingSystem{
    int[] spaces;
    Task1DesignParkingSystem(int big,int medium,int small){
        spaces=new int[]{0,big,medium,small};
    }
    public boolean addCar(int carType){
        if(spaces[carType]>0){
            spaces[carType]--;
            return true;
        }
        return false;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int big=sc.nextInt();
        int medium=sc.nextInt();
        int small=sc.nextInt();
        Task1DesignParkingSystem parking=new Task1DesignParkingSystem(big,medium,small);
        int n=sc.nextInt();
        for(int i=0;i<n;i++){
            int carType=sc.nextInt();
            System.out.println(parking.addCar(carType));
        }
        sc.close();
    }
}