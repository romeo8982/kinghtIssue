package org.example;

import java.util.stream.IntStream;

//    O(N)
public class Solution2DynamicPrograming {
    public static int run(final int startPosition, final int numberOfMoves) {
        if(numberOfMoves==0)
            return 0;
        int[][] mapOfResults = new int[MapOfMoves.size()][numberOfMoves];
        for(int i = 0; i < MapOfMoves.size(); i++)
            mapOfResults[i][0] = MapOfMoves.get(i).size();

        for(final Integer m : IntStream.range(1, numberOfMoves).toArray()) {
            for(int i = 0; i < MapOfMoves.size(); i++)
                mapOfResults[i][m] = MapOfMoves.get(i).stream()
                        .mapToInt(position -> mapOfResults[position][m - 1])
                        .sum();
            }
        return mapOfResults[startPosition][numberOfMoves-1];
    }
}
