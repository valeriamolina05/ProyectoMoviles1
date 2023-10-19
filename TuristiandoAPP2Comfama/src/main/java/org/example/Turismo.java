package org.example;

import org.example.gui.busquedas.ShowFindEmpresaPrivadaForm;
import org.example.gui.busquedas.ShowFindEntidadCulturalForm;
import org.example.gui.busquedas.ShowFindEventoForm;
import org.example.gui.busquedas.ShowFindUsuarioAfiliadoForm;
import org.example.gui.busquedas.ShowFindUsuarioOcasionalForm;
import org.example.gui.registros.ShowEmpresaRegistrationForm;
import org.example.gui.registros.ShowEntidadCulturalRegistrationForm;
import org.example.gui.registros.ShowEventoRegistrationForm;
import org.example.gui.registros.ShowUsuarioAfiliadoRegistrationForm;
import org.example.gui.registros.ShowUsuarioOcasionalRegistrationForm;
import org.example.controladores.ControladorEmpresaPrivada;
import org.example.controladores.ControladorEntidadCultural;
import org.example.controladores.ControladorEvento;
import org.example.controladores.ControladorUsuarioAfiliado;
import org.example.controladores.ControladorUsuarioOcasional;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
// import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Turismo extends Application {
        private final ShowEmpresaRegistrationForm empresaRegistrationForm = new ShowEmpresaRegistrationForm();
        private final ShowEntidadCulturalRegistrationForm entidadCulturalRegistrationForm = new ShowEntidadCulturalRegistrationForm();
        private final ShowEventoRegistrationForm eventoRegistrationForm = new ShowEventoRegistrationForm();
        private final ShowUsuarioAfiliadoRegistrationForm usuarioAfiliadoRegistrationForm = new ShowUsuarioAfiliadoRegistrationForm();
        private final ShowUsuarioOcasionalRegistrationForm usuarioOcasionalRegistrationForm = new ShowUsuarioOcasionalRegistrationForm();

        private final ShowFindUsuarioAfiliadoForm findUsuarioAfiliadoForm = new ShowFindUsuarioAfiliadoForm();
        private final ShowFindUsuarioOcasionalForm findUsuarioOcasionalForm = new ShowFindUsuarioOcasionalForm();
        private final ShowFindEmpresaPrivadaForm findEmpresaPrivadaForm = new ShowFindEmpresaPrivadaForm();
        private final ShowFindEntidadCulturalForm findEntidadCulturalForm = new ShowFindEntidadCulturalForm();
        private final ShowFindEventoForm findEventoForm = new ShowFindEventoForm();

        private final ControladorEmpresaPrivada controladorEPrivada = new ControladorEmpresaPrivada();
        private final ControladorEntidadCultural controladorEcultural = new ControladorEntidadCultural();
        private final ControladorEvento controladorEvento = new ControladorEvento();
        private final ControladorUsuarioOcasional controladorUsuarioOcasional = new ControladorUsuarioOcasional();
        private final ControladorUsuarioAfiliado controladorUsuarioAfiliado = new ControladorUsuarioAfiliado();

        private final String fontStyle = "-fx-background-color: #0a84b8;";
        private final String buttonStyle = "-fx-background-color: #00406f; -fx-text-fill: white;";
        private final String labelStyle = "-fx-text-fill: white;";
        private final String titleLabelStyle = "-fx-font-size: 30px; -fx-text-fill: white;";

        public static void main(String[] args) {
                launch(args);
        }

        @Override
        public void start(Stage primaryStage) {
                Stage menu = new Stage();
                menu.setTitle("Sistema de Registro de Turismo");
                // private String img = "gui/imagenes/LogoCirculo.png";
                // private Image icon = new Image(img);
                // menu.getIcons().add(icon);

                GridPane grid = new GridPane();
                grid.setAlignment(Pos.CENTER);
                grid.setHgap(20);
                grid.setVgap(20);

                Scene scene = new Scene(grid, 650, 400);
                // Definir un estilo CSS para la ventana

                // Aplicar el estilo a la escena
                scene.getRoot().setStyle(this.fontStyle);
                menu.setScene(scene);

                Label titleLabel = new Label("Menú de Opciones");
                titleLabel.setStyle(this.titleLabelStyle);
                grid.add(titleLabel, 0, 0, 2, 1);
                GridPane.setHalignment(titleLabel, HPos.CENTER);

                // Columna para botones de registro
                VBox registroBox = new VBox(10);
                registroBox.setAlignment(Pos.CENTER);
                registroBox.setSpacing(10);

                Button registerEmpresaButton = new Button("Registrar Empresa Privada");
                registerEmpresaButton.setStyle(this.buttonStyle);
                Button registerEntidadCulturalButton = new Button("Registrar Entidad Cultural");
                registerEntidadCulturalButton.setStyle(this.buttonStyle);
                Button registerEventoButton = new Button("Registrar Evento");
                registerEventoButton.setStyle(this.buttonStyle);
                Button registerUsuarioAfiliadoButton = new Button("Registrar Usuario Afiliado");
                registerUsuarioAfiliadoButton.setStyle(this.buttonStyle);
                Button registerUsuarioOcasionalButton = new Button("Registrar Usuario Ocasional");
                registerUsuarioOcasionalButton.setStyle(this.buttonStyle);

                registroBox.getChildren().addAll(
                                registerEmpresaButton,
                                registerEntidadCulturalButton,
                                registerEventoButton,
                                registerUsuarioAfiliadoButton,
                                registerUsuarioOcasionalButton);
                grid.add(registroBox, 0, 1);

                // Columna para botones de búsqueda
                VBox busquedaBox = new VBox(10);
                busquedaBox.setAlignment(Pos.CENTER);
                busquedaBox.setSpacing(10);

                Button buscarEmpresaButton = new Button("Buscar Empresa Privada");
                buscarEmpresaButton.setStyle(this.buttonStyle);
                Button buscarEntidadCulturalButton = new Button("Buscar Entidad Cultural");
                buscarEntidadCulturalButton.setStyle(this.buttonStyle);
                Button buscarEventoButton = new Button("Buscar Evento");
                buscarEventoButton.setStyle(this.buttonStyle);
                Button buscarUsuarioAfiliadoButton = new Button("Buscar Usuario Afiliado");
                buscarUsuarioAfiliadoButton.setStyle(this.buttonStyle);
                Button buscarUsuarioOcasionalButton = new Button("Buscar Usuario Ocasional");
                buscarUsuarioOcasionalButton.setStyle(this.buttonStyle);

                busquedaBox.getChildren().addAll(
                                buscarEmpresaButton,
                                buscarEntidadCulturalButton,
                                buscarEventoButton,
                                buscarUsuarioAfiliadoButton,
                                buscarUsuarioOcasionalButton);
                grid.add(busquedaBox, 1, 1);

                // Configurar eventos para los botones (similar a tu código existente)
                // Funciones de registro
                registerEmpresaButton
                                .setOnAction(event -> empresaRegistrationForm.showEmpresaRegistrationForm(primaryStage,
                                                controladorEPrivada, fontStyle, buttonStyle, labelStyle,
                                                titleLabelStyle));
                registerEntidadCulturalButton.setOnAction(event -> entidadCulturalRegistrationForm
                                .showEntidadCulturalRegistrationForm(primaryStage, controladorEcultural, fontStyle,
                                                buttonStyle, labelStyle, titleLabelStyle));
                registerEventoButton.setOnAction(event -> eventoRegistrationForm.showEventoRegistrationForm(
                                primaryStage, controladorEvento, fontStyle, buttonStyle, labelStyle, titleLabelStyle));
                registerUsuarioAfiliadoButton.setOnAction(event -> usuarioAfiliadoRegistrationForm
                                .showUsuarioAfiliadoRegistrationForm(primaryStage, controladorUsuarioAfiliado,
                                                fontStyle, buttonStyle, labelStyle, titleLabelStyle));
                registerUsuarioOcasionalButton.setOnAction(event -> usuarioOcasionalRegistrationForm
                                .showUsuarioOcasionalRegistrationForm(primaryStage, controladorUsuarioOcasional,
                                                fontStyle, buttonStyle, labelStyle, titleLabelStyle));

                // Funciones de Buscar
                buscarEmpresaButton.setOnAction(event -> findEmpresaPrivadaForm.showFindEmpresaPrivadaForm(primaryStage,
                                controladorEPrivada, fontStyle, buttonStyle, labelStyle, titleLabelStyle));
                buscarEntidadCulturalButton
                                .setOnAction(event -> findEntidadCulturalForm.showFindEntidadCulturalForm(primaryStage,
                                                controladorEcultural, fontStyle, buttonStyle, labelStyle,
                                                titleLabelStyle));
                buscarEventoButton.setOnAction(event -> findEventoForm.showFindEventoForm(primaryStage,
                                controladorEvento, fontStyle, buttonStyle, labelStyle, titleLabelStyle));
                buscarUsuarioAfiliadoButton
                                .setOnAction(event -> findUsuarioAfiliadoForm.showFindUsuarioAfiliadoForm(primaryStage,
                                                controladorUsuarioAfiliado, fontStyle, buttonStyle, labelStyle,
                                                titleLabelStyle));
                buscarUsuarioOcasionalButton.setOnAction(event -> findUsuarioOcasionalForm.showFindUsuarioOcasionalForm(
                                primaryStage, controladorUsuarioOcasional, fontStyle, buttonStyle, labelStyle,
                                titleLabelStyle));

                menu.setOnCloseRequest(closeEvent -> menu.close());

                menu.show();

        }
}
