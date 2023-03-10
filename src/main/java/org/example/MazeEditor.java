package org.example;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import javax.swing.*;

/**
 * A graphical user interface for creating and editing mazes.
 * The user can toggle the values of the cells in the maze by clicking on them.
 * The user can also solve the maze by clicking the "Solve" button.
 */
public class MazeEditor extends JPanel {
    private static final int CELL_SIZE = 20;
    private static final int PADDING = 10;
    private final int[][] maze;

    public MazeEditor(int[][] maze) {
        this.maze = maze;
        setPreferredSize(new Dimension(maze[0].length * CELL_SIZE + PADDING * 2, maze.length * CELL_SIZE + PADDING * 2));

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int x = (e.getX() - PADDING) / CELL_SIZE;
                int y = (e.getY() - PADDING) / CELL_SIZE;
                if (x >= 0 && x < maze[0].length && y >= 0 && y < maze.length) {
                    maze[y][x] = (maze[y][x] + 1) % 2;
                    repaint();
                }
            }
        });
    }

    @Override
    public void paintComponent(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());

        g.setColor(Color.BLACK);
        for (int y = 0; y < maze.length; y++) {
            for (int x = 0; x < maze[y].length; x++) {
                if (maze[y][x] == 1) {
                    g.fillRect(PADDING + x * CELL_SIZE, PADDING + y * CELL_SIZE, CELL_SIZE, CELL_SIZE);
                }
            }
        }
    }

    private static void createAndShowGui(int[][] maze) {
        JFrame frame = new JFrame("Maze Editor");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.getContentPane().add(new MazeEditor(maze));
        JLabel instructionsLabel = new JLabel("Click on cells to toggle between 0 and 1");
        frame.getContentPane().add(instructionsLabel, BorderLayout.NORTH);
        JButton saveButton = new JButton("Solve");
        saveButton.addActionListener(e -> {
            int[][] mazeArray = Arrays.stream(maze).map(int[]::clone).toArray($ -> maze.clone());
            Maze m = new Maze(mazeArray);
            Maze flooded = Flood.flood(m);
            try {
                Maze route = Navigator.calculateRoute(flooded);
                MazeVisualizer.showMaze(route);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }

        });
        frame.getContentPane().add(saveButton, BorderLayout.SOUTH);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void run(int[][] maze) {
        SwingUtilities.invokeLater(() -> createAndShowGui(maze));
    }
}
