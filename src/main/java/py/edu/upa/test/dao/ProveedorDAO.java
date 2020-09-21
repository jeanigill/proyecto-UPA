package py.edu.upa.test.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import py.edu.upa.test.entity.Proveedor;

@Stateless
public class ProveedorDAO {
	@PersistenceContext
	EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	public List<Proveedor> findWithFilter(String filter) {

		Session session = (Session) entityManager.getDelegate();
		Criteria criteria = session.createCriteria(Proveedor.class);
		
		criteria.add(
				Restrictions.ilike("description", filter)
				);
		
		return criteria.list();

	}
	
	
	@SuppressWarnings("unchecked")
	public List<Proveedor> find() {

		Session session = (Session) entityManager.getDelegate();
		Criteria criteria = session.createCriteria(Proveedor.class);
		
		return criteria.list();

	}
	
	//Obtener al proveedor según su ID
	public Proveedor findById(Integer id) {

		Session session = (Session) entityManager.getDelegate();
		Criteria criteria = session.createCriteria(Proveedor.class);
		
		criteria.add(Restrictions.eq("id", id));
		
		return (Proveedor) criteria.uniqueResult();

	}
	
	//Insertar un nuevo proveedor
	
	public void insert(Proveedor p){
		entityManager.persist(p);
	}
	
	//Actualizar un proveedor	
	public void update(Integer id, Proveedor proveedor){
		Proveedor p = findById(id);
		p.setNombre(proveedor.getNombre());
		p.setCi(proveedor.getCi());
		p.setDireccion(proveedor.getDireccion());
		p.setRepresentante(proveedor.getRepresentante());
		p.setEmail(proveedor.getEmail());
		entityManager.merge(p);
	}
	
	//Eliminar a un proveedor 
	public void delete(Integer id){
		Proveedor p = findById(id);
		entityManager.merge(p);
	}	
		
	//Obtener lista de proveedores paginadas
	
	/**
	 * @param id_proveedor
	 * @return lista de proveedores 
	 */	
	@SuppressWarnings("unchecked")
	public List<Proveedor> findWithPagination(Integer page, Integer size) {
		
		//Calcular inicio
		int registroInicio = 0;
		registroInicio = (page - 1)* size;		

		Session session = (Session) entityManager.getDelegate();
		Criteria criteria = session.createCriteria(Proveedor.class);
				
		criteria.add(
				Restrictions.or(
						Restrictions.eq("deleted", false),
						Restrictions.isNull("deleted")));
		
		//Asignar Registro de inicio
		criteria.setFirstResult(registroInicio);
		//Asignar Tamaño de Página
		criteria.setMaxResults(size);
		//Retornar lista
		return criteria.list();

	}
	
}