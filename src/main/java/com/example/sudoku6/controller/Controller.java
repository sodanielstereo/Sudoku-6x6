package com.example.sudoku6.controller;

import com.example.sudoku6.model.Model;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;

import java.util.Optional;

public class Controller {
    @FXML private GridPane sudokuGrid;

    private Model model;
    private Cell[][] cells;

    @FXML
    public void initialize() {
        model = new Model();
        cells = new Cell[model.getSize()][model.getSize()];
        initializeBoard();
        startNewGame();
    }

    private void initializeBoard() {
        for (int row = 0; row < model.getSize(); row++) {
            for (int col = 0; col < model.getSize(); col++) {
                Cell cell = new Cell(row, col);
                cells[row][col] = cell;
                sudokuGrid.add(cell, col, row);

                cell.setOnKeyPressed(this::handleCellKeyPress);
            }
        }
    }

    private void handleCellKeyPress(KeyEvent event) {
        Cell cell = (Cell) event.getSource();

        switch (event.getCode()) {
            case DIGIT1: case DIGIT2: case DIGIT3:
            case DIGIT4: case DIGIT5: case DIGIT6:
                int num = Integer.parseInt(event.getText());
                if (model.isValidPlacement(cell.getRow(), cell.getCol(), num)) {
                    cell.setNumber(num);
                    model.setValueAt(cell.getRow(), cell.getCol(), num);
                    cell.clearHighlight();
                } else {
                    cell.highlightError();
                }
                break;
            case BACK_SPACE: case DELETE:
                cell.clear();
                model.clearCell(cell.getRow(), cell.getCol());
                cell.clearHighlight();
                break;
        }
    }

    @FXML
    private void startNewGame() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Nuevo Juego");
        alert.setHeaderText("¿Deseas comenzar un nuevo juego?");
        alert.setContentText("Se perderá el progreso actual.");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            model.generateNewBoard();
            updateViewFromModel();
        }
    }

    private void updateViewFromModel() {
        for (int row = 0; row < model.getSize(); row++) {
            for (int col = 0; col < model.getSize(); col++) {
                cells[row][col].setNumber(model.getValueAt(row, col));
                cells[row][col].setEditable(model.isCellEmpty(row, col));
            }
        }
    }
}