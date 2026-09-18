/*
 * TASK 10: CIRCULAR PALINDROMES
 *
 * PROBLEM STATEMENT:
 * Given a string S, consider every possible rotation of S.
 * For each rotation, find the maximum length of a palindromic
 * substring and print the answer.
 *
 * INPUT:
 * 13
 * aaaaabbbbaaaa
 *
 * OUTPUT:
 * 12
 * 12
 * 10
 * 8
 * 8
 * 9
 * 11
 * 13
 * 11
 * 9
 * 8
 * 8
 * 10
 */
package Week2.week6;
import java.util.*;
public class Task10CircularPalindromes{
    static int[] buildManacher(String s){
        int n=s.length();
        int[] p=new int[n];
        int center=0;
        int right=0;
        for(int i=0;i<n;i++){
            int mirror=2*center-i;
            if(i<right){
                p[i]=Math.min(right-i,p[mirror]);
            }
            while(i+p[i]+1<n&&i-p[i]-1>=0&&s.charAt(i+p[i]+1)==s.charAt(i-p[i]-1)){
                p[i]++;
            }
            if(i+p[i]>right){
                center=i;
                right=i+p[i];
            }
        }
        return p;
    }
    static class SparseTable{
        int[][] table;
        int[] log;
        SparseTable(int[] arr){
            int n=arr.length;
            log=new int[n+1];
            for(int i=2;i<=n;i++){
                log[i]=log[i/2]+1;
            }
            int levels=log[n]+1;
            table=new int[levels][n];
            for(int i=0;i<n;i++){
                table[0][i]=arr[i];
            }
            for(int level=1;level<levels;level++){
                int length=1<<level;
                int half=length>>1;
                for(int i=0;i+length<=n;i++){
                    table[level][i]=Math.max(table[level-1][i],table[level-1][i+half]);
                }
            }
        }
        int query(int left,int right){
            if(left>right){
                return 0;
            }
            int length=right-left+1;
            int level=log[length];
            return Math.max(table[level][left],table[level][right-(1<<level)+1]);
        }
    }
    public static int[] circularPalindromes(String s){
        int n=s.length();
        String doubled=s+s;
        StringBuilder transformed=new StringBuilder();
        transformed.append('#');
        for(char c:doubled.toCharArray()){
            transformed.append(c);
            transformed.append('#');
        }
        int[] radius=buildManacher(transformed.toString());
        SparseTable sparse=new SparseTable(radius);
        int[] answer=new int[n];
        for(int start=0;start<n;start++){
            int left=2*start;
            int right=2*(start+n-1);
            int low=1;
            int high=n;
            int best=1;
            while(low<=high){
                int mid=(low+high)/2;
                int centerLeft=left+mid-1;
                int centerRight=right-mid+1;
                if(centerLeft<=centerRight&&sparse.query(centerLeft,centerRight)>=mid){
                    best=mid;
                    low=mid+1;
                }else{
                    high=mid-1;
                }
            }
            answer[start]=best;
        }
        return answer;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        String s=sc.next();
        int[] result=circularPalindromes(s);
        for(int value:result){
            System.out.println(value);
        }
        sc.close();
    }
}