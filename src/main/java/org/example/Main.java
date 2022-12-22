package org.example;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Maze m = FileUtility.readMaze("maze.json");
        Maze flooded = Flood.flood(m);
        MazeVisualizer.showMaze(flooded);

        Navigator.calculateRoute(flooded);


    }
}