package com.example.sudoku6.model;
import com.example.sudoku6.model.exceptions.NoSuggestion;
import com.example.sudoku6.view.WelcomeView;
import javafx.scene.control.Cell;

import java.util.*;

public class Model extends WelcomeModel{
    private final int SIZE = 6;
    private final int [][] solvedBoard = new int [SIZE][SIZE];
    private final int [][] boardToShow = new int [SIZE][SIZE];

    public Model() { generateBoard();}

    public int [][] getBoardToShow() {
        removeNumbers(0, 0);
        removeNumbers(0, 2);
        removeNumbers(2, 0);
        removeNumbers(2, 2);
        removeNumbers(4, 0);
        removeNumbers(4, 2);

        return boardToShow;
    }

    public boolean generateBoard() {
       for (int row = 0; row < SIZE; row++) {
           if (solvedBoard[row][row] == 0) {
               List<Integer> numbers = new gerRandomNumbers();
               for (int num : numbers){
                   if (istheNumberValid(num, row, col)){
                       solvedBoard[row][row] = num;
                       if (generateBoard()) {
                           return true;
                       }
                       solvedBoard[row][col] = 0;
                   }
               }
               return false;
           }

       }
       return true;
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