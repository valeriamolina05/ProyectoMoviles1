package org.example.gui.registros;



import org.example.controladores.ControladorUsuarioAfiliado;
import org.example.gui.Alerts;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ShowUsuarioAfiliadoRegistrationForm {
    private Alerts alert = new Alerts();

    public void showUsuarioAfiliadoRegistrationForm(Stage primaryStage, ControladorUsuarioAfiliado controladorUsuarioAfiliado, String fontStyle, String buttonStyle, String labelStyle, String titleLabelStyle) {
        primaryStage.setTitle("Registro de Usuario Afiliado");

        GridPane formGrid = new GridPane();
        formGrid.setHgap(10);
        formGrid.setVgap(10);
        formGrid.setAlignment(Pos.CENTER);

        TextField documentoField = new TextField();
        TextField nombreField = new TextField();
        TextField correoField = new TextField();
        PasswordField contraseñaField = new PasswordField();
        TextField valorMensualidadField = new TextField();
        TextField cedulaInvitadoField = new TextField();

        Label titleLabel = new Label("Registro de Usuario Afiliado");
        GridPane.setHalignment(titleLabel, HPos.CENTER);
        titleLabel.setStyle(titleLabelStyle);
        formGrid.add(titleLabel, 0, 0, 2, 1);

        Label documentoLabel = new Label("Documento:");
        documentoLabel.setStyle(labelStyle);
        formGrid.add(documentoLabel, 0, 1);
        formGrid.add(documentoField, 1, 1);

        Label nombreLabel = new Label("Nombre:");
        nombreLabel.setStyle(labelStyle);
        formGrid.add(nombreLabel, 0, 2);
        formGrid.add(nombreField, 1, 2);

        Label correoLabel = new Label("Correo:");
        correoLabel.setStyle(labelStyle);
        formGrid.add(correoLabel, 0, 3);
        formGrid.add(correoField, 1, 3);

        Label contraseñaLabel = new Label("Contraseña:");
        contraseñaLabel.setStyle(labelStyle);
        formGrid.add(contraseñaLabel, 0, 4);
        formGrid.add(contraseñaField, 1, 4);

        Label valorMensualidadLabel = new Label("Valor Mensualidad:");
        valorMensualidadLabel.setStyle(labelStyle);
        formGrid.add(valorMensualidadLabel, 0, 5);
        formGrid.add(valorMensualidadField, 1, 5);

        Label cedulaInvitadoLabel = new Label("Cédula del Invitado:");
        cedulaInvitadoLabel.setStyle(labelStyle);
        formGrid.add(cedulaInvitadoLabel, 0, 6);
        formGrid.add(cedulaInvitadoField, 1, 6);
        Button registrarButton = new Button("Registrar Afiliado");
        registrarButton.setMaxWidth(Double.MAX_VALUE);
        registrarButton.setStyle(buttonStyle);
        formGrid.add(registrarButton, 1, 7);

        Label errorLabel = new Label();
        errorLabel.setStyle("-fx-text-fill: red;");

        VBox vbox = new VBox(formGrid);
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(20));

        Scene registrationScene = new Scene(vbox, 450, 400);
        registrationScene.getRoot().setStyle(fontStyle);
        primaryStage.setScene(registrationScene);
        primaryStage.show();

        registrarButton.setOnAction(event -> {
            try {
                String documento = documentoField.getText();
                String nombre = nombreField.getText();
                String correo = correoField.getText();
                String contraseña = contraseñaField.getText();
                Double valorMensualidad = Double.parseDouble(valorMensualidadField.getText());
                String cedulaInvitado = cedulaInvitadoField.getText().isEmpty() ? null : cedulaInvitadoField.getText();

                controladorUsuarioAfiliado.registrarUsuarioAfiliado(documento, nombre,
                        correo, contraseña,
                        valorMensualidad,
                        cedulaInvitado);

                alert.showConfirmation("El usuario afiliado registrado", "El usuario afiliado sido registrado con éxito.");

                documentoField.clear();
                nombreField.clear();
                correoField.clear();
                contraseñaField.clear();
                valorMensualidadField.clear();
                cedulaInvitadoField.clear();
            } catch (Exception e) {
                errorLabel.setText("Error: " + e.getMessage());
            }
        });
    }

}
