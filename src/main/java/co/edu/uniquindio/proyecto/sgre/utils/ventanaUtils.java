package co.edu.uniquindio.proyecto.sgre.utils;

import co.edu.uniquindio.proyecto.sgre.model.Empleado;
import co.edu.uniquindio.proyecto.sgre.model.Ventana;

public class ventanaUtils {

    public static Ventana inicializarDatos() {
        Ventana Ventana = new Ventana();
        Empleado empleado = new Empleado();
        empleado.setNombre("juan");
        empleado.setCedula("125454");
        empleado.setCorreo("aasfa@gmail.om");
        System.out.println("Información del banco creada");
        Ventana.getListaEmpleados().add(empleado);

        return Ventana;
  }
}
