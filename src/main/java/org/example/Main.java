package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        printBoard(createBoard());
        System.out.println(possibleMoves(1,2).size());

    }

    private static List<Integer> possibleMoves(int position, int intNumberOfMoves) {
        List<Integer> coordinateList = new ArrayList<>();

        if (intNumberOfMoves == 0) {
            return coordinateList;
        } else {
            switch (position) {
                case 1 -> {
                    coordinateList.add(8);
                    coordinateList.add(6);
                }
                case 2 -> {
                    coordinateList.add(7);
                    coordinateList.add(9);
                }
                case 3 -> {
                    coordinateList.add(4);
                    coordinateList.add(8);
                }
                case 4 -> {
                    coordinateList.add(3);
                    coordinateList.add(9);
                    coordinateList.add(0);
                }
                case 6 -> {
                    coordinateList.add(2);
                    coordinateList.add(7);
                    coordinateList.add(0);
                }
                case 7 -> {
                    coordinateList.add(2);
                    coordinateList.add(6);
                }
                case 8 -> {
                    coordinateList.add(1);
                    coordinateList.add(3);
                }
                case 9 -> {
                    coordinateList.add(2);
                    coordinateList.add(4);
                }
                case 0 -> {
                    coordinateList.add(4);
                    coordinateList.add(6);
                }
                default -> {
                }
            }

            List<Integer> resultList = new ArrayList<>(coordinateList);

            for (Integer number : coordinateList) {
                resultList.addAll(possibleMoves(number, intNumberOfMoves - 1));
            }

            return resultList;
        }
    }



    private static Board createBoard() {
        Tail[] tails = {
                new Tail(1, new Coordinate(0, 3)),
                new Tail(2, new Coordinate(1, 3)),
                new Tail(3, new Coordinate(2, 3)),
                new Tail(4, new Coordinate(0, 2)),
                new Tail(5, new Coordinate(1, 2)),
                new Tail(6, new Coordinate(2, 2)),
                new Tail(7, new Coordinate(0, 1)),
                new Tail(8, new Coordinate(1, 1)),
                new Tail(9, new Coordinate(2, 1)),
                new Tail(0, new Coordinate(1, 0))
        };
        return new Board(tails);
    }

    private static void printBoard(Board board) {
        for (int i = 3; i >= 0; i--) {
            for (int j = 0; j <= 2; j++) {
                if (board.getTail(new Coordinate(j, i)) == null) {
                    System.out.print("X");
                } else {
                    System.out.print(board.getTail(new Coordinate(j, i)).getNumber());
                }
            }
            System.out.println();
        }
    }
}

