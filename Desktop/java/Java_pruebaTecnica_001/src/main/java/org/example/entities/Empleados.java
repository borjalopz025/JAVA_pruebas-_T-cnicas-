package org.example.entities;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity(name= "empleados")
public class Empleados {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;


    @Column(nullable = false, length = 200)
    private String nombre;

    @Column(nullable = false, length = 200)
    private String apellido;

    @Column(nullable = false, length = 200)
    private String cargo;


    @Column(nullable = false)
    private Double salario;


    @Column(nullable = false)
    private LocalDate fechaDeInicio;


    public Empleados() {}

    public Empleados(Integer id,  String nombre,String apellido, String cargo , Double salario, LocalDate fechaDeInicio) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cargo = cargo;
        this.salario = salario;
        this.fechaDeInicio = fechaDeInicio;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public LocalDate getFechaDeInicio() {
        return fechaDeInicio;
    }

    public void setFechaDeInicio(LocalDate fechaDeInicio) {
        this.fechaDeInicio = fechaDeInicio;
    }



    @Override
    public String toString() {
        return "Empleados{" +
                "apellido='" + apellido + '\'' +
                ", id=" + id +
                ", nombre='" + nombre + '\'' +
                ", cargo='" + cargo + '\'' +
                ", salario=" + salario +
                ", fechaDeInicio=" + fechaDeInicio +
                '}';
    }
}
