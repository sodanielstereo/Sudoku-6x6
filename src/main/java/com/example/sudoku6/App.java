package com.example.sudoku6;

import com.example.sudoku6.view.View;
import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {
    @Override
    public void start(Stage primaryStage) {
        try {
            primaryStage.setTitle("Sudoku 6x6");
            new View(primaryStage);
        } catch (Exception e) {
            System.err.println("Application failed to start:");
            e.printStackTrace();
            System.exit(1);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}