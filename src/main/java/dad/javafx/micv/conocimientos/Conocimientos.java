package dad.javafx.micv.conocimientos;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class Conocimientos {
    
	
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

    @FXML
    void aniadirConocimientoAction(ActionEvent event) {

    }

    @FXML
    void aniadirIdiomaAction(ActionEvent event) {

    }

    @FXML
    void eliminarAction(ActionEvent event) {

    }
}
