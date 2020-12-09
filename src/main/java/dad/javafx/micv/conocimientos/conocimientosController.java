package dad.javafx.micv.conocimientos;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;

import dad.javafx.micv.model.*;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class conocimientosController {
    
	//model
	private ObjectProperty<Conocimientos> conocimientos = new SimpleObjectProperty<>();
	
	@FXML
    private BorderPane view;

    @FXML
    private TableView<Conocimientos> conocimentoTableView;

    @FXML
    private TableColumn<Conocimientos, String> denominacionColumn;

    @FXML
    private TableColumn<Conocimientos, String> nivelColumn;

    @FXML
    private VBox vBox;

    @FXML
    private Button aniadirConocimientoButton;

    @FXML
    private Button aniadirIdiomaButton;

    @FXML
    private Button eliminarButton;

    //Iniciar
    public conocimientosController() throws IOException {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ConocimientosView.fxml"));
    	loader.setController(this);
    	loader.load();
	}
    
	public BorderPane getView() {
		return view;
	}
    
    @FXML
    void aniadirConocimientoAction(ActionEvent event) {
    	Dialog<Conocimientos> dialog = new Dialog<>();
		dialog.setTitle("Nueva conocimiento");
		dialog.setHeaderText("Agregar un nuevo conocimiento");

		ButtonType loginButtonType = new ButtonType("Agregar", ButtonData.OK_DONE);
		dialog.getDialogPane().getButtonTypes().addAll(loginButtonType, ButtonType.CANCEL);

		GridPane grid = new GridPane();
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(20, 150, 10, 10));

		ComboBox nivel = new ComboBox();
		nivel.getItems().addAll("Básico", "Medio", "Avanzado");
		TextField denominacion = new TextField();
		Button btnReset = new Button("X");
		btnReset.setOnAction(d -> {
			nivel.getSelectionModel().clearSelection();
		});

		grid.add(new Label("Denominación: "), 0, 0);
		grid.add(denominacion, 1, 0);
		grid.add(new Label("Nivel:"), 0, 1);
		grid.add(nivel, 1, 1);
		grid.add(btnReset, 2, 1);

		dialog.getDialogPane().setContent(grid);

		dialog.setResultConverter(dialogButton -> {
			if (dialogButton == loginButtonType) {
				return new Conocimientos(denominacion.getText(), nivel.getSelectionModel().getSelectedItem().toString());
			}
			return null;
		});

		Optional<Conocimientos> result = dialog.showAndWait();

		if (result.isPresent()) {
			conocimentoTableView.getItems().add(result.get());
		}
    }

    @FXML
    void aniadirIdiomaAction(ActionEvent event) {
    	Dialog<Idioma> dialog = new Dialog<>();
		dialog.setTitle("Nueva conocimiento");
		dialog.setHeaderText("Agregar un nuevo conocimiento");

		ButtonType loginButtonType = new ButtonType("Agregar", ButtonData.OK_DONE);
		dialog.getDialogPane().getButtonTypes().addAll(loginButtonType, ButtonType.CANCEL);

		GridPane grid = new GridPane();
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(20, 150, 10, 10));

		ComboBox nivel = new ComboBox();
		nivel.getItems().addAll("Básico", "Medio", "Avanzado");
		TextField denominacion = new TextField();
		TextField certificacion = new TextField();
		Button btnReset = new Button("X");
		btnReset.setOnAction(d -> {
			nivel.getSelectionModel().clearSelection();
		});

		grid.add(new Label("Denominación: "), 0, 0);
		grid.add(denominacion, 1, 0);
		grid.add(new Label("Nivel:"), 0, 1);
		grid.add(nivel, 1, 1);
		grid.add(btnReset, 2, 1);
		grid.add(new Label("Certificación: "), 0, 2);
		grid.add(certificacion, 1, 2);

		dialog.getDialogPane().setContent(grid);

		dialog.setResultConverter(dialogButton -> {
			if (dialogButton == loginButtonType) {
				return new Idioma(denominacion.getText(), nivel.getSelectionModel().getSelectedItem().toString(),
						certificacion.getText());
			}
			return null;
		});

		Optional<Idioma> result = dialog.showAndWait();

		if (result.isPresent()) {
			conocimentoTableView.getItems().add(result.get());
		}
    }

    @FXML
    void eliminarAction(ActionEvent event) {
    	Conocimientos con = conocimentoTableView.getSelectionModel().getSelectedItem();

		Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
		alert.setHeaderText(null);
		alert.setTitle("Eliminar Conocimiento");
		alert.setContentText("¿Estas seguro de que quieres borrar este conocimiento? \n " + con);
		Optional<ButtonType> action = alert.showAndWait();

		if (action.get() == ButtonType.OK) {
			conocimentoTableView.getItems().remove(con);
		}

    }
    
    public void initialize(URL location, ResourceBundle resources) {
    	conocimientos.addListener((o, ov, nv) -> onConocimientosChanged(o, ov, nv));

		denominacionColumn.setCellValueFactory(v -> v.getValue().denominacionProperty());
		nivelColumn.setCellValueFactory(v -> v.getValue().nivelProperty());

		denominacionColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		nivelColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		
	}
	
    
    
    private void onConocimientosChanged(ObservableValue<? extends Conocimientos> o,
			Conocimientos ov, Conocimientos nv) {

		System.out.println("ov=" + ov + "/nv=" + nv);

		if (ov != null) {

			conocimentoTableView.setItems(null);
			// TODO desbindear el resto de propiedades

		}

		if (nv != null) {
			conocimentoTableView.setItems((ObservableList<Conocimientos>) nv);
			// TODO bindear el resto de propiedades

		}

	}
    
	public final ObjectProperty<Conocimientos> conocimientoProperty() {
		return this.conocimientos;
	}

	public final Conocimientos getConocimientos() {
		return this.conocimientoProperty().get();
	}

	public final void setConocimientos(final Conocimientos conocimiento) {
		this.conocimientoProperty().set(conocimiento);
	}
}
