package us.malfeasant.corporal64.ui;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

/**
 * Both builds a MenuBar and collects the properties and listeners that
 * make it work all in one place
 */
class MenuContainer {
    final MenuBar menuBar;

    MenuContainer() {
        var exitItem = new MenuItem("Exit");
        var fileMenu = new Menu("File", null, exitItem);

        var inspectMenu = new Menu("Inspect");

        menuBar = new MenuBar(fileMenu, new SpeedControl().controlMenu, inspectMenu);
    }
}