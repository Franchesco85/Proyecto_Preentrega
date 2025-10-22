package com.techlab;

import com.sun.source.tree.WhileLoopTree;
import com.techlab.excepciones.NumeroInvalidoException;
import com.techlab.productos.Producto;
import com.techlab.servicio.ProductoService;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainPreentrega {

  public static void main(String[] args) {

    Scanner teclado = new Scanner(System.in);
    int opcion;

    List<Producto> productos = new ArrayList<>();
    ProductoService servicio = new ProductoService();

    do {

      // Mostrar las opciones
      System.out.println("""
          1) Agregar producto.
          2) Listar productos.
          3) Buscar producto.
          4) Actualizar producto.
          5) Eliminar producto.
          6) Crear un pedido.
          7) Listar pedidos.
          8) Salir.
          """);

      // Elegir un número válido
      while (true) {
        opcion = Utilidad.numeroIntValido(teclado, "Elija una opción: ");

        try {
          // Validar la opcion que no sea incorrecta
          if (opcion < 1 || opcion > 8) {
            throw new NumeroInvalidoException("Opción inválida");
          }

          break;
        } catch (NumeroInvalidoException e) {
          System.out.println("Opción Inválida");
        }
      }

      switch (opcion) {
        case 1: // Agregar producto
          servicio.agregarProducto(teclado, productos);
          Utilidad.presioneEnterparaContinuar(teclado);
          Utilidad.dejarEspacios(50);
          break;
        case 2: // Listar Productos
          servicio.listarProductos(productos);
          Utilidad.presioneEnterparaContinuar(teclado);
          Utilidad.dejarEspacios(50);
          break;
        case 3: // Buscar producto
          servicio.buscarProductoPorId(teclado, productos);
          Utilidad.presioneEnterparaContinuar(teclado);
          Utilidad.dejarEspacios(50);
          break;
        case 4: // Actualizar producto
          servicio.actualizarProducto(teclado, productos);
          Utilidad.presioneEnterparaContinuar(teclado);
          Utilidad.dejarEspacios(50);
          break;
        case 5: // Eliminar producto
          break;
        case 6: // Crear un pedido
          break;
        case 7: // Listar pedidos
          break;
        case 8: // Salir
          break;
      }
    } while (opcion != 8);
  }
}











