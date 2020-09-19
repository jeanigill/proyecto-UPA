package py.edu.upa.test.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import py.edu.upa.test.dao.ProductoDAO;
import py.edu.upa.test.entity.Producto;

@Stateless
public class ProductoBC {
	
    @Inject
    private ProductoDAO dao;

    //GetALL
    public List<Producto> find() {
    	return dao.find();
    }
    
    //GetID
    public Producto findById(Integer id) {
    	return dao.findById(id);
    }
    
    //Insertar
    public void insert(Producto p){
    	dao.insert(p);
    }
    
    //Actualizar 
    public void update(Integer id, Producto producto){
    	dao.update(id, producto);
    }
    
    //Eliminar
    public void delete(Integer id){
    	dao.delete(id);
    }
    
    //NO SE PARA QUE SIRVE PERO ESTABA EN TASK Y LLAMA EL METODO QUE NO SE DE DAO
	public List<Producto> getWithFilter(String filter) {
		return dao.findWithFilter(filter);
	}
	
	//Paginacion
	public List<Producto> getPaginatedTasks(Integer page, Integer size){
		return dao.findWithPagination(page, size);	
	}
	
}
