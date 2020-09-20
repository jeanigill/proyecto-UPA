package py.edu.upa.test.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import py.edu.upa.test.dao.ProveedorDAO;
import py.edu.upa.test.entity.Proveedor;

@Stateless
public class ProveedorBC {
	
    @Inject
    private ProveedorDAO dao;

    //GetALL
    public List<Proveedor> find() {
    	return dao.find();
    }
    
    //GetID
    public Proveedor findById(Integer id) {
    	return dao.findById(id);
    }
    
    //Insertar
    public void insert(Proveedor p){
    	dao.insert(p);
    }
    
    //Actualizar 
    public void update(Integer id, Proveedor proveedor){
    	dao.update(id, proveedor);
    }
    
    //Eliminar
    public void delete(Integer id){
    	dao.delete(id);
    }
    
    //PREGUNTAR SOBRE ESTE METODO
	public List<Proveedor> getWithFilter(String filter) {
		return dao.findWithFilter(filter);
	}
	
}
