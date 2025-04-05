package com.example.sudoku6.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class View extends Stage{

    public View() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource
                ("/com/example/sudoku6/sudoku-view.fxml"));
        Parent root = loader.load();
        this.setTitle("Sudoku 6");
        Scene scene = new Scene(root);
        this.setScene(scene);
        this.setResizable(false);
        this.show();
    }
    private static class SudokuView {
        private static View instance;
    }
    public static View getInstance() throws IOException {
        if (SudokuView.instance == null) {
            return SudokuView.instance = new View();
        }else{
            return SudokuView.instance;
        }
    }
}