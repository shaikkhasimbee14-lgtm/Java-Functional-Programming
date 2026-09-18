/*
Task Name: Java Method Overriding

Problem Statement:
Complete the Soccer class by overriding the getNumberOfTeamMembers()
method so that it prints that a Soccer team has 11 players.

Sample Input:
No input

Sample Output:
Generic Sports
Each team has n players in Generic Sports
Soccer Class
Each team has 11 players in Soccer Class
*/

class Sports{
    String getName(){
        return"Generic Sports";
    }
    void getNumberOfTeamMembers(){
        System.out.println("Each team has n players in "+getName());
    }
}
class Soccer extends Sports{
    @Override
    String getName(){
        return"Soccer Class";
    }
    @Override
    void getNumberOfTeamMembers(){
        System.out.println("Each team has 11 players in "+getName());
    }
}
public class Main{
    public static void main(String[]args){
        Sports sports=new Sports();
        Soccer soccer=new Soccer();
        System.out.println(sports.getName());
        sports.getNumberOfTeamMembers();
        System.out.println(soccer.getName());
        soccer.getNumberOfTeamMembers();
    }
}