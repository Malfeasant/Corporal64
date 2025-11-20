package us.malfeasant.corporal64.ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        var exitItem = new MenuItem("Exit");
        var fileMenu = new Menu("File", null, exitItem);
        var inspectMenu = new Menu("Inspect");
        var menuBar = new MenuBar(fileMenu, new SpeedControl().controlMenu, inspectMenu);
        
        var pane = new BorderPane();
        pane.setTop(menuBar);

        stage.setTitle("Corporal64");
        stage.setScene(new Scene(pane));
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}