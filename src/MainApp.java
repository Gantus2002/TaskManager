import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.time.LocalTime;

public class MainApp extends Application {
    private GestorTareas gestorTareas;

    @Override
    public void start(Stage primaryStage) {
        gestorTareas = new GestorTareas();

        primaryStage.setTitle("Gestor de Tareas");

        // Crear el panel y los campos de entrada
        GridPane grid = new GridPane();
        TextField tituloField = new TextField();
        TextField descripcionField = new TextField();
        TextField fechaField = new TextField();
        TextField horaField = new TextField();
        TextField prioridadField = new TextField();

        grid.add(new Label("Título:"), 0, 0);
        grid.add(tituloField, 1, 0);
        grid.add(new Label("Descripción:"), 0, 1);
        grid.add(descripcionField, 1, 1);
        grid.add(new Label("Fecha (YYYY-MM-DD):"), 0, 2);
        grid.add(fechaField, 1, 2);
        grid.add(new Label("Hora (HH:MM):"), 0, 3);
        grid.add(horaField, 1, 3);
        grid.add(new Label("Prioridad (1-5):"), 0, 4);
        grid.add(prioridadField, 1, 4);

        Button agregarButton = new Button("Agregar Tarea");
        agregarButton.setOnAction(e -> agregarTarea(tituloField, descripcionField, fechaField, horaField, prioridadField));

        grid.add(agregarButton, 1, 5);

        Scene scene = new Scene(grid, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void agregarTarea(TextField tituloField, TextField descripcionField, TextField fechaField, TextField horaField, TextField prioridadField) {
        String titulo = tituloField.getText();
        String descripcion = descripcionField.getText();
        LocalDate fechaLimite = LocalDate.parse(fechaField.getText());
        LocalTime horaLimite = LocalTime.parse(horaField.getText());
        int prioridad = Integer.parseInt(prioridadField.getText());

        // Crear nueva tarea con el estado de completada como false
        Tarea nuevaTarea = new Tarea(titulo, descripcion, fechaLimite, horaLimite, prioridad);
        gestorTareas.agregarTarea(nuevaTarea);

        // Limpiar campos
        tituloField.clear();
        descripcionField.clear();
        fechaField.clear();
        horaField.clear();
        prioridadField.clear();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
