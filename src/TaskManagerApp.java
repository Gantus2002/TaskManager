import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

/**
 * Clase principal que maneja la interacción del usuario con el gestor de tareas.
 */
public class TaskManagerApp {

    public static void main(String[] args) {
        // Crear el gestor de tareas
        GestorTareas gestor = new GestorTareas();
        Scanner scanner = new Scanner(System.in);

        // Menú simple
        int opcion = -1;
        while (opcion != 0) {
            System.out.println("\n--- Menú de Gestor de Tareas ---");
            System.out.println("1. Agregar tarea");
            System.out.println("2. Listar tareas");
            System.out.println("3. Eliminar tarea");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();  // Consumir la nueva línea

            switch (opcion) {
                case 1:
                    // Agregar una nueva tarea
                    System.out.print("Ingresa el título de la tarea: ");
                    String titulo = scanner.nextLine();

                    System.out.print("Ingresa la descripción de la tarea: ");
                    String descripcion = scanner.nextLine();

                    System.out.print("Ingresa la fecha límite (AAAA-MM-DD): ");
                    String fecha = scanner.nextLine();
                    LocalDate fechaLimite = LocalDate.parse(fecha);

                    // Agregar la hora límite
                    System.out.print("Ingresa la hora límite (HH:MM, formato 24 horas): ");
                    String hora = scanner.nextLine();
                    LocalTime horaLimite = LocalTime.parse(hora);

                    System.out.print("Ingresa la prioridad (1-5): ");
                    int prioridad = scanner.nextInt();
                    scanner.nextLine();  // Consumir la nueva línea

                    // Crear y agregar la tarea con fecha y hora
                    Tarea nuevaTarea = new Tarea(titulo, descripcion, fechaLimite, horaLimite, prioridad);
                    gestor.agregarTarea(nuevaTarea);

                    System.out.println("Tarea agregada con éxito.");
                    break;

                case 2:
                    // Listar todas las tareas
                    System.out.println("\nLista de tareas:");
                    gestor.listarTareas();
                    break;

                case 3:
                    // Eliminar una tarea por índice
                    System.out.print("Ingresa el índice de la tarea a eliminar: ");
                    int indice = scanner.nextInt();
                    gestor.eliminarTarea(indice);
                    break;

                case 0:
                    // Salir
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción no válida, por favor intenta de nuevo.");
                    break;
            }
        }

        scanner.close();
    }
}
