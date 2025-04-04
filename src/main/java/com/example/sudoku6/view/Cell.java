package com.example.sudoku6.view;

import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Cell extends StackPane {
    private final int row;
    private final int col;
    private Label numberLabel;
    private Rectangle background;
    private boolean editable = true;

    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
        initializeCell();
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    private void initializeCell() {
        background = new Rectangle(40, 40);
        background.setFill(Color.WHITE);
        background.setStroke(Color.BLACK);

        numberLabel = new Label();
        numberLabel.setStyle("-fx-font-size: 18; -fx-font-weight: bold;");

        this.getChildren().addAll(background, numberLabel);
        this.setOnMouseClicked(this::handleMouseClick);
        this.setFocusTraversable(true);
    }

    public void setNumber(int number) {
        if (number == 0) {
            numberLabel.setText("");
        } else {
            numberLabel.setText(String.valueOf(number));
        }
    }

    public void clear() {
        if (editable) {
            numberLabel.setText("");
        }
    }

    public boolean isEmpty() {
        return numberLabel.getText().isEmpty();
    }

    public void highlightError() {
        background.setStroke(Color.RED);
        background.setStrokeWidth(2);
    }

    public void clearHighlight() {
        background.setStroke(Color.BLACK);
        background.setStrokeWidth(1);
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
        if (!editable && !isEmpty()) {
            numberLabel.setTextFill(Color.BLUE);
        } else {
            numberLabel.setTextFill(Color.BLACK);
        }
    }

    private void handleMouseClick(MouseEvent event) {
        if (editable) {
            this.requestFocus();
        }
    }
}