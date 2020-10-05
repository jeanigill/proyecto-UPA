package py.edu.upa.test.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;


import py.edu.upa.test.entity.Empresa;


@Stateless
public class EmpresaDAO {
	@PersistenceContext
	EntityManager entityManager;
	

	
	//Obtener la lista de Empresas
		@SuppressWarnings("unchecked")
		public List<Empresa> find() {

			Session session = (Session) entityManager.getDelegate();
			Criteria criteria = session.createCriteria(Empresa.class);
						
			return criteria.list();

		}
	
		//Obtener una Empresa según ID
		public Empresa findById(Integer id) {

			Session session = (Session) entityManager.getDelegate();
			Criteria criteria = session.createCriteria(Empresa.class);
			
			criteria.add(Restrictions.eq("id", id));
			
			return (Empresa) criteria.uniqueResult();

		}
	
}