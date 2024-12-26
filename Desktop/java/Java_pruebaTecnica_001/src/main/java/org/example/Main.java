package org.example;


import org.example.controllers.EmpleadosController;
import org.example.entities.Empleados;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        EmpleadosController empleadosController = new EmpleadosController();

        Empleados emepleado1 = new Empleados(null, "Juan", "Garcia" , "Ingeniero" ,  3500.00, LocalDate.of(2020, 3,1));
        Empleados emepleado2 = new Empleados(null, "David", "Lopez" , "jardinero" ,  2500.00, LocalDate.of(2020, 3,1));
        Empleados emepleado3 = new Empleados(null, "Marta", "Garcia" , "abogada" ,  5500.00, LocalDate.of(2020, 3,1));
        Empleados emepleado4 = new Empleados(null, "Carlos", "Perez" , "Ingeniero" ,  3500.00, LocalDate.of(2020, 3,1));
        Empleados emepleado5 = new Empleados(null, "Jessica", "Sanchez" , "farmaceutica" ,  3800.00, LocalDate.of(2020, 3,1));
        Empleados emepleado6 = new Empleados(null, "Pedro", "Lopez" , "futbolista" ,  44500.00, LocalDate.of(2020, 3,1));
        Empleados emepleado7 = new Empleados(null, "Javier", "Sanchez" , "Ingeniero" ,  3500.00, LocalDate.of(2020, 3,1));
        Empleados emepleado8 = new Empleados(null, "Luna", "Hierro" , "periodista" ,  2500.00, LocalDate.of(2020, 3,1));
        Empleados emepleado9 = new Empleados(null, "Jaime", "Alvarez" , "enfermero" ,  3000.00, LocalDate.of(2020, 3,1));
        Empleados emepleado10 = new Empleados(null, "Sergio", "Mendez" , "medico" ,  10000.00, LocalDate.of(2020, 3,1));


//        // Registrar un empleado
//       empleadosController.registrar(emepleado10);
//
//        //Listar empleados
//        List<Empleados> todosLosEmpleados = empleadosController.listarEmpleados();
//
//       for ( Empleados e : todosLosEmpleados){
//            System.out.println(e);
//        }

        //actualizar datos del empleado, primero vamos a buscarlo por el id y actualizamos los datos
        int idEmpleado = 402;
        Empleados actualizarDatosEmpleado = empleadosController.buscarEmpleado(idEmpleado);
//        actualizarDatosEmpleado.setCargo("Policia");
        actualizarDatosEmpleado.setSalario(3000.00);
        empleadosController.actualizarDatos(actualizarDatosEmpleado);


//        //vamos a borrar un empleado de la base de datos
//        Integer eliminarEmpleado = 655;
//        EmpleadosController.eliminar(eliminarEmpleado);
//
//
//        // encontramos a los usuarios que tengan el mismo cargo y lo sacamos por pantalla
//        String cargoEmpleado = "Ingeniero";
//        List<Empleados> cargoEmple = EmpleadosController.encontrarCargo(cargoEmpleado);
//
//        for (Empleados e : cargoEmple){
//            System.out.println(e);
//        }
    }
}