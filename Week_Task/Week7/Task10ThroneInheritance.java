p/*
 * TASK 10: THRONE INHERITANCE
 *
 * PROBLEM STATEMENT:
 * A kingdom contains a king, children and grandchildren.
 * The inheritance order follows the family tree.
 * A child is placed after the parent and before younger siblings.
 * Dead people are removed from the order, but their children
 * remain in the inheritance tree.
 *
 * INPUT:
 * king
 * 5
 * birth king Alice
 * birth king Bob
 * birth Alice Jack
 * death Bob
 * order
 *
 * OUTPUT:
 * king Alice Jack
 */
package Week7;
import java.util.*;
public class Task10ThroneInheritance{
    String king;
    HashMap<String,ArrayList<String>> children=new HashMap<>();
    HashSet<String> dead=new HashSet<>();
    Task10ThroneInheritance(String kingName){
        king=kingName;
        children.put(kingName,new ArrayList<>());
    }
    public void birth(String parentName,String childName){
        children.putIfAbsent(parentName,new ArrayList<>());
        children.put(childName,new ArrayList<>());
        children.get(parentName).add(childName);
    }
    public void death(String name){
        dead.add(name);
    }
    public void dfs(String person,ArrayList<String> order){
        if(!dead.contains(person)){
            order.add(person);
        }
        for(String child:children.getOrDefault(person,new ArrayList<>())){
            dfs(child,order);
        }
    }
    public List<String> getInheritanceOrder(){
        ArrayList<String> order=new ArrayList<>();
        dfs(king,order);
        return order;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String king=sc.next();
        Task10ThroneInheritance throne=new Task10ThroneInheritance(king);
        int n=sc.nextInt();
        for(int i=0;i<n;i++){
            String operation=sc.next();
            if(operation.equals("birth")){
                String parent=sc.next();
                String child=sc.next();
                throne.birth(parent,child);
            }else if(operation.equals("death")){
                String name=sc.next();
                throne.death(name);
            }else if(operation.equals("order")){
                List<String> order=throne.getInheritanceOrder();
                for(String person:order){
                    System.out.print(person+" ");
                }
                System.out.println();
            }
        }
        sc.close();
    }
}