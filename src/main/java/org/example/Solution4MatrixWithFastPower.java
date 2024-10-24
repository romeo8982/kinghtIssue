package org.example;

import java.util.*;

//    O(log N)
public class Solution4MatrixWithFastPower {
    public static int run(final int startPosition, final int numberOfMoves) {
        if(numberOfMoves < 1)
            return 0;
        Matrix startVector = new Matrix(MapOfMoves.size(),1);
        for(int i = 0; i < MapOfMoves.size(); i++)
            startVector.set(i,0,1);

        startVector = calculatePowerOfMoveMatrix(numberOfMoves).multiply(startVector);

        return startVector.get(startPosition,0);
    }

    public static Set<Integer> splitPowerToPowersOf2(int number) {
        Set<Integer> results = new HashSet<>();
        int currentPower = 1;
        while(number > 0){
            if(number%2==1){
               results.add(currentPower);
            }
            currentPower *= 2;
            number /= 2;
        }
        return results;
    }

    private static Map<Integer,Matrix> calculatePowers(Set<Integer> usedPowers) {
        Integer topPower = usedPowers.stream().max(Integer::compareTo).get();
        Map<Integer,Matrix> onlyUsedPowers = new HashMap<>();
        Map<Integer,Matrix> allPowers = new HashMap<>();

        allPowers.put(1, MapOfMoves.matrixOfPoints());
        for(int i = 2; i <= topPower; i *= 2) {
            allPowers.put(i,allPowers.get(i/2).multiply(allPowers.get(i/2)));
        }

        usedPowers.forEach(p -> onlyUsedPowers.put(p, allPowers.get(p)));
        return onlyUsedPowers;
    }

    private static Matrix calculatePowerOfMoveMatrix(int power) {
        Map<Integer,Matrix> powers = calculatePowers(splitPowerToPowersOf2(power));

        Matrix pointsMatrix = Matrix.createIdentityMatrix(MapOfMoves.size());
        for(Matrix p : powers.values())
            pointsMatrix = pointsMatrix.multiply(p);
        return pointsMatrix;
    }
}
