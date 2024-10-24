package org.example;

//    O(3^N)
public class Solution1Recursion {
    public static int run(final int startPosition, final int numberOfMoves) {
        if(numberOfMoves < 1)
            return 0;
        if(numberOfMoves == 1)
            return MapOfMoves.get(startPosition).size();
        return MapOfMoves.get(startPosition).stream()
                .mapToInt(position -> run(position, numberOfMoves - 1))
                .sum();
    }
}
