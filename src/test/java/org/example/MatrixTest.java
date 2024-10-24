package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MatrixTest {
    private void compare(Matrix m, int[][] data) {
        compare(m, create(data));
    }

    private void compare(Matrix m1, Matrix m2) {
        assertEquals(m1.X(),m2.X());
        assertEquals(m1.Y(),m2.Y());
        for(int x = 0; x < m1.X(); x++)
            for(int y = 0; y < m1.Y(); y++)
                assertEquals(m1.get(x,y),m2.get(x,y));
    }

    private static Matrix create(int[][] data) {
        int sizeY = data[0].length;
        for(int[] l : data) {
            if(l.length != sizeY)
                throw new RuntimeException("Not a correct matrix size");
        }
        Matrix m = new Matrix(data.length,sizeY);
        for(int x = 0; x < data.length; x++)
            for(int y = 0; y < sizeY; y++)
                m.set(x,y,data[x][y]);
        return m;
    }

    @Test
    public void test1() {
        Matrix m1 = create(new int[][]{{1,2,3}});
        Matrix m2 = create(new int[][]{{6},{7},{8}});
        Matrix m3 = m1.multiply(m2);
        compare(m3, new int[][]{{44}});
    }

    @Test
    public void test2() {
        Matrix m1 = create(new int[][]{
                {1},
                {2},
                {3}});
        Matrix m2 = create(new int[][]{{6,7}});
        Matrix m3 = m1.multiply(m2);
        compare(m3, new int[][]{
                {6,7},
                {12,14},
                {18,21}});
    }

    @Test
    public void test3() {
        Matrix m1 = new Matrix(3,2);
        Matrix m2 = new Matrix(2,4);
        Matrix m3 = m1.multiply(m2);
        compare(m3, new Matrix(3,4));
    }
}
