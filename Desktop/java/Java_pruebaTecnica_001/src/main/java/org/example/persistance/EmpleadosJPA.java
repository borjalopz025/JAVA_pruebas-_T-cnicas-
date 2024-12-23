package org.example.persistance;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.example.entities.Empleados;

import java.util.ArrayList;
import java.util.List;


public class EmpleadosJPA {

    public void registrar(Empleados nuevoEmpleado) {

        // instancia de EntityManager para interactuar con la base de datos.
        EntityManager em = ConfigJPA.getEntityManager();
        try {

            em.getTransaction().begin();
            em.persist(nuevoEmpleado); //Guarda un nuevo empleado en la base de datos
            em.getTransaction().commit();

        } catch (Exception e) {

            System.out.println("Ha habido un error a la hora de registrar un empleado " + e.getMessage());

        } finally {
            em.close();
        }
    }

    public List<Empleados> listarEmpleados() {
        EntityManager em = ConfigJPA.getEntityManager();

        try {
            // consulta para seleccionar todos los empleados de la base de datos
            TypedQuery<Empleados> query = em.createQuery("SELECT p FROM empleados p", Empleados.class);
            return query.getResultList();

        } catch (Exception e) {
            System.out.println("Ha habido un error" + e.getMessage());

            // Retorna una lista vacía si ocurre un error
            return new ArrayList<>();

        } finally {
            em.close();
        }
    }

    public Empleados buscarEmpleado(int idEmpleado) {
        EntityManager em = ConfigJPA.getEntityManager();

        try {
            // Busca el empleado en la base de datos por su id
            return em.find(Empleados.class, idEmpleado);

        }  catch (Exception e) {

            System.out.println("Ha habido un error a la hora de encontrar el empleado " + e.getMessage());

            return new Empleados();

        } finally {
            em.close();
        }
    }

    public void actualizarDatos(Empleados actualizarDatosEmpleado) {

        EntityManager em = ConfigJPA.getEntityManager();

        try {

            em.getTransaction().begin();
            em.merge(actualizarDatosEmpleado); //Actualiza los datos de los empleados en la base de datos
            em.getTransaction().commit();

        } catch (Exception e) {

            System.out.println("Ha habido un error a la hora de actualizar los datos de un empleado " + e.getMessage());

        }  finally {
            em.close();
        }
    }

    public static void eliminar(Integer eliminarEmpleado) {
        EntityManager em = ConfigJPA.getEntityManager();

        try {

            em.getTransaction().begin();
            Empleados empleado = em.find(Empleados.class, eliminarEmpleado);
            if (empleado != null) {
                em.remove(empleado); //Elimina al empleado de la base de datos si existe
            }
            em.getTransaction().commit();

        }  catch (Exception e) {

            System.out.println("Ha habido un error a la hora de eliminar un empleado " + e.getMessage());

        } finally {
            em.close();
        }
    }

    public static List<Empleados> encontrarCargo(String cargoEmpleado) {
        EntityManager em = ConfigJPA.getEntityManager();

        try {
            //consulta para buscar empleados con un cargo específico
            TypedQuery<Empleados> query = em.createQuery("SELECT p FROM empleados p WHERE p.cargo = :cargoEmpleado", Empleados.class);

            //asigna el valor al parametro
            query.setParameter("cargoEmpleado", cargoEmpleado);

            return query.getResultList();

        } catch (Exception e) {

            System.out.println("Ha habido un error con la consulta para buscar un empleado por su cargo " + e.getMessage());
            return new ArrayList<>();

        }  finally {
            em.close();
        }
    }
}
