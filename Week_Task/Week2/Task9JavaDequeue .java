import java.util.*;
public class test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        Deque<Integer> deque = new ArrayDeque<Integer>();
        Set<Integer> set = new HashSet<Integer>();
        int max = 0;
        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            deque.addLast(num);
            set.add(num);
            if (deque.size() == m) {
                max = Math.max(max, set.size());

                int removed = deque.removeFirst();

                if (!deque.contains(removed)) {
                    set.remove(removed);
                }
            }
        }
        System.out.println(max);
    }
}