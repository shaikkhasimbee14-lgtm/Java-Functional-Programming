/*
Task Name: Java Exception Handling - Try Catch

Problem Statement:
Read two integers and perform integer division.

If the input is not a valid integer, handle the InputMismatchException.
If the second number is zero, handle the ArithmeticException.

Sample Input 0:
10
3

Sample Output 0:
3

Sample Input 1:
10
Hello

Sample Output 1:
java.util.InputMismatchException

Sample Input 2:
10
0

Sample Output 2:
java.lang.ArithmeticException: / by zero

Sample Input 3:
23.323
0

Sample Output 3:
java.util.InputMismatchException
*/

import java.util.*;
public class Main{
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        try{
            int a=sc.nextInt();
            int b=sc.nextInt();
            System.out.println(a/b);
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
