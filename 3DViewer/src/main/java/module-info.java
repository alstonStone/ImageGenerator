module com.example._3dviewer {
    requires javafx.controls;
    requires javafx.fxml;
    requires jimObjModelImporterJFX;


    opens com.example._3dviewer to javafx.fxml;
    exports com.example._3dviewer;
}