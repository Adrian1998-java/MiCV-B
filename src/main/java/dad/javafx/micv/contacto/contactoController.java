package dad.javafx.micv.contacto;

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
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.fxml.Initializable;

public class contactoController implements Initializable{

	//model
	private ObjectProperty<Personal> personal = new SimpleObjectProperty<>();
	
	@FXML
    private SplitPane View;

    @FXML
    private TitledPane telefonoPane;

    @FXML
    private BorderPane borderTelefonePane;

    @FXML
    private TableView<?> TelefonoTableView;

    @FXML
    private TableColumn<?, ?> NumeroColumn;

    @FXML
    private TableColumn<?, ?> TipoColumn;

    @FXML
    private Button AniadirTelefonoButton;

    @FXML
    private Button BorrarTelefonoButton;

    @FXML
    private TitledPane direccionesCorreoPane;

    @FXML
    private BorderPane borderCorreoPane;

    @FXML
    private TableView<?> CorreoTableView;

    @FXML
    private TableColumn<?, ?> EmailColumn;

    @FXML
    private Button AniadirCorreoButton;

    @FXML
    private Button BorrarCorreoButton;

    @FXML
    private TitledPane webPane;

    @FXML
    private BorderPane borderWebPane;

    @FXML
    private Button AniadirWebButton;

    @FXML
    private Button BorrarWebButton;

    @FXML
    private TableView<?> WebTableView;

    @FXML
    private TableColumn<?, ?> URLColumn;
    
    
    public contactoController() throws IOException {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ContactoView.fxml"));
    	loader.setController(this);
    	loader.load();
    }
    
	public SplitPane getView() {
		return View;
	}

	  @FXML
	    void AniadirCorreo(ActionEvent event) {

	    }

	    @FXML
	    void AniadirTelefono(ActionEvent event) {

	    }

	    @FXML
	    void AniadirWeb(ActionEvent event) {

	    }

	    @FXML
	    void BorrarCorreo(ActionEvent event) {

	    }

	    @FXML
	    void BorrarTelefono(ActionEvent event) {

	    }

	    @FXML
	    void BorrarWeb(ActionEvent event) {

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
