package mappe.del2.patient;

import javafx.scene.Node;
import javafx.scene.control.Button;

/**
 * The type Factory.
 */
public class Factory {
    /**
     * Create node.
     *
     * @param nodeType the node type
     * @return the node
     * this isn't used due to fxml
     */
    public Node create(String nodeType){
        if (nodeType.equalsIgnoreCase("BUTTON")){
            return new Button();
        }
        return null;
    }
}
