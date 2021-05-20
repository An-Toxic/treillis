package com.mycompany.projet_treillis;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
       stage.setTitle("Treillis");
       Scene scene = new Scene(new Interface_graphique());
       
       stage.sizeToScene();
        stage.setScene(scene);
        stage.show();
    }
    

    public static void main(String[] args) {
        launch();
    }

}