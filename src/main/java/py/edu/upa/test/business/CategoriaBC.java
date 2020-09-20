package py.edu.upa.test.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import py.edu.upa.test.dao.CategoriaDAO;
import py.edu.upa.test.entity.Categoria;
import py.edu.upa.test.entity.Producto;


@Stateless
public class CategoriaBC {
	
    @Inject
	private CategoriaDAO dao;
	

	public List<Categoria> find() {
		return dao.find();
	}
	
	public Categoria findById(Integer id) {
		return dao.findById(id);
	}
	
	public void insert(Categoria c){
		dao.insert(c);
	}
	
	public void update(Integer id, Categoria c){
		dao.update(id, c);
	}
	
	public void delete(Integer id){
		dao.delete(id);
	}
	
	public List<Categoria> getWithFilter(String filter) {
		return dao.findWithFilter(filter);
	}
	//Paginación
		//public List<Categoria> getPaginatedTasks(Integer page, Integer size){
			//return dao.findWithPagination(page, size);
//}
}