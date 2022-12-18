package com.example.navigatoractivity.Entidades;

import java.util.UUID;

public class Producto {
    private String id;
    private String  imagen;
    private String nombre;
    private String descripcion;
    private int precio;

    public Producto(String id,  String nombre, String descripcion, int precio, String imagen) {
        this.id= id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.imagen = imagen;
    }

    public Producto(String nombre, String descripcion, int precio,String imagen) {
        this.id= UUID.randomUUID().toString();;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.imagen=imagen;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

   public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
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

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
}


