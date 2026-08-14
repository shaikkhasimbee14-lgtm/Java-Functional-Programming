/*Hashtag Frequency Counter
Problem Description
Count frequency of hashtags appearing in social media posts using maps/dictionaries.
Input Format
First line contains integer N.
Next N lines contain hashtags.
Output Format
Display hashtag frequencies.
Sample Input
5
java
python
java
ai
python
Sample Output
java 2
python 2
ai 1*/

import java.util.HashMap;
import java.util.Scanner;
public class HashtagFrequencyCounter {
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