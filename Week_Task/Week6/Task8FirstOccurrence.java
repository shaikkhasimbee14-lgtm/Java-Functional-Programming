/*
 * TASK 8: FIND THE INDEX OF THE FIRST OCCURRENCE IN A STRING
 *
 * PROBLEM STATEMENT:
 * Given two strings haystack and needle, return the index of
 * the first occurrence of needle in haystack.
 * If needle is not present, return -1.
 *
 * INPUT:
 * sadbutsad
 * sad
 *
 * OUTPUT:
 * 0
 */
package Week2.week6;
import java.util.*;
public class Task8FirstOccurrence{
    public static int strStr(String haystack,String needle){
        if(needle.length()==0){
            return 0;
        }
        int[] lps=buildLPS(needle);
        int i=0;
        int j=0;
        while(i<haystack.length()){
            if(haystack.charAt(i)==needle.charAt(j)){
                i++;
                j++;
                if(j==needle.length()){
                    return i-j;
                }
            }else{
                if(j!=0){
                    j=lps[j-1];
                }else{
                    i++;
                }
            }
        }
        return -1;
    }
    public static int[] buildLPS(String pattern){
        int[] lps=new int[pattern.length()];
        int length=0;
        int i=1;
        while(i<pattern.length()){
            if(pattern.charAt(i)==pattern.charAt(length)){
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
        return lps;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String haystack=sc.next();
        String needle=sc.next();
        System.out.println(strStr(haystack,needle));
        sc.close();
    }
}