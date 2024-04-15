package co.edu.uniquindio.proyecto.sgre.controller;

import co.edu.uniquindio.proyecto.sgre.controller.service.IEmpleadoControllerService;
import co.edu.uniquindio.proyecto.sgre.mapping.dto.EmpleadoDto;

import java.util.List;

public class EmpleadoController implements IEmpleadoControllerService {
    ModelFactoryController modelFactoryController;
    public EmpleadoController(){
        modelFactoryController = ModelFactoryController.getInstance();
    }

    public List<EmpleadoDto> obtenerEmpleados() {
        return modelFactoryController.obtenerEmpleados();
    }

    @Override
    public boolean agregarEmpleado(EmpleadoDto empleadoDto) {
        return modelFactoryController.agregarEmpleado(empleadoDto);
    }
    @Override
    public boolean eliminarEmpleado(String cedula) {
        return modelFactoryController.eliminarEmpleado(cedula);
    }
    @Override
    public boolean actualizarEmpleado(String cedulaActual, EmpleadoDto empleadoDto) {
        return modelFactoryController.actualizarEmpleado(cedulaActual, empleadoDto);
    }
}
