package Matrices;

public class TransparentMatrix implements Matrix{
    private Matrix matrix;

    public TransparentMatrix(Matrix matrix){
        this.matrix = matrix;
    }

    @Override
    public int getElement(int i, int j) throws ArrayIndexOutOfBoundsException {
        return this.matrix.getElement(j, i);
    }
}
