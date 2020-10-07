package py.edu.upa.test.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import py.edu.upa.test.entity.Categoria;
import py.edu.upa.test.entity.Producto;




@Stateless
public class CategoriaDAO {
	@PersistenceContext
	EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	public List<Categoria> findWithFilter(String filter) {

		Session session = (Session) entityManager.getDelegate();
		Criteria criteria = session.createCriteria(Categoria.class);
		
		criteria.add(Restrictions.ilike("description", filter));
		
		return criteria.list();

	}
	//Obtener lista de categorias
	@SuppressWarnings("unchecked")
	public List<Categoria> find() {

		Session session = (Session) entityManager.getDelegate();
		Criteria criteria = session.createCriteria(Categoria.class);
	
		
		return criteria.list();

	}
	//Encontrar categoría
	public Categoria findById(Integer id) {

		Session session = (Session) entityManager.getDelegate();
		Criteria criteria = session.createCriteria(Categoria.class);
		
		criteria.add(Restrictions.eq("id", id));
		
		return (Categoria) criteria.uniqueResult();

	}
	//Insertar categoría
	public void insert(Categoria c){
		entityManager.persist(c);
	}
	//Actualizar categoría
	public void update(Integer id, Categoria categoria){
		Categoria c = findById(id);
		c.setNombre(categoria.getNombre());
		c.setUrl(categoria.getUrl());
		entityManager.merge(c);
	}
	//Eliminar categoria
	public void delete(Integer id){
		Categoria c = findById(id);
		entityManager.remove(c);
	}
	//Obtener lista de categorias paginadas	
		/**
		 * @param id
		 * @return lista de productos
		 */	
		@SuppressWarnings("unchecked")
		public List<Categoria> findWithPagination(Integer page, Integer size) {
			
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