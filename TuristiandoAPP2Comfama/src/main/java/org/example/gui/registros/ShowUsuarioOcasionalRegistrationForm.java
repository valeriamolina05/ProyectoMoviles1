package org.example.gui.registros;



import org.example.controladores.ControladorUsuarioOcasional;
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

public class ShowUsuarioOcasionalRegistrationForm {
    private Alerts alert = new Alerts();
    

    public void showUsuarioOcasionalRegistrationForm(Stage primaryStage, ControladorUsuarioOcasional controladorUsuarioOcasional , String fontStyle, String buttonStyle, String labelStyle, String titleLabelStyle) {
        primaryStage.setTitle("Registro de Usuario Ocasional");
        

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setAlignment(Pos.CENTER);

        Label titleLabel = new Label("Registro de Usuario Ocasional");
        GridPane.setHalignment(titleLabel, HPos.CENTER);
        titleLabel.setStyle(titleLabelStyle);
        grid.add(titleLabel, 0, 0, 2, 1);

        Label documentoLabel = new Label("Documento:");
        documentoLabel.setStyle(labelStyle);
        grid.add(documentoLabel, 0, 1);
        TextField documentoField = new TextField();
        grid.add(documentoField, 1, 1);

        Label nombreLabel = new Label("Nombre:");
        nombreLabel.setStyle(labelStyle);
        grid.add(nombreLabel, 0, 2);
        TextField nombreField = new TextField();
        grid.add(nombreField, 1, 2);

        Label correoLabel = new Label("Correo:");
        correoLabel.setStyle(labelStyle);
        grid.add(correoLabel, 0, 3);
        TextField correoField = new TextField();
        grid.add(correoField, 1, 3);

        Label contraseñaLabel = new Label("Contraseña:");
        contraseñaLabel.setStyle(labelStyle);
        grid.add(contraseñaLabel, 0, 4);
        PasswordField contraseñaField = new PasswordField();
        grid.add(contraseñaField, 1, 4);

        Label valorCuotaLabel = new Label("Valor de Cuota:");
        valorCuotaLabel.setStyle(labelStyle);
        grid.add(valorCuotaLabel, 0, 5);
        TextField valorCuotaField = new TextField();
        grid.add(valorCuotaField, 1, 5);

        Button registrarButton = new Button("Registrar Usuario Ocasional");
        registrarButton.setStyle(buttonStyle);
        registrarButton.setMaxWidth(Double.MAX_VALUE);
        grid.add(registrarButton, 1, 6);

        Label errorLabel = new Label();
        errorLabel.setStyle("-fx-text-fill: red;");

        VBox vbox = new VBox(grid);
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(20));

        Scene scene = new Scene(vbox, 450, 400);
        scene.getRoot().setStyle(fontStyle);
        primaryStage.setScene(scene);
        primaryStage.show();

        registrarButton.setOnAction(event -> {
            try {
                String documento = documentoField.getText();
                String nombre = nombreField.getText();
                String correo = correoField.getText();
                String contraseña = contraseñaField.getText();
                Double valorCuota = valorCuotaField.getText().isEmpty() ? null
                        : Double.parseDouble(valorCuotaField.getText());
                controladorUsuarioOcasional.registrarUsuarioOcasional(documento, nombre, correo, contraseña,
                        valorCuota);

                alert.showConfirmation("Usuario ocasional registrado", "El usuario ocasional ha sido registrado con éxito.");

                documentoField.clear();
                nombreField.clear();
                correoField.clear();
                contraseñaField.clear();
                valorCuotaField.clear();
            } catch (Exception e) {
                errorLabel.setText("Error: " + e.getMessage());
            }
        });
    }

}
