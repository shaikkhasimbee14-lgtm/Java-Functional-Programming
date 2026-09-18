/***Calculator Unit Testing**
**Problem Description**
Write unit tests for calculator operations including addition and division.
**Input Format**
Arithmetic expression.
**Output Format**
Display test result.
**Sample Input**
10 + 20
**Sample Output**
  Test Passed */
import java.util.*;
class Task9CalculatorUnitTesting{
    static int add(int a, int b) {
        return a + b;
    }
    static int divide(int a, int b) {
        return a / b;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        String operator = sc.next();
        int b = sc.nextInt();
        boolean passed = false;
        if (operator.equals("+")) {
            int result = add(a, b);
            if (result == a + b) {
                passed = true;
            }
        }
        else if (operator.equals("/")) {
            if (b != 0) {
                int result = divide(a, b);
                if (result == a / b) {
                    passed = true;
                }
            }
        }
        if (passed) {
            System.out.println("Test Passed");
        } else {
            System.out.println("Test Failed");
        }
        sc.close();
    }
}