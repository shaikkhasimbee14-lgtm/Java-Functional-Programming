/*Intelligent DNA Pattern Search
Problem Description
A bioinformatics company needs to identify occurrences of dangerous DNA patterns inside a massive DNA sequence. Implement efficient pattern matching using KMP or Boyer-Moore algorithm.
Input Format
First line contains DNA string T.
Second line contains pattern string P.
Output Format
Print all starting indices where pattern occurs.
Constraints
1 ≤ |T| ≤ 10^6
1 ≤ |P| ≤ 10^5*/
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class DnaPattern {
    static int[] createLPS(String pattern) {
        int[] lps = new int[pattern.length()];
        int len = 0;
        for (int i = 1; i < pattern.length(); i++) {
            while (len > 0 &&
                   pattern.charAt(i) != pattern.charAt(len)) {
                len = lps[len - 1];
            }
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
            }
            lps[i] = len;
        }
        return lps;
    }
    static List<Integer> kmp(String text, String pattern) {
        int[] lps = createLPS(pattern);
        List<Integer> positions = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < text.length()) {
            if (text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            }
            if (j == pattern.length()) {
                positions.add(i - j);
                j = lps[j - 1];
            } 
            else if (i < text.length() &&
                     text.charAt(i) != pattern.charAt(j)) {
                if (j != 0) {
                    j = lps[j - 1];
                } 
                else {
                    i++;
                }
            }
        }
        return positions;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        String pattern = sc.nextLine();
        kmp(text, pattern)
                .stream()
                .map(String::valueOf)
                .forEach(pos -> System.out.print(pos + " "));
        sc.close();
    }
}
