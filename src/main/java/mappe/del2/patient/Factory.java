package mappe.del2.patient;

import javafx.scene.Node;
import javafx.scene.control.Button;

public class Factory {
    public Node create(String nodeType){
        if (nodeType.equalsIgnoreCase("BUTTON")){
            return new Button();
        }
        return null;
    }
}
