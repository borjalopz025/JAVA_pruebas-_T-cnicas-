package org.example.persistance;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.example.entities.Empleados;

import java.util.List;


public class EmpleadosJPA {

    public void registrar(Empleados nuevoEmpleado) {
        EntityManager em = ConfigJPA.getEntityManager();

        try {

            em.getTransaction().begin();
            em.persist(nuevoEmpleado);
            em.getTransaction().commit();

        } finally {
            em.close();
        }
    }

    public List<Empleados> listarEmpleados() {
        EntityManager em = ConfigJPA.getEntityManager();

        try {
            TypedQuery<Empleados> query = em.createQuery("SELECT p FROM empleados p", Empleados.class);
            return query.getResultList();

        } finally {
            em.close();
        }

    }

    public Empleados buscarEmpleado(int idEmpleado) {
        EntityManager em = ConfigJPA.getEntityManager();

        try {

            return em.find(Empleados.class, idEmpleado);

        } finally {
            em.close();
        }
    }

    public void actualizarDatos(Empleados actualizarDatosEmpleado) {

        EntityManager em = ConfigJPA.getEntityManager();

        try {

            em.getTransaction().begin();
            em.merge(actualizarDatosEmpleado);
            em.getTransaction().commit();

        } finally {
            em.close();
        }
    }

    public static void eliminar(Integer eliminarEmpleado) {
        EntityManager em = ConfigJPA.getEntityManager();

        try {

            em.getTransaction().begin();
            Empleados empleado = em.find(Empleados.class, eliminarEmpleado);
            if (empleado != null) {
                em.remove(empleado);
            }
            em.getTransaction().commit();

        } finally {
            em.close();
        }
    }

    public static List<Empleados> encontrarCargo(String cargoEmpleado) {
        EntityManager em = ConfigJPA.getEntityManager();

        try {

            TypedQuery<Empleados> query = em.createQuery("SELECT p FROM empleados p WHERE p.cargo = :cargoEmpleado", Empleados.class);

            query.setParameter("cargoEmpleado", cargoEmpleado);

            return query.getResultList();

        } finally {
            em.close();
        }
    }
}
