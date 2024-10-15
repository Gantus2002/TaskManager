import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class TaskManagerApp {
    public static void main(String[] args) {
        GestorTareas gestorTareas = new GestorTareas();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("Menú:");
            System.out.println("1. Agregar tarea");
            System.out.println("2. Listar tareas");
            System.out.println("3. Buscar tarea por fecha");
            System.out.println("4. Buscar tarea por prioridad");
            System.out.println("5. Marcar tarea como completada");
            System.out.println("0. Salir");
            System.out.print("Selecciona una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    // Agregar tarea
                    System.out.print("Título de la tarea: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Descripción de la tarea: ");
                    String descripcion = scanner.nextLine();
                    System.out.print("Fecha límite (YYYY-MM-DD): ");
                    LocalDate fechaLimite = LocalDate.parse(scanner.nextLine());
                    System.out.print("Hora límite (HH:MM): ");
                    LocalTime horaLimite = LocalTime.parse(scanner.nextLine());
                    System.out.print("Prioridad (1-5): ");
                    int prioridad = scanner.nextInt();
                    scanner.nextLine(); // Limpiar el buffer

                    // Crear la tarea
                    Tarea nuevaTarea = new Tarea(titulo, descripcion, fechaLimite, horaLimite, prioridad, false);
                    gestorTareas.agregarTarea(nuevaTarea);
                    System.out.println("Tarea agregada.");
                    break;

                case 2:
                    // Listar tareas
                    gestorTareas.listarTareas();
                    break;

                case 3:
                    // Buscar tarea por fecha
                    System.out.print("Ingresa la fecha (YYYY-MM-DD): ");
                    LocalDate fechaBusqueda = LocalDate.parse(scanner.nextLine());
                    gestorTareas.buscarPorFecha(fechaBusqueda);
                    break;

                case 4:
                    // Buscar tarea por prioridad
                    System.out.print("Ingresa la prioridad (1-5): ");
                    int prioridadBusqueda = scanner.nextInt();
                    gestorTareas.buscarPorPrioridad(prioridadBusqueda);
                    break;

                case 5:
                    // Marcar tarea como completada
                    System.out.print("Ingresa el índice de la tarea a marcar como completada: ");
                    int indiceCompletar = scanner.nextInt();
                    gestorTareas.marcarTareaComoCompletada(indiceCompletar);
                    break;

                case 0:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
            }
        } while (opcion != 0);

        scanner.close();
    }
}
