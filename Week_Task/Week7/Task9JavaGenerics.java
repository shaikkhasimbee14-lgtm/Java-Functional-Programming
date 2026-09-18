/*
 * TASK 9: JAVA GENERICS
 *
 * PROBLEM STATEMENT:
 * Write one generic method named printArray that can print
 * elements from arrays of different data types.
 * The method should work for both Integer and String arrays.
 * Method overloading should not be used.
 *
 * INPUT:
 * 3
 * 1
 * 2
 * 3
 * 2
 * Hello
 * World
 *
 * OUTPUT:
 * 1
 * 2
 * 3
 * Hello
 * World
 */
package Week7;
import java.util.*;
public class Task9JavaGenerics{
    public static <T> void printArray(T[] array){
        for(T element:array){
            System.out.println(element);
        }
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        Integer[] numbers=new Integer[n];
        for(int i=0;i<n;i++){
            numbers[i]=sc.nextInt();
        }
        int m=sc.nextInt();
        String[] words=new String[m];
        for(int i=0;i<m;i++){
            words[i]=sc.next();
        }
        printArray(numbers);
        printArray(words);
        sc.close();
    }
}
