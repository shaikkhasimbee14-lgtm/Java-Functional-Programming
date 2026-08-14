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