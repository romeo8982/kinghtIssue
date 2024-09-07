package org.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    private static Map<Integer, List<Integer>> moveMap = new HashMap<>();

    static {
        moveMap.put(0, List.of(4, 6));
        moveMap.put(1, List.of(8, 6));
        moveMap.put(2, List.of(7, 9));
        moveMap.put(3, List.of(4, 8));
        moveMap.put(4, List.of(3, 9, 0));
        moveMap.put(5, List.of());  // No moves from 5
        moveMap.put(6, List.of(2, 7, 0));
        moveMap.put(7, List.of(2, 6));
        moveMap.put(8, List.of(1, 3));
        moveMap.put(9, List.of(2, 4));
    }

    public static int numberOfPossibleMovements(int position, int numberOfMoves) {
        if (numberOfMoves == 0) {
            return 1;
        }

        int totalMoves = 0;
        for (int nextPosition : moveMap.get(position)) {
            totalMoves += numberOfPossibleMovements(nextPosition, numberOfMoves - 1);
        }

        return totalMoves;
    }

    public static void main(String[] args) {
        System.out.println("F(0,1) = " + numberOfPossibleMovements(0, 1)); // Expected: 2
        System.out.println("F(1,1) = " + numberOfPossibleMovements(1, 1)); // Expected: 2
        System.out.println("F(2,1) = " + numberOfPossibleMovements(2, 1)); // Expected: 2
        System.out.println("F(3,1) = " + numberOfPossibleMovements(3, 1)); // Expected: 2
        System.out.println("F(4,1) = " + numberOfPossibleMovements(4, 1)); // Expected: 3
        System.out.println("F(5,1) = " + numberOfPossibleMovements(5, 1)); // Expected: 0
        System.out.println("F(6,1) = " + numberOfPossibleMovements(6, 1)); // Expected: 3
        System.out.println("F(7,1) = " + numberOfPossibleMovements(7, 1)); // Expected: 2
        System.out.println("F(8,1) = " + numberOfPossibleMovements(8, 1)); // Expected: 2
        System.out.println("F(9,1) = " + numberOfPossibleMovements(9, 1)); // Expected: 2
        System.out.println("F(4,2) = " + numberOfPossibleMovements(4, 2)); // Expected: 6
        System.out.println("F(4,3) = " + numberOfPossibleMovements(4, 3)); // Expected: 16
    }
}
