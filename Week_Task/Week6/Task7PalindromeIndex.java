/*
 * TASK 7: PALINDROME INDEX
 *
 * PROBLEM STATEMENT:
 * Given a string, find the index of one character that can be
 * removed to make the string a palindrome.
 * If the string is already a palindrome, return -1.
 * If no removal can make it a palindrome, return -1.
 *
 * INPUT:
 * 3
 * aaab
 * baa
 * aaa
 *
 * OUTPUT:
 * 3
 * 0
 * -1
 */
package Week2.week6;
import java.util.*;
public class Task7PalindromeIndex{
    public static int palindromeIndex(String s){
        int left=0;
        int right=s.length()-1;
        while(left<right){
            if(s.charAt(left)!=s.charAt(right)){
                if(isPalindrome(s,left+1,right)){
                    return left;
                }
                if(isPalindrome(s,left,right-1)){
                    return right;
                }
                return -1;
            }
            left++;
            right--;
        }
        return -1;
    }
    public static boolean isPalindrome(String s,int left,int right){
        while(left<right){
            if(s.charAt(left)!=s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int q=sc.nextInt();
        while(q-->0){
            String s=sc.next();
            System.out.println(palindromeIndex(s));
        }
        sc.close();
    }
}