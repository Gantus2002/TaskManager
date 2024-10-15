import java.time.LocalDate;
import java.time.LocalTime;


/**
 * Clase que representa una tarea en el sistema.
 * Contiene información sobre el título, descripción, fecha límite y prioridad.
 */
public class Tarea {

    // Atributos privados
    private String titulo;
    private String descripcion;
    private LocalDate fechaLimite;
    private LocalTime horaLimite;
    private int prioridad;

    /**
     * Constructor para crear una nueva tarea.
     *
     * @param titulo El título de la tarea.
     * @param descripcion Una descripción breve de la tarea.
     * @param fechaLimite La fecha límite para completar la tarea.
     * @param horaLimite La hora límite de la tarea.
     * @param prioridad La prioridad de la tarea (1 a 5, donde 1 es más alta).
     */
    public Tarea(String titulo, String descripcion, LocalDate fechaLimite, LocalTime horaLimite, int prioridad) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fechaLimite = fechaLimite;
        this.horaLimite = horaLimite;
        this.prioridad = prioridad;
    }

    // Métodos Getters y Setters documentados

    /**
     * Obtiene el título de la tarea.
     * @return El título de la tarea.
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Establece un nuevo título para la tarea.
     * @param titulo El nuevo título de la tarea.
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Obtiene la descripción de la tarea.
     * @return La descripción de la tarea.
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Establece una nueva descripción para la tarea.
     * @param descripcion La nueva descripción de la tarea.
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Obtiene la fecha límite de la tarea.
     * @return La fecha límite como LocalDate.
     */
    public LocalDate getFechaLimite() {
        return fechaLimite;
    }

    /**
     * Establece una nueva fecha límite para la tarea.
     * @param fechaLimite La nueva fecha límite.
     */
    public void setFechaLimite(LocalDate fechaLimite) {
        this.fechaLimite = fechaLimite;
    }
    /**
     * Obtiene la hora límite de la tarea.
     * @return La hora límite de la tarea.
     */
    public LocalTime getHoraLimite() {
        return horaLimite;
    }

    /**
     * Establece una nueva hora límite para la tarea.
     * @param horaLimite La nueva hora límite de la tarea.
     */
    public void setHoraLimite(LocalTime horaLimite) {
        this.horaLimite = horaLimite;
    }


    /**
     * Obtiene la prioridad de la tarea.
     * @return La prioridad de la tarea (1-5).
     */
    public int getPrioridad() {
        return prioridad;
    }

    /**
     * Establece una nueva prioridad para la tarea.
     * @param prioridad La nueva prioridad de la tarea.
     */
    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    /**
     * Devuelve una representación de la tarea en forma de cadena.
     * @return Una cadena con la información de la tarea.
     */
    @Override
    public String toString() {
        return "Tarea{" +
                "titulo='" + titulo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", fechaLimite=" + fechaLimite +
                ", horaLimite=" + horaLimite +  // Incluimos la hora en la representación en texto
                ", prioridad=" + prioridad +
                '}';
    }
}

