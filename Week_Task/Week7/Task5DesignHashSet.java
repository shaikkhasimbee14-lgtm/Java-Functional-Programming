/*
 * TASK 5: DESIGN HASHSET
 *
 * PROBLEM STATEMENT:
 * Design a HashSet without using Java's built-in HashSet.
 * The class must support add, remove and contains operations.
 *
 * INPUT:
 * 7
 * add 1
 * add 2
 * contains 1
 * contains 3
 * remove 2
 * contains 2
 * contains 1
 *
 * OUTPUT:
 * true
 * false
 * false
 * true
 */
package Week7;
import java.util.*;
public class Task5DesignHashSet{
    boolean[] data=new boolean[1000001];
    public void add(int key){
        data[key]=true;
    }
    public void remove(int key){
        data[key]=false;
    }
    public boolean contains(int key){
        return data[key];
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        Task5DesignHashSet set=new Task5DesignHashSet();
        int n=sc.nextInt();
        for(int i=0;i<n;i++){
            String operation=sc.next();
            int key=sc.nextInt();
            if(operation.equals("add")){
                set.add(key);
            }else if(operation.equals("remove")){
                set.remove(key);
            }else if(operation.equals("contains")){
                System.out.println(set.contains(key));
            }
        }
        sc.close();
    }
}