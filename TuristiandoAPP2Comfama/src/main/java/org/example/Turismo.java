package org.example;

import org.example.controladores.ControladorEmpresaPrivada;
import org.example.controladores.ControladorEntidadCultural;
import org.example.controladores.ControladorEvento;
import org.example.controladores.ControladorUsuarioAfiliado;
import org.example.controladores.ControladorUsuarioOcacional;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Turismo extends Application {
    private ControladorEmpresaPrivada controladorEPrivada = new ControladorEmpresaPrivada();
    private ControladorEntidadCultural controladorEcultural = new ControladorEntidadCultural();
    private ControladorEvento controladorEvento = new ControladorEvento();
    private ControladorUsuarioOcacional controladorUsuarioOcacional = new ControladorUsuarioOcacional();
    private ControladorUsuarioAfiliado controladorUsuarioAfiliado = new ControladorUsuarioAfiliado();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Sistema de Registro de Turismo");

        VBox vbox = new VBox();
        vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(20);

        Scene scene = new Scene(vbox, 400, 300);
        primaryStage.setScene(scene);

        Label titleLabel = new Label("Menú de Opciones");
        titleLabel.setStyle("-fx-font-size: 16px;");

        Button registerEmpresaButton = new Button("Registrar Empresa Privada");
        registerEmpresaButton.setStyle("-fx-background-color: #009688; -fx-text-fill: white;");
        Button registerEntidadCulturalButton = new Button("Registrar Entidad Cultural");
        registerEntidadCulturalButton.setStyle("-fx-background-color: #009688; -fx-text-fill: white;");
        Button registerEventoButton = new Button("Registrar Evento");
        registerEventoButton.setStyle("-fx-background-color: #009688; -fx-text-fill: white;");
        Button registerUsuarioAfiliadoButton = new Button("Registrar Usuario Afiliado");
        registerUsuarioAfiliadoButton.setStyle("-fx-background-color: #009688; -fx-text-fill: white;");
        Button registerUsuarioOcasionalButton = new Button("Registrar Usuario Ocasional");
        registerUsuarioOcasionalButton.setStyle("-fx-background-color: #009688; -fx-text-fill: white;");

        vbox.getChildren().addAll(titleLabel, registerEmpresaButton, registerEntidadCulturalButton,
                registerEventoButton, registerUsuarioAfiliadoButton, registerUsuarioOcasionalButton);

        registerEmpresaButton.setOnAction(event -> showEmpresaRegistrationForm(primaryStage));
        registerEntidadCulturalButton.setOnAction(event -> showEntidadCulturalRegistrationForm(primaryStage));
        registerEventoButton.setOnAction(event -> showEventoRegistrationForm(primaryStage));
        registerUsuarioAfiliadoButton.setOnAction(event -> showUsuarioAfiliadoRegistrationForm(primaryStage));
        registerUsuarioOcasionalButton.setOnAction(event -> showUsuarioOcasionalRegistrationForm(primaryStage));

        primaryStage.setOnCloseRequest(closeEvent -> {
            primaryStage.close();
        });
        primaryStage.show();

    }

    private void showEmpresaRegistrationForm(Stage primaryStage) {
        Stage empresaRegistrationStage = new Stage();
        empresaRegistrationStage.setTitle("Registro de Empresa Privada");

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 20, 20, 20));

        Scene scene = new Scene(grid, 400, 300);
        empresaRegistrationStage.setScene(scene);

        Label titleLabel = new Label("Registro de Empresa Privada");
        grid.add(titleLabel, 0, 0);

        Label nitLabel = new Label("NIT:");
        grid.add(nitLabel, 0, 1);
        TextField nitField = new TextField();
        grid.add(nitField, 1, 1);

        Label nombreLabel = new Label("Nombre:");
        grid.add(nombreLabel, 0, 2);
        TextField nombreField = new TextField();
        grid.add(nombreField, 1, 2);

        Label descripcionLabel = new Label("Descripción:");
        grid.add(descripcionLabel, 0, 3);
        TextField descripcionField = new TextField();
        grid.add(descripcionField, 1, 3);

        Label ubicacionLabel = new Label("Ubicación (Número):");
        grid.add(ubicacionLabel, 0, 4);
        TextField ubicacionField = new TextField();
        grid.add(ubicacionField, 1, 4);

        Label representanteLabel = new Label("Nombre del Representante:");
        grid.add(representanteLabel, 0, 5);
        TextField representanteField = new TextField();
        grid.add(representanteField, 1, 5);

        Label cedulaRepresentanteLabel = new Label("Cédula del Representante:");
        grid.add(cedulaRepresentanteLabel, 0, 6);
        TextField cedulaRepresentanteField = new TextField();
        grid.add(cedulaRepresentanteField, 1, 6);

        Button registerButton = new Button("Registrar");
        registerButton.setStyle("-fx-background-color: #009688; -fx-text-fill: white;");
        grid.add(registerButton, 0, 7);

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
                controladorEPrivada.registrarEmpresa(nit, nombre, descripcion, ubicacion, nombreRepresentante,
                        cedulaRepresentante);

                // Cierra la ventana de registro
                mostrarConfirmacion("Empresa registrada", "La Empresa ha sido registrada con éxito.");
                primaryStage.close();
                start(primaryStage);
            } catch (Exception e) {
                errorLabel.setText("Error: " + e.getMessage());
            }
        });

        primaryStage.setOnCloseRequest(closeEvent -> {
            closeEvent.consume();
            start(primaryStage);
        });

        VBox vbox = new VBox(grid);
        vbox.setAlignment(Pos.CENTER);

        Scene registrationScene = new Scene(vbox, 400, 300);
        empresaRegistrationStage.setScene(registrationScene);

        empresaRegistrationStage.show();
    }

    private void showEntidadCulturalRegistrationForm(Stage primaryStage) {
        primaryStage.setTitle("Registro de Entidad Cultural");

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);

        Label titleLabel = new Label("Registro de Entidad Cultural");
        titleLabel.setStyle("-fx-font-size: 16px;");

        Label nitLabel = new Label("NIT:");
        TextField nitField = new TextField();

        Label nombreLabel = new Label("Nombre:");
        TextField nombreField = new TextField();

        Label descripcionLabel = new Label("Descripción:");
        TextField descripcionField = new TextField();

        Label ubicacionLabel = new Label("Ubicación (ingrese un número):");
        TextField ubicacionField = new TextField();

        Label misionLabel = new Label("Misión:");
        TextField misionField = new TextField();

        Label organizacionLabel = new Label("Organización:");
        TextField organizacionField = new TextField();

        Label telefonoLabel = new Label("Teléfono:");
        TextField telefonoField = new TextField();

        Label correoLabel = new Label("Correo:");
        TextField correoField = new TextField();

        Button registerButton = new Button("Registrar Entidad Cultural");
        registerButton.setStyle("-fx-background-color: #009688; -fx-text-fill: white;");

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

        Scene scene = new Scene(vbox, 400, 400);
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

                controladorEcultural.registrarEmpresa(nit, nombre, descripcion, ubicacion, mision, organizacion,
                        telefono, correo);
                mostrarConfirmacion("Empresa registrada", "La Empresa ha sido registrado con éxito.");
                primaryStage.close();
                start(primaryStage);
            } catch (Exception e) {
                errorLabel.setText("Error: " + e.getMessage());
            }
        });
        primaryStage.setOnCloseRequest(closeEvent -> {
            closeEvent.consume();
            start(primaryStage);
        });

        primaryStage.show();
    }

    private void showEventoRegistrationForm(Stage primaryStage) {
        Stage eventoStage = new Stage();
        eventoStage.setTitle("Registro de Evento");

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 20, 20, 20));

        Scene eventoScene = new Scene(grid, 400, 400);
        eventoStage.setScene(eventoScene);

        Label titleLabel = new Label("Registro de Evento");
        titleLabel.setFont(new Font("Arial", 16));
        GridPane.setHalignment(titleLabel, HPos.CENTER);
        grid.add(titleLabel, 0, 0, 2, 1);

        Label tituloLabel = new Label("Título:");
        grid.add(tituloLabel, 0, 1);
        TextField tituloField = new TextField();
        grid.add(tituloField, 1, 1);

        Label descripcionLabel = new Label("Descripción:");
        grid.add(descripcionLabel, 0, 2);
        TextField descripcionField = new TextField();
        grid.add(descripcionField, 1, 2);

        Label fechaInicioLabel = new Label("Fecha de Inicio (dd/MM/yyyy HH:mm):");
        grid.add(fechaInicioLabel, 0, 3);
        TextField fechaInicioField = new TextField();
        grid.add(fechaInicioField, 1, 3);

        Label fechaFinLabel = new Label("Fecha de Fin (dd/MM/yyyy HH:mm):");
        grid.add(fechaFinLabel, 0, 4);
        TextField fechaFinField = new TextField();
        grid.add(fechaFinField, 1, 4);

        Label costoPersonaLabel = new Label("Costo por Persona:");
        grid.add(costoPersonaLabel, 0, 5);
        TextField costoPersonaField = new TextField();
        grid.add(costoPersonaField, 1, 5);

        Label categoriaLabel = new Label("Categoría:");
        grid.add(categoriaLabel, 0, 6);
        TextField categoriaField = new TextField();
        grid.add(categoriaField, 1, 6);

        Label ubicacionLabel = new Label("Ubicación:");
        grid.add(ubicacionLabel, 0, 7);
        TextField ubicacionField = new TextField();
        grid.add(ubicacionField, 1, 7);

        Label idECulturalLabel = new Label("ID de la Entidad Cultural:");
        grid.add(idECulturalLabel, 0, 8);
        TextField idECulturalField = new TextField();
        grid.add(idECulturalField, 1, 8);

        Label idEPrivadaLabel = new Label("ID de la Empresa Privada:");
        grid.add(idEPrivadaLabel, 0, 9);
        TextField idEPrivadaField = new TextField();
        grid.add(idEPrivadaField, 1, 9);

        Button registrarEventoButton = new Button("Registrar Evento");
        GridPane.setHalignment(registrarEventoButton, HPos.CENTER);
        registrarEventoButton.setStyle("-fx-background-color: #009688; -fx-text-fill: white;");
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
                String ubicacion = ubicacionField.getText();
                Integer idECultural = Integer.parseInt(idECulturalField.getText());
                Integer idEPrivada = idEPrivadaField.getText().isEmpty() ? null
                        : Integer.parseInt(idEPrivadaField.getText());

                controladorEvento.registrarEvento(titulo, descripcion, fechaInicio, fechaFin, costoPersona, categoria,
                        ubicacion, idECultural, idEPrivada);
                mostrarConfirmacion("Evento registrado", "El evento ha sido registrado con éxito.");
                primaryStage.close();
                eventoStage.close();
                start(primaryStage);
            } catch (Exception e) {
                errorLabel.setText("Error: " + e.getMessage());
            }
        });

        primaryStage.setOnCloseRequest(closeEvent -> {
            closeEvent.consume();
            start(primaryStage);
        });
        VBox vbox = new VBox(grid);
        vbox.setAlignment(Pos.CENTER);

        Scene scene = new Scene(vbox, 400, 400);
        eventoStage.setScene(scene);

        eventoStage.showAndWait();
    }

    private void showUsuarioAfiliadoRegistrationForm(Stage primaryStage) {
        primaryStage.setTitle("Registro de Usuario Afiliado");

        GridPane formGrid = new GridPane();
        formGrid.setHgap(10);
        formGrid.setVgap(10);

        TextField documentoField = new TextField();
        TextField nombreField = new TextField();
        TextField correoField = new TextField();
        PasswordField contraseñaField = new PasswordField();
        TextField valorMensualidadField = new TextField();
        TextField cedulaInvitadoField = new TextField("0");

        Label titleLabel = new Label("Registro de Usuario Afiliado");
        formGrid.add(titleLabel, 0, 0);

        Label documentoLabel = new Label("Documento:");
        formGrid.add(documentoLabel, 0, 1);
        formGrid.add(documentoField, 1, 1);

        Label nombreLabel = new Label("Nombre:");
        formGrid.add(nombreLabel, 0, 2);
        formGrid.add(nombreField, 1, 2);

        Label correoLabel = new Label("Correo:");
        formGrid.add(correoLabel, 0, 3);
        formGrid.add(correoField, 1, 3);

        Label contraseñaLabel = new Label("Contraseña:");
        formGrid.add(contraseñaLabel, 0, 4);
        formGrid.add(contraseñaField, 1, 4);

        Label valorMensualidadLabel = new Label("Valor Mensualidad:");
        formGrid.add(valorMensualidadLabel, 0, 5);
        formGrid.add(valorMensualidadField, 1, 5);

        Label cedulaInvitadoLabel = new Label("Cédula del Invitado:");
        formGrid.add(cedulaInvitadoLabel, 0, 6);
        formGrid.add(cedulaInvitadoField, 1, 6);

        Button registrarButton = new Button("Registrar");
        registrarButton.setStyle("-fx-background-color: #009688; -fx-text-fill: white;");
        formGrid.add(registrarButton, 1, 7);

        Label errorLabel = new Label();
        errorLabel.setStyle("-fx-text-fill: red;");

        registrarButton.setOnAction(event -> {
            try {
                String documento = documentoField.getText();
                String nombre = nombreField.getText();
                String correo = correoField.getText();
                String contraseña = contraseñaField.getText();
                Double valorMensualidad = Double.parseDouble(valorMensualidadField.getText());
                String cedulaInvitado = cedulaInvitadoField.getText();

                controladorUsuarioAfiliado.registrarUsuarioAfiliado(documento, nombre, correo, contraseña,
                        valorMensualidad,
                        cedulaInvitado);

                mostrarConfirmacion("El usuario afiliado registrado", "El usuario afiliado sido registrado con éxito.");
                start(primaryStage);
            } catch (Exception e) {
                errorLabel.setText("Error: " + e.getMessage());
            }
        });

        primaryStage.setOnCloseRequest(closeEvent -> {
            closeEvent.consume();
            start(primaryStage);
        });

        VBox vbox = new VBox(formGrid);
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(20));

        Scene registrationScene = new Scene(vbox, 400, 300);
        primaryStage.setScene(registrationScene);
        primaryStage.show();
    }

    private void showUsuarioOcasionalRegistrationForm(Stage primaryStage) {
        primaryStage.setTitle("Registro de Usuario Ocasional");

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);

        Label titleLabel = new Label("Registro de Usuario Ocasional");
        titleLabel.setStyle("-fx-font-size: 16px;");
        grid.add(titleLabel, 0, 0, 2, 1);

        Label documentoLabel = new Label("Documento:");
        grid.add(documentoLabel, 0, 1);
        TextField documentoField = new TextField();
        grid.add(documentoField, 1, 1);

        Label nombreLabel = new Label("Nombre:");
        grid.add(nombreLabel, 0, 2);
        TextField nombreField = new TextField();
        grid.add(nombreField, 1, 2);

        Label correoLabel = new Label("Correo:");
        grid.add(correoLabel, 0, 3);
        TextField correoField = new TextField();
        grid.add(correoField, 1, 3);

        Label contraseñaLabel = new Label("Contraseña:");
        grid.add(contraseñaLabel, 0, 4);
        PasswordField contraseñaField = new PasswordField();
        grid.add(contraseñaField, 1, 4);

        Label valorCuotaLabel = new Label("Valor de Cuota:");
        grid.add(valorCuotaLabel, 0, 5);
        TextField valorCuotaField = new TextField("0.00");
        grid.add(valorCuotaField, 1, 5);

        Button registrarButton = new Button("Registrar Usuario Ocasional");
        registrarButton.setStyle("-fx-background-color: #009688; -fx-text-fill: white;");
        grid.add(registrarButton, 1, 6);

        Label errorLabel = new Label();
        errorLabel.setStyle("-fx-text-fill: red;");

        registrarButton.setOnAction(event -> {
            try {
                String documento = documentoField.getText();
                String nombre = nombreField.getText();
                String correo = correoField.getText();
                String contraseña = contraseñaField.getText();
                Double valorCuota = Double.parseDouble(valorCuotaField.getText());

                controladorUsuarioOcacional.registrarUsuarioOcasional(documento, nombre, correo, contraseña,
                        valorCuota);

                mostrarConfirmacion("Usuario ocasional registrado",
                        "El usuario ocasional ha sido registrado con éxito.");
                primaryStage.close();
                start(primaryStage);
            } catch (Exception e) {
                errorLabel.setText("Error: " + e.getMessage());
            }
        });

        primaryStage.setOnCloseRequest(closeEvent -> {
            closeEvent.consume();
            start(primaryStage);
        });

        VBox vbox = new VBox(grid);
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(20));

        Scene scene = new Scene(vbox, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void mostrarConfirmacion(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
