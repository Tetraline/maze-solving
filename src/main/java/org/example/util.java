package org.example;

public class util {
    /**
     * Returns whether the given indices are within the bounds of the given array.
     *
     * @param array the array to check
     * @param x the x index to check
     * @param y the y index to check
     * @return true if the indices are within the bounds of the array, false otherwise
     */
    public static boolean isWithinBounds(int[][] array, int y, int x) {
        return x >= 0 && x < array[0].length && y >= 0 && y < array.length;
    }
}
