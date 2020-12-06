package dad.javafx.micv.conocimientos;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import dad.javafx.micv.model.Personal;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class conocimientosController {
    
	//model
	private ObjectProperty<Personal> personal = new SimpleObjectProperty<>();
	
	@FXML
    private BorderPane view;

    @FXML
    private TableView<?> conocimentoTableView;

    @FXML
    private TableColumn<?, ?> denominacionColumn;

    @FXML
    private TableColumn<?, ?> nivelColumn;

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

    }

    @FXML
    void aniadirIdiomaAction(ActionEvent event) {

    }

    @FXML
    void eliminarAction(ActionEvent event) {

    }
    
    @Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	public final ObjectProperty<Personal> personalProperty() {
		return this.personal;
	}

	public final Personal getPersonal() {
		return this.personalProperty().get();
	}

	public final void setPersonal(final Personal personal) {
		this.personalProperty().set(personal);
	}
}
