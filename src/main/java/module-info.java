module com.example.sudoku6 {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.example.sudoku6 to javafx.fxml;
    opens com.example.sudoku6.controller to javafx.fxml;
    opens com.example.sudoku6.view to javafx.fxml;

    exports com.example.sudoku6;
    exports com.example.sudoku6.controller;
    exports com.example.sudoku6.view;
}