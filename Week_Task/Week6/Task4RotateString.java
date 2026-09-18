/*
 * TASK 4: ROTATE STRING
 *
 * PROBLEM STATEMENT:
 * Given two strings s and goal, determine whether s can become
 * goal after performing some number of left rotations.
 *
 * INPUT:
 * abcde
 * cdeab
 *
 * OUTPUT:
 * true
 */
package Week2.week6;
import java.util.*;
public class Task4RotateString{
    public static boolean rotateString(String s,String goal){
        if(s.length()!=goal.length()){
            return false;
        }
        String text=s+s;
        return kmpSearch(text,goal);
    }
    public static boolean kmpSearch(String text,String pattern){
        int[] lps=buildLPS(pattern);
        int i=0;
        int j=0;
        while(i<text.length()){
            if(text.charAt(i)==pattern.charAt(j)){
                i++;
                j++;
                if(j==pattern.length()){
                    return true;
                }
            }else{
                if(j!=0){
                    j=lps[j-1];
                }else{
                    i++;
                }
            }
        }
        return false;
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
        String s=sc.next();
        String goal=sc.next();
        System.out.println(rotateString(s,goal));
        sc.close();
    }
}