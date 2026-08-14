/*Smart Traffic Navigation System
Problem Description
A smart city application stores road connectivity information using nested collections. Given city junctions and roads, determine whether a route exists between two junctions using graph representation with collections.
Input Format
First line contains integers N and M.
Next M lines contain connected junction pairs.
Last line contains source and destination.
Output Format
Print YES if route exists, otherwise NO.
Constraints
1 ≤ N ≤ 10^5
1 ≤ M ≤ 2×10^5
Sample Input
5 4
1 2
2 3
3 4
4 5
1 5
Sample Output
YES*/

import java.util.*;
import java.util.function.Predicate;
public class SmartTrafficNavigation{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        int source = sc.nextInt();
        int destination = sc.nextInt();
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.add(source);
        visited.add(source);
        boolean found = false;
        while (!queue.isEmpty()) {
            int current = queue.poll();
            Predicate<Integer> isDestination =
                    node -> node == destination;
            if (isDestination.test(current)) {
                found = true;
                break;
            }
            graph.get(current).stream()
                    .filter(node -> !visited.contains(node))
                    .forEach(node -> {
                        visited.add(node);
                        queue.add(node);
                    });
        }
        System.out.println(found ? "YES" : "NO");
        sc.close();
    }
}