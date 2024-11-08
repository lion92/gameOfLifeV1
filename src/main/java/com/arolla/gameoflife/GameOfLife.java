package com.arolla.gameoflife;

public class GameOfLife {
    private boolean[][] grid;
    private int width;
    private int height;

    public GameOfLife(int width, int height) {
        this.width = width;
        this.height = height;
        grid = new boolean[height][width];
    }

    public void setCellState(int x, int y, boolean alive) {
        grid[y][x] = alive;
    }

    public boolean getCellState(int x, int y) {
        return grid[y][x];
    }

    public void nextGeneration() {
        boolean[][] newGrid = new boolean[height][width];

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int liveNeighbors = countLiveNeighbors(x, y);

                if (grid[y][x]) {
                    // Règle 1 et 3 : Mort par sous-population ou surpopulation
                    newGrid[y][x] = liveNeighbors == 2 || liveNeighbors == 3;
                } else {
                    // Règle 4 : Reproduction
                    newGrid[y][x] = liveNeighbors == 3;
                }
            }
        }

        grid = newGrid;
    }

    private int countLiveNeighbors(int x, int y) {
        int count = 0;

        for (int j = -1; j <= 1; j++) {
            for (int i = -1; i <= 1; i++) {
                if (i == 0 && j == 0) continue; // Ignorer la cellule elle-même

                int neighborX = x + i;
                int neighborY = y + j;

                // Vérifier les limites de la grille
                if (neighborX >= 0 && neighborX < width && neighborY >= 0 && neighborY < height) {
                    if (grid[neighborY][neighborX]) {
                        count++;
                    }
                }
            }
        }

        return count;
    }
}

