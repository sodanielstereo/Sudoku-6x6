package com.example.sudoku6.model;

import java.util.Random;

public class Model {
    private int[][] board;
    private final int SIZE = 6;
    private final int BLOCK_WIDTH = 2;
    private final int BLOCK_HEIGHT = 3;

    public Model() {
        board = new int[SIZE][SIZE];
    }

    public int getSize() {
        return SIZE;
    }

    public int getValueAt(int row, int col) {
        return board[row][col];
    }

    public void setValueAt(int row, int col, int value) {
        board[row][col] = value;
    }

    public void clearCell(int row, int col) {
        board[row][col] = 0;
    }

    public boolean isCellEmpty(int row, int col) {
        return board[row][col] == 0;
    }

    public boolean isValidPlacement(int row, int col, int num) {
        return !isInRow(row, num) && !isInColumn(col, num) && !isInBlock(row, col, num);
    }

    private boolean isInRow(int row, int num) {
        for (int col = 0; col < SIZE; col++) {
            if (board[row][col] == num) {
                return true;
            }
        }
        return false;
    }

    private boolean isInColumn(int col, int num) {
        for (int row = 0; row < SIZE; row++) {
            if (board[row][col] == num) {
                return true;
            }
        }
        return false;
    }

    private boolean isInBlock(int row, int col, int num) {
        int blockStartRow = row - row % BLOCK_HEIGHT;
        int blockStartCol = col - col % BLOCK_WIDTH;

        for (int r = 0; r < BLOCK_HEIGHT; r++) {
            for (int c = 0; c < BLOCK_WIDTH; c++) {
                if (board[blockStartRow + r][blockStartCol + c] == num) {
                    return true;
                }
            }
        }
        return false;
    }

    public void generateNewBoard() {
        resetBoard();
        fillDiagonalBlocks();
    }

    private void resetBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = 0;
            }
        }
    }

    private void fillDiagonalBlocks() {
        Random rand = new Random();
        for (int block = 0; block < 3; block++) {
            fillBlock(block * 2, block * 2);
        }
    }

    private void fillBlock(int row, int col) {
        Random rand = new Random();
        int numsPlaced = 0;
        while (numsPlaced < 2) {
            int num = rand.nextInt(6) + 1;
            int x = row + rand.nextInt(2);
            int y = col + rand.nextInt(3);

            if (board[x][y] == 0 && isValidPlacement(x, y, num)) {
                board[x][y] = num;
                numsPlaced++;
            }
        }
    }
}