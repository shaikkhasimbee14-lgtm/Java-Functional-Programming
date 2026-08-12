/*Maximum Profit Analyzer
Problem Description
Given daily profit/loss values, find the maximum possible profit obtainable from a contiguous sequence of days using Kadane’s Algorithm.
Input Format
First line contains integer N.
Second line contains N integers.
Output Format
Print maximum subarray sum.
Constraints
1 ≤ N ≤ 10^5*/
import java.util.*;
public class MaximumProfit{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int maxProfit = Arrays.stream(arr)
                .skip(1)
                .boxed()
                .reduce(
                    new int[]{arr[0], arr[0]},
                    (state, value) -> {
                        // state[0] = current sum
                        // state[1] = maximum sum
                        state[0] = Math.max(
                            value,
                            state[0] + value
                        );

                        state[1] = Math.max(
                            state[1],
                            state[0]
                        );

                        return state;
                    },

                    (state1, state2) -> state1
                )[1];

        // Print maximum subarray sum
        System.out.println(maxProfit);

        sc.close();
    }
}