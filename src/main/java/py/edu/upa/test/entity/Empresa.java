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
	private Integer ruc;
	private String nombre;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getRuc() {
		return ruc;
	}
	public void setRuc(Integer ruc) {
		this.ruc = ruc;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}