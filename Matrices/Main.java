package Matrices;

public class Main {
    public static void main(String[] args) {
        int[][] matrix = {{7, 5, 4},
                          {2, 3, 6},
                          {8, 9, 0}};

        Matrix matrixImpl = new MatrixImpl(matrix);
        Matrix transparentMatrix = new TransparentMatrix(matrixImpl);
        Matrix sumOfTwoMatrices = new SumOfTwoMatrices(matrixImpl, transparentMatrix);

        // Matrices printing
        System.out.println("Transposed matrix:");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(transparentMatrix.getElement(i, j) + " ");
            }
            System.out.println(" ");
        }
        System.out.println("=======================");
        System.out.println("Sum of Transposed matrix and matrix:");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(sumOfTwoMatrices.getElement(i, j) + " ");
            }
            System.out.println(" ");
        }
    }
}
