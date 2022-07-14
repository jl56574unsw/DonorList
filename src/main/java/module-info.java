module com.mycompany.donorlist {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.donorlist to javafx.fxml;
    exports com.mycompany.donorlist;
}
