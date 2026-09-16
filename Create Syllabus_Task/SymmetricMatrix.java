import java.util.Scanner;
import java.util.stream.IntStream;

public class SymmetricMatrix{

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of matrix: ");
        int n = sc.nextInt();

        int[][] matrix = new int[n][n];

        System.out.println("Enter matrix elements:");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        boolean symmetric = IntStream.range(0, n)
                .allMatch(i ->
                    IntStream.range(0, n)
                            .allMatch(j -> matrix[i][j] == matrix[j][i])
                );

        if (symmetric) {
            System.out.println("The matrix is symmetric.");
        } else {
            System.out.println("The matrix is not symmetric.");
        }

        sc.close();
    }
}