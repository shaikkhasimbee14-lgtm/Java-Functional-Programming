/*
 * TASK 2: REPEATED SUBSTRING PATTERN
 *
 * PROBLEM STATEMENT:
 * Given a string s, check whether it can be constructed by
 * taking a substring of it and appending multiple copies of
 * that substring together.
 *
 * INPUT:
 * abab
 *
 * OUTPUT:
 * true
 */
package Week2.week6;
import java.util.*;
public class Task2RepeatedSubstringPattern{
    public static boolean repeatedSubstringPattern(String s){
        int n=s.length();
        int[] lps=new int[n];
        int length=0;
        int i=1;
        while(i<n){
            if(s.charAt(i)==s.charAt(length)){
                length++;
                lps[i]=length;
                i++;
            }else{
                if(length!=0){
                    length=lps[length-1];
                }else{
                    lps[i]=0;
                    i++;
                }
            }
        }
        int longestPrefixSuffix=lps[n-1];
        return longestPrefixSuffix>0&&n%(n-longestPrefixSuffix)==0;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        System.out.println(repeatedSubstringPattern(s));
        sc.close();
    }
}