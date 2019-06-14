package com.perisic.luka.androidmodularstarterexample.ui;

import java.util.Arrays;

/**
 * Created by Luka Perisic on 14.6.2019..
 */
public class GasoProblem {

    public static Character[][] Matrix = new Character[3][3];
    private static Character[] fills = new Character[] {'R', 'G', 'B'};

    public static void fillMatrix(Character[][] matrix, int currentRow, int currentCollumn, Direction direction, int currentFill) {
        if(matrix[currentRow][currentCollumn] == null) {
            currentFill = currentFill > 2 ? 0 : currentFill;
            matrix[currentRow][currentCollumn] = fills[currentFill];
            if(!canGoSameDirection(direction, 3, 3, currentRow, currentCollumn)) {
                direction = nextDirection(direction);
            }
            switch (direction) {
                case DOWN:
                    currentRow++;
                    break;
                case RIGHT:
                    currentCollumn++;
                    break;
                case UP:
                    currentRow--;
                    break;
                default://left
                    currentCollumn--;
                    break;
            }
            fillMatrix(matrix, currentRow, currentCollumn, direction, ++currentFill);
        }
    }

    private static boolean canGoSameDirection(Direction direction, int rows, int collumns, int currentRow, int currentCollumn) {
        switch (direction) {
            case DOWN:
                return currentRow + 1 < currentRow;
            case RIGHT:
                return currentCollumn + 1 < currentCollumn;
            case UP:
                return currentRow > 0;
            default://left
                return currentCollumn > 0;
        }
    }

    private static Direction nextDirection(Direction direction) {
        switch (direction) {
            case DOWN:
                return Direction.RIGHT;
            case RIGHT:
                return Direction.UP;
            case UP:
                return Direction.LEFT;
            default://left
                return Direction.DOWN;
        }
    }

    public enum Direction {

        DOWN, RIGHT, UP, LEFT

    }

}
