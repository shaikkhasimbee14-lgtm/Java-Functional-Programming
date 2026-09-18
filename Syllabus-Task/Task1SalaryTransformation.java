/*
Task 1 (Easy): Salary Transformation System
Problem Description
A company stores employee salaries in a list. Increase each salary by 10% and print the updated salaries using functional transformation techniques.
Input Format
•	First line contains integer N.
•	Second line contains N space-separated integers.
Output Format
Print updated salaries.
Constraints
•	1 ≤ N ≤ 10^5
Sample Input
5
1000 2000 3000 4000 5000
Sample Output
1100 2200 3300 4400 5500
*/

import java.util.Arrays;
import java.util.Scanner;
public class Task1SalaryTransformation{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter number of Employees:");
        int n=sc.nextInt();
        int[] salaries=new int[n];
        System.out.println("Enter salaries of employees:" + " ");
        for(int i=0;i<n;i++){
            salaries[i]=sc.nextInt();
        }
        Arrays.stream(salaries)
                .map(salary -> salary + salary * 10 / 100)
                .forEach(salary -> System.out.print(salary +" "));
        sc.close();        
    }
}