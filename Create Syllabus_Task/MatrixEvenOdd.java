import java.util.*;
import java.util.stream.*;
public class MatrixEvenOdd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter rows: ");
        int rows = sc.nextInt();

        System.out.print("Enter columns: ");
        int cols = sc.nextInt();

        int[][] matrix = new int[rows][cols];

        System.out.println("Enter matrix elements:");

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        IntStream elements = Arrays.stream(matrix)
                                   .flatMapToInt(Arrays::stream);
        long even = elements.filter(n -> n % 2 == 0).count();

        long odd = Arrays.stream(matrix)
                         .flatMapToInt(Arrays::stream)
                         .filter(n -> n % 2 != 0)
                         .count();

        System.out.println("Number of even elements: " + even);
        System.out.println("Number of odd elements: " + odd);

        sc.close();
    }
}
