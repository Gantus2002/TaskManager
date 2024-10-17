import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Clase que representa una tarea.
 */
public class Tarea implements Serializable {
    private String titulo;
    private String descripcion;
    private LocalDate fechaLimite;
    private LocalTime horaLimite;
    private int prioridad;
    private boolean completada;

    /**
     * Constructor para crear una nueva tarea.
     *
     * @param titulo       El título de la tarea.
     * @param descripcion  La descripción de la tarea.
     * @param fechaLimite  La fecha límite de la tarea.
     * @param horaLimite   La hora límite de la tarea.
     * @param prioridad    La prioridad de la tarea (1-5).
     */
    public Tarea(String titulo, String descripcion, LocalDate fechaLimite, LocalTime horaLimite, int prioridad, boolean completada) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fechaLimite = fechaLimite;
        this.horaLimite = horaLimite;
        this.prioridad = prioridad;
        this.completada = false; // por defecto, la tarea no está completada
    }

    // Getters y Setters

    public String getTitulo() {
        return titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public LocalDate getFechaLimite() {
        return fechaLimite;
    }

    public LocalTime getHoraLimite() {
        return horaLimite;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public boolean isCompletada() {
        return completada;
    }

    public void setCompletada(boolean completada) {
        this.completada = completada;
    }

    @Override
    public String toString() {
        return "Tarea{" +
                "titulo='" + titulo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", fechaLimite=" + fechaLimite +
                ", horaLimite=" + horaLimite +
                ", prioridad=" + prioridad +
                ", completada=" + completada +
                '}';
    }
}
