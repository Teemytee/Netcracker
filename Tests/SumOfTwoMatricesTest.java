package Tests;

import Matrices.Matrix;
import Matrices.MatrixImpl;
import Matrices.SumOfTwoMatrices;
import org.junit.Assert;
import org.junit.Test;

public class SumOfTwoMatricesTest {
    @Test
    public void sumOfTwoMatricesTest(){
        int[][] matrix_one = {{7, 5}, {2, 3}};
        int[][] matrix_two = {{4, 2}, {7, 9}};
        Matrix matrixImpl_one = new MatrixImpl(matrix_one);
        Matrix matrixImpl_two = new MatrixImpl(matrix_two);
        Matrix sumOfTwoMatrices = new SumOfTwoMatrices(matrixImpl_one, matrixImpl_two);
        Assert.assertEquals(11, sumOfTwoMatrices.getElement(0, 0));
    }
}
