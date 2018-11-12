package pl.edu.agh.cs.to2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application{

    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception{
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("My first JavaFX app");

        initRootLayout();
    }

    public static void main(String[] args){
        launch(args);
    }



    private void initRootLayout() {
        try {
            // load layout from FXML file
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/lol.fxml"));
            VBox rootLayout =  loader.load();

            // add layout to a scene and show them all
            Scene scene = new Scene(rootLayout,600,480);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // don't do this in common apps
            e.printStackTrace();
        }
    }
}
