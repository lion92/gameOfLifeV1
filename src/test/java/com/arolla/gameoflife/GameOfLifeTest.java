package com.arolla.gameoflife;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GameOfLifeTest {

    @Test
    public void testSingleCellDiesDueToUnderpopulation() {
        // Step 1: Create an instance of the game with a 3x3 grid
        GameOfLife game = new GameOfLife(3, 3);

        // Step 2: Activate a living cell at the center of the grid
        game.setCellState(1, 1, true);

        // Step 3: Verify that the cell is alive before advancing
        assertTrue(game.getCellState(1, 1), "The cell should initially be alive");

        // Step 4: Advance to the next generation
        game.nextGeneration();

        // Step 5: Verify that the cell has died due to underpopulation
        assertFalse(game.getCellState(1, 1), "The cell should have died due to underpopulation");
    }
}
