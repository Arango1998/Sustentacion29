
package com.webfutbol2017.beans;

import com.webfutbol2017.backend.persistence.entities.Ciudad;
import com.webfutbol2017.backend.persistence.facades.CiudadFacade;
import com.webfutbol2017.converters.InterfaceController;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Cristian Suesca
 */
@Named(value = "ciudadManagedBean")
@RequestScoped
public class CiudadManagedBean implements Serializable, InterfaceController<Ciudad>{
    private Ciudad ciudad;
    @EJB
    private CiudadFacade cf;

    
    public CiudadManagedBean() {
    }
    
     @PostConstruct
    public void init(){
        ciudad = new Ciudad();
    }

    @Override
    public Ciudad getObjectByKey(Integer key) {
    return cf.find(key);
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }
    
      public List<Ciudad> listar(){
        return cf.findAll();
    }
      
       
    public void crearCiudad(){
        cf.create(ciudad);
    }
    
    
}
