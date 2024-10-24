package org.example;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Stream;

public class SolutionTest {
    @AllArgsConstructor
    static class ExpectedWithResult {
        @Getter
        final int startPosition;
        @Getter
        final int numberOfMoves;
        @Getter
        final int result;
    }

    static final List<ExpectedWithResult> expectedResults = List.of(
            new ExpectedWithResult(0, 1, 2),
            new ExpectedWithResult(1, 1, 2),
            new ExpectedWithResult(2, 1, 2),
            new ExpectedWithResult(3, 1, 2),
            new ExpectedWithResult(4, 1, 3),
            new ExpectedWithResult(5, 1, 0),
            new ExpectedWithResult(5, 10, 0),
            new ExpectedWithResult(6, 1, 3),
            new ExpectedWithResult(7, 1, 2),
            new ExpectedWithResult(8, 1, 2),
            new ExpectedWithResult(9, 1, 2),
            new ExpectedWithResult(4, 2, 6),
            new ExpectedWithResult(4, 3, 16),
            new ExpectedWithResult(4, 7, 440),
            new ExpectedWithResult(4, 14, 126336),
            new ExpectedWithResult(4, 25, 1301753856)
    );

    static final List<BiFunction<Integer,Integer,Integer>> approaches = List.of(
            Solution1Recursion::run,
            Solution2DynamicPrograming::run,
            Solution3Matrix::run,
            Solution4MatrixWithFastPower::run
    );

    public static Stream<Arguments> testArguments(){
        return approaches.stream().flatMap(a -> expectedResults.stream().map(r -> Arguments.of(r.getStartPosition(), r.getNumberOfMoves(), r.getResult(), a)));
    }

    @ParameterizedTest
    @MethodSource("testArguments")
    public void test1(int startPosition, int numberOfMoves, int result, BiFunction<Integer,Integer,Integer> approach) {
        Assertions.assertEquals(result, approach.apply(startPosition, numberOfMoves));
    }
}
