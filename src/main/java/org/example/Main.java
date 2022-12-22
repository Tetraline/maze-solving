package org.example;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws Exception {
        Maze m = FileUtility.readMaze("maze.json");
        Maze flooded = Flood.flood(m);
      //  MazeVisualizer.showMaze(flooded);

       Maze route = Navigator.calculateRoute(flooded);
       MazeVisualizer.showMaze(route);



    }
}