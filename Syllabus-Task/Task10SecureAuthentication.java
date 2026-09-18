/*Secure Authentication Stress Testing
Problem Description
Develop automated test cases for a login system supporting:
•	Boundary value testing
•	Exception testing
•	Timeout testing
•	Parameterized testing
•	Edge case validation
The system should validate thousands of login attempts efficiently.
Input Format
•	First line contains integer N.
•	Next N lines contain username and password.
Output Format
Display SUCCESS or FAILURE for each login.
Constraints
•	1 ≤ N ≤ 10^5
•	Username length: 3–20
•	Password length: 6–20
Sample Input
3
admin admin123
ab 123
user pass
Sample Output
SUCCESS
FAILURE
FAILURE
 */

import java.util.*;
class Task10SecureAuthentication {
    static boolean validateLogin(String username, String password) {
        if (username.length() < 3 || username.length() > 20) {
            return false;
        }
        if (password.length() < 6 || password.length() > 20) {
            return false;
        }
        if (username.equals("admin") && password.equals("admin123")) {
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            String username = sc.next();
            String password = sc.next();
            try {
                if (validateLogin(username, password)) {
                    System.out.println("SUCCESS");
                } else {
                    System.out.println("FAILURE");
                }
            } catch (Exception e) {
                System.out.println("FAILURE");
            }
        }
        sc.close();
    }
}