package py.edu.upa.test.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="empresa", schema="public")
public class Empresa implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	@Id
    @SequenceGenerator(name = "empresa_id_seq", sequenceName = "empresa_id_seq", allocationSize = 1, schema= "public")
    @GeneratedValue(generator = "empresa_id_seq")
	
	//Variables 
	private Integer id;
	private String  ruc;
	private String nombre;
	private Integer telefono;
	private String email;
	private String ciudad;
	private String pais;
	
	
	public Empresa () {
		
	}
	
	
	public Integer getTelefono() {
		return telefono;
	}


	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getCiudad() {
		return ciudad;
	}


	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}


	public String getPais() {
		return pais;
	}


	public void setPais(String pais) {
		this.pais = pais;
	}


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getRuc() {
		return ruc;
	}
	public void setRuc(String ruc) {
		this.ruc = ruc;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
	
}