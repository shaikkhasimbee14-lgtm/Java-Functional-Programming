/*Smart Traffic Navigation System
Problem Description
A smart city application stores road connectivity information using nested collections. Given city junctions and roads, determine whether a route exists between two junctions using graph representation with collections.
Input Format
•	First line contains integers N and M.
•	Next M lines contain connected junction pairs.
•	Last line contains source and destination.
Output Format
Print YES if route exists, otherwise NO.
Constraints
•	1 ≤ N ≤ 10^5
•	1 ≤ M ≤ 2×10^5
Sample Input
5 4
1 2
2 3
3 4
4 5
1 5
Sample Output
YES
 */
  
import java.util.*;
class Task8SmartTrafficNavigationSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        int source = sc.nextInt();
        int destination = sc.nextInt();
        boolean[] visited = new boolean[N + 1];
        Queue<Integer> queue = new LinkedList<>();

        queue.add(source);
        visited[source] = true;
        boolean found = false;
        while (!queue.isEmpty()) {
            int current = queue.poll();
            if (current == destination) {
                found = true;
                break;
            }
            for (int next : graph.get(current)) {

                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }
        if (found) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
        sc.close();
    }
}
