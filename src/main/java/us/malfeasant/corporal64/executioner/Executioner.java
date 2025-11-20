package us.malfeasant.corporal64.executioner;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javafx.beans.property.ObjectProperty;
import us.malfeasant.corporal64.control.Speed;

public class Executioner {
    private final ExecutorService queue = Executors.newSingleThreadExecutor();
    
    public Executioner(ObjectProperty<Speed> speedProperty) {
        speedProperty.subscribe(s -> {
            
        });
    }
}
