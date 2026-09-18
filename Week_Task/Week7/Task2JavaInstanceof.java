/*
 * TASK 2: JAVA INSTANCEOF KEYWORD
 *
 * PROBLEM STATEMENT:
 * The instanceof operator checks whether an object belongs
 * to a particular class.
 * Given a list of Student, Rockstar and Hacker objects,
 * count how many objects belong to each class.
 *
 * INPUT:
 * 5
 * Student
 * Student
 * Rockstar
 * Student
 * Hacker
 *
 * OUTPUT:
 * 3 1 1
 */
package Week7;
import java.util.*;
public class Task2JavaInstanceof{
    static class Student{}
    static class Rockstar{}
    static class Hacker{}
    public static int[] count(ArrayList<Object> list){
        int student=0;
        int rockstar=0;
        int hacker=0;
        for(Object obj:list){
            if(obj instanceof Student){
                student++;
            }else if(obj instanceof Rockstar){
                rockstar++;
            }else if(obj instanceof Hacker){
                hacker++;
            }
        }
        return new int[]{student,rockstar,hacker};
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        ArrayList<Object> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            String type=sc.next();
            if(type.equals("Student")){
                list.add(new Student());
            }else if(type.equals("Rockstar")){
                list.add(new Rockstar());
            }else if(type.equals("Hacker")){
                list.add(new Hacker());
            }
        }
        int[] result=count(list);
        System.out.println(result[0]+" "+result[1]+" "+result[2]);
        sc.close();
    }
}