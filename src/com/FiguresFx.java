package com;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FiguresFx extends Application{
    @Override
    public void start(Stage window) throws Exception {
        window.setTitle("FiguresFx");
        Parent root = FXMLLoader.load(getClass().getResource("/View/MainScreenView.fxml"));
        window.setScene(new Scene(root, 1024, 600));
        window.setResizable(false);
        window.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
