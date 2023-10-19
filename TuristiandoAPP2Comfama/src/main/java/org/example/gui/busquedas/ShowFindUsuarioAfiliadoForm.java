package org.example.gui.busquedas;



import org.example.controladores.ControladorUsuarioAfiliado;
import org.example.modelos.ModeloAfiliado;

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

public class ShowFindUsuarioAfiliadoForm {
    
    public void showFindUsuarioAfiliadoForm(Stage primaryStage, ControladorUsuarioAfiliado controladorUsuarioAfiliado, String fontStyle, String buttonStyle, String labelStyle, String titleLabelStyle) {
        primaryStage.setTitle("Buscar Usuario Afiliado");
        

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);

        Label titleLabel = new Label("Búsqueda de Usuario Afiliado");
        titleLabel.setStyle(titleLabelStyle);
        grid.add(titleLabel, 0, 0, 2, 1);

        Label idLabel = new Label("ID del Usuario Afiliado:");
        idLabel.setStyle(labelStyle);
        grid.add(idLabel, 0, 1);
        TextField idField = new TextField();
        grid.add(idField, 1, 1);

        Button buscarButton = new Button("Buscar Afiliado");
        buscarButton.setStyle(buttonStyle);
        grid.add(buscarButton, 1, 2);

        TextArea resultadoLabel = new TextArea("");
        resultadoLabel.setStyle("-fx-text-fill: green;");
        grid.add(resultadoLabel, 0, 3, 2, 1);

        buscarButton.setOnAction(event -> {
            try {
                String idUsuarioAfiliado = idField.getText();
                ModeloAfiliado usuarioAfiliado = controladorUsuarioAfiliado.buscarUsuarioAfiliado(idUsuarioAfiliado);
                if (usuarioAfiliado != null) {
                    resultadoLabel.setText("Usuario Afiliado encontrado: " + usuarioAfiliado);
                } else {
                    resultadoLabel.setText("Usuario Afiliado no encontrado.");
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
