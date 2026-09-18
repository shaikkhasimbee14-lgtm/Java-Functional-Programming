/*
TASK4	Intelligent DNA Pattern Search
Problem Description
A bioinformatics company needs to identify occurrences of dangerous DNA patterns inside a massive DNA sequence. Implement efficient pattern matching using KMP or Boyer-Moore algorithm.
Input Format
•	First line contains DNA string T.
•	Second line contains pattern string P.
Output Format
Print all starting indices where pattern occurs.
Constraints
•	1 ≤ |T| ≤ 10^6
•	1 ≤ |P| ≤ 10^5
Sample Input
AABAACAADAABAABA
AABA
Sample Output
0 9 12
 */
import java.util.Scanner;
public class Task4IntelligenceDnaPatternSearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter DNA String: ");
        String T = sc.nextLine();
        System.out.print("Enter Pattern String: ");
        String P = sc.nextLine();
        int[] lps = new int[P.length()];
        int len = 0;
        int i = 1;
        while (i < P.length()) {
            if (P.charAt(i) == P.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } 
            else {
                if (len != 0) {
                    len = lps[len - 1];
                } 
                else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        i = 0;
        int j = 0;
        while (i < T.length()){
            if (T.charAt(i) == P.charAt(j)) {
                i++;
                j++;
            }
            if (j == P.length()) {
                System.out.print((i - j) + " ");
                j = lps[j - 1];
            }
            else if (i < T.length() && T.charAt(i) != P.charAt(j)) {
                if (j != 0) {
                    j = lps[j - 1];
                } 
                else {
                    i++;
                }
            }
        }
        sc.close();
    }
}