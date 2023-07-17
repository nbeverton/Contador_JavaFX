module com.nbeverton.contador_javafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.nbeverton.contador_javafx to javafx.fxml;
    exports com.nbeverton.contador_javafx;
}