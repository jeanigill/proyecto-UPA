package py.edu.upa.test.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="producto", schema="public")
public class Producto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
    @SequenceGenerator(name = "producto_id_seq", sequenceName = "producto_id_seq", allocationSize = 1, schema= "public")
    @GeneratedValue(generator = "producto_id_seq")
	
	//VARIABLES
	private Integer id;
	private String codigo;
	private String nombre;

	@Column(name="precio_unitario")
	private BigDecimal precioUnitario;
	
	private String descripcion;


	private Boolean favorito;
	private Boolean oferta;
	
	@Column(name="cantidad_stock")
	private Integer cantidadStock;
	
	//JOINS (EN BD)	
	@ManyToOne
	@JoinColumn(name="id_categoria")
	private Producto categoria;
	
	@ManyToOne
	@JoinColumn(name="id_1")
	private Producto proveedor;
	
	@ManyToOne
	@JoinColumn(name="id_2")
	private Producto empresa;

	//GETTERS Y SETTERS
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public BigDecimal getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(BigDecimal precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Boolean getFavorito() {
		return favorito;
	}

	public void setFavorito(Boolean favorito) {
		this.favorito = favorito;
	}

	public Boolean getOferta() {
		return oferta;
	}

	public void setOferta(Boolean oferta) {
		this.oferta = oferta;
	}

	public Integer getCantidadStock() {
		return cantidadStock;
	}

	public void setCantidadStock(Integer cantidadStock) {
		this.cantidadStock = cantidadStock;
	}

	public Producto getCategoria() {
		return categoria;
	}

	public void setCategoria(Producto categoria) {
		this.categoria = categoria;
	}

	public Producto getProveedor() {
		return proveedor;
	}

	public void setProveedor(Producto proveedor) {
		this.proveedor = proveedor;
	}

	public Producto getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Producto empresa) {
		this.empresa = empresa;
	}

}