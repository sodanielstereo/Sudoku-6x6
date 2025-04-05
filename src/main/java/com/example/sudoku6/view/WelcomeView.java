package com.example.sudoku6.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class WelcomeView extends Stage {


    public WelcomeView() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/sudoku6/welcome-view.fxml"));
        Parent root = loader.load();
        this.setTitle("Thank you for playing Sudoku 6");
        Scene scene = new Scene(root);
        this.setScene(scene);
        this.setResizable(false);
        this.show();
    }

    private static class WelcomeSudokuView {
        private static WelcomeView instance;
    }

    public static WelcomeView getInstance() throws IOException {

        if (WelcomeSudokuView.instance == null) {
            return WelcomeSudokuView.instance = new WelcomeView();
        }else{
            return WelcomeSudokuView.instance;
        }
    }
}
