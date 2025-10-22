package com.techlab;

import com.techlab.excepciones.IdNoEncontradaException;
import com.techlab.excepciones.NumeroInvalidoException;
import com.techlab.productos.Producto;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Utilidad {

  /**
   * Lee un entero válido desde el scanner mostrando el mensaje.
   * Usa nextLine() y parseo para evitar problemas con el buffer del Scanner.
   */
  public static int numeroIntValido(Scanner teclado, String mensaje) {
    int numero;
    while (true) {
      try {
        System.out.print(mensaje);
        String linea = teclado.nextLine().trim();
        numero = Integer.parseInt(linea);
        return numero;
      } catch (NumberFormatException e) {
        System.out.println("Entrada inválida. Ingrese un número entero válido.");
      }
    }
  }

  /**
   * Lee un double válido desde el scanner mostrando el mensaje.
   * Usa nextLine() y Double.parseDouble para controlar bien el buffer.
   */
  public static double numeroDoubleValido(Scanner teclado, String mensaje) {
    double numero;
    while (true) {
      try {
        System.out.print(mensaje);
        String linea = teclado.nextLine().trim();
        numero = Double.parseDouble(linea);
        return numero;
      } catch (NumberFormatException e) {
        System.out.println("Entrada inválida. Ingrese un número decimal válido.");
      }
    }
  }

  /**
   * Lee un double positivo (mayor o igual a 0? aquí lo hacemos > 0).
   * Repite hasta que el usuario ingrese un valor correcto.
   */
  public static double numeroDoublePositivo(Scanner teclado, String mensaje) {
    while (true) {
      double numero = numeroDoubleValido(teclado, mensaje);
      if (numero > 0) {
        return numero;
      } else {
        System.out.println("El número debe ser positivo. Intente nuevamente.");
      }
    }
  }

  /**
   * Lee un entero positivo (> 0). Repite hasta obtener un entero positivo.
   * Método agregado porque ProductService lo usa.
   */
  public static int numeroIntPositivo(Scanner teclado, String mensaje) {
    while (true) {
      int numero = numeroIntValido(teclado, mensaje);
      if (numero > 0) {
        return numero;
      } else {
        System.out.println("El número debe ser positivo. Intente nuevamente.");
      }
    }
  }

  public static void dejarEspacios(int cantidad) {
    for (int i = 0; i < cantidad; i++) {
      System.out.println();
    }
  }

  public static void presioneEnterparaContinuar(Scanner scanner) {
    System.out.print("\nPresione 'Enter' para continuar...");
    scanner.nextLine();
  }

  /**
   * Busca la posición del producto con la ID indicada en la lista.
   * Devuelve:
   *   -1 -> si la lista es null o vacía o si no se encuentra la ID
   *  >=0 -> índice en la lista
   */
  public static int posicionProductoId(int id, List<Producto> productos) {

    if (productos == null || productos.isEmpty()) {
      return -1;
    }

    for (int i = 0; i < productos.size(); i++) {
      if (productos.get(i).getId() == id) {
        return i;
      }
    }

    return -1;
  }
}
