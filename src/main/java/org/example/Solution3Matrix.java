package org.example;

//    O(N)
public class Solution3Matrix {
    public static int run(final int startPosition, final int numberOfMoves) {
        if(numberOfMoves < 1)
            return 0;
        Matrix matrix = MapOfMoves.matrixOfPoints();
        Matrix startVector = new Matrix(MapOfMoves.size(),1);
        for(int i = 0; i < MapOfMoves.size(); i++)
            startVector.set(i,0,1);

        for(int m = 0; m < numberOfMoves; m++) {
            startVector = matrix.multiply(startVector);
        }
        return startVector.get(startPosition,0);
    }
}
