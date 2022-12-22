package org.example;

public class Flood {


    public static int[][] assignDistance(int x, int y, int[][] maze) {
        int distance = maze[x][y];
        try {
            if (maze[x][y + 1] == 0) {
                maze[x][y + 1] = distance + 1;
                maze = assignDistance(x, y + 1, maze);
            }
        } catch (Exception e) {
        }
        try {
            if (maze[x + 1][y] == 0) {
                maze[x + 1][y] = distance + 1;
                maze = assignDistance(x + 1, y, maze);
            }
        } catch (Exception e) {
        }
        try {
            if (maze[x - 1][y] == 0) {
                maze[x - 1][y] = distance + 1;
                maze = assignDistance(x - 1, y, maze);
            }
        } catch (Exception e) {

        }
        try {
            if (maze[x][y - 1] == 0) {
                maze[x][y - 1] = distance + 1;
                maze = assignDistance(x, y - 1, maze);
            }
        } catch (Exception e) {
        }
        return maze;
    }


    public static Maze flood(Maze m) {
        int[][] flooded = m.getImage();
        int MAZE_WIDTH = flooded.length;
        int MAZE_HEIGHT = flooded[0].length;

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
