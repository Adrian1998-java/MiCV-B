package dad.javafx.micv.model;

import java.time.LocalDate;

import com.google.gson.Gson;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Experiencia {
	private ObjectProperty<LocalDate> desdeFecha = new SimpleObjectProperty<LocalDate>();
	private ObjectProperty<LocalDate> hastaFecha = new SimpleObjectProperty<LocalDate>();
	private StringProperty denominacion = new SimpleStringProperty();
	private StringProperty empleador = new SimpleStringProperty();
	
	public Experiencia() {
		
	}

	public Experiencia(String denominacion, String empleador, LocalDate desde, LocalDate hasta) {
		super();
		this.denominacion.set(denominacion);
		this.empleador.set(empleador);
		this.desdeFecha.set(desde);
		this.hastaFecha.set(hasta);
	}

	public ObjectProperty<LocalDate> getDesdeFecha() {
		return desdeFecha;
	}

	public void setDesdeFecha(ObjectProperty<LocalDate> desdeFecha) {
		this.desdeFecha = desdeFecha;
	}
	public ObjectProperty<LocalDate> desdeFechaProperty() {
		return desdeFecha;
	}
	
	public ObjectProperty<LocalDate> getHastaFecha() {
		return hastaFecha;
	}

	public void setHastaFecha(ObjectProperty<LocalDate> hastaFecha) {
		this.hastaFecha = hastaFecha;
	}
	public ObjectProperty<LocalDate> hastaFechaProperty() {
		return hastaFecha;
	}

	public StringProperty getDenominacion() {
		return denominacion;
	}

	public void setDenominacion(StringProperty denominacion) {
		this.denominacion = denominacion;
	}
	public StringProperty denominacionProperty() {
		return denominacion;
	}
	
	public StringProperty getEmpleador() {
		return empleador;
	}

	public void setEmpleador(StringProperty empleador) {
		this.empleador = empleador;
	}
	public StringProperty empleadorProperty() {
		return empleador;
	}

	@Override
	public String toString() {
		return "Experiencia [desdeFecha=" + desdeFecha + ", hastaFecha=" + hastaFecha + ", denominacion=" + denominacion
				+ ", empleador=" + empleador + "]";
	}
	
	
	
}
