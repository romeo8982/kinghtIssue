package org.example;

import java.util.List;
import java.util.stream.IntStream;

public class MapOfMoves {
    // map current position to possibleMove
    private static final List<List<Integer>> map = List.of(
            /* Position 0 */ List.of(4,6),
            /* Position 1 */ List.of(6,8),
            /* Position 2 */ List.of(7,9),
            /* Position 3 */ List.of(4,8),
            /* Position 4 */ List.of(0,3,9),
            /* Position 5 */ List.of(),
            /* Position 6 */ List.of(0,1,7),
            /* Position 7 */ List.of(2,6),
            /* Position 8 */ List.of(1,3),
            /* Position 9 */ List.of(2,4)
    );

    public static List<Integer> get(int position) {
        return map.get(position);
    }

    public static int size() {
        return map.size();
    }

    public static Matrix matrixOfPoints() {
        Matrix m = new Matrix(size(),size());
        for(final Integer x : IntStream.range(0, size()).toArray()) {
            get(x).forEach(y -> m.set(x,y,1));
        }
        return m;
    }
}
