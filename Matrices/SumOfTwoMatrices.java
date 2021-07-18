package Matrices;

public class SumOfTwoMatrices implements Matrix{
    private Matrix matrix_one;
    private Matrix matrix_two;

    public SumOfTwoMatrices(Matrix matrix_one, Matrix matrix_two){
        this.matrix_one = matrix_one;
        this.matrix_two = matrix_two;
    }

    @Override
    public int getElement(int i, int j) throws ArrayIndexOutOfBoundsException {
        return (matrix_one.getElement(i, j) + matrix_two.getElement(i, j));
    }
}
