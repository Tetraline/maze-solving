package org.example;

public class Maze {
    private int[][] image;

    public Maze(int[][] image) {
        this.image = image;
    }

    public int[][] getImage() {
        return image;
    }

    public void setImage(int[][] image) {
        this.image = image;
    }
}
