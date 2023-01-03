package org.example;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws Exception {
        Maze m = FileUtility.readMaze("maze.json");
        Maze flooded = Flood.flood(m);
        Maze route = Navigator.calculateRoute(flooded);
        MazeVisualizer.showMaze(route);

    }
}