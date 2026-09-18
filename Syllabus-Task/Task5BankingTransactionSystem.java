/*Banking Transaction System
Problem Description
Design classes for bank accounts supporting deposit and withdrawal operations.
Input Format
•	First line contains integer N.
•	Next N lines contain operations.
Output Format
Display final balance.
Sample Input
3
Deposit 5000
Withdraw 2000
Deposit 1000
Sample Output
4000
 */
import java.util.Scanner;
public class Task5BankingTransactionSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int balance = 0;
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int amount = sc.nextInt();
            if (type.equals("Deposit")) {
                balance += amount;
            } 
            else if (type.equals("Withdraw")) {
                balance -= amount;
            }
        }
        System.out.println(balance);
        sc.close();
    }
}