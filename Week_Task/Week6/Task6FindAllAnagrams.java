/*
 * TASK 6: FIND ALL ANAGRAMS IN A STRING
 *
 * PROBLEM STATEMENT:
 * Given two strings s and p, find all starting indices of
 * substrings in s that are anagrams of p.
 *
 * INPUT:
 * cbaebabacd
 * abc
 *
 * OUTPUT:
 * 0 6
 */
package Week2.week6;
import java.util.*;
public class Task6FindAllAnagrams{
    public static List<Integer> findAnagrams(String s,String p){
        List<Integer> result=new ArrayList<>();
        if(p.length()>s.length()){
            return result;
        }
        int[] pCount=new int[26];
        int[] windowCount=new int[26];
        for(char c:p.toCharArray()){
            pCount[c-'a']++;
        }
        int windowSize=p.length();
        for(int i=0;i<s.length();i++){
            windowCount[s.charAt(i)-'a']++;
            if(i>=windowSize){
                windowCount[s.charAt(i-windowSize)-'a']--;
            }
            if(i>=windowSize-1){
                if(Arrays.equals(pCount,windowCount)){
                    result.add(i-windowSize+1);
                }
            }
        }
        return result;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        String p=sc.next();
        List<Integer> result=findAnagrams(s,p);
        for(int index:result){
            System.out.print(index+" ");
        }
        sc.close();
    }
}