package com.techlab.productos;

public class Producto {

  //Atributos
  private static int idContador = 1;

  private int id;
  private String nombre;
  private double precio;
  private int stock;

  // Constructores
  public Producto(String nombre, double precio, int stock) {
    this.nombre = nombre;
    this.precio = precio;
    this.stock = stock;

    // id única autoincremental
    id = idContador;
    idContador++;
  }

  // Métodos
  public String toString() {
    /*
    String formato:
    %n -> dejar un espacio
    %s -> string
    %f -> decimal
    &.2f -> decimal solo con 2 números decimales
    %d -> entero
     */

    return String.format("ID: %d | Nombre: %s | Precio: %2.f | Stock: %d",
        id, nombre, precio, stock);
  }

  // Getters y Setters
  public int getId() {
    return id;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public double getPrecio() {
    return precio;
  }

  public void setPrecio(double precio) {
    this.precio = precio;
  }
}