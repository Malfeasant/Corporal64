package us.malfeasant.corporal64.ui;

import java.util.IdentityHashMap;
import java.util.Map;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.control.Menu;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import us.malfeasant.corporal64.control.Speed;

class SpeedControl {
    private final Map<Speed, Toggle> speedMap;
    final ObjectProperty<Speed> speedProperty;
    final Menu controlMenu;
    
    SpeedControl() {
        speedProperty = new SimpleObjectProperty<Speed>(Speed.PAUSE);
        
        controlMenu = new Menu("Control");
        var group = new ToggleGroup();

        speedMap = new IdentityHashMap<>();
        for (Speed s : Speed.values()) {
            var item = new RadioMenuItem(s.menuText);
            item.setToggleGroup(group);
            speedMap.put(s, item);  // oops, had this backwards
            controlMenu.getItems().add(item);
            // TODO seems like there should be a better way to do this with bindings...
            item.setOnAction(e -> speedProperty.set(s));
        }

        // when something external sets the speed property, set the check to match
        speedProperty.subscribe(s -> {
            group.selectToggle(speedMap.get(s));
        });
    }
}
