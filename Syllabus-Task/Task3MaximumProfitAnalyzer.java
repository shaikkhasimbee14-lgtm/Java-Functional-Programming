/*Maximum Profit Analyzer
Problem Description
Given daily profit/loss values, find the maximum possible profit obtainable from a contiguous(next to the other number without stopping) 
sequence of days using Kadane’s Algorithm.("""it contains two pointers like currentsum and maxsum""").
""""it also contains negative input values which means loss and positive for profit values""""
Input Format
•	First line contains integer N.
•	Second line contains N integers.
Output Format
Print maximum subarray sum.
Constraints
•	1 ≤ N ≤ 10^5
Sample Input
8
-2 -3 4 -1 -2 1 5 -3
Sample Output
7
 */

import java.util.Scanner;
public class Task3MaximumProfitAnalyzer {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter no. of days:");
        int n=sc.nextInt();
        int[] arr=new int[n];
        System.out.print("Enter profit/loss values:"+"  ");
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();

        }
        int CurrentSum=arr[0];
        int MaxSum=Integer.MIN_VALUE;
        int num;
        for(int i=1;i<n;i++){
            num=arr[i];
            CurrentSum=Math.max(num,CurrentSum+num);
            MaxSum=Math.max(MaxSum,CurrentSum);
        }
        System.out.println(MaxSum);
        sc.close();
    }
    
}
