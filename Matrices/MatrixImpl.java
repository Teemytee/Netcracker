package Matrices;

public class MatrixImpl implements Matrix {
    private final int[][] matrix;

    public MatrixImpl(int[][] matrix) {
        this.matrix = matrix;
    }

    @Override
    public int getElement(int i, int j) {
        return matrix[i][j];
    }

}
