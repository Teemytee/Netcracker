package Tests;

import Matrices.Matrix;
import Matrices.MatrixImpl;
import Matrices.TransparentMatrix;
import org.junit.Assert;
import org.junit.Test;

public class TransparentMatrixTest {
    @Test
    public void transparentMatrixTest(){
        int[][] matrix = {{7, 5, 4},
                          {2, 3, 6},
                          {8, 9, 0}};
        Matrix matrixImpl_one = new MatrixImpl(matrix);
        Matrix transparentMatrix = new TransparentMatrix(matrixImpl_one);
        Assert.assertEquals(2, transparentMatrix.getElement(0, 1));

    }
}
