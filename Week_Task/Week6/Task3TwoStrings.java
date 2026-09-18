/*
 * TASK 3: TWO STRINGS
 *
 * PROBLEM STATEMENT:
 * Given two strings, determine whether they share at least
 * one common substring.
 * A substring can be as small as one character.
 *
 * INPUT:
 * 2
 * hello
 * world
 * hi
 * world
 *
 * OUTPUT:
 * YES
 * NO
 */
package Week2.week6;
import java.util.*;
public class Task3TwoStrings{
    public static String twoStrings(String s1,String s2){
        boolean[] present=new boolean[26];
        for(char c:s1.toCharArray()){
            present[c-'a']=true;
        }
        for(char c:s2.toCharArray()){
            if(present[c-'a']){
                return "YES";
            }
        }
        return "NO";
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            String s1=sc.next();
            String s2=sc.next();
            System.out.println(twoStrings(s1,s2));
        }
        sc.close();
    }
}