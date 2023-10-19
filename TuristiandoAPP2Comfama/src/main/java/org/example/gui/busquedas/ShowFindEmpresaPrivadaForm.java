package org.example.gui.busquedas;



import org.example.controladores.ControladorEmpresaPrivada;
import org.example.modelos.ModeloEmpresaPrivada;

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

public class ShowFindEmpresaPrivadaForm {
    
    public void showFindEmpresaPrivadaForm(Stage primaryStage, ControladorEmpresaPrivada controladorEPrivada, String fontStyle, String buttonStyle, String labelStyle, String titleLabelStyle) {

        primaryStage.setTitle("Búsqueda de Empresa Privada");

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);

        Label titleLabel = new Label("Búsqueda de Empresa Privada");
        GridPane.setHalignment(titleLabel, HPos.CENTER);
        titleLabel.setStyle(titleLabelStyle);
        grid.add(titleLabel, 0, 0, 2, 1);

        Label empresaPrivadaIdLabel = new Label("ID de la Empresa Privada:");
        empresaPrivadaIdLabel.setStyle(labelStyle);
        grid.add(empresaPrivadaIdLabel, 0, 1);
        TextField empresaPrivadaIdField = new TextField();
        grid.add(empresaPrivadaIdField, 1, 1);

        Button buscarButton = new Button("Buscar Empresa Privada");
        buscarButton.setStyle(buttonStyle);
        grid.add(buscarButton, 1, 2);

        TextArea resultadoArea = new TextArea();
        resultadoArea.setEditable(false);
        grid.add(resultadoArea, 0, 3, 2, 1);

        buscarButton.setOnAction(event -> {
            try {
                String idEmpresaPrivada = empresaPrivadaIdField.getText();
                ModeloEmpresaPrivada empresaPrivada = controladorEPrivada.buscarEmpresaPrivada(idEmpresaPrivada);
                if (empresaPrivada != null) {
                    resultadoArea.setText("Empresa Privada encontrada: " + empresaPrivada);
                } else {
                    resultadoArea.setText("Empresa Privada no encontrada.");
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
