package com.example.pruebafinal.modelos;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="mercancia")
public class Mercancia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer iup;
    private String nombre;
    private String descripcion;
    private String zona;
    private LocalDate fechaEntrada;
    private String motivoDevolucion;
    private Double volumen;

    public Mercancia() {
    }

    public Mercancia(Integer iup, String nombre, String descripcion, String zona, LocalDate fechaEntrada, String motivoDevolucion, Double volumen) {
        this.iup = iup;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.zona = zona;
        this.fechaEntrada = fechaEntrada;
        this.motivoDevolucion = motivoDevolucion;
        this.volumen = volumen;
    }

    public Integer getIup() {
        return iup;
    }

    public void setIup(Integer iup) {
        this.iup = iup;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public LocalDate getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(LocalDate fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public String getMotivoDevolucion() {
        return motivoDevolucion;
    }

    public void setMotivoDevolucion(String motivoDevolucion) {
        this.motivoDevolucion = motivoDevolucion;
    }

    public Double getVolumen() {
        return volumen;
    }

    public void setVolumen(Double volumen) {
        this.volumen = volumen;
    }
}

