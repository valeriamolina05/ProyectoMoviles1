package org.example.gui.busquedas;



import org.example.controladores.ControladorUsuarioOcasional;
import org.example.modelos.ModeloOcasional;

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

public class ShowFindUsuarioOcasionalForm {

    public void showFindUsuarioOcasionalForm(Stage primaryStage, ControladorUsuarioOcasional controladorUsuarioOcasional , String fontStyle, String buttonStyle, String labelStyle, String titleLabelStyle) {
        primaryStage.setTitle("Buscar Usuario Ocasional");
        

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);

        Label titleLabel = new Label("Buscar Usuario Ocasional");
        GridPane.setHalignment(titleLabel, HPos.CENTER);
        titleLabel.setStyle(titleLabelStyle);
        grid.add(titleLabel, 0, 0, 2, 1);

        Label documentoLabel = new Label("Documento:");
        documentoLabel.setStyle(labelStyle);
        grid.add(documentoLabel, 0, 1);

        TextField documentoField = new TextField();
        grid.add(documentoField, 1, 1);

        Button buscarButton = new Button("Buscar Usuario Ocasional");
        buscarButton.setStyle(buttonStyle);
        grid.add(buscarButton, 1, 2);

        TextArea resultadoLabel = new TextArea();
        grid.add(resultadoLabel, 0, 3, 2, 1);

        buscarButton.setOnAction(event -> {
            try {
                String documento = documentoField.getText();
                ModeloOcasional usuarioOcasional = controladorUsuarioOcasional.buscarUsuarioOcasional(documento);

                if (usuarioOcasional != null) {
                    resultadoLabel.setText("Usuario Ocasional encontrado: " + usuarioOcasional.toString());
                } else {
                    resultadoLabel.setText("Usuario Ocasional no encontrado.");
                }
            } catch (Exception e) {
                resultadoLabel.setText("Error: " + e.getMessage());
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
