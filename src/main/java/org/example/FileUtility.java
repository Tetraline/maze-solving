package org.example;

import com.google.gson.Gson;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileUtility {
public static Maze readMaze(String path) throws IOException {
    String json = new String(Files.readAllBytes(Paths.get("maze.json")));
    int[][] image = new Gson().fromJson(json, int[][].class);
    return new Maze(image);
}
}
