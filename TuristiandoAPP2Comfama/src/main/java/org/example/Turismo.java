package org.example;

import org.example.controladores.ControladorEmpresaPrivada;
import org.example.controladores.ControladorEntidadCultural;
import org.example.controladores.ControladorEvento;
import org.example.controladores.ControladorUsuarioAfiliado;
import org.example.controladores.ControladorUsuarioOcasional;
import org.example.modelos.ModeloAfiliado;
import org.example.modelos.ModeloEmpresaPrivada;
import org.example.modelos.ModeloEntidadCultural;
import org.example.modelos.ModeloEvento;
import org.example.modelos.ModeloOcasional;

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
    private ControladorUsuarioOcasional controladorUsuarioOcasional = new ControladorUsuarioOcasional();
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

        Scene scene = new Scene(vbox, 400, 650);
        primaryStage.setScene(scene);

        Label titleLabel = new Label("Menú de Opciones");
        titleLabel.setStyle("-fx-font-size: 16px;");

        Button registerEmpresaButton = new Button("Registrar Empresa Privada");
        registerEmpresaButton.setStyle("-fx-background-color: #009688; -fx-text-fill:white;");
        Button registerEntidadCulturalButton = new Button("Registrar Entidad Cultural");
        registerEntidadCulturalButton.setStyle("-fx-background-color: #009688;-fx-text-fill: white;");
        Button registerEventoButton = new Button("Registrar Evento");
        registerEventoButton.setStyle("-fx-background-color: #009688; -fx-text-fill:white;");
        Button registerUsuarioAfiliadoButton = new Button("Registrar Usuario Afiliado");
        registerUsuarioAfiliadoButton.setStyle("-fx-background-color: #009688;-fx-text-fill: white;");
        Button registerUsuarioOcasionalButton = new Button("Registrar Usuario Ocasional");
        registerUsuarioOcasionalButton.setStyle("-fx-background-color: #009688;-fx-text-fill: white;");

        Button buscarEmpresaButton = new Button("Buscar Empresa Privada");
        buscarEmpresaButton.setStyle("-fx-background-color: #009688; -fx-text-fill:white;");
        Button buscarEntidadCulturalButton = new Button("Buscar Entidad Cultural");
        buscarEntidadCulturalButton.setStyle("-fx-background-color: #009688;-fx-text-fill: white;");
        Button buscarEventoButton = new Button("Buscar Evento");
        buscarEventoButton.setStyle("-fx-background-color: #009688; -fx-text-fill:white;");
        Button buscarUsuarioAfiliadoButton = new Button("Buscar Usuario Afiliado");
        buscarUsuarioAfiliadoButton.setStyle("-fx-background-color: #009688;-fx-text-fill: white;");
        Button buscarUsuarioOcasionalButton = new Button("Buscar Usuario Ocasional");
        buscarUsuarioOcasionalButton.setStyle("-fx-background-color: #009688;-fx-text-fill: white;");

        vbox.getChildren().addAll(
                titleLabel,
                registerEmpresaButton,
                registerEntidadCulturalButton,
                registerEventoButton,
                registerUsuarioAfiliadoButton,
                registerUsuarioOcasionalButton,
                buscarEmpresaButton,
                buscarEntidadCulturalButton,
                buscarEventoButton,
                buscarUsuarioAfiliadoButton,
                buscarUsuarioOcasionalButton);

        registerEmpresaButton.setOnAction(event -> showEmpresaRegistrationForm(primaryStage));
        registerEntidadCulturalButton.setOnAction(event -> showEntidadCulturalRegistrationForm(primaryStage));
        registerEventoButton.setOnAction(event -> showEventoRegistrationForm(primaryStage));
        registerUsuarioAfiliadoButton.setOnAction(event -> showUsuarioAfiliadoRegistrationForm(primaryStage));
        registerUsuarioOcasionalButton.setOnAction(event -> showUsuarioOcasionalRegistrationForm(primaryStage));

        buscarEmpresaButton.setOnAction(event -> showBuscarEmpresaPrivadaForm(primaryStage));
        buscarEntidadCulturalButton.setOnAction(event -> showBuscarEntidadCulturalForm(primaryStage));
        buscarEventoButton.setOnAction(event -> showBuscarEventoForm(primaryStage));
        buscarUsuarioAfiliadoButton.setOnAction(event -> showBuscarUsuarioAfiliadoForm(primaryStage));
        buscarUsuarioOcasionalButton.setOnAction(event -> showBuscarUsuarioOcasionalForm(primaryStage));

        primaryStage.setOnCloseRequest(closeEvent -> {
            primaryStage.close();
        });
        primaryStage.show();
    }

    private void showEmpresaRegistrationForm(Stage primaryStage) {
        primaryStage.setTitle("Registro de Empresa Privada");

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 20, 20, 20));

        Label titleLabel = new Label("Registro de Empresa Privada");
        grid.add(titleLabel, 0, 0, 2, 1);

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

        Button registerButton = new Button("Registrar Empresa Privada");
        registerButton.setStyle("-fx-background-color: #009688; -fx-text-fill:white;");
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
                mostrarConfirmacion("Empresa registrada", "La Empresa ha sido registrada con éxito.");

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

        primaryStage.setOnCloseRequest(closeEvent -> {
            closeEvent.consume();
            start(primaryStage);
        });

        VBox vbox = new VBox(grid);
        vbox.setAlignment(Pos.CENTER);

        Scene registrationScene = new Scene(vbox, 350, 300);
        primaryStage.setScene(registrationScene);

        primaryStage.show();
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
        registerButton.setStyle("-fx-background-color: #009688; -fx-text-fill:white;");
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

                controladorEcultural.registrarEmpresa(nit, nombre, descripcion, ubicacion,
                        mision, organizacion,
                        telefono, correo);
                mostrarConfirmacion("Empresa registrada", "La Empresa ha sido registrado con éxito.");

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

        primaryStage.setOnCloseRequest(closeEvent -> {
            closeEvent.consume();
            start(primaryStage);
        });

        primaryStage.show();
    }

    private void showEventoRegistrationForm(Stage primaryStage) {
        primaryStage.setTitle("Registro de Evento");

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 20, 20, 20));

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

        Label categoriaLabel = new Label("Categoría (arte, musica, teatro, biblioteca, otros):");
        grid.add(categoriaLabel, 0, 6);
        TextField categoriaField = new TextField();
        grid.add(categoriaField, 1, 6);

        Label ubicacionLabel = new Label("Zona (rural, urbana, centro, otro):");
        grid.add(ubicacionLabel, 0, 7);

        ChoiceBox<String> ubicacionChoice = new ChoiceBox<>();
        ubicacionChoice.getItems().addAll("Rural", "Urbana", "Centro", "Otro");
        ubicacionChoice.setValue("Otro"); // Establece un valor predeterminado
        grid.add(ubicacionChoice, 1, 7);

        Label idECulturalLabel = new Label("ID de la Entidad Cultural:");
        grid.add(idECulturalLabel, 0, 8);
        TextField idECulturalField = new TextField();
        grid.add(idECulturalField, 1, 8);

        Label idEPrivadaLabel = new Label("ID de la Empresa Privada:");
        grid.add(idEPrivadaLabel, 0, 9);
        TextField idEPrivadaField = new TextField();
        grid.add(idEPrivadaField, 1, 9);

        Button registrarEventoButton = new Button("Registrar Evento");
        registrarEventoButton.setMaxWidth(Double.MAX_VALUE);
        registrarEventoButton.setStyle("-fx-background-color: #009688; -fx-text-fill:white;");
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
                String ubicacion = ubicacionChoice.getValue();
                Integer idECultural = idECulturalField.getText().isEmpty() ? null
                        : Integer.parseInt(idECulturalField.getText());
                Integer idEPrivada = idEPrivadaField.getText().isEmpty() ? null
                        : Integer.parseInt(idEPrivadaField.getText());

                controladorEvento.registrarEvento(titulo, descripcion, fechaInicio, fechaFin,
                        costoPersona, categoria,
                        ubicacion, idECultural, idEPrivada);
                mostrarConfirmacion("Evento registrado", "El evento ha sido registrado con éxito.");

                tituloField.clear();
                descripcionField.clear();
                fechaInicioField.clear();
                fechaFinField.clear();
                costoPersonaField.clear();
                categoriaField.clear();
                ubicacionChoice.setValue("Otro");
                idECulturalField.clear();
                idEPrivadaField.clear();
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

        Scene scene = new Scene(vbox, 455, 400);
        primaryStage.setScene(scene);

        primaryStage.show();
    }

    private void showUsuarioAfiliadoRegistrationForm(Stage primaryStage) {
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
        formGrid.add(titleLabel, 0, 0, 2, 1);

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

        Button registrarButton = new Button("Registrar Afiliado");
        registrarButton.setMaxWidth(Double.MAX_VALUE);
        registrarButton.setStyle("-fx-background-color: #009688; -fx-text-fill:white;");
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
                String cedulaInvitado = cedulaInvitadoField.getText().isEmpty() ? null : cedulaInvitadoField.getText();

                controladorUsuarioAfiliado.registrarUsuarioAfiliado(documento, nombre,
                        correo, contraseña,
                        valorMensualidad,
                        cedulaInvitado);

                mostrarConfirmacion("El usuario afiliado registrado", "El usuario afiliado sido registrado con éxito.");

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
        TextField valorCuotaField = new TextField();
        grid.add(valorCuotaField, 1, 5);

        Button registrarButton = new Button("Registrar Usuario Ocasional");
        registrarButton.setStyle("-fx-background-color: #009688; -fx-text-fill:white;");
        registrarButton.setMaxWidth(Double.MAX_VALUE);
        grid.add(registrarButton, 1, 6);

        Label errorLabel = new Label();
        errorLabel.setStyle("-fx-text-fill: red;");

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

                mostrarConfirmacion("Usuario ocasional registrado",
                        "El usuario ocasional ha sido registrado con éxito.");

                documentoField.clear();
                nombreField.clear();
                correoField.clear();
                contraseñaField.clear();
                valorCuotaField.clear();
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

        Scene scene = new Scene(vbox, 350, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void showBuscarUsuarioAfiliadoForm(Stage primaryStage) {
        primaryStage.setTitle("Buscar Usuario Afiliado");

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);

        Label titleLabel = new Label("Búsqueda de Usuario Afiliado");
        titleLabel.setStyle("-fx-font-size: 16px;");
        grid.add(titleLabel, 0, 0, 2, 1);

        Label idLabel = new Label("ID del Usuario Afiliado:");
        grid.add(idLabel, 0, 1);
        TextField idField = new TextField();
        grid.add(idField, 1, 1);

        Button buscarButton = new Button("Buscar Afiliado");
        buscarButton.setStyle("-fx-background-color: #009688; -fx-text-fill:white;");
        grid.add(buscarButton, 1, 2);

        TextArea resultadoLabel = new TextArea("");
        resultadoLabel.setStyle("-fx-text-fill: green;");
        grid.add(resultadoLabel, 0, 3, 2, 1);

        buscarButton.setOnAction(event -> {
            try {
                int idUsuarioAfiliado = Integer.parseInt(idField.getText());
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

        primaryStage.setOnCloseRequest(closeEvent -> {
            closeEvent.consume();
            start(primaryStage);
        });

        VBox vbox = new VBox(grid);
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(20));

        Scene scene = new Scene(vbox, 400, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void showBuscarUsuarioOcasionalForm(Stage primaryStage) {
        primaryStage.setTitle("Buscar Usuario Ocasional");

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);

        Label titleLabel = new Label("Buscar Usuario Ocasional");
        titleLabel.setStyle("-fx-font-size: 16px;");
        grid.add(titleLabel, 0, 0, 2, 1);

        Label documentoLabel = new Label("Documento:");
        grid.add(documentoLabel, 0, 1);
        TextField documentoField = new TextField();
        grid.add(documentoField, 1, 1);

        Button buscarButton = new Button("Buscar Usuario Ocasional");
        buscarButton.setStyle("-fx-background-color: #009688; -fx-text-fill:white;");
        grid.add(buscarButton, 1, 2);

        TextArea resultadoLabel = new TextArea();
        grid.add(resultadoLabel, 0, 3, 2, 1);

        buscarButton.setOnAction(event -> {
            try {
                Integer documento = Integer.parseInt(documentoField.getText());
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

        primaryStage.setOnCloseRequest(closeEvent -> {
            closeEvent.consume();
            start(primaryStage);
        });

        VBox vbox = new VBox(grid);
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(20));

        Scene scene = new Scene(vbox, 400, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void showBuscarEntidadCulturalForm(Stage primaryStage) {
        primaryStage.setTitle("Buscar Entidad Cultural");

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);

        Label titleLabel = new Label("Buscar Entidad Cultural");
        titleLabel.setStyle("-fx-font-size: 16px;");
        grid.add(titleLabel, 0, 0, 2, 1);

        Label idLabel = new Label("ID de la Entidad Cultural:");
        grid.add(idLabel, 0, 1);
        TextField idField = new TextField();
        grid.add(idField, 1, 1);

        Button buscarButton = new Button("Buscar Entidad Cultural");
        buscarButton.setStyle("-fx-background-color: #009688; -fx-text-fill:white;");
        grid.add(buscarButton, 1, 2);

        TextArea resultadoLabel = new TextArea();
        grid.add(resultadoLabel, 0, 3, 2, 1);

        buscarButton.setOnAction(event -> {
            try {
                int idEntidadCultural = Integer.parseInt(idField.getText());
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

        primaryStage.setOnCloseRequest(closeEvent -> {
            closeEvent.consume();
            start(primaryStage);
        });

        VBox vbox = new VBox(grid);
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(20));

        Scene scene = new Scene(vbox, 400, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void showBuscarEmpresaPrivadaForm(Stage primaryStage) {

        primaryStage.setTitle("Búsqueda de Empresa Privada");

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);

        Label titleLabel = new Label("Búsqueda de Empresa Privada");
        titleLabel.setStyle("-fx-font-size: 16px;");
        grid.add(titleLabel, 0, 0, 2, 1);

        Label empresaPrivadaIdLabel = new Label("ID de la Empresa Privada:");
        grid.add(empresaPrivadaIdLabel, 0, 1);
        TextField empresaPrivadaIdField = new TextField();
        grid.add(empresaPrivadaIdField, 1, 1);

        Button buscarButton = new Button("Buscar Empresa Privada");
        buscarButton.setStyle("-fx-background-color: #009688; -fx-text-fill:white;");
        grid.add(buscarButton, 1, 2);

        TextArea resultadoArea = new TextArea();
        resultadoArea.setEditable(false);
        grid.add(resultadoArea, 0, 3, 2, 1);

        buscarButton.setOnAction(event -> {
            try {
                int idEmpresaPrivada = Integer.parseInt(empresaPrivadaIdField.getText());
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

    private void showBuscarEventoForm(Stage primaryStage) {
        primaryStage.setTitle("Buscar Evento");

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);

        Label titleLabel = new Label("Buscar Evento");
        titleLabel.setStyle("-fx-font-size: 16px;");
        grid.add(titleLabel, 0, 0, 2, 1);

        Label eventoIdLabel = new Label("ID del Evento:");
        grid.add(eventoIdLabel, 0, 1);
        TextField eventoIdField = new TextField();
        grid.add(eventoIdField, 1, 1);

        Button buscarButton = new Button("Buscar Evento");
        buscarButton.setStyle("-fx-background-color: #009688; -fx-text-fill:white;");
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

// public class Turismo {
// public static void main(String[] args) {

// Scanner scanner = new Scanner(System.in);

// System.out.println("Bienvenido al Sistema de Registro de Turismo");

// while (true) {
// System.out.println("\nMenú de Opciones:");
// System.out.println("1. Registrar Empresa Privada");
// System.out.println("2. Registrar Entidad Cultural");
// System.out.println("3. Registrar Evento");
// System.out.println("4. Registrar Usuario Afiliado");
// System.out.println("5. Registrar Usuario Ocasional");
// System.out.println("6. Buscar Usuario Afiliado");
// System.out.println("7. Buscar Usuario Ocasional");
// System.out.println("8. Buscar Empresa Privada");
// System.out.println("9. Buscar Entidad Cultural");
// System.out.println("10. Buscar Evento");
// System.out.println("11. Salir");
// System.out.print("Por favor, seleccione una opción (1-11): ");

// int opcion = scanner.nextInt();
// scanner.nextLine(); // Consumir el salto de línea

// switch (opcion) {
// case 1:
// registrarEmpresaPrivada(scanner);
// break;
// case 2:
// registrarEntidadCultural(scanner);
// break;
// case 3:
// registrarEvento(scanner);
// break;
// case 4:
// registrarUsuarioAfiliado(scanner);
// break;
// case 5:
// registrarUsuarioOcasional(scanner);
// break;
// case 6:
// buscarUsuarioAfiliado(scanner);
// break;
// case 7:
// buscarEmpresaPrivada(scanner);
// break;
// case 8:
// buscarEntidadCultural(scanner);
// break;
// case 9:
// buscarEvento(scanner);
// break;
// case 10:
// buscarUsuarioOcasional(scanner);
// break;
// case 11:
// System.out.println("Gracias por utilizar el Sistema de Registro de Turismo.
// ¡Hasta pronto!");
// System.exit(0);
// break;
// default:
// System.out.println("Opción no válida. Por favor, seleccione una opción
// válida.");
// }

// }
// }

// private static void registrarEmpresaPrivada(Scanner scanner) {
// System.out.println("Registro de Empresa Privada");
// System.out.print("NIT: ");
// String nit = scanner.nextLine();
// System.out.print("Nombre: ");
// String nombre = scanner.nextLine();
// System.out.print("Descripción: ");
// String descripcion = scanner.nextLine();
// System.out.print("Ubicación (ingrese un número): ");
// Integer ubicacion = scanner.nextInt();
// scanner.nextLine(); // Consumir el salto de línea
// System.out.print("Nombre del Representante: ");
// String nombreRepresentante = scanner.nextLine();
// System.out.print("Cédula del Representante: ");
// String cedulaRepresentante = scanner.nextLine();

// ControladorEmpresaPrivada controladorEPrivada = new
// ControladorEmpresaPrivada();
// controladorEPrivada.registrarEmpresa(nit, nombre, descripcion, ubicacion,
// nombreRepresentante,
// cedulaRepresentante);

// System.out.println("Empresa Privada registrada con éxito.");
// }

// private static void registrarEntidadCultural(Scanner scanner) {
// System.out.println("Registro de Entidad Cultural");
// System.out.print("NIT: ");
// String nit = scanner.nextLine();
// System.out.print("Nombre: ");
// String nombre = scanner.nextLine();
// System.out.print("Descripción: ");
// String descripcion = scanner.nextLine();
// System.out.print("Ubicación (ingrese un número): ");
// Integer ubicacion = scanner.nextInt();
// scanner.nextLine(); // Consumir el salto de línea
// System.out.print("Misión: ");
// String mision = scanner.nextLine();
// System.out.print("Organización: ");
// String organizacion = scanner.nextLine();
// System.out.print("Teléfono: ");
// String telefono = scanner.nextLine();
// System.out.print("Correo: ");
// String correo = scanner.nextLine();

// ControladorEntidadCultural controladorEcultural = new
// ControladorEntidadCultural();
// controladorEcultural.registrarEmpresa(nit, nombre, descripcion, ubicacion,
// mision, organizacion, telefono,
// correo);

// System.out.println("Entidad Cultural registrada con éxito.");
// }

// private static void registrarEvento(Scanner scanner) {
// System.out.println("Registro de Evento");
// System.out.print("Título: ");
// String titulo = scanner.nextLine();
// System.out.print("Descripción: ");
// String descripcion = scanner.nextLine();
// System.out.print("Fecha de Inicio (formato: dd/MM/yyyy HH:mm): ");
// String fechaInicio = scanner.nextLine();
// System.out.print("Fecha de Fin (formato: dd/MM/yyyy HH:mm): ");
// String fechaFin = scanner.nextLine();
// System.out.print("Costo por Persona: ");
// Double costoPersona = scanner.nextDouble();
// scanner.nextLine(); // Consumir el salto de línea
// System.out.print("Categoría: ");
// String categoria = scanner.nextLine();
// System.out.print("Ubicación: ");
// String ubicacion = scanner.nextLine();
// System.out.print("ID de la Entidad Cultural: ");
// Integer idECultural = scanner.nextInt();
// scanner.nextLine(); // Consumir el salto de línea
// System.out.print("ID de la Empresa Privada (deje en blanco si no aplica): ");
// String idEPrivadaInput = scanner.nextLine();

// // Convierte el ID de la Empresa Privada a Integer o lo deja como null
// Integer idEPrivada = null;
// if (!idEPrivadaInput.isEmpty()) {
// idEPrivada = Integer.parseInt(idEPrivadaInput);
// }

// ControladorEvento controladorEvento = new ControladorEvento();
// controladorEvento.registrarEvento(titulo, descripcion, fechaInicio, fechaFin,
// costoPersona, categoria,
// ubicacion, idECultural, idEPrivada);

// System.out.println("Evento registrado con éxito.");
// }

// private static void registrarUsuarioAfiliado(Scanner scanner) {
// System.out.println("Registro de Usuario Afiliado");
// System.out.print("Documento: ");
// String documento = scanner.nextLine();
// System.out.print("Nombre: ");
// String nombre = scanner.nextLine();
// System.out.print("Correo: ");
// String correo = scanner.nextLine();
// System.out.print("Contraseña: ");
// String contraseña = scanner.nextLine();
// System.out.print("Valor Mensualidad: ");
// Double valorMensualidad = scanner.nextDouble();
// scanner.nextLine(); // Consumir el salto de línea
// System.out.print("Cédula del Invitado (deje en blanco si no aplica): ");
// String cedulaInvitado = scanner.nextLine();

// ControladorUsuarioAfiliado controladorUsuarioAfiliado = new
// ControladorUsuarioAfiliado();
// controladorUsuarioAfiliado.registrarUsuarioAfiliado(documento, nombre,
// correo, contraseña, valorMensualidad,
// cedulaInvitado);

// System.out.println("Usuario Afiliado registrado con éxito.");
// }

// private static void registrarUsuarioOcasional(Scanner scanner) {
// System.out.println("Registro de Usuario Ocasional");
// System.out.print("Documento: ");
// String documento = scanner.nextLine();
// System.out.print("Nombre: ");
// String nombre = scanner.nextLine();
// System.out.print("Correo: ");
// String correo = scanner.nextLine();
// System.out.print("Contraseña: ");
// String contraseña = scanner.nextLine();
// System.out.print("Valor de Cuota: ");
// Double valorCuota = scanner.nextDouble();
// scanner.nextLine(); // Consumir el salto de línea

// ControladorUsuarioOcasional controladorUsuarioOcasional = new
// ControladorUsuarioOcasional();
// controladorUsuarioOcasional.registrarUsuarioOcasional(documento, nombre,
// correo, contraseña, valorCuota);

// System.out.println("Usuario Ocasional registrado con éxito.");
// }

// private static void buscarUsuarioAfiliado(Scanner scanner) {
// System.out.print("Ingrese el ID del Usuario Afiliado a buscar: ");
// int idUsuarioAfiliado = scanner.nextInt();
// ControladorUsuarioAfiliado controladorUsuarioAfiliado = new
// ControladorUsuarioAfiliado();
// ModeloAfiliado usuarioAfiliado =
// controladorUsuarioAfiliado.buscarUsuarioAfiliado(idUsuarioAfiliado);
// if (usuarioAfiliado != null) {
// System.out.println("Usuario Afiliado encontrado: " + usuarioAfiliado);
// } else {
// System.out.println("Usuario Afiliado no encontrado.");
// }
// }

// private static void buscarEmpresaPrivada(Scanner scanner) {
// System.out.print("Ingrese el ID de la Empresa Privada a buscar: ");
// int idEmpresaPrivada = scanner.nextInt();
// ControladorEmpresaPrivada controladorEmpresaPrivada = new
// ControladorEmpresaPrivada();
// ModeloEmpresaPrivada empresaPrivada =
// controladorEmpresaPrivada.buscarEmpresaPrivada(idEmpresaPrivada);
// if (empresaPrivada != null) {
// System.out.println("Empresa Privada encontrada: " + empresaPrivada);
// } else {
// System.out.println("Empresa Privada no encontrada.");
// }
// }

// private static void buscarEntidadCultural(Scanner scanner) {
// System.out.print("Ingrese el ID de la Entidad Cultural a buscar: ");
// int idEntidadCultural = scanner.nextInt();
// ControladorEntidadCultural controladorEntidadCultural = new
// ControladorEntidadCultural();
// ModeloEntidadCultural entidadCultural =
// controladorEntidadCultural.buscarEntidadCultural(idEntidadCultural);
// if (entidadCultural != null) {
// System.out.println("Entidad Cultural encontrada: " + entidadCultural);
// } else {
// System.out.println("Entidad Cultural no encontrada.");
// }
// }

// private static void buscarEvento(Scanner scanner) {
// System.out.print("Ingrese el ID del Evento a buscar: ");
// int idEvento = scanner.nextInt();
// ControladorEvento controladorEvento = new ControladorEvento();
// ModeloEvento evento = controladorEvento.buscarEvento(idEvento);
// if (evento != null) {
// System.out.println("Evento encontrado: " + evento);
// } else {
// System.out.println("Evento no encontrado.");
// }
// }

// private static void buscarUsuarioOcasional(Scanner scanner) {
// System.out.print("Ingrese el ID del Usuario Ocasional a buscar: ");
// int idUsuarioOcasional = scanner.nextInt();
// ControladorUsuarioOcasional controladorUsuarioOcasional = new
// ControladorUsuarioOcasional();
// ModeloOcasional usuarioOcasional =
// controladorUsuarioOcasional.buscarUsuarioOcasional(idUsuarioOcasional);
// if (usuarioOcasional != null) {
// System.out.println("Usuario Ocasional encontrado: " + usuarioOcasional);
// } else {
// System.out.println("Usuario Ocasional no encontrado.");
// }
// }

// }
