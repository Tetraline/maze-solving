package org.example;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MazeVisualizer {
    private static final int CELL_SIZE = 20;
    private static final int MAZE_WIDTH = 10;
    private static final int MAZE_HEIGHT = 10;
    private static final Color WALL_COLOR = Color.BLACK;
    private static final Color BACKGROUND_COLOR = Color.WHITE;

    private static class MazePanel extends JPanel {
        private final Maze maze;

        public MazePanel(Maze maze) {
            this.maze = maze;
            setPreferredSize(new Dimension(MAZE_WIDTH * CELL_SIZE, MAZE_HEIGHT * CELL_SIZE));
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            for (int y = 0; y < MAZE_HEIGHT; y++) {
                for (int x = 0; x < MAZE_WIDTH; x++) {
                    // TODO: Refactor this into a switch
                    if (maze.getImage()[y][x] == 1) {
                        g.setColor(WALL_COLOR);
                    } else {
                        g.setColor(BACKGROUND_COLOR);
                    }
                    if (maze.getImage()[y][x] > 2) {
                        if(maze.getImage()[y][x]>2000){
                            g.setColor(Color.YELLOW);
                            g.fillRect(x * CELL_SIZE, y * CELL_SIZE, CELL_SIZE, CELL_SIZE);
                            g.setColor(Color.GRAY);
                            g.drawString(Integer.toString(maze.getImage()[y][x]-2000), x * CELL_SIZE + CELL_SIZE / 2 - 10, y * CELL_SIZE + CELL_SIZE / 2);
                        }else {
                            g.setColor(Color.GRAY);
                            g.drawString(Integer.toString(maze.getImage()[y][x]), x * CELL_SIZE + CELL_SIZE / 2 - 10, y * CELL_SIZE + CELL_SIZE / 2);
                        }
                    }else {
                        g.fillRect(x * CELL_SIZE, y * CELL_SIZE, CELL_SIZE, CELL_SIZE);
                    }
                }
            }
        }
    }

    public static void showMaze(Maze maze){
        JFrame frame = new JFrame("Maze Visualizer");
        //frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //frame.addWindowListener(new WindowAdapter() {
        //    @Override
        //    public void windowClosed(WindowEvent e) {
        //        System.exit(0);
        //    }
        //});

        // Add the maze panel to the window
        MazePanel panel = new MazePanel(maze);
        frame.add(panel);

        // Display the window
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
