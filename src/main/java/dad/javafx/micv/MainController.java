package dad.javafx.micv;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.hildan.fxgson.FxGson;

import com.google.gson.Gson;

import dad.javafx.micv.model.CV;
import dad.javafx.micv.model.Conocimientos;
import dad.javafx.micv.personal.PersonalController;
import dad.javafx.micv.contacto.contactoController;
import dad.javafx.micv.experiencia.experienciaController;
import dad.javafx.micv.formacion.formacionController;
import dad.javafx.micv.conocimientos.conocimientosController;
import dad.javafx.micv.utils.JSONUtils;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Tab;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

public class MainController implements Initializable {
	
	private static String pathFile = "";
	// controllers
	private PersonalController personalController = new PersonalController();
	private contactoController contactoController = new contactoController();
	private formacionController formacionController = new formacionController();
	private experienciaController experienciaController = new experienciaController();
	private conocimientosController conocimientosController = new conocimientosController();
	
	// model
	
	private ObjectProperty<CV> cv = new SimpleObjectProperty<>();
	
	// view

    @FXML
    private BorderPane view;

    @FXML
    private Tab personalTab;

    @FXML
    private Tab contactoTab;

    @FXML
    private Tab formacionTab;

    @FXML
    private Tab experienciaTab;

    @FXML
    private Tab conocimientosTab;
	
	public MainController() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/MainView.fxml"));
		loader.setController(this);
		loader.load();
	}
	
	public BorderPane getView() {
		return view;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		personalTab.setContent(personalController.getView());
		contactoTab.setContent(contactoController.getView());
		formacionTab.setContent(formacionController.getView());
		experienciaTab.setContent(experienciaController.getView());
		conocimientosTab.setContent(conocimientosController.getView());
		
		cv.addListener((o, ov, nv) -> onCVChanged(o, ov, nv));
		
		cv.set(new CV());
		
	}

    private void onCVChanged(ObservableValue<? extends CV> o, CV ov, CV nv) {
    	
    	if (ov != null) {
    		
    		personalController.personalProperty().unbind(); // desbindeo personalProperty del CV anterior
    		// desbindear resto de controllers
    		contactoController.personalProperty().unbind();
    		formacionController.formacionProperty().unbind();
    		experienciaController.experienciaProperty().unbind();
    		conocimientosController.conocimientoProperty().unbind();
    	}

    	if (nv != null) {
    		
    		personalController.personalProperty().bind(nv.personalProperty()); // bindeo personalProperty del nuevo CV
    		// bindear resto de controllers
    		contactoController.personalProperty().bind(nv.personalProperty());
    		formacionController.formacionProperty().bind(nv.formacionProperty());
    		experienciaController.experienciaProperty().bind(nv.experienciasProperty());
    		conocimientosController.conocimientoProperty().bind((ObservableValue<? extends Conocimientos>) nv.conocimientosProperty());
    		
    	}
    	
	}

	@FXML
    void onAbrirAction(ActionEvent event) {

    	FileChooser fileChooser = new FileChooser();
    	fileChooser.setTitle("Abrir un currículum");
    	fileChooser.getExtensionFilters().add(new ExtensionFilter("Currículum Vitae (*.cv)", "*.cv"));
    	fileChooser.getExtensionFilters().add(new ExtensionFilter("Todos los archivos", "*.*"));
    	File cvFile = fileChooser.showOpenDialog(App.getPrimaryStage());
    	if (cvFile != null) {
    		try {
    			pathFile = cvFile.getAbsolutePath();
				cv.set(JSONUtils.fromJson(cvFile, CV.class));
			} catch (IOException e) {
				e.printStackTrace();
			}
    	}
		
    }

    @FXML
    void onAcercaDeAction(ActionEvent event) {
    	Alert alert = new Alert(AlertType.INFORMATION);
    	alert.setTitle("Acerca de...");
    	alert.setHeaderText("Escucha:");
    	alert.setContentText("Esta es la Aplicación Mi-CV!");

    	alert.showAndWait();
    }

    @FXML
    void onGuardarAction(ActionEvent event) {

		try {
			File cvFile = new File(pathFile);
			if (cvFile.exists()) {

				JSONUtils.toJson(cvFile, cv.get());

			} else {
				this.onGuardarComoAction(event);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

    @FXML
    void onGuardarComoAction(ActionEvent event) {

    	FileChooser fileChooser = new FileChooser();
    	fileChooser.setTitle("Guardar un currículum");
    	fileChooser.getExtensionFilters().add(new ExtensionFilter("Currículum Vitae (*.cv)", "*.cv"));
    	fileChooser.getExtensionFilters().add(new ExtensionFilter("Todos los archivos", "*.*"));
    	File cvFile = fileChooser.showSaveDialog(App.getPrimaryStage());
    	if (cvFile != null) {
    		
    		try {
    			pathFile = cvFile.getAbsolutePath();
				JSONUtils.toJson(cvFile, cv.get());
			} catch (IOException e) {
				e.printStackTrace();
			}
    		
    	}
    	
    }

    @FXML
    void onNuevoAction(ActionEvent event) {
    	System.out.println("Has pulsado nuevo");
    	pathFile = "";
    	cv.set(new CV());
    }

    @FXML
    void onSalirAction(ActionEvent event) {

    }
	
}
