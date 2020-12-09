package dad.javafx.micv.experiencia;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import javafx.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Optional;
import java.util.ResourceBundle;

import dad.javafx.micv.model.*;
import javafx.beans.property.ListProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TitledPane;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.fxml.Initializable;

public class experienciaController implements Initializable{
	
	//model
	private ListProperty<Experiencia> experiencia = new SimpleListProperty<>(FXCollections.observableArrayList());	
	
	@FXML
    private AnchorPane view;

    @FXML
    private TableView<Experiencia> tableView;

    @FXML
    private TableColumn<Experiencia, LocalDate> desdeColumn;

    @FXML
    private TableColumn<Experiencia, LocalDate> hastaColumn;

    @FXML
    private TableColumn<Experiencia, String> denominacionColumn;

    @FXML
    private TableColumn<Experiencia, String> empleadorColumn;

    @FXML
    private Button aniadirButton;

    @FXML
    private Button eliminarButton;

    public experienciaController() throws IOException {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/experienciaView.fxml"));
    	loader.setController(this);
    	loader.load();
    }
    
	public AnchorPane getView() {
		return view;
	}
    
    @FXML
    void aniadir(ActionEvent event) {
    	Dialog<Experiencia> dialog = new Dialog<>();
		dialog.setTitle("Nueva conocimiento");
		dialog.setHeaderText("Agregar un nuevo conocimiento");

		ButtonType loginButtonType = new ButtonType("Agregar", ButtonData.OK_DONE);
		dialog.getDialogPane().getButtonTypes().addAll(loginButtonType, ButtonType.CANCEL);

		GridPane grid = new GridPane();
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(20, 150, 10, 10));

		DatePicker desde = new DatePicker();
		DatePicker hasta = new DatePicker();
		TextField denominacion = new TextField();
		TextField empleador = new TextField();

		grid.add(new Label("Denominación: "), 0, 0);
		grid.add(denominacion, 1, 0);
		grid.add(new Label("Empleador"), 0, 1);
		grid.add(empleador, 1, 1);
		grid.add(new Label("Desde:"), 0, 2);
		grid.add(desde, 1, 2);
		grid.add(new Label("Hasta:"), 0, 3);
		grid.add(hasta, 1, 3);

		dialog.getDialogPane().setContent(grid);

		dialog.setResultConverter(dialogButton -> {
			if (dialogButton == loginButtonType) {
				return new Experiencia(denominacion.getText(), empleador.getText(), desde.getValue(), hasta.getValue());
			}
			return null;
		});

		Optional<Experiencia> result = dialog.showAndWait();

		if (result.isPresent()) {
			tableView.getItems().add(result.get());
		}
    }

    @FXML
    void eliminar(ActionEvent event) {
    	Experiencia conocimineto = tableView.getSelectionModel().getSelectedItem();

		Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
		alert.setHeaderText(null);
		alert.setTitle("Eliminar Conocimiento");
		alert.setContentText("¿Estas seguro de que quieres borrar este conocimiento? \n " + conocimineto);
		Optional<ButtonType> action = alert.showAndWait();

		if (action.get() == ButtonType.OK) {
			tableView.getItems().remove(conocimineto);
		}

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		experiencia.addListener((o, ov, nv) -> onExperienciaChanged(o, ov, nv));

		desdeColumn.setCellValueFactory(v -> v.getValue().desdeFechaProperty());
		hastaColumn.setCellValueFactory(v -> v.getValue().hastaFechaProperty());
		denominacionColumn.setCellValueFactory(v -> v.getValue().denominacionProperty());
		empleadorColumn.setCellValueFactory(v -> v.getValue().empleadorProperty());
		
		denominacionColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		empleadorColumn.setCellFactory(TextFieldTableCell.forTableColumn());
	}
	
	private void onExperienciaChanged(ObservableValue<? extends ObservableList<Experiencia>> o,
			ObservableList<Experiencia> ov, ObservableList<Experiencia> nv) {

		System.out.println("ov=" + ov + "/nv=" + nv);

		if (ov != null) {

			tableView.setItems(null);
			// TODO desbindear el resto de propiedades

		}

		if (nv != null) {
			tableView.setItems(nv);
			// TODO bindear el resto de propiedades

		}

	}
	
	public final ListProperty<Experiencia> experienciaProperty() {
		return this.experiencia;
	}

	public final ObservableList<Experiencia> getExperiencia() {
		return this.experienciaProperty().get();
	}

	public final void setExperiencia(final ObservableList<Experiencia> experiencia) {
		this.experienciaProperty().set(experiencia);
	}

}
