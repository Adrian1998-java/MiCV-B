package dad.javafx.micv.experiencia;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

import javafx.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import dad.javafx.micv.model.Personal;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.fxml.Initializable;

public class experienciaController implements Initializable{
	
	//model
	private ObjectProperty<Personal> personal = new SimpleObjectProperty<>();
	
	@FXML
    private AnchorPane view;

    @FXML
    private TableView<?> tableView;

    @FXML
    private TableColumn<?, ?> desdeColumn;

    @FXML
    private TableColumn<?, ?> hastaColumn;

    @FXML
    private TableColumn<?, ?> denominacionColumn;

    @FXML
    private TableColumn<?, ?> empleadorColumn;

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

    }

    @FXML
    void eliminar(ActionEvent event) {

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
