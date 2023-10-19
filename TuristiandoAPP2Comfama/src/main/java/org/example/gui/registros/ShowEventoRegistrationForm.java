package org.example.gui.registros;



import org.example.controladores.ControladorEvento;
import org.example.gui.Alerts;

import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ShowEventoRegistrationForm {
    private Alerts alert = new Alerts();

    public void showEventoRegistrationForm(Stage primaryStage, ControladorEvento controladorEvento, String fontStyle, String buttonStyle, String labelStyle, String titleLabelStyle) {
        primaryStage.setTitle("Registro de Evento");

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setAlignment(Pos.CENTER);

        Label titleLabel = new Label("Registro de Evento");
        titleLabel.setStyle(titleLabelStyle);
        GridPane.setHalignment(titleLabel, HPos.CENTER);
        grid.add(titleLabel, 0, 0, 2, 1);

        Label tituloLabel = new Label("Título:");
        tituloLabel.setStyle(labelStyle); // Aplica el estilo
        grid.add(tituloLabel, 0, 1);
        TextField tituloField = new TextField();
        grid.add(tituloField, 1, 1);

        Label descripcionLabel = new Label("Descripción:");
        descripcionLabel.setStyle(labelStyle); // Aplica el estilo
        grid.add(descripcionLabel, 0, 2);
        TextField descripcionField = new TextField();
        grid.add(descripcionField, 1, 2);

        Label fechaInicioLabel = new Label("Fecha de Inicio (dd/MM/yyyy HH:mm):");
        fechaInicioLabel.setStyle(labelStyle); // Aplica el estilo
        grid.add(fechaInicioLabel, 0, 3);
        TextField fechaInicioField = new TextField();
        grid.add(fechaInicioField, 1, 3);

        Label fechaFinLabel = new Label("Fecha de Fin (dd/MM/yyyy HH:mm):");
        fechaFinLabel.setStyle(labelStyle); // Aplica el estilo
        grid.add(fechaFinLabel, 0, 4);
        TextField fechaFinField = new TextField();
        grid.add(fechaFinField, 1, 4);

        Label costoPersonaLabel = new Label("Costo por Persona:");
        costoPersonaLabel.setStyle(labelStyle); // Aplica el estilo
        grid.add(costoPersonaLabel, 0, 5);
        TextField costoPersonaField = new TextField();
        grid.add(costoPersonaField, 1, 5);

        Label categoriaLabel = new Label("Categoría (arte, música, teatro, biblioteca, otros):");
        categoriaLabel.setStyle(labelStyle); // Aplica el estilo
        grid.add(categoriaLabel, 0, 6);
        TextField categoriaField = new TextField();
        grid.add(categoriaField, 1, 6);

        Label ubicacionLabel = new Label("Zona (rural, urbana, centro, otro):");
        ubicacionLabel.setStyle(labelStyle); // Aplica el estilo
        grid.add(ubicacionLabel, 0, 7);

        ChoiceBox<String> ubicacionChoice = new ChoiceBox<>();
        ubicacionChoice.getItems().addAll("Rural", "Urbana", "Centro", "Otro");
        ubicacionChoice.setValue("Otro"); // Establece un valor predeterminado
        grid.add(ubicacionChoice, 1, 7);

        Label idECulturalLabel = new Label("ID de la Entidad Cultural:");
        idECulturalLabel.setStyle(labelStyle); // Aplica el estilo
        grid.add(idECulturalLabel, 0, 8);
        TextField idECulturalField = new TextField();
        grid.add(idECulturalField, 1, 8);

        Label idEPrivadaLabel = new Label("ID de la Empresa Privada:");
        idEPrivadaLabel.setStyle(labelStyle); // Aplica el estilo
        grid.add(idEPrivadaLabel, 0, 9);
        TextField idEPrivadaField = new TextField();
        grid.add(idEPrivadaField, 1, 9);

        Button registrarEventoButton = new Button("Registrar Evento");
        registrarEventoButton.setMaxWidth(Double.MAX_VALUE);
        registrarEventoButton.setStyle(buttonStyle);
        grid.add(registrarEventoButton, 0, 10, 2, 1);

        Label errorLabel = new Label();
        errorLabel.setStyle("-fx-text-fill: red;");

        registrarEventoButton.setOnAction(event -> {
            try {
                String titulo = tituloField.getText();
                String descripcion = descripcionField.getText();
                String fechaInicio = fechaInicioField.getText();
                String fechaFin = fechaFinField.getText();
                Double costoPersona = Double.parseDouble(costoPersonaField.getText());
                String categoria = categoriaField.getText();
                String ubicacion = ubicacionChoice.getValue();
                Integer idECultural = idECulturalField.getText().isEmpty() ? null
                        : Integer.parseInt(idECulturalField.getText());
                Integer idEPrivada = idEPrivadaField.getText().isEmpty() ? null
                        : Integer.parseInt(idEPrivadaField.getText());

                controladorEvento.registrarEvento(titulo, descripcion, fechaInicio, fechaFin,
                        costoPersona, categoria,
                        ubicacion, idECultural, idEPrivada);
                alert.showConfirmation("Evento registrado", "El evento ha sido registrado con éxito.");

                tituloField.clear();
                descripcionField.clear();
                fechaInicioField.clear();
                fechaFinField.clear();
                costoPersonaField.clear();
                categoriaField.clear();
                ubicacionChoice.setValue("Otro");
                idECulturalField.clear();
                idEPrivadaField.clear();
            } catch (Exception e) {
                errorLabel.setText("Error: " + e.getMessage());
            }
        });
        VBox vbox = new VBox(grid);
        vbox.setAlignment(Pos.CENTER);

        Scene scene = new Scene(vbox, 460, 450);
        scene.getRoot().setStyle(fontStyle);
        primaryStage.setScene(scene);

        primaryStage.show();
    }

}
