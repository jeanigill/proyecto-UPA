package py.edu.upa.test.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import py.edu.upa.test.entity.Producto;

@Stateless
public class ProductoDAO {
	@PersistenceContext
	EntityManager entityManager;
	
	//Estaba en el ejemplo de Task pero no sé exactamente que hace
	@SuppressWarnings("unchecked")
	public List<Producto> findWithFilter(String filter) {

		Session session = (Session) entityManager.getDelegate();
		Criteria criteria = session.createCriteria(Producto.class);
		
		return criteria.list();

	}
	
	//Obtener la lista de productos
	@SuppressWarnings("unchecked")
	public List<Producto> find() {

		Session session = (Session) entityManager.getDelegate();
		Criteria criteria = session.createCriteria(Producto.class);
		
		return criteria.list();

	}
	
	//Obtener un producto según ID
	public Producto findById(Integer id) {

		Session session = (Session) entityManager.getDelegate();
		Criteria criteria = session.createCriteria(Producto.class);
		
		criteria.add(Restrictions.eq("id", id));
		
		return (Producto) criteria.uniqueResult();

	}
	
	//Insertar (cargar) un nuevo producto
	public void insert(Producto p){
		entityManager.persist(p);
	}
	
	//Actualizar un prodcuto	
	public void update(Integer id, Producto producto){
		Producto p = findById(id);
		//p.setId(producto.getId()); CREO QUE NO HACE FALTA
		p.setCodigo(producto.getCodigo());
		p.setNombre(producto.getNombre());
		p.setPrecioUnitario(producto.getPrecioUnitario());
		p.setDescripcion(producto.getDescripcion());
		p.setFavorito(producto.getFavorito());
		p.setOferta(producto.getOferta());
		p.setCantidadStock(producto.getCantidadStock());
		p.setCategoria(producto.getCategoria());		
		p.setProveedor(producto.getProveedor());
		p.setEmpresa(producto.getEmpresa());
		entityManager.merge(p);
	}
	
	//Eliminar un producto del catálogo
	public void delete(Integer id){
		Producto p = findById(id);
		entityManager.merge(p);
	}	
		
	//Obtener lista de productos paginadas	
	/**
	 * @param id
	 * @return lista de productos
	 */	
	@SuppressWarnings("unchecked")
	public List<Producto> findWithPagination(Integer page, Integer size) {
		
		//Calcular inicio
		int registroInicio = 0;
		registroInicio = (page - 1)* size;		

		Session session = (Session) entityManager.getDelegate();
		Criteria criteria = session.createCriteria(Producto.class);
		
		//Asignar Registro de inicio
		criteria.setFirstResult(registroInicio);
		//Asignar Tamaño de Página
		criteria.setMaxResults(size);
		//Retornar lista
		return criteria.list();

	}
	
}