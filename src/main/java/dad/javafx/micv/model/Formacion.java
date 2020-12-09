package dad.javafx.micv.model;

import java.time.LocalDate;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Formacion {
	private ObjectProperty<LocalDate> desdeFecha = new SimpleObjectProperty<LocalDate>();
	private ObjectProperty<LocalDate> hastaFecha = new SimpleObjectProperty<LocalDate>();
	private StringProperty denominacion = new SimpleStringProperty();
	private StringProperty organizador = new SimpleStringProperty();
	
	public Formacion() {
		// TODO Auto-generated constructor stub
	}
	
	public Formacion(String denominacion, String organizador, LocalDate desde, LocalDate hasta) {
		super();
		this.denominacion.set(denominacion);
		this.organizador.set(organizador);
		this.hastaFecha.set(hasta);
		this.desdeFecha.set(desde);
	}
	//Getter y setters
	public ObjectProperty<LocalDate> getDesdeFecha() {
		return desdeFecha;
	}
	public void setDesdeFecha(ObjectProperty<LocalDate> desdeFecha) {
		this.desdeFecha = desdeFecha;
	}
	public ObjectProperty<LocalDate> desdeFechaProperty(){
		return desdeFecha;
	}
	
	
	public ObjectProperty<LocalDate> getHastaFecha() {
		return hastaFecha;
	}
	public void setHastaFecha(ObjectProperty<LocalDate> hastaFecha) {
		this.hastaFecha = hastaFecha;
	}
	public ObjectProperty<LocalDate> hastaFechaProperty(){
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
	
	public StringProperty getOrganizador() {
		return organizador;
	}
	public void setOrganizador(StringProperty organizador) {
		this.organizador = organizador;
	}
	public StringProperty organizadorProperty() {
		return organizador;
	}
	
	@Override
	public String toString() {
		return "Formación [desdeFecha=" + desdeFecha + ", hastaFecha=" + hastaFecha + ", denominacion=" + denominacion
				+ ", organizador=" + organizador + "]";
	}
	
	
}
