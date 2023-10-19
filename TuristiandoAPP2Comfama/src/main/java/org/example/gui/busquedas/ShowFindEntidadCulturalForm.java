package org.example.gui.busquedas;



import org.example.controladores.ControladorEntidadCultural;
import org.example.modelos.ModeloEntidadCultural;

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

public class ShowFindEntidadCulturalForm {
    
    public void showFindEntidadCulturalForm(Stage primaryStage, ControladorEntidadCultural controladorEcultural, String fontStyle, String buttonStyle, String labelStyle, String titleLabelStyle ) {
        primaryStage.setTitle("Buscar Entidad Cultural");

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);

        Label titleLabel = new Label("Buscar Entidad Cultural");
        GridPane.setHalignment(titleLabel, HPos.CENTER);
        titleLabel.setStyle(titleLabelStyle);
        grid.add(titleLabel, 0, 0, 2, 1);

        Label idLabel = new Label("ID de la Entidad Cultural:");
        idLabel.setStyle(labelStyle);
        grid.add(idLabel, 0, 1);
        TextField idField = new TextField();
        grid.add(idField, 1, 1);

        Button buscarButton = new Button("Buscar Entidad Cultural");
        buscarButton.setStyle(buttonStyle);
        grid.add(buscarButton, 1, 2);

        TextArea resultadoLabel = new TextArea();
        grid.add(resultadoLabel, 0, 3, 2, 1);

        buscarButton.setOnAction(event -> {
            try {
                String idEntidadCultural = idField.getText();
                ModeloEntidadCultural entidadCultural = controladorEcultural.buscarEntidadCultural(idEntidadCultural);

                if (entidadCultural != null) {
                    resultadoLabel.setText("Entidad Cultural encontrada: " + entidadCultural);
                } else {
                    resultadoLabel.setText("Entidad Cultural no encontrada.");
                }
            } catch (NumberFormatException e) {
                resultadoLabel.setText("Por favor, ingrese un ID válido.");
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
