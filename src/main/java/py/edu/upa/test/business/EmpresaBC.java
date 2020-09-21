package py.edu.upa.test.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import py.edu.upa.test.dao.EmpresaDAO;
import py.edu.upa.test.entity.Empresa;



@Stateless
public class EmpresaBC {
	
	@Inject
    private EmpresaDAO dao;
	
	 //GetALL
    public List<Empresa> find() {
    	return dao.find();
    }
    
    //GetID
    public Empresa findById(Integer id) {
    	return dao.findById(id);
    }

}
