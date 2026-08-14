/*Banking Transaction System
Problem Description
Design classes for bank accounts supporting deposit and withdrawal operations.
Input Format
First line contains integer N.
Next N lines contain operations.
Output Format
Display final balance.*/

import java.util.*;
public class BankingTransaction{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        List<String> transactions = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            transactions.add(sc.nextLine());
        }
        double balance = transactions.stream()
                .mapToDouble(transaction -> {
                    String[] parts = transaction.split(" ");
                    double amount = Double.parseDouble(parts[1]);
                    if (parts[0].equalsIgnoreCase("Deposit")) {
                        return amount;
                    } else {
                        return -amount;
                    }
                })
                .sum();
        System.out.println((int) balance);
        sc.close();
    }
}
