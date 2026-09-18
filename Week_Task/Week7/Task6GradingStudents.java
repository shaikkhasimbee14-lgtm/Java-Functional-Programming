/*
 * TASK 6: GRADING STUDENTS
 *
 * PROBLEM STATEMENT:
 * A teacher rounds grades according to these rules:
 * If the grade is less than 38, it is not rounded.
 * Otherwise, if the difference between the grade and the
 * next multiple of 5 is less than 3, round the grade up.
 *
 * INPUT:
 * 4
 * 73
 * 67
 * 38
 * 33
 *
 * OUTPUT:
 * 75
 * 67
 * 40
 * 33
 */
package Week7;
import java.util.*;
public class Task6GradingStudents{
    public static int gradingStudents(int grade){
        if(grade<38){
            return grade;
        }
        int next=((grade/5)+1)*5;
        if(next-grade<3){
            return next;
        }
        return grade;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        for(int i=0;i<n;i++){
            int grade=sc.nextInt();
            System.out.println(gradingStudents(grade));
        }
        sc.close();
    }
}