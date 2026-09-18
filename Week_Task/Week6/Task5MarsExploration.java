/*
 * TASK 5: MARS EXPLORATION
 *
 * PROBLEM STATEMENT:
 * The original message sent to Mars is a repeated "SOS".
 * Some characters may be changed during transmission.
 * Count the number of altered characters.
 *
 * INPUT:
 * SOSSPSSQSSOR
 *
 * OUTPUT:
 * 3
 */
package Week2.week6;
import java.util.*;
public class Task5MarsExploration{
    public static int marsExploration(String s){
        int count=0;
        String message="SOS";
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!=message.charAt(i%3)){
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        System.out.println(marsExploration(s));
        sc.close();
    }
}