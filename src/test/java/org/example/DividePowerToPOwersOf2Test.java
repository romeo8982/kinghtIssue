package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DividePowerToPOwersOf2Test {
    private static void compare(int value, Integer... expectedElements) {
        Integer[] actual = Solution4MatrixWithFastPower.splitPowerToPowersOf2(value).toArray(Integer[]::new);
        Assertions.assertArrayEquals(actual, expectedElements);
    }

    @Test public void test1() {compare(1, 1);}
    @Test public void test2() {compare(2, 2);}
    @Test public void test3() {compare(3, 1,2);}
    @Test public void test4() {compare(4, 4);}
    @Test public void test5() {compare(5, 1,4);}
    @Test public void test6() {compare(6, 2,4);}
    @Test public void test7() {compare(7, 1,2,4);}
    @Test public void test8() {compare(8, 8);}
    @Test public void test9() {compare(9, 1,8);}
    @Test public void test10() {compare(10, 2,8);}
    @Test public void test11() {compare(11, 1,2,8);}
}
