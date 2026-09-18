/*
Task Name: Java Interface

Problem Statement:
Implement the AdvancedArithmetic interface using MyCalculator.
The divisor_sum method must calculate the sum of all divisors of n.

Example:
Divisors of 6 are 1, 2, 3 and 6.
Their sum is 12.

Sample Input:
6

Sample Output:
I implemented: AdvancedArithmetic
12
*/

interface AdvancedArithmetic{
    int divisor_sum(int n);
}
class MyCalculator implements AdvancedArithmetic{
    public int divisor_sum(int n){
        int sum=0;
        for(int i=1;i<=n;i++){
            if(n%i==0){
                sum+=i;
            }
        }
        return sum;
    }
}
public class Main{
    public static void main(String[]args){
        java.util.Scanner sc=new java.util.Scanner(System.in);
        int n=sc.nextInt();
        MyCalculator calculator=new MyCalculator();
        System.out.println("I implemented: AdvancedArithmetic");
        System.out.println(calculator.divisor_sum(n));
    }
}
