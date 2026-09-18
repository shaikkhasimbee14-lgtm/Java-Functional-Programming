/*
 * TASK 8: JAVA INHERITANCE II
 *
 * PROBLEM STATEMENT:
 * Create a class named Arithmetic with an add method that
 * returns the sum of two integers.
 * Create a class named Adder that inherits Arithmetic.
 *
 * INPUT:
 * 10
 * 20
 *
 * OUTPUT:
 * My superclass is: Arithmetic
 * 30
 */
package Week7;
import java.util.*;
class Arithmetic{
    int add(int a,int b){
        return a+b;
    }
}
class Adder extends Arithmetic{
}
public class Task8JavaInheritance2{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        Adder adder=new Adder();
        System.out.println("My superclass is: Arithmetic");
        System.out.println(adder.add(a,b));
        sc.close();
    }
}