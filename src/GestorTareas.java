import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que gestiona una lista de tareas.
 * Permite agregar, editar, eliminar, listar y buscar tareas.
 */
public class GestorTareas {
    private List<Tarea> listaTareas;

    /**
     * Constructor que inicializa la lista de tareas.
     */
    public GestorTareas() {
        this.listaTareas = new ArrayList<>();
    }

    /**
     * Agrega una nueva tarea a la lista.
     *
     * @param tarea La tarea a agregar.
     */
    public void agregarTarea(Tarea tarea) {
        listaTareas.add(tarea);
    }

    /**
     * Elimina una tarea de la lista por su índice.
     *
     * @param index El índice de la tarea a eliminar.
     */
    public void eliminarTarea(int index) {
        if (index >= 0 && index < listaTareas.size()) {
            listaTareas.remove(index);
        } else {
            System.out.println("Índice fuera de rango.");
        }
    }

    /**
     * Lista todas las tareas en la consola.
     */
    public void listarTareas() {
        if (listaTareas.isEmpty()) {
            System.out.println("No hay tareas para mostrar.");
        } else {
            for (int i = 0; i < listaTareas.size(); i++) {
                Tarea tarea = listaTareas.get(i);
                System.out.println(i + ". " + tarea);
            }
        }
    }

    /**
     * Busca y lista todas las tareas que vencen en una fecha específica.
     *
     * @param fecha La fecha a buscar.
     */
    public void buscarPorFecha(LocalDate fecha) {
        System.out.println("Tareas para la fecha: " + fecha);
        for (Tarea tarea : listaTareas) {
            if (tarea.getFechaLimite().equals(fecha)) {
                System.out.println(tarea);
            }
        }
    }

    /**
     * Busca y lista todas las tareas con una prioridad específica.
     *
     * @param prioridad La prioridad a buscar (1-5).
     */
    public void buscarPorPrioridad(int prioridad) {
        System.out.println("Tareas con prioridad " + prioridad + ":");
        for (Tarea tarea : listaTareas) {
            if (tarea.getPrioridad() == prioridad) {
                System.out.println(tarea);
            }
        }
    }

    /**
     * Marca una tarea como completada por su índice.
     *
     * @param index El índice de la tarea a marcar como completada.
     */
    public void marcarTareaComoCompletada(int index) {
        if (index >= 0 && index < listaTareas.size()) {
            Tarea tarea = listaTareas.get(index);
            tarea.setCompletada(true);
            System.out.println("Tarea marcada como completada: " + tarea);
        } else {
            System.out.println("Índice fuera de rango.");
        }
    }

    // Aquí también puedes implementar los métodos de guardar y cargar tareas desde un archivo
    // para la persistencia de datos
}
