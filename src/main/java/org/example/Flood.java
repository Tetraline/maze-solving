package org.example;

public class Flood {


    public static int[][] assignDistance(int y, int x, int[][] maze) {
        int distance = maze[y][x];
        try {
            if (maze[y][x + 1] == 0) {
                maze[y][x + 1] = distance + 1;
                maze = assignDistance(y, x + 1, maze);
            }
        } catch (Exception ignored) {
        }
        try {
            if (maze[y + 1][x] == 0) {
                maze[y + 1][x] = distance + 1;
                maze = assignDistance(y + 1, x, maze);
            }
        } catch (Exception ignored) {
        }
        try {
            if (maze[y - 1][x] == 0) {
                maze[y - 1][x] = distance + 1;
                maze = assignDistance(y - 1, x, maze);
            }
        } catch (Exception ignored) {

        }
        try {
            if (maze[y][x - 1] == 0) {
                maze[y][x - 1] = distance + 1;
                maze = assignDistance(y, x - 1, maze);
            }
        } catch (Exception ignored) {
        }
        return maze;
    }


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
