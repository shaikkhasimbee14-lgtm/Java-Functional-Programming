/*
Task Name: Java Factory Pattern

Problem Statement:
Create a FoodFactory class containing getFood(String).
The method should return a Cake object when the input is "cake"
and a Pizza object when the input is "pizza".

Sample Input 1:
cake

Sample Output 1:
The factory returned class Cake
Someone ordered a Dessert!

Sample Input 2:
pizza

Sample Output 2:
The factory returned class Pizza
Someone ordered Fast Food!
*/

import java.util.*;
interface Food{
    String getType();
}
class Cake implements Food{
    public String getType(){
        return"Someone ordered a Dessert!";
    }
}

class Pizza implements Food{
    public String getType(){
        return"Someone ordered Fast Food!";
    }
}

class FoodFactory{
    public Food getFood(String order){
        if(order.equals("cake")){
            return new Cake();
        }
        if(order.equals("pizza")){
            return new Pizza();
        }
        return null;
    }
}

public class Main{
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        String order=sc.nextLine();
        FoodFactory factory=new FoodFactory();
        Food food=factory.getFood(order);
        System.out.println("The factory returned class "+food.getClass().getSimpleName());
        System.out.println(food.getType());
    }
}