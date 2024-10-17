import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.*;
import java.time.LocalDate;
import java.util.List;

public class MainApp extends Application {

    private final ObservableList<Tarea> tareasList = FXCollections.observableArrayList();
    private static final String ERROR_TITLE = "Error";
    private static final String FILE_PATH = "tareas.dat";

    @Override
    public void start(Stage primaryStage) {
        // Crear la TableView
        TableView<Tarea> tableView = new TableView<>();

        // Crear las columnas
        TableColumn<Tarea, String> tituloColumn = new TableColumn<>("Título");
        tituloColumn.setCellValueFactory(new PropertyValueFactory<>("titulo"));

        TableColumn<Tarea, String> descripcionColumn = new TableColumn<>("Descripción");
        descripcionColumn.setCellValueFactory(new PropertyValueFactory<>("descripcion"));

        TableColumn<Tarea, LocalDate> fechaColumn = new TableColumn<>("Fecha Límite");
        fechaColumn.setCellValueFactory(new PropertyValueFactory<>("fechaLimite"));

        TableColumn<Tarea, Integer> prioridadColumn = new TableColumn<>("Prioridad");
        prioridadColumn.setCellValueFactory(new PropertyValueFactory<>("prioridad"));

        TableColumn<Tarea, Boolean> completadaColumn = new TableColumn<>("Completada");
        completadaColumn.setCellValueFactory(new PropertyValueFactory<>("completada"));

        // Agregar las columnas a la TableView
        tableView.getColumns().addAll(tituloColumn, descripcionColumn, fechaColumn, prioridadColumn, completadaColumn);

        // Establecer la lista de tareas
        tableView.setItems(tareasList);

        // Crear campos de texto y botón para agregar tarea
        TextField tituloField = new TextField();
        tituloField.setPromptText("Título");
        TextField descripcionField = new TextField();
        descripcionField.setPromptText("Descripción");
        DatePicker fechaPicker = new DatePicker();
        ChoiceBox<Integer> prioridadChoiceBox = new ChoiceBox<>(FXCollections.observableArrayList(1, 2, 3, 4, 5));
        prioridadChoiceBox.setValue(1);

        Button agregarButton = new Button("Agregar Tarea");
        Button eliminarButton = new Button("Eliminar Tarea");
        Button completarButton = new Button("Marcar como Completada");
        Button guardarButton = new Button("Guardar Tareas");
        Button cargarButton = new Button("Cargar Tareas");

        // Acción del botón "Agregar Tarea"
        agregarButton.setOnAction(e -> {
            String titulo = tituloField.getText();
            String descripcion = descripcionField.getText();
            LocalDate fecha = fechaPicker.getValue();
            Integer prioridad = prioridadChoiceBox.getValue();

            if (titulo.isEmpty() || descripcion.isEmpty() || fecha == null || prioridad == null) {
                mostrarAlerta(ERROR_TITLE, "Por favor, completa todos los campos.");
            } else {
                Tarea tarea = new Tarea(titulo, descripcion, fecha, null, prioridad, false);
                tareasList.add(tarea);
                tableView.refresh();
                limpiarCampos(tituloField, descripcionField, fechaPicker, prioridadChoiceBox);
            }
        });

        // Acción del botón "Eliminar Tarea"
        eliminarButton.setOnAction(e -> {
            Tarea tareaSeleccionada = tableView.getSelectionModel().getSelectedItem();
            if (tareaSeleccionada != null) {
                tareasList.remove(tareaSeleccionada);
                tableView.refresh();
            } else {
                mostrarAlerta(ERROR_TITLE, "Selecciona una tarea para eliminar.");
            }
        });

        // Acción del botón "Marcar como Completada"
        completarButton.setOnAction(e -> {
            Tarea tareaSeleccionada = tableView.getSelectionModel().getSelectedItem();
            if (tareaSeleccionada != null) {
                tareaSeleccionada.setCompletada(true);
                tableView.refresh();
            } else {
                mostrarAlerta(ERROR_TITLE, "Selecciona una tarea para marcar como completada.");
            }
        });

        // Acción del botón "Guardar Tareas"
        guardarButton.setOnAction(e -> guardarTareas(FILE_PATH));

        // Acción del botón "Cargar Tareas"
        cargarButton.setOnAction(e -> cargarTareas(FILE_PATH, tableView));

        // Layout y escena
        VBox layout = new VBox(10, tableView, tituloField, descripcionField, fechaPicker, prioridadChoiceBox, agregarButton, eliminarButton, completarButton, guardarButton, cargarButton);
        Scene scene = new Scene(layout, 600, 500);

        primaryStage.setTitle("Gestor de Tareas");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.ERROR);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }

    private void limpiarCampos(TextField tituloField, TextField descripcionField, DatePicker fechaPicker, ChoiceBox<Integer> prioridadChoiceBox) {
        tituloField.clear();
        descripcionField.clear();
        fechaPicker.setValue(null);
        prioridadChoiceBox.setValue(1);
    }

    private void guardarTareas(String rutaArchivo) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(rutaArchivo))) {
            oos.writeObject(FXCollections.observableArrayList(tareasList));
            mostrarAlerta("Éxito", "Tareas guardadas correctamente.");
        } catch (IOException e) {
            mostrarAlerta(ERROR_TITLE, "Error al guardar las tareas: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    private void cargarTareas(String rutaArchivo, TableView<Tarea> tableView) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(rutaArchivo))) {
            List<Tarea> tareasCargadas = (List<Tarea>) ois.readObject();
            tareasList.setAll(tareasCargadas);
            tableView.refresh();
            mostrarAlerta("Éxito", "Tareas cargadas correctamente.");
        } catch (IOException | ClassNotFoundException e) {
            mostrarAlerta(ERROR_TITLE, "Error al cargar las tareas: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
