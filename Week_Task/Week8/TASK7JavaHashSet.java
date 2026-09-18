/*
Task Name: Java HashSet

Problem Statement:
You are given pairs of strings.
Two pairs are identical only when both strings in the pair are equal.

After reading each pair, print the number of unique pairs.

Sample Input:
5
john tom
john mary
john tom
mary anna
mary anna

Sample Output:
1
2
2
3
3
*/

import java.util.*;
public class Main{
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        Set<String>set=new HashSet<>();
        for(int i=0;i<n;i++){
            String a=sc.next();
            String b=sc.next();
            set.add(a+" "+b);
            System.out.println(set.size());
        }
    }
}