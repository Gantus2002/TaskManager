import java.util.ArrayList;
import java.util.List;

/**
 * Clase que gestiona una lista de tareas.
 * Permite agregar, editar, eliminar y listar tareas.
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
     * @param tarea La tarea a agregar.
     */
    public void agregarTarea(Tarea tarea) {
        listaTareas.add(tarea);
    }

    /**
     * Elimina una tarea de la lista por su índice.
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
     * Edita una tarea existente en la lista.
     * @param index El índice de la tarea a editar.
     * @param nuevaTarea La nueva tarea con la que se reemplazará la existente.
     */
    public void editarTarea(int index, Tarea nuevaTarea) {
        if (index >= 0 && index < listaTareas.size()) {
            listaTareas.set(index, nuevaTarea);
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
     * Obtiene una tarea por su índice.
     * @param index El índice de la tarea a obtener.
     * @return La tarea en el índice especificado o null si el índice está fuera de rango.
     */
    public Tarea obtenerTarea(int index) {
        if (index >= 0 && index < listaTareas.size()) {
            return listaTareas.get(index);
        } else {
            System.out.println("Índice fuera de rango.");
            return null;
        }
    }
}
