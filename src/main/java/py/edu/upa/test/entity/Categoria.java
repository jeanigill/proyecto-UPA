package py.edu.upa.test.entity;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="categoria", schema="public")
public class Categoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
    @SequenceGenerator(name = "categoria_id_seq", sequenceName = "categoria_id_seq", allocationSize = 1, schema= "public")
    @GeneratedValue(generator = "categoria_id_seq")
	
	private Integer id;

	private String nombre;

	public Categoria() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}