/*
Task Name: Java Exception Handling

Problem Statement:
Create a MyCalculator class with a power(int n,int p) method.

If n or p is negative, throw an exception with the message:
n or p should not be negative.

If both n and p are zero, throw an exception with the message:
n and p should not be zero.

Otherwise return n raised to the power p.

Sample Input:
3 5
2 4
0 0
-1 -2
-1 3

Sample Output:
243
16
java.lang.Exception: n and p should not be zero.
java.lang.Exception: n or p should not be negative.
java.lang.Exception: n or p should not be negative.
*/

import java.util.*;

class MyCalculator{
    long power(int n,int p)throws Exception{
        if(n<0||p<0){
            throw new Exception("n or p should not be negative.");
        }
        if(n==0&&p==0){
            throw new Exception("n and p should not be zero.");
        }
        return(long)Math.pow(n,p);
    }
}

public class Main{
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        MyCalculator calculator=new MyCalculator();

        while(sc.hasNextInt()){
            int n=sc.nextInt();
            int p=sc.nextInt();

            try{
                System.out.println(calculator.power(n,p));
            }catch(Exception e){
                System.out.println(e);
            }
        }
    }
}