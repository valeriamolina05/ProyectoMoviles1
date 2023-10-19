package org.example.gui.registros;



import org.example.controladores.ControladorEntidadCultural;
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

public class ShowEntidadCulturalRegistrationForm {
    private Alerts alert = new Alerts();
    
    public void showEntidadCulturalRegistrationForm(Stage primaryStage, ControladorEntidadCultural controladorEcultural, String fontStyle, String buttonStyle, String labelStyle, String titleLabelStyle) {
        primaryStage.setTitle("Registro de Entidad Cultural");

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setAlignment(Pos.CENTER);

        Label titleLabel = new Label("Registro de Entidad Cultural");
        GridPane.setHalignment(titleLabel, HPos.CENTER);
        titleLabel.setStyle(titleLabelStyle);

        Label nitLabel = new Label("NIT:");
        nitLabel.setStyle(labelStyle);
        TextField nitField = new TextField();

        Label nombreLabel = new Label("Nombre:");
        nombreLabel.setStyle(labelStyle);
        TextField nombreField = new TextField();

        Label descripcionLabel = new Label("Descripción:");
        descripcionLabel.setStyle(labelStyle);
        TextField descripcionField = new TextField();

        Label ubicacionLabel = new Label("Ubicación (ingrese un número):");
        ubicacionLabel.setStyle(labelStyle);
        TextField ubicacionField = new TextField();

        Label misionLabel = new Label("Misión:");
        misionLabel.setStyle(labelStyle);
        TextField misionField = new TextField();

        Label organizacionLabel = new Label("Organización:");
        organizacionLabel.setStyle(labelStyle);
        TextField organizacionField = new TextField();

        Label telefonoLabel = new Label("Teléfono:");
        telefonoLabel.setStyle(labelStyle);
        TextField telefonoField = new TextField();

        Label correoLabel = new Label("Correo:");
        correoLabel.setStyle(labelStyle);
        TextField correoField = new TextField();

        Button registerButton = new Button("Registrar Entidad Cultural");
        registerButton.setStyle(buttonStyle);
        registerButton.setMaxWidth(Double.MAX_VALUE); // Centra el botón

        Label errorLabel = new Label();
        errorLabel.setStyle("-fx-text-fill: red;");

        grid.add(titleLabel, 0, 0, 2, 1);
        grid.add(nitLabel, 0, 1);
        grid.add(nitField, 1, 1);
        grid.add(nombreLabel, 0, 2);
        grid.add(nombreField, 1, 2);
        grid.add(descripcionLabel, 0, 3);
        grid.add(descripcionField, 1, 3);
        grid.add(ubicacionLabel, 0, 4);
        grid.add(ubicacionField, 1, 4);
        grid.add(misionLabel, 0, 5);
        grid.add(misionField, 1, 5);
        grid.add(organizacionLabel, 0, 6);
        grid.add(organizacionField, 1, 6);
        grid.add(telefonoLabel, 0, 7);
        grid.add(telefonoField, 1, 7);
        grid.add(correoLabel, 0, 8);
        grid.add(correoField, 1, 8);
        grid.add(registerButton, 0, 9, 2, 1);
        grid.add(errorLabel, 0, 10, 2, 1);

        VBox vbox = new VBox(grid);
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(20));

        Scene scene = new Scene(vbox, 450, 400);
        scene.getRoot().setStyle(fontStyle);
        primaryStage.setScene(scene);

        registerButton.setOnAction(event -> {
            try {
                String nit = nitField.getText();
                String nombre = nombreField.getText();
                String descripcion = descripcionField.getText();
                Integer ubicacion = Integer.parseInt(ubicacionField.getText());
                String mision = misionField.getText();
                String organizacion = organizacionField.getText();
                String telefono = telefonoField.getText();
                String correo = correoField.getText();

                controladorEcultural.registrarEmpresa(nit, nombre, descripcion, ubicacion,
                        mision, organizacion,
                        telefono, correo);
                alert.showConfirmation("Empresa registrada", "La Empresa ha sido registrado con éxito.");

                nitField.clear();
                nombreField.clear();
                descripcionField.clear();
                ubicacionField.clear();
                misionField.clear();
                organizacionField.clear();
                telefonoField.clear();
                correoField.clear();
            } catch (Exception e) {
                errorLabel.setText("Error: " + e.getMessage());
            }
        });

        primaryStage.show();
    }

}
