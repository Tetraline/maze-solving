package org.example;

public class Flood {

    /**
     * Assigns a distance value to each position in the given maze starting from the given position.
     * The distance value is equal to the number of steps required to reach the given position from the maze entrance.
     *
     * @param y the y coordinate of the starting position
     * @param x the x coordinate of the starting position
     * @param maze the maze to assign distance values to
     * @return the modified maze with distance values assigned
     */
    public static int[][] assignDistance(int y, int x, int[][] maze) {
        int distance = maze[y][x];
        if (isWithinBounds(maze, y, x + 1) && maze[y][x + 1] == 0) {
            maze[y][x + 1] = distance + 1;
            maze = assignDistance(y, x + 1, maze);
        }
        if (isWithinBounds(maze, y + 1, x) && maze[y + 1][x] == 0) {
            maze[y + 1][x] = distance + 1;
            maze = assignDistance(y + 1, x, maze);
        }
        if (isWithinBounds(maze, y - 1, x) && maze[y - 1][x] == 0) {
            maze[y - 1][x] = distance + 1;
            maze = assignDistance(y - 1, x, maze);
        }
        if (isWithinBounds(maze, y, x - 1) && maze[y][x - 1] == 0) {
            maze[y][x - 1] = distance + 1;
            maze = assignDistance(y, x - 1, maze);
        }
        return maze;
    }

    /**
     * Returns whether the given indices are within the bounds of the given array.
     *
     * @param array the array to check
     * @param x the x index to check
     * @param y the y index to check
     * @return true if the indices are within the bounds of the array, false otherwise
     */
    private static boolean isWithinBounds(int[][] array, int y, int x) {
        return x >= 0 && x < array[0].length && y >= 0 && y < array.length;
    }

    /**
     * Floods a given maze by
     * 1. Finding the maze entrance
     * 2. Recursively assigning distances to every point using the assignDistance method
     *
     * @param m the maze to flood
     * @return the flooded maze
     */
    public static Maze flood(Maze m) {
        int[][] flooded = m.getImage();
        int MAZE_WIDTH = flooded.length;

        int startX = 0;
        for (int x = 0; x < MAZE_WIDTH; x++) {
            if (flooded[0][x] == 0) {
                startX = x;
            }
        }
        flooded[0][startX] = 2;
        m.setImage(assignDistance(0, startX, flooded));
        return m;
    }
}
