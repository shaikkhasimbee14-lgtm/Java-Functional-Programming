/*
 * TASK 4: DESIGN BROWSER HISTORY
 *
 * PROBLEM STATEMENT:
 * Design a browser history for one browser tab.
 * The browser starts at a homepage.
 * It should support visiting a new URL, moving backward
 * and moving forward through the browsing history.
 *
 * INPUT:
 * google.com
 * visit youtube.com
 * visit facebook.com
 * back 1
 * forward 1
 *
 * OUTPUT:
 * youtube.com
 * facebook.com
 */
package Week7;
import java.util.*;
public class Task4DesignBrowserHistory{
    ArrayList<String> history=new ArrayList<>();
    int current=0;
    public Task4DesignBrowserHistory(String homepage){
        history.add(homepage);
    }
    public void visit(String url){
        while(history.size()>current+1){
            history.remove(history.size()-1);
        }
        history.add(url);
        current++;
    }
    public String back(int steps){
        current=Math.max(0,current-steps);
        return history.get(current);
    }
    public String forward(int steps){
        current=Math.min(history.size()-1,current+steps);
        return history.get(current);
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String homepage=sc.next();
        Task4DesignBrowserHistory browser=new Task4DesignBrowserHistory(homepage);
        int n=sc.nextInt();
        for(int i=0;i<n;i++){
            String operation=sc.next();
            if(operation.equals("visit")){
                browser.visit(sc.next());
            }else if(operation.equals("back")){
                System.out.println(browser.back(sc.nextInt()));
            }else if(operation.equals("forward")){
                System.out.println(browser.forward(sc.nextInt()));
            }
        }
        sc.close();
    }
}