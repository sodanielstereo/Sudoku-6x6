package com.example.sudoku6.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class View {
    public View(Stage primaryStage) {
        try {
            // Try multiple ways to locate the FXML file
            URL fxmlUrl = getClass().getResource("/com/example/sudoku6/view/sudoku-view.fxml");

            if (fxmlUrl == null) {
                // Alternative path for debugging
                fxmlUrl = getClass().getClassLoader().getResource("com/example/sudoku6/view/sudoku-view.fxml");
            }

            if (fxmlUrl == null) {
                throw new IOException("Cannot find FXML file. Tried:\n" +
                        "1. /com/example/sudoku6/view/sudoku-view.fxml\n" +
                        "2. com/example/sudoku6/view/sudoku-view.fxml (via classloader)");
            }

            System.out.println("Loading FXML from: " + fxmlUrl); // Debug output

            FXMLLoader loader = new FXMLLoader(fxmlUrl);
            Parent root = loader.load();

            // Load CSS
            URL cssUrl = getClass().getResource("/com/example/sudoku6/view/styles.css");
            if (cssUrl == null) {
                System.out.println("Warning: CSS file not found");
            }

            Scene scene = new Scene(root);
            if (cssUrl != null) {
                scene.getStylesheets().add(cssUrl.toExternalForm());
            }

            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (IOException e) {
            System.err.println("Fatal error loading FXML:");
            e.printStackTrace();
            System.exit(1);
        }
    }
}