import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class TaskManagerApp {

    public static void main(String[] args) {
        GestorTareas gestorTareas = new GestorTareas();
        Scanner scanner = new Scanner(System.in);

        // Interacción con el usuario
        while (true) {
            System.out.println("\nSeleccione una opción:");
            System.out.println("1. Agregar nueva tarea");
            System.out.println("2. Listar tareas");
            System.out.println("3. Marcar tarea como completada");
            System.out.println("4. Buscar tareas por fecha");
            System.out.println("5. Buscar tareas por prioridad");
            System.out.println("6. Guardar tareas en un archivo");
            System.out.println("7. Cargar tareas desde un archivo");
            System.out.println("8. Salir");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    // Agregar nueva tarea
                    System.out.println("Ingrese el título de la tarea:");
                    String titulo = scanner.nextLine();
                    System.out.println("Ingrese la descripción de la tarea:");
                    String descripcion = scanner.nextLine();
                    System.out.println("Ingrese la fecha límite (AAAA-MM-DD):");
                    LocalDate fechaLimite = LocalDate.parse(scanner.nextLine());
                    System.out.println("Ingrese la hora límite (HH:MM):");
                    LocalTime horaLimite = LocalTime.parse(scanner.nextLine());
                    System.out.println("Ingrese la prioridad (1-5):");
                    int prioridad = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea

                    Tarea nuevaTarea = new Tarea(titulo, descripcion, fechaLimite, horaLimite, prioridad);
                    gestorTareas.agregarTarea(nuevaTarea);
                    System.out.println("Tarea agregada exitosamente.");
                    break;

                case 2:
                    // Listar tareas
                    System.out.println("Tareas existentes:");
                    gestorTareas.listarTareas();
                    break;

                case 3:
                    // Marcar tarea como completada
                    System.out.println("Ingrese el índice de la tarea a marcar como completada:");
                    int indice = scanner.nextInt();
                    gestorTareas.marcarComoCompletada(indice);
                    break;

                case 4:
                    // Buscar tareas por fecha
                    System.out.println("Ingrese la fecha (AAAA-MM-DD) para buscar tareas:");
                    LocalDate fechaBusqueda = LocalDate.parse(scanner.nextLine());
                    gestorTareas.buscarPorFecha(fechaBusqueda);
                    break;

                case 5:
                    // Buscar tareas por prioridad
                    System.out.println("Ingrese la prioridad (1-5) para buscar tareas:");
                    int prioridadBusqueda = scanner.nextInt();
                    gestorTareas.buscarPorPrioridad(prioridadBusqueda);
                    break;

                case 6:
                    // Guardar tareas en un archivo
                    gestorTareas.guardarTareas("tareas.dat");
                    System.out.println("Tareas guardadas exitosamente.");
                    break;

                case 7:
                    // Cargar tareas desde un archivo
                    gestorTareas.cargarTareas("tareas.dat");
                    System.out.println("Tareas cargadas exitosamente.");
                    break;

                case 8:
                    // Salir
                    System.out.println("Saliendo...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }
}
