module co.edu.uniquindio.proyecto.sgre {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.mapstruct;


    opens co.edu.uniquindio.proyecto.sgre to javafx.fxml;
    exports co.edu.uniquindio.proyecto.sgre;

}