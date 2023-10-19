package org.example.gui.busquedas;



import org.example.controladores.ControladorEvento;
import org.example.modelos.ModeloEvento;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ShowFindEventoForm {
    
    public void showFindEventoForm(Stage primaryStage, ControladorEvento controladorEvento, String fontStyle, String buttonStyle, String labelStyle, String titleLabelStyle) {
        primaryStage.setTitle("Buscar Evento");

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);

        Label titleLabel = new Label("Buscar Evento");
        GridPane.setHalignment(titleLabel, HPos.CENTER);
        titleLabel.setStyle(titleLabelStyle);
        grid.add(titleLabel, 0, 0, 2, 1);

        Label eventoIdLabel = new Label("ID del Evento:");
        eventoIdLabel.setStyle(labelStyle);
        grid.add(eventoIdLabel, 0, 1);
        TextField eventoIdField = new TextField();
        grid.add(eventoIdField, 1, 1);

        Button buscarButton = new Button("Buscar Evento");
        buscarButton.setStyle(buttonStyle);
        grid.add(buscarButton, 1, 2);

        TextArea resultadoArea = new TextArea();
        resultadoArea.setEditable(false);
        grid.add(resultadoArea, 0, 3, 2, 1);

        buscarButton.setOnAction(event -> {
            try {
                int idEvento = Integer.parseInt(eventoIdField.getText());
                ModeloEvento evento = controladorEvento.buscarEvento(idEvento);
                if (evento != null) {
                    resultadoArea.setText("Evento encontrado: " + evento);
                } else {
                    resultadoArea.setText("Evento no encontrado.");
                }
            } catch (NumberFormatException e) {
                resultadoArea.setText("Por favor, ingrese un ID válido.");
            }
        });

        VBox vbox = new VBox(grid);
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(20));

        Scene scene = new Scene(vbox, 450, 400);
        scene.getRoot().setStyle(fontStyle);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
