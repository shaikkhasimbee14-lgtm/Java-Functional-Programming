/*
Task Name: Java Method Overriding 2 - Super Keyword

Problem Statement:
Use the super keyword to call the overridden method of the parent
class from the child class.

The Cycle class has a define_me() method.
The Motorcycle class extends Cycle and overrides define_me().
Use super.define_me() to access the parent class method.

Sample Input:
No input

Sample Output:
Hello I am a motorcycle, I am a cycle with an engine.
My ancestor is a cycle who is a vehicle with pedals.
*/

class Cycle{
String define_me(){
return"I am a cycle with pedals.";
}
}

class Motorcycle extends Cycle{
String define_me(){
return"I am a motorcycle, I am a cycle with an engine.";
}

void print(){
System.out.println("Hello "+define_me());
System.out.println("My ancestor is a cycle who is "+super.define_me());
}
}

public class Main{
public static void main(String[]args){
Motorcycle m=new Motorcycle();
m.print();
}
}