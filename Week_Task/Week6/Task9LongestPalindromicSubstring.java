/*
 * TASK 9: LONGEST PALINDROMIC SUBSTRING
 *
 * PROBLEM STATEMENT:
 * Given a string s, find the longest palindromic substring
 * present in the string.
 *
 * INPUT:
 * babad
 *
 * OUTPUT:
 * bab
 *
 * "aba" is also a valid answer for this input.
 */
package Week2.week6;
import java.util.*;
public class Task9LongestPalindromicSubstring{
    public static String longestPalindrome(String s){
        if(s.length()<=1){
            return s;
        }
        StringBuilder transformed=new StringBuilder();
        transformed.append('#');
        for(char c:s.toCharArray()){
            transformed.append(c);
            transformed.append('#');
        }
        int n=transformed.length();
        int[] radius=new int[n];
        int center=0;
        int right=0;
        int maxLength=0;
        int maxCenter=0;
        for(int i=0;i<n;i++){
            int mirror=2*center-i;
            if(i<right){
                radius[i]=Math.min(right-i,radius[mirror]);
            }
            while(i+radius[i]+1<n&&i-radius[i]-1>=0&&transformed.charAt(i+radius[i]+1)==transformed.charAt(i-radius[i]-1)){
                radius[i]++;
            }
            if(i+radius[i]>right){
                center=i;
                right=i+radius[i];
            }
            if(radius[i]>maxLength){
                maxLength=radius[i];
                maxCenter=i;
            }
        }
        int start=(maxCenter-maxLength)/2;
        return s.substring(start,start+maxLength);
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        System.out.println(longestPalindrome(s));
        sc.close();
    }
}