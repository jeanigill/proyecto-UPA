package py.edu.upa.test.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="proveedor", schema="public")
public class Proveedor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
    @SequenceGenerator(name = "proveedor_id_seq", sequenceName = "proveedor_id_seq", allocationSize = 1, schema= "public")
    @GeneratedValue(generator = "proveedor_id_seq")
	
	//VARIABLES
	private Integer id;
	private String ci;
	private String nombre;
	private String direccion;
	private String representante;
	private String email;

	private Boolean contratado;
	
	public Proveedor () {
		
	}
	
	//GETTERS Y SETTERS
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCi() {
		return ci;
	}

	public void setCi(String ci) {
		this.ci = ci;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getRepresentante() {
		return representante;
	}

	public void setRepresentante(String representante) {
		this.representante = representante;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getContratado() {
		return contratado;
	}

	public void setContratado(Boolean contratado) {
		this.contratado = contratado;
	}
	
	
}
