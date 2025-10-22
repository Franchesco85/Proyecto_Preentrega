package com.techlab.servicio;

import com.techlab.Utilidad;
import com.techlab.excepciones.IdNoEncontradaException;
import com.techlab.productos.Producto;
import java.util.List;
import java.util.Scanner;

public class ProductoService {

  // Agregar producto
  public void agregarProducto(Scanner teclado, List<Producto> productos) {
    Utilidad.dejarEspacios(50);
    System.out.println("========== AGREGAR NUEVO PRODUCTO ==========\n");

    System.out.println("Datos del nuevo producto");
    System.out.print("Nombre: ");
    String nombre = teclado.nextLine().trim();

    double precio = Utilidad.numeroDoublePositivo(teclado, "Precio: ");
    int stock = Utilidad.numeroIntPositivo(teclado, "Stock: ");

    Producto producto = new Producto(nombre, precio, stock);
    productos.add(producto);

    System.out.println("Producto agregado con éxito:");
    System.out.println(producto);
  }

  // Listar productos
  public void listarProductos(List<Producto> productos) {
    Utilidad.dejarEspacios(50);
    System.out.println("========== LISTA DE PRODUCTOS ==========\n");

    if (productos == null || productos.isEmpty()) {
      System.out.println("No hay productos para mostrar.");
      return;
    }

    for (Producto p : productos) {
      System.out.println(p);
    }
  }

  // Buscar producto (por ID)
  public void buscarProductoPorId(Scanner teclado, List<Producto> productos) {
    Utilidad.dejarEspacios(50);
    System.out.println("========== BUSCAR PRODUCTO POR ID ==========\n");

    int posicion = posicionId(teclado, productos);

    if (posicion == -2) {
      System.out.println("La lista de productos se encuentra vacía");
    } else if (posicion == -1) {
      System.out.println("No existe un producto con la ID solicitada");
    } else {
      System.out.println(productos.get(posicion));
    }
  }

  // Actualizar producto
  public void actualizarProducto(Scanner teclado, List<Producto> productos) {
    Utilidad.dejarEspacios(50);
    System.out.println("========== ACTUALIZAR PRODUCTO POR ID ==========\n");

    int posicion = posicionId(teclado, productos);

    if (posicion == -2) {
      System.out.println("La lista de productos se encuentra vacía");
      return;
    } else if (posicion == -1) {
      System.out.println("No existe un producto con la ID solicitada");
      return;
    }

    Producto p = productos.get(posicion);
    System.out.println("Está por actualizar el producto:");
    System.out.println(p);

    // Si posicionId() usa nextInt() internamente y deja '\n' en buffer,
    // descomentar la siguiente línea:
    // teclado.nextLine();

    System.out.println("\nIngrese los nuevos valores (Enter para mantener el actual):");

    // NOMBRE
    System.out.print("Nombre actual [" + p.getNombre() + "]: ");
    String nuevoNombre = teclado.nextLine().trim();
    if (!nuevoNombre.isEmpty()) {
      p.setNombre(nuevoNombre);
    }

    // PRECIO
    System.out.print("Precio actual [" + p.getPrecio() + "]: ");
    String lineaPrecio = teclado.nextLine().trim();
    if (!lineaPrecio.isEmpty()) {
      try {
        double nuevoPrecio = Double.parseDouble(lineaPrecio);
        if (nuevoPrecio > 0) {
          p.setPrecio(nuevoPrecio);
        } else {
          System.out.println("Precio inválido. Se mantiene el valor anterior.");
        }
      } catch (NumberFormatException e) {
        System.out.println("Formato de precio inválido. Se mantiene el valor anterior.");
      }
    }

    // STOCK
    System.out.print("Stock actual [" + p.getId() + "]: ");
    String lineaStock = teclado.nextLine().trim();
    if (!lineaStock.isEmpty()) {
      try {
        int nuevoStock = Integer.parseInt(lineaStock);
        if (nuevoStock >= 0) {
          p.setPrecio(nuevoStock);
        } else {
          System.out.println("Stock inválido. Se mantiene el valor anterior.");
        }
      } catch (NumberFormatException e) {
        System.out.println("Formato de stock inválido. Se mantiene el valor anterior.");
      }
    }

    System.out.println("\nProducto actualizado con éxito:");
    System.out.println(p);
  }

  /**
   * Método auxiliar: buscar posición por ID
   * Retorna:
   *   -2 -> lista null o vacía
   *   -1 -> no existe producto con la ID solicitada
   *  >=0 -> índice válido en la lista
   */
  private int posicionId(Scanner teclado, List<Producto> productos) {
    if (productos == null || productos.isEmpty()) {
      return -2;
    }

    int id = Utilidad.numeroIntValido(teclado, "Ingrese la ID solicitada: ");

    // Utilidad.posicionProductoId devuelve la posición (o -1 si no existe)
    int pos = Utilidad.posicionProductoId(id, productos);
    if (pos == -1) {
      return -1;
    }
    return pos;
  }
}
