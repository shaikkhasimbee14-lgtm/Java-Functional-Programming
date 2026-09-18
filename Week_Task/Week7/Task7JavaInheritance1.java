/*
 * TASK 7: JAVA INHERITANCE I
 *
 * PROBLEM STATEMENT:
 * Create an Animal class with a walk method.
 * Create a Bird class that inherits from Animal.
 * Bird should have fly and sing methods.
 *
 * OUTPUT:
 * I am walking
 * I am flying
 * I am singing
 */
package Week7;
import java.util.*;
class Animal{
    void walk(){
        System.out.println("I am walking");
    }
}
class Bird extends Animal{
    void fly(){
        System.out.println("I am flying");
    }
    void sing(){
        System.out.println("I am singing");
    }
}
public class Task7JavaInheritance1{
    public static void main(String[] args){
        Bird bird=new Bird();
        bird.walk();
        bird.fly();
        bird.sing();
    }
}
