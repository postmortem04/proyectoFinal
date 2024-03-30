package co.edu.uniquindio.proyecto.sgre.controller;
import co.edu.uniquindio.proyecto.sgre.controller.service.IModelFactoryService;
import co.edu.uniquindio.proyecto.sgre.exceptions.EmpleadoException;
import co.edu.uniquindio.proyecto.sgre.mapping.dto.EmpleadoDto;
import co.edu.uniquindio.proyecto.sgre.mapping.mappers.ventanaMapper;
import co.edu.uniquindio.proyecto.sgre.model.Empleado;
import co.edu.uniquindio.proyecto.sgre.model.Ventana;
import co.edu.uniquindio.proyecto.sgre.utils.ventanaUtils;

import java.util.List;

public class ModelFactoryController implements IModelFactoryService{
    Ventana ventana;
    ventanaMapper mapper= ventanaMapper.INSTANCE;

    private static class SingletonHolder {
        private final static ModelFactoryController eINSTANCE = new ModelFactoryController();
    }

    public static ModelFactoryController getInstance() {
        return SingletonHolder.eINSTANCE;
    }

    public ModelFactoryController() {

        System.out.println("invocación clase singleton");
        cargarDatosBase();
    }

    private void cargarDatosBase() {
     ventana = ventanaUtils.inicializarDatos();
    }

    public Ventana getBanco() {
        return ventana;
    }

    public void setBanco(Ventana Ventana) {
        this.ventana = Ventana;
    }

    @Override
    public List<EmpleadoDto> obtenerEmpleados() {
        return  mapper.getEmpleadosDto(ventana.getListaEmpleados());
    }

    @Override
    public boolean agregarEmpleado(EmpleadoDto empleadoDto) {
        try{
            if(!ventana.verificarEmpleadoExistente(empleadoDto.cedula())) {
                Empleado empleado = mapper.empleadoDtoToEmpleado(empleadoDto);
                getBanco().agregarEmpleado(empleado);
            }
            return true;
        }catch (EmpleadoException e){
            e.getMessage();
            return false;
        }
    }

    @Override
    public boolean eliminarEmpleado(String cedula) {
        boolean flagExiste = false;
        try {
            flagExiste = getBanco().eliminarEmpleado(cedula);
        } catch (EmpleadoException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return flagExiste;
    }

    @Override
    public boolean actualizarEmpleado(String cedulaActual, EmpleadoDto empleadoDto) {
        try {
            Empleado empleado = mapper.empleadoDtoToEmpleado(empleadoDto);
            getBanco().actualizarEmpleado(cedulaActual, empleado);
            return true;
        } catch (EmpleadoException e) {
            e.printStackTrace();
            return false;
        }
    }


}
