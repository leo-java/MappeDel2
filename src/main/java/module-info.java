module MappeDel2 {
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.controls;
    requires java.logging;
    opens mappe.del2.patient to javafx.fxml, javafx.graphics;
    opens mappe.del2.patient.model to javafx.base;
    exports mappe.del2.patient;
}