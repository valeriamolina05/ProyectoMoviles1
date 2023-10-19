package org.example.gui.registros;



import org.example.controladores.ControladorEmpresaPrivada;
import org.example.gui.Alerts;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ShowEmpresaRegistrationForm {
    private Alerts alert = new Alerts();

    public void showEmpresaRegistrationForm(Stage primaryStage, ControladorEmpresaPrivada controladorEPrivada, String fontStyle, String buttonStyle, String labelStyle, String titleLabelStyle) {
        primaryStage.setTitle("Registro de Empresa Privada");

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setAlignment(Pos.CENTER);

        Label titleLabel = new Label("Registro de Empresa Privada");
        GridPane.setHalignment(titleLabel, HPos.CENTER);
        titleLabel.setStyle(titleLabelStyle);
        grid.add(titleLabel, 0, 0, 2, 1);

        Label nitLabel = new Label("NIT:");
        nitLabel.setStyle(labelStyle);
        grid.add(nitLabel, 0, 1);
        TextField nitField = new TextField();
        grid.add(nitField, 1, 1);

        Label nombreLabel = new Label("Nombre:");
        nombreLabel.setStyle(labelStyle);
        grid.add(nombreLabel, 0, 2);
        TextField nombreField = new TextField();
        grid.add(nombreField, 1, 2);

        Label descripcionLabel = new Label("Descripción:");
        descripcionLabel.setStyle(labelStyle);
        grid.add(descripcionLabel, 0, 3);
        TextField descripcionField = new TextField();
        grid.add(descripcionField, 1, 3);

        Label ubicacionLabel = new Label("Ubicación (Número):");
        ubicacionLabel.setStyle(labelStyle);
        grid.add(ubicacionLabel, 0, 4);
        TextField ubicacionField = new TextField();
        grid.add(ubicacionField, 1, 4);

        Label representanteLabel = new Label("Nombre del Representante:");
        representanteLabel.setStyle(labelStyle);
        grid.add(representanteLabel, 0, 5);
        TextField representanteField = new TextField();
        grid.add(representanteField, 1, 5);

        Label cedulaRepresentanteLabel = new Label("Cédula del Representante:");
        cedulaRepresentanteLabel.setStyle(labelStyle);
        grid.add(cedulaRepresentanteLabel, 0, 6);
        TextField cedulaRepresentanteField = new TextField();
        grid.add(cedulaRepresentanteField, 1, 6);

        Button registerButton = new Button("Registrar Empresa Privada");
        registerButton.setStyle(buttonStyle);
        registerButton.setMaxWidth(Double.MAX_VALUE);
        grid.add(registerButton, 0, 7, 2, 1);

        Label errorLabel = new Label();
        errorLabel.setStyle("-fx-text-fill: red;");

        registerButton.setOnAction(event -> {
            try {
                // Obtén los valores de los campos y llama al método de registro
                String nit = nitField.getText();
                String nombre = nombreField.getText();
                String descripcion = descripcionField.getText();
                Integer ubicacion = Integer.parseInt(ubicacionField.getText());
                String nombreRepresentante = representanteField.getText();
                String cedulaRepresentante = cedulaRepresentanteField.getText();

                // Llama al método de registro de empresa privada con los valores ingresados
                controladorEPrivada.registrarEmpresa(nit, nombre, descripcion, ubicacion,
                        nombreRepresentante,
                        cedulaRepresentante);

                // Cierra la ventana de registro
                alert.showConfirmation("Empresa registrada", "La Empresa ha sido registrada con éxito.");

                nitField.clear();
                nombreField.clear();
                descripcionField.clear();
                ubicacionField.clear();
                representanteField.clear();
                cedulaRepresentanteField.clear();
            } catch (Exception e) {
                errorLabel.setText("Error: " + e.getMessage());
            }
        });
        VBox vbox = new VBox(grid);
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(20));
        

        Scene registrationScene = new Scene(vbox, 450, 400);
        registrationScene.getRoot().setStyle(fontStyle);
        primaryStage.setScene(registrationScene);
        primaryStage.show();

    }

    
}
