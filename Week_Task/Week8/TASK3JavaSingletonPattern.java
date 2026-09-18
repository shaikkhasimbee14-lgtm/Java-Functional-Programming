/*
Task Name: Java Singleton Pattern

Problem Statement:
Create a Singleton class that restricts the class to only one object.
The class must have a private constructor, a public String variable
named str, and a static getSingleInstance() method.

Sample Input:
hello world

Sample Output:
Hello I am a singleton! Let me say hello world to you
*/

import java.util.*;

class Singleton{
    private static Singleton instance=new Singleton();
    public String str;
    private Singleton(){}
    public static Singleton getSingleInstance(){
        return instance;
    }
}

public class Main{
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        Singleton singleton=Singleton.getSingleInstance();
        singleton.str=s;
        System.out.println("Hello I am a singleton! Let me say "+singleton.str+" to you");
    }
}