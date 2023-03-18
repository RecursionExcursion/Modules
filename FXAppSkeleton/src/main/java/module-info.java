module com.example.applicationstarttemplate {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.applicationstarttemplate to javafx.fxml;
    exports com.example.applicationstarttemplate;
}