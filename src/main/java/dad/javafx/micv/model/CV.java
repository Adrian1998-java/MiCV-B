package dad.javafx.micv.model;

import org.hildan.fxgson.FxGson;

import com.google.gson.Gson;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CV {

	//Objetos de las pestañas
	
	private ObjectProperty<Personal> personal = new SimpleObjectProperty<Personal>(new Personal());
	//Linea reservada para contacto
	private ListProperty<Formacion> formacion = new SimpleListProperty<>(FXCollections.observableArrayList());
	private ListProperty<Experiencia> experiencias = new SimpleListProperty<>(FXCollections.observableArrayList());
	private ListProperty<Conocimientos> conocimientos = new SimpleListProperty<>(FXCollections.observableArrayList());
	
	//Personal
	public final ObjectProperty<Personal> personalProperty() {
		return this.personal;
	}

	public final Personal getPersonal() {
		return this.personalProperty().get();
	}
	
	public final void setPersonal(final Personal personal) {
		this.personalProperty().set(personal);
	}
	
	//Formacion
	public final ListProperty<Formacion> formacionProperty() {
		return this.formacion;
	}

	public final ObservableList<Formacion> getFormacion() {
		return this.formacionProperty().get();
	}

	public final void setFormacion(final ObservableList<Formacion> formacion) {
		this.formacionProperty().set(formacion);
	}
	
	//Experiencias
	public final ListProperty<Experiencia> experienciasProperty() {
		return this.experiencias;
	}

	public final ObservableList<Experiencia> getExperiencias() {
		return this.experienciasProperty().get();
	}

	public final void setExperiencias(final ObservableList<Experiencia> experiencias) {
		this.experienciasProperty().set(experiencias);
	}
	
	//Conocimientos
	public final ListProperty<Conocimientos> conocimientosProperty() {
		return this.conocimientos;
	}

	public final ObservableList<Conocimientos> getConocimientos() {
		return this.conocimientosProperty().get();
	}

	public final void setConocimientos(final ObservableList<Conocimientos> conocimientos) {
		this.conocimientosProperty().set(conocimientos);
	}
	
	public static void main(String[] args) {
		
		CV cv = new CV();
		cv.getPersonal().setNombre("Chuck");
		cv.getPersonal().setApellidos("Norris");
		cv.getPersonal().getNacionalidades().add(new Nacionalidad("estadounidense"));
		
		Gson gson = 
			FxGson.fullBuilder()
                .setPrettyPrinting()
                .create();
		
		String json = gson.toJson(cv); // convertir modelo de datos a json (marshalling)

		System.out.println(json);
		
		cv = gson.fromJson(json, CV.class); // convertir json a modelo de datos (unmarshalling) 
		
	}
	
}



