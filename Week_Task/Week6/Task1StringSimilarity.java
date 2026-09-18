/*
 * TASK 1: STRING SIMILARITY
 *
 * PROBLEM STATEMENT:
 * Given a string S, similarity between S and one of its suffixes
 * is the length of their longest common prefix.
 * Find the sum of similarities of S with all its suffixes.
 *
 * INPUT:
 * 2
 * ababaa
 * aa
 *
 * OUTPUT:
 * 11
 * 3
 */
package Week2.week6;
import java.util.*;
public class Task1StringSimilarity{
    public static long stringSimilarity(String s){
        int n=s.length();
        int[] z=new int[n];
        int left=0;
        int right=0;
        for(int i=1;i<n;i++){
            if(i<=right){
                z[i]=Math.min(right-i+1,z[i-left]);
            }
            while(i+z[i]<n&&s.charAt(z[i])==s.charAt(i+z[i])){
                z[i]++;
            }
            if(i+z[i]-1>right){
                left=i;
                right=i+z[i]-1;
            }
        }
        long sum=n;
        for(int value:z){
            sum+=value;
        }
        return sum;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            String s=sc.next();
            System.out.println(stringSimilarity(s));
        }
        sc.close();
    }
}