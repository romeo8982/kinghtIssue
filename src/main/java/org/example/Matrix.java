package org.example;

public class Matrix {
    private final int[][] values;

    public Matrix(int x, int y) {
        values = new int[x][y];
    }

    public void set(int x, int y, int value) {
        values[x][y] = value;
    }

    public int get(int x, int y) {
        return values[x][y];
    }

    public int X() {
        return values.length;
    }

    public int Y() {
        return values[0].length;
    }

    public static Matrix createIdentityMatrix(int size) {
        Matrix m = new Matrix(size,size);
        for(int i = 0; i < size; i++)
            m.set(i,i,1);
        return m;
    }

    public Matrix multiply(Matrix m) {
        Matrix newM = new Matrix(X(),m.Y());
        if (m.X() != Y())
            throw new RuntimeException("Cannot multiply matrix with wrong sizes");
        for (int i = 0; i < X(); i++) {
            for (int j = 0; j < m.Y(); j++) {
                int tmp = 0;
                for (int k = 0; k < m.X(); k++)
                    tmp += get(i,k) * m.get(k,j);
                newM.set(i,j,tmp);
            }
        }
        return newM;
    }
}
