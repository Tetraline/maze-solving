package org.example;

import java.util.Arrays;

public class Navigator {

    public static Maze calculateRoute(Maze m) throws Exception {

        int[][] flooded = m.getImage();
        int MAZE_WIDTH = flooded.length;
        int MAZE_HEIGHT = flooded[0].length;

        int endX = 0;
        for (int x = 0; x < MAZE_WIDTH; x++) {
            if (flooded[MAZE_HEIGHT - 1][x] != 1) {
                endX = x;
            }
        }

        int currentY = MAZE_HEIGHT - 1;
        int currentX = endX;
        // While we are not at the end of the maze..
        while (currentY > 0) {
            // Options will be north, east, south, west
            int[] options = new int[4];
            options[0] = getOptions(flooded, currentX, currentY - 1);
            options[1] = getOptions(flooded, currentX + 1, currentY);
            options[2] = getOptions(flooded, currentX, currentY + 1);
            options[3] = getOptions(flooded, currentX - 1, currentY);
            int directionToMove = lowestIndex(options);
            switch (directionToMove) {
                case 0:
                    currentY = currentY - 1;
                    break;
                case 1:
                    currentX = currentX + 1;
                    break;
                case 2:
                    currentY = currentY + 1;
                    break;
                case 3:
                    currentX = currentX - 1;
                    break;
                default:
                    throw new Exception("Unknown switch case");
            }
            flooded[currentY][currentX] += 2000;
        }
        m.setImage(flooded);
        return m;
    }

    private static int lowestIndex(int[] array) {
        int lowestIndex = 0;
        int lowestValue = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < lowestValue) {
                lowestValue = array[i];
                lowestIndex = i;
            }
        }
        return lowestIndex;
    }

    private static int getOptions(int[][] array, int x, int y) {
        try {
            int value = array[y][x];
            if (value != 1) {
                return value;
            } else {
                // Wall Case
                return 444;
            }
        } catch (Exception e) {
            // Array out of bounds
            return 555;
        }
    }

}
