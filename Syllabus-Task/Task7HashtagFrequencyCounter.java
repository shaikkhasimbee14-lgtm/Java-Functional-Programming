/**/import java.util.HashMap;
import java.util.Scanner;
public class Task7HashtagFrequencyCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter number of subjects");
        int n = sc.nextInt();
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String hashtag = sc.next();
            if (map.containsKey(hashtag)) {
                map.put(hashtag, map.get(hashtag) + 1);
            } else {
                map.put(hashtag, 1);
            }
        }
        for (String hashtag : map.keySet()) {
            System.out.println(hashtag + " " + map.get(hashtag));
        }
        sc.close();
    }
}