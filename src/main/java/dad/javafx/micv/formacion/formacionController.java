package dad.javafx.micv.formacion;

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

public class formacionController implements Initializable{
	
	//model
	private ListProperty<Formacion> formacion = new SimpleListProperty<>(FXCollections.observableArrayList());
    
	@FXML
    private AnchorPane View;

    @FXML
    private TableView<Formacion> TableView;

    @FXML
    private TableColumn<Formacion, LocalDate> DesdeColumn;

    @FXML
    private TableColumn<Formacion, LocalDate> HastaColumn;

    @FXML
    private TableColumn<Formacion, String> DenominacionColumn;

    @FXML
    private TableColumn<Formacion, String> OrganizadorColumn;

    @FXML
    private Button AñadirButton;

    @FXML
    private Button EliminarButton;

    public formacionController() throws IOException {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/FormacionView.fxml"));
    	loader.setController(this);
    	loader.load();
    }
    
	public AnchorPane getView() {
		return View;
	}
	
    @FXML
    void AñadirFormacion(ActionEvent event) {

    	Dialog<Formacion> dialog = new Dialog<>();
		dialog.setTitle("Nueva titulo");
		dialog.setHeaderText("Agregar una nueva titulo");

		ButtonType loginButtonType = new ButtonType("Agregar", ButtonData.OK_DONE);
		dialog.getDialogPane().getButtonTypes().addAll(loginButtonType, ButtonType.CANCEL);

		GridPane grid = new GridPane();
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(20, 150, 10, 10));

		DatePicker desde = new DatePicker();
		DatePicker hasta = new DatePicker();
		TextField denominacion = new TextField();
		TextField organizador = new TextField();

		grid.add(new Label("Denominación: "), 0, 0);
		grid.add(denominacion, 1, 0);
		grid.add(new Label("Organizador"), 0, 1);
		grid.add(organizador, 1, 1);
		grid.add(new Label("Desde:"), 0, 2);
		grid.add(desde, 1, 2);
		grid.add(new Label("Hasta:"), 0, 3);
		grid.add(hasta, 1, 3);

		dialog.getDialogPane().setContent(grid);

		dialog.setResultConverter(dialogButton -> {
			if (dialogButton == loginButtonType) {
				return new Formacion(denominacion.getText().toString(), organizador.getText().toString(), desde.getValue(),
						hasta.getValue());
			}
			return null;
		});

		Optional<Formacion> result = dialog.showAndWait();

		if (result.isPresent()) {
			TableView.getItems().add(result.get());
		}
    }

    @FXML
    void EliminarFormacion(ActionEvent event) {
    	Formacion formacion = TableView.getSelectionModel().getSelectedItem();

		Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
		alert.setHeaderText(null);
		alert.setTitle("Eliminar Titulo");
		alert.setContentText("¿Estas seguro de que quieres borrar este titulo? \n " + formacion);
		Optional<ButtonType> action = alert.showAndWait();

		if (action.get() == ButtonType.OK) {
			TableView.getItems().remove(formacion);
		}
 formacion = TableView.getSelectionModel().getSelectedItem();

		Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
		alert.setHeaderText(null);
		alert.setTitle("Eliminar Titulo");
		alert.setContentText("¿Estas seguro de que quieres borrar este titulo? \n " + formacion);
		Optional<ButtonType> accion = alert.showAndWait();

		if (action.get() == ButtonType.OK) {
			TableView.getItems().remove(formacion);
		}

    }
    
    
	public void initialize(URL location, ResourceBundle resources) {
		

		formacion.addListener((o, ov, nv) -> onFormacionChanged(o, ov, nv));
		
		DesdeColumn.setCellValueFactory(v -> v.getValue().desdeFechaProperty());
		HastaColumn.setCellValueFactory(v -> v.getValue().hastaFechaProperty());
		DenominacionColumn.setCellValueFactory(v -> v.getValue().denominacionProperty());
		OrganizadorColumn.setCellValueFactory(v -> v.getValue().organizadorProperty());

		DenominacionColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		OrganizadorColumn.setCellFactory(TextFieldTableCell.forTableColumn());
	}
	//Cuando cambia la tabla
	private void onFormacionChanged(ObservableValue<? extends ObservableList<Formacion>> o, ObservableList<Formacion> ov,
			ObservableList<Formacion> nv) {

		System.out.println("ov=" + ov + "/nv=" + nv);

		if (ov != null) {

			TableView.setItems(null);

		}

		if (nv != null) {

			TableView.setItems(nv);

		}

	}


	public final ListProperty<Formacion> formacionProperty() {
		return this.formacion;
	}

	public final ObservableList<Formacion> getFormacion() {
		return this.formacionProperty().get();
	}

	public final void setFormacion(final ObservableList<Formacion> formacion) {
		this.formacionProperty().set(formacion);
	}

}
