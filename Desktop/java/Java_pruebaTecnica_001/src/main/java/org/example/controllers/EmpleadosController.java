package org.example.controllers;

import org.example.entities.Empleados;
import org.example.persistance.EmpleadosJPA;

import java.util.List;

public class EmpleadosController {

    // Instancia de la clase de persistencia para interactuar con la base de datos.
    EmpleadosJPA empleadosJPA = new EmpleadosJPA();

    // Elimina a un empleado de la base de datos
    public static void eliminar(Integer eliminarEmpleado) {
        EmpleadosJPA.eliminar(eliminarEmpleado);
    }

    // encuentra a los empleados con el mismo cargo
    public static List<Empleados> encontrarCargo(String cargoEmpleado) {
        return EmpleadosJPA.encontrarCargo(cargoEmpleado);
    }

    // registra en la base de datos a los empleados
    public void registrar(Empleados nuevoEmpleado) {
        empleadosJPA.registrar(nuevoEmpleado);
    }

    // saca una lista de todos los empleados de la base de datos
    public List<Empleados> listarEmpleados() {
        return empleadosJPA.listarEmpleados();
    }

    // busca un empleado por su id
    public Empleados buscarEmpleado(int idEmpleado) {
        return empleadosJPA.buscarEmpleado(idEmpleado);
    }

    // Actualiza los datos de un empleado en la base de datos
    public void actualizarDatos(Empleados actualizarDatosEmpleado) {
        empleadosJPA.actualizarDatos(actualizarDatosEmpleado);
    }
}
