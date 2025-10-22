📦 Sistema de Gestión de Productos (Preentrega). Este es un proyecto básico de consola desarrollado en Java usando IntelliJ IDEA, que simula un sistema rudimentario de gestión de productos con un menú interactivo.

🎯 Características: El programa permite realizar las siguientes operaciones a través de un menú de consola:Agregar Producto: Permite ingresar los detalles de un nuevo producto (nombre, precio, stock) y lo añade a la lista. La ID del producto es autogenerada.Listar Productos: Muestra todos los productos actualmente registrados en el sistema.Buscar Producto: Permite buscar y mostrar un producto específico ingresando su ID.Actualizar Producto: Permite modificar los datos (nombre, precio, stock) de un producto existente, buscándolo por su ID.Gestión de Excepciones: Incluye manejo básico de excepciones para la entrada de datos (números válidos, números positivos, opciones de menú).

🛠️ Tecnologías/Lenguaje: JavaEntorno de Desarrollo (IDE): IntelliJ IDEAGestión de Dependencias: El proyecto es nativo de IntelliJ (sin Maven/Gradle explícito), usando las librerías estándar de Java.

📁 Estructura del Proyecto: El código está organizado en varios paquetes para separar las responsabilidades (Modelo, Servicio y Utilidades):PaqueteClases PrincipalesDescripcióncom.techlabMainPreentrega, UtilidadContiene el punto de entrada (main) y métodos de utilidad para la interacción con el usuario (manejo de Scanner, validaciones de entrada, formato).com.techlab.productosProductoLa clase Modelo que representa un producto, incluyendo su ID autoincremental, nombre, precio y stock.com.techlab.servicioProductoServiceLa clase Servicio que contiene la lógica de negocio para gestionar la lista de productos (agregar, listar, buscar, actualizar).com.techlab.excepcionesNumeroInvalidoException, ...Contiene clases para excepciones personalizadas usadas para la validación de datos.

🚀 Cómo EjecutarClonar/Descargar el repositorio. Abrir el proyecto en IntelliJ IDEA.Asegurarse de tener un JDK de Java configurado.Ejecutar la clase principal: com.techlab.MainPreentrega.El programa se ejecutará en la consola, mostrando el menú de opciones para interactuar.

✏️ Uso del ProgramaAl iniciar, se mostrará el siguiente menú:
1) Agregar producto.
2) Listar productos.
3) Buscar producto.
4) Actualizar producto.
5) Eliminar producto. (Pendiente de implementación)
6) Crear un pedido. (Pendiente de implementación)
7) Listar pedidos. (Pendiente de implementación)
8) Salir.

Para interactuar, solo necesita ingresar el número correspondiente a la acción que desea realizar y seguir las instrucciones en pantalla.📝 Notas sobre la ImplementaciónLa persistencia de los datos no está implementada. Los productos se almacenan en una lista (ArrayList) y se pierden al finalizar la ejecución del programa.Las opciones 5, 6 y 7 están presentes en el menú pero su lógica de negocio (eliminar producto, crear/listar pedidos) se encuentra pendiente de implementación en el código proporcionado.Se utiliza la clase Utilidad para centralizar la lectura y validación de entradas por consola, asegurando que el programa solo reciba tipos de datos correctos (int, double y valores positivos).
